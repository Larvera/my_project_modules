package com.kyu.excel.core.make;

import com.kyu.excel.enumtype.ExcelEnumOpenSourceType;
import com.kyu.excel.generator.JXLExcelGenerator;
import com.kyu.excel.generator.JXLSExcelGenerator;
import com.kyu.excel.generator.POIExcelGenerator;

/**
 * @FileName : ExcelFactory.java
 * @Project : sample_project
 * @Date : 2012. 8. 14.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
@Deprecated
public class ExcelFactory {

	/**
	 * <pre>
	 * createInstance
	 *
	 * <pre>
	 * @param excelType
	 * @return
	 */
	public static ExcelCore createInstance(ExcelEnumOpenSourceType excelType) {
		ExcelCore excelCore = null;

		// JXL
		if (ExcelEnumOpenSourceType.JXL == excelType) {
			excelCore = new JXLExcelGenerator();
		}
		// JXLS
		else if (ExcelEnumOpenSourceType.JXLS == excelType) {
			excelCore = new JXLSExcelGenerator();
		}
		// POI
		else if (ExcelEnumOpenSourceType.POI == excelType) {
			excelCore = new POIExcelGenerator();
		}

		return excelCore;
	}
}
