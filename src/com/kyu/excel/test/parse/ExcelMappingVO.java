package com.kyu.excel.test.parse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

import com.kyu.common.DateUtil;
import com.kyu.excel.core.make.ExcelData;

/**
 * @FileName : ExcelMappingVO.java
 * @Project : sample_project
 * @Date : 2012. 9. 25.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
@Data
public class ExcelMappingVO implements ExcelData {

	/** 통신비 청구 금액 */
	private int phoneAmount;
	/** 통신비 지원 제외 금액 */
	private int phoneExceptAmount;
	/** 통신비 실정산 금액 */
	private int phoneCalculationAmount;
	/** 총 점심 식대 사용 금액 */
	private int totalLunchAmount;
	/** 총 석식 식대 사용 금액 */
	private int totalDinnerAmount;
	/** 총 카드 사용 금액 */
	private int totalAmount;
	/** 택시 사용 내역(업무) */
	private final List<ParseVO> taxiBusinessList = new ArrayList<ParseVO>();
	/** 택시 사용 내역(심야) */
	private final List<ParseVO> taxiNightList = new ArrayList<ParseVO>();
	/** 석식 사용 내역 */
	private final List<ParseVO> dinnerList = new ArrayList<ParseVO>();
	/** 점심 사용 내역 */
	private final List<ParseVO> lunchList = new ArrayList<ParseVO>();
	/** 기타 사용 내역 */
	private final List<ParseVO> meetingCostList = new ArrayList<ParseVO>();
	/** 기타 사용 내역 */
	private final List<ParseVO> otherList = new ArrayList<ParseVO>();

	/**
	 * @param meetingCostList the meetingCostList to set
	 */
	public void setMeetingCostList(ParseVO vo) {
		meetingCostList.add(vo);
	}

	/**
	 * @param lunchList the lunchList to set
	 */
	public void setLunchList(ParseVO vo) {
		lunchList.add(vo);
	}

	/**
	 * @param otherList the oherList to set
	 */
	public void setOtherList(ParseVO vo) {
		otherList.add(vo);
	}

	/**
	 * @param taxiBusinessList the taxiBusinessList to set
	 */
	public void setTaxiBusinessList(ParseVO vo) {
		taxiBusinessList.add(vo);
	}

	/**
	 * @param taxiNightList the taxiNightList to set
	 */
	public void setTaxiNightList(ParseVO vo) {
		taxiNightList.add(vo);
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(int amount) {
		totalAmount += amount;
	}

	/**
	 * @param totalDinnerAmount the totalDinnerAmount to set
	 */
	public void setTotalDinnerAmount(int amount) {
		totalDinnerAmount += amount;
	}

	/**
	 * @param totalLunchAmount the totalLunchAmount to set
	 */
	public void setTotalLunchAmount(int amount) {
		totalLunchAmount += amount;
	}

	/**
	 * @param dinnerList the dinnerList to set
	 */
	public void setDinnerList(ParseVO vo) {
		dinnerList.add(vo);
	}

	/**
	 * <pre>
	 * createExcelParamMap
	 *
	 * <pre>
	 * @return
	 */
	public Map<String, Object> createExcelParamMap() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("vo", this);
		paramMap.put("date", DateUtil.getHangulYyyyMM());

		return paramMap;
	}

}
