package com.kyu.http;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * @FileName : SSLTrustManager.java
 * @Project : sample_project
 * @Date : 2012. 7. 24.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class SSLTrustManager implements TrustManager, X509TrustManager {

	/**
	 * <pre>
	 * isServerTrusted
	 *
	 * <pre>
	 * @param certs
	 * @return
	 */
	public boolean isServerTrusted(X509Certificate[] certs) {
		System.out.println("##isServerTrusted## X509Certificate=" + certs);
		return true;
	}

	/**
	 * <pre>
	 * isClientTrusted
	 *
	 * <pre>
	 * @param certs
	 * @return
	 */
	public boolean isClientTrusted(X509Certificate[] certs) {
		System.out.println("##isClientTrusted## X509Certificate=" + certs);
		return true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.net.ssl.X509TrustManager#getAcceptedIssuers()
	 */
	@Override
	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * javax.net.ssl.X509TrustManager#checkServerTrusted(java.security.cert.
	 * X509Certificate[], java.lang.String)
	 */
	@Override
	public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException {
		System.out.println("##checkServerTrusted## authType=" + certs[0]);

//		try {
//
//			// Get trust store
//			KeyStore trustStore = KeyStore.getInstance("JKS");
//			String cacertPath = System.getProperty("java.home") + "/lib/security/cacerts";
//			trustStore.load(new FileInputStream(cacertPath), "changeit".toCharArray());
//
//			// Get Trust Manager
//			TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//			tmf.init(trustStore);
//			TrustManager[] tms = tmf.getTrustManagers();
//			((X509TrustManager) tms[0]).checkServerTrusted(certs, authType);
//
//		} catch (KeyStoreException e) {
//			e.printStackTrace();
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}

		return;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * javax.net.ssl.X509TrustManager#checkClientTrusted(java.security.cert.
	 * X509Certificate[], java.lang.String)
	 */
	@Override
	public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {
		System.out.println("##checkClientTrusted## authType=" + authType);
		return;
	}
}
