package com.kyu.excel.core.parse;

/**
 * @FileName : ExcelParse.java
 * @Project : sample_project
 * @Date : 2012. 9. 24.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public interface ExcelValue {

	/**
	 * <pre>
	 * setValue
	 *
	 * <pre>
	 * @param cellIdx
	 * @param value
	 */
	public void setValue(int cellIdx, String value);
}
