package com.kyu.excel.generator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.kyu.excel.core.make.AbstractExcelCore;
import com.kyu.excel.core.make.ExcelData;

/**
 * @FileName : POIExcelGenerator.java
 * @Project : sample_project
 * @Date : 2012. 8. 14.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class POIExcelGenerator extends AbstractExcelCore {

	/**
	 * <pre>
	 * createWorkBook
	 *
	 * <pre>
	 * @param data
	 * @param excelFileName
	 */
	@Override
	public void createWorkBook(ExcelData data, String excelFileName) {
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		HSSFSheet sheet = hssfWorkbook.createSheet(excelFileName);
	}


}
