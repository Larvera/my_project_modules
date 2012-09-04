package com.kyu.excel.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kyu.excel.core.ExcelData;

/**
 * @FileName : ReportVO.java
 * @Project : sample_project
 * @Date : 2012. 8. 13.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class ReportVO implements ExcelData {

	private List<?> list;
	private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the list
	 */
	public List<?> getList() {
		return list;
	}


	/**
	 * @param list the list to set
	 */
	public void setList(List<?> list) {
		this.list = list;
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see com.kyu.excel.core.ExcelData#createExcelParamMap()
	 */
	@Override
	public Map<String, Object> createExcelParamMap() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("vo", this);
		return paramMap;
	}
}
