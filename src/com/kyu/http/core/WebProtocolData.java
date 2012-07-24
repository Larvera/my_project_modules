/*
 * @(#)ResponseData.java	2011. 5. 28
 *
 * Copyright(c) 2009 INCROSS Ltd.
 *
 * NOTICE:
 * This source code that is confidential and proprietary to INCROSS Ltd.
 * No part of this source code may be reproduced in any form
 * whatsoever without prior approval by INCROSS Ltd.
 */
package com.kyu.http.core;


/**
 * The Class ResponseData.
 */
public class WebProtocolData {

	/** 요청 인코딩 */
	private String requestEncoding;
	/** 요청 content type */
	private String requestContentType;
	/** 요청 body data */
	private String requestContent;
	/** 요청 URL */
	private String requestUrl;

	/** 응답 HTTP 상태 코드 */
	private int responseStatus;
	/** 응답 content type */
	private String responseContentType;
	/** 응답 body data */
	private String responseContent;

	/** 연동 프로토콜 구분 (HTTP, HTTPS) */
	private SendType sendType;

	/**
	 * @return the requestUrl
	 */
	public String getRequestUrl() {
		return requestUrl;
	}
	/**
	 * @param requestUrl the requestUrl to set
	 */
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
	/**
	 * @return the sendType
	 */
	public SendType getSendType() {
		return sendType;
	}
	/**
	 * @param sendType the sendType to set
	 */
	public void setSendType(SendType sendType) {
		this.sendType = sendType;
	}
	/**
	 * @return the requestEncoding
	 */
	public String getRequestEncoding() {
		return requestEncoding;
	}
	/**
	 * @param requestEncoding the requestEncoding to set
	 */
	public void setRequestEncoding(String requestEncoding) {
		this.requestEncoding = requestEncoding;
	}
	/**
	 * @return the requestContentType
	 */
	public String getRequestContentType() {
		return requestContentType;
	}
	/**
	 * @param requestContentType the requestContentType to set
	 */
	public void setRequestContentType(String requestContentType) {
		this.requestContentType = requestContentType;
	}
	/**
	 * @return the requestContent
	 */
	public String getRequestContent() {
		return requestContent;
	}
	/**
	 * @param requestContent the requestContent to set
	 */
	public void setRequestContent(String requestContent) {
		this.requestContent = requestContent;
	}
	/**
	 * @return the responseStatus
	 */
	public int getResponseStatus() {
		return responseStatus;
	}
	/**
	 * @param responseStatus the responseStatus to set
	 */
	public void setResponseStatus(int responseStatus) {
		this.responseStatus = responseStatus;
	}
	/**
	 * @return the responseContentType
	 */
	public String getResponseContentType() {
		return responseContentType;
	}
	/**
	 * @param responseContentType the responseContentType to set
	 */
	public void setResponseContentType(String responseContentType) {
		this.responseContentType = responseContentType;
	}
	/**
	 * @return the responseContent
	 */
	public String getResponseContent() {
		return responseContent;
	}
	/**
	 * @param responseContent the responseContent to set
	 */
	public void setResponseContent(String responseContent) {
		this.responseContent = responseContent;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HttpData [requestEncoding=" + requestEncoding + ", requestContentType=" + requestContentType
				+ ", requestContent=" + requestContent + ", requestUrl=" + requestUrl + ", responseStatus="
				+ responseStatus + ", responseContentType=" + responseContentType + ", responseContent="
				+ responseContent + ", sendType=" + sendType + "]";
	}
}
