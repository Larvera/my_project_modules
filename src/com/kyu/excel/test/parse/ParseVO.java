package com.kyu.excel.test.parse;

import com.kyu.excel.core.parse.ExcelValue;

/**
 * @FileName : ParseVO.java
 * @Project : sample_project
 * @Date : 2012. 9. 24.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class ParseVO implements ExcelValue {

	/** 이용일 */
	private String date;
	/** 이용시간 */
	private String time;
	/** 사용 금액 */
	private String amount;
	/** 가맹점 명 */
	private String memberStoreName;
	/** 결제 상태 */
	private String status;

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return the memberStoreName
	 */
	public String getMemberStoreName() {
		return memberStoreName;
	}

	/**
	 * @param memberStoreName
	 *            the memberStoreName to set
	 */
	public void setMemberStoreName(String memberStoreName) {
		this.memberStoreName = memberStoreName;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ParseVO [date=" + date + ", time=" + time + ", amount=" + amount + ", memberStoreName="
				+ memberStoreName + ", status=" + status + "]";
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.kyu.excel.core.parse.ExcelValue#setValue(int, java.lang.String)
	 */
	@Override
	public void setValue(int cellIdx, String value) {
		// 이용일
		if (cellIdx == 1) {
			date = value;
		}
		// 이용시간
		else if (cellIdx == 2) {
			time = value;
		}
		// 사용 금액
		else if (cellIdx == 5) {
			amount = value;
		}
		// 가맹점명
		else if (cellIdx == 6) {
			memberStoreName = value;
		}
		// 승인 상태
		else if (cellIdx == 13) {
			status = value;
		}
	}
}
