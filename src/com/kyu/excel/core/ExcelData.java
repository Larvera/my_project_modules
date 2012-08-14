package com.kyu.excel.core;

import java.util.Map;

/**
 * @FileName : ExcelData.java
 * @Project : sample_project
 * @Date : 2012. 8. 13.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public interface ExcelData {

	/**
	 * <pre>
	 * createExcelParamMap
	 * excel에 보여줄 데이터
	 * <pre>
	 * @return
	 */
	public abstract Map<String, Object> createExcelParamMap();

}
