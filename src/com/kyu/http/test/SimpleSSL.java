package com.kyu.http.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Security;

import com.sun.net.ssl.internal.ssl.Provider;

/**
 * @FileName : SimpleSSL.java
 * @Project : sample_project
 * @Date : 2012. 7. 24.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class SimpleSSL {

	public static void main(String[] args) {
//		String url = "https://www.t-ad.co.kr";
		String url = "https://admin.t-ad.co.kr:8443/apoc/report/adReportList.do";
//		String url = "https://220.103.245.206:8443/apoc/report/adReportList.do";

		// 공인 인증서인 경우만 정상적으로 https 연동이 된다.
		System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
		Provider provider = new Provider();
		Security.addProvider(provider);

		try {
			URL httpsUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) httpsUrl.openConnection();
			conn.setUseCaches(false);
			conn.setConnectTimeout(40000);
			conn.setDoOutput(true);
			conn.connect();

			int responseCode = conn.getResponseCode();
			System.out.println("##responseCode=" + responseCode);

			StringBuffer buffer = new StringBuffer();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));

			int read = 0;
			char[] cbuff = new char[1024];
			while ((read = reader.read(cbuff)) > 0) {
				buffer.append(cbuff, 0, read);
			}

			// response html 출력
			System.out.println("##htmlCode=" + buffer.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
