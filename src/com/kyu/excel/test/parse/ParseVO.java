package com.kyu.excel.test.parse;

import lombok.Data;

import com.kyu.excel.core.parse.ExcelValue;

/**
 * @FileName : ParseVO.java
 * @Project : sample_project
 * @Date : 2012. 9. 24.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
@Data
public class ParseVO implements ExcelValue, Cloneable {

	/** 결제 종류 */
	private String paymentKind;
	/** 석식 초과분 */
	private int dinnerExceed;
	/** 이용일 */
	private String date;
	/** 이용시간 */
	private String time;
	/** 사용 금액 */
	private int amount;
	/** 가맹점 명 */
	private String memberStoreName;
	/** 결제 상태 */
	private String status;

	/**
	 * <pre>
	 * setValue
	 *
	 * <pre>
	 * @param cellIdx
	 * @param value
	 */
	@Override
	public void setValue(int cellIdx, String value) {

		// 결제 구분
		if (cellIdx == 0) {
			paymentKind = value;
		}
		// 석식 초과분
		else if (cellIdx == 1 && value != null) {
			dinnerExceed = Integer.parseInt(value);
		}
		// 이용일
		else if (cellIdx == 3) {
			date = value;
		}
		// 이용시간
		else if (cellIdx == 4) {
			time = value;
		}
		// 사용 금액
		else if (cellIdx == 7) {
			amount = Integer.parseInt(value);
		}
		// 가맹점명
		else if (cellIdx == 8) {
			memberStoreName = value;
		}
		// 승인 상태
		else if (cellIdx == 15) {
			status = value;
		}
	}

	/**
	 * <pre>
	 * clone
	 *
	 * <pre>
	 * @return
	 * @throws CloneNotSupportedException
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj = super.clone();
		return obj;
	}
}
