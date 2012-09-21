package com.kyu.excel.test.schema;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kyu.excel.core.ExcelData;

/**
 * @FileName : SchemaVO.java
 * @Project : sample_project
 * @Date : 2012. 9. 20.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class SchemaVO implements ExcelData {

	/** 테이블 리스트 */
	private List<TableVO> tableList;

	/**
	 * @return the tableList
	 */
	public List<TableVO> getTableList() {
		return tableList;
	}

	/**
	 * @param tableList
	 *            the tableList to set
	 */
	public void setTableList(List<TableVO> tableList) {
		this.tableList = tableList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SchemaVO [tableList=" + tableList + "]";
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
