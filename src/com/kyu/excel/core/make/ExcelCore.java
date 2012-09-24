package com.kyu.excel.core.make;

import javax.servlet.http.HttpServletResponse;

/**
 * @FileName : ExcelCore.java
 * @Project : sample_project
 * @Date : 2012. 8. 14.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public interface ExcelCore {

	/**
	 * <pre>
	 * createWorkBook
	 * 엑셀 workboox 생성
	 * <pre>
	 * @param data
	 * @param excelFileName
	 * @throws Exception
	 */
	public void createWorkBook(ExcelData data, String excelFileName) throws Exception;

	/**
	 * <pre>
	 * downloadExcel
	 * 엑셀 다운로드
	 * <pre>
	 * @param response
	 * @param fileName
	 * @throws Exception
	 */
	public void downloadExcel(HttpServletResponse response, String fileName) throws Exception;

	/**
	 * <pre>
	 * writeExcel
	 * 엑셀 파일 write
	 * <pre>
	 * @param savePath
	 * @throws Exception
	 */
	public void writeExcel(String savePath) throws Exception;

}
