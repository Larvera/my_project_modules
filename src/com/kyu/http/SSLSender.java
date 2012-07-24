package com.kyu.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import com.kyu.http.core.BaseSender;
import com.kyu.http.core.WebProtocol;
import com.kyu.http.core.WebProtocolData;

/**
 * @FileName : SSLSender.java
 * @Project : sample_project
 * @Date : 2012. 7. 24.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class SSLSender extends BaseSender implements WebProtocol {

	/** The http url. */
	private final URL httpUrl;

	/** The conn. */
	private final HttpsURLConnection conn;

	/**
	 * @param url
	 * @throws IOException
	 */
	public SSLSender(String url) throws Exception {
		// SSL 셋팅
		trustAllHttpsCertificates();
		HttpsURLConnection.setDefaultHostnameVerifier(new SSLHostnameVerifier());

		httpUrl = new URL(url);
		conn = (HttpsURLConnection) httpUrl.openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setRequestMethod("POST");
		conn.setConnectTimeout(5000);
		conn.setReadTimeout(10000);
	}

	/**
	 * <pre>
	 * trustAllHttpsCertificates
	 *
	 * <pre>
	 * @throws Exception
	 */
	private void trustAllHttpsCertificates() throws Exception {
		TrustManager[] trustAllCerts = new TrustManager[1];
		trustAllCerts[0] = new SSLTrustManager();
		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, null);
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	}

	/**
	 * <pre>
	 * send
	 * 요청 및 응답
	 *
	 * <pre>
	 * @param httpData
	 * @return
	 */
	@Override
	public WebProtocolData send(WebProtocolData httpData) {
		StringBuffer buffer = new StringBuffer();
		BufferedReader reader = null;
		DataOutputStream out = null;
		try {
			String encode = httpData.getRequestEncoding();
			byte[] btContent = httpData.getRequestContent().getBytes(encode);
			conn.setRequestProperty("Content-Type", httpData.getRequestContentType());
			conn.setRequestProperty("Content-Length", String.valueOf(btContent.length));

			out = new DataOutputStream(conn.getOutputStream());
			out.write(btContent);
			out.flush();

			int responseCode = conn.getResponseCode();
			httpData.setResponseStatus(responseCode);

			if (responseCode == HTTP_STATUS_SC_OK) { // 200 응답 코드 받았을 때 수행
				reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), encode));

				int read = 0;
				char[] cbuff = new char[1024];
				while ((read = reader.read(cbuff)) > 0) {
					buffer.append(cbuff, 0, read);
				}

				if (buffer.length() > 0) {
					String content = makeDecode(buffer);
					httpData.setResponseContent(content);
					String type = conn.getHeaderField("Content-Type");
					httpData.setResponseContentType(type);
				}
			}

		} catch (SocketTimeoutException socketTimeoutException) {
			System.out.println("##SocketTimeoutException## socketTimeoutException=" + socketTimeoutException);
			httpData.setResponseStatus(HTTP_STATUS_SC_REQUEST_TIMEOUT); // socket timeout 에러
		} catch (Exception exception) {
			System.out.println("##Exception## exception=" + exception);
			httpData.setResponseStatus(HTTP_STATUS_SC_INTERNAL_SERVER_ERROR); // 서버 내부 오류
		} finally {
			close(reader);
			close(out);
			urlConnectionClose();
		}

		return httpData;
	}

	/**
	 * <pre>
	 * urlConnectionClose
	 *
	 * <pre>
	 */
	private void urlConnectionClose() {
		if (conn != null) {
			conn.disconnect();
		}
	}
}
