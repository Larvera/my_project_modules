package com.kyu.excel;

import javax.servlet.http.HttpServletResponse;

import com.kyu.common.Conf;
import com.kyu.excel.core.ExcelCore;
import com.kyu.excel.core.ExcelData;
import com.kyu.excel.core.ExcelFactory;
import com.kyu.excel.en.ExcelBaseType;
import com.kyu.excel.en.ExcelEnumOpenSourceType;



/**
 * @FileName : ExcelHandler.java
 * @Project : sample_project
 * @Date : 2012. 8. 13.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class ExcelHandler {

	/**
	 * <pre>
	 * createExcel
	 * 엑셀 파일 생성 (default JXLS)
	 * <pre>
	 * @param data
	 * @param baseType
	 * @return
	 */
	public boolean createExcel(ExcelData data, ExcelBaseType baseType) {
		return createExcel(data, ExcelEnumOpenSourceType.JXLS, baseType);
	}

	/**
	 * <pre>
	 * createExcel
	 * 엑셀 파일 생성
	 * <pre>
	 * @param data
	 * @param excelType
	 * @param baseType
	 * @return
	 */
	public boolean createExcel(ExcelData data, ExcelEnumOpenSourceType excelType, ExcelBaseType baseType) {
		try {
			ExcelCore core = ExcelFactory.createInstance(excelType);

			// excel workbook 생성
			String excelFileName = baseType.getExcelFileName();
			core.createWorkBook(data, excelFileName);

			// 엑셀 파일 생성
			String savePath = Conf.getValue("excel.directory") + excelFileName;
			core.writeExcel(savePath);

			System.out.println("##createExcel## excelFileName=" + excelFileName + ", savePath=" + savePath);

		} catch (Exception ex) {
			System.out.println("##createExcel## (exception failed) data=" + data + ", excelType=" + excelType);
			ex.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean excelDownload(ExcelData data, ExcelBaseType baseType, HttpServletResponse response) {
		return excelDownload(data, ExcelEnumOpenSourceType.JXLS, baseType, response);
	}

	public boolean excelDownload(ExcelData data, ExcelEnumOpenSourceType excelType, ExcelBaseType baseType, HttpServletResponse response) {
		return false;
	}
}
