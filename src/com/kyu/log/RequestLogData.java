package com.kyu.log;

/**
 * @FileName : RequestLogData.java
 * @Project : sample_project
 * @Date : 2012. 5. 31.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class RequestLogData {

	/** 연동일자 */
	public long date;
	/** 트랜잭션 아이디 */
	public String transactionId;
	/** 연동 구분 코드 */
	public String serviceCode;
	/** 연동 수행 완료 시간 */
	public long executionTime;
	/** 결과 값 (SUCCESS, FAIL) */
	public String result;
	/** 결과 코드 값 */
	public String resultCode;
	/** 로그 write idx */
	public long logWriteIdx;

	public long getLogWriteIdx() {
		return logWriteIdx;
	}

	public void setLogWriteIdx(long logWriteIdx) {
		this.logWriteIdx = logWriteIdx;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public long getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(long executionTime) {
		this.executionTime = executionTime;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	@Override
	public String toString() {
		return "RequestLogData [transactionId=" + transactionId + ", result=" + result + ", resultCode=" + resultCode
				+ ", serviceCode=" + serviceCode + ", executionTime=" + executionTime + ", date=" + date
				+ ", logWriteIdx=" + logWriteIdx + "]";
	}
}
