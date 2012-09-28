package com.kyu.excel.test.parse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kyu.common.DateUtil;
import com.kyu.excel.core.make.ExcelData;

/**
 * @FileName : ExcelMappingVO.java
 * @Project : sample_project
 * @Date : 2012. 9. 25.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
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
	private final List<ParseVO> otherList = new ArrayList<ParseVO>();

	/**
	 * @return the lunchList
	 */
	public List<ParseVO> getLunchList() {
		return lunchList;
	}

	/**
	 * @param lunchList the lunchList to set
	 */
	public void setLunchList(ParseVO vo) {
		lunchList.add(vo);
	}

	/**
	 * @return the oherList
	 */
	public List<ParseVO> getOtherList() {
		return otherList;
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
	 * @return the taxiBusinessList
	 */
	public List<ParseVO> getTaxiBusinessList() {
		return taxiBusinessList;
	}

	/**
	 * @return the taxiNightList
	 */
	public List<ParseVO> getTaxiNightList() {
		return taxiNightList;
	}

	/**
	 * @return the totalAmount
	 */
	public int getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(int amount) {
		totalAmount += amount;
	}

	/**
	 * @return the phoneCalculationAmount
	 */
	public int getPhoneCalculationAmount() {
		return phoneCalculationAmount;
	}

	/**
	 * @param phoneCalculationAmount the phoneCalculationAmount to set
	 */
	public void setPhoneCalculationAmount(int phoneCalculationAmount) {
		this.phoneCalculationAmount = phoneCalculationAmount;
	}

	/**
	 * @return the totalDinnerAmount
	 */
	public int getTotalDinnerAmount() {
		return totalDinnerAmount;
	}

	/**
	 * @param totalDinnerAmount the totalDinnerAmount to set
	 */
	public void setTotalDinnerAmount(int amount) {
		totalDinnerAmount += amount;
	}

	/**
	 * @return the phoneExceptAmount
	 */
	public int getPhoneExceptAmount() {
		return phoneExceptAmount;
	}

	/**
	 * @param phoneExceptAmount the phoneExceptAmount to set
	 */
	public void setPhoneExceptAmount(int phoneExceptAmount) {
		this.phoneExceptAmount = phoneExceptAmount;
	}

	/**
	 * @return the totalLunchAmount
	 */
	public int getTotalLunchAmount() {
		return totalLunchAmount;
	}

	/**
	 * @param totalLunchAmount the totalLunchAmount to set
	 */
	public void setTotalLunchAmount(int amount) {
		totalLunchAmount += amount;
	}

	/**
	 * @return the phoneAmount
	 */
	public int getPhoneAmount() {
		return phoneAmount;
	}

	/**
	 * @param phoneAmount the phoneAmount to set
	 */
	public void setPhoneAmount(int phoneAmount) {
		this.phoneAmount = phoneAmount;
	}

	/**
	 * @param dinnerList the dinnerList to set
	 */
	public void setDinnerList(ParseVO vo) {
		dinnerList.add(vo);
	}

	/**
	 * @return the dinnerList
	 */
	public List<ParseVO> getDinnerList() {
		return dinnerList;
	}



	/*
	 * (non-Javadoc)
	 *
	 * @see com.kyu.excel.core.make.ExcelData#createExcelParamMap()
	 */
	@Override
	public Map<String, Object> createExcelParamMap() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("vo", this);
		paramMap.put("date", DateUtil.getHangulYyyyMM());

		return paramMap;
	}

}
