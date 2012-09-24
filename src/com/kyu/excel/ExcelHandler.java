package com.kyu.excel;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.kyu.common.Conf;
import com.kyu.excel.core.make.ExcelCore;
import com.kyu.excel.core.make.ExcelData;
import com.kyu.excel.core.parse.ExcelParser;
import com.kyu.excel.core.parse.ExcelValue;
import com.kyu.excel.enumtype.ExcelBaseType;



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
	 * 엑셀 파일 생성
	 * <pre>
	 * @param data
	 * @param excelType
	 * @param baseType
	 * @return
	 */
	public static boolean createExcel(ExcelData data, ExcelCore core, ExcelBaseType baseType) {
		String excelFileName = null;
		String savePath = null;
		try {
			// excel workbook 생성
			excelFileName = baseType.getExcelFileName();
			core.createWorkBook(data, excelFileName);

			// 엑셀 파일 생성
			savePath = Conf.getValue("excel.directory") + excelFileName;
			core.writeExcel(savePath);

			System.out.println("##createExcel## excelFileName=" + excelFileName + ", savePath=" + savePath);

		} catch (Exception ex) {
			System.out.println("##createExcel## (exception failed) excelFileName=" + excelFileName + ", savePath=" + savePath);
			ex.printStackTrace();
			return false;
		}

		return true;
	}

	/**
	 * <pre>
	 * excelDownload
	 * 엑셀 파일 다운로드
	 * <pre>
	 * @param data
	 * @param excelType
	 * @param baseType
	 * @param response
	 */
	public static void excelDownload(ExcelData data, ExcelCore core, ExcelBaseType baseType, HttpServletResponse response) {
		String excelFileName = null;
		try {
			// excel workbook 생성
			excelFileName = baseType.getExcelFileName();
			core.createWorkBook(data, excelFileName);

			// 엑셀 다운로드
			core.downloadExcel(response, excelFileName);
			System.out.println("##createExcel## excelFileName=" + excelFileName);

		} catch (Exception ex) {
			System.out.println("##createExcel## (exception failed) excelFileName=" + excelFileName);
			ex.printStackTrace();
		}
	}

	/**
	 * <pre>
	 * parse
	 * 엑셀 파싱
	 * <pre>
	 * @param excelStream
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public static List<ExcelValue> parse(InputStream excelStream, Class<? extends ExcelValue> clazz) throws Exception {
		ExcelParser parser = new ExcelParser();
		List<ExcelValue> excelValueList = parser.parse(excelStream, clazz);
		return excelValueList;
	}
}
