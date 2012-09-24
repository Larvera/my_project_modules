package com.kyu.excel.generator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;

import net.sf.jxls.transformer.XLSTransformer;

import com.kyu.common.Conf;
import com.kyu.excel.core.make.AbstractExcelCore;
import com.kyu.excel.core.make.ExcelData;

/**
 * @FileName : JXLSExcelGenerator.java
 * @Project : sample_project
 * @Date : 2012. 8. 14.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class JXLSExcelGenerator extends AbstractExcelCore {

	/* (non-Javadoc)
	 * @see com.kyu.excel.core.ExcelCore#createExcel(com.kyu.excel.core.ExcelData, com.kyu.excel.core.ExcelBaseType)
	 */
	@Override
	public void createWorkBook(ExcelData data, String excelFileName) throws Exception {
		XLSTransformer transformer = new XLSTransformer();

		// excel template read
		String templateFilePath = getExcelTemplatePath(Conf.getValue("excel.template.path"), excelFileName);
		InputStream is = new BufferedInputStream(new FileInputStream(templateFilePath));

		// excel workbook 생성
		Map<String, Object> paramMap = data.createExcelParamMap();
		workbook = transformer.transformXLS(is, paramMap);
	}

	/**
	 * <pre>
	 * getExcelTemplatePath
	 *
	 * <pre>
	 * @param templatePath
	 * @param excelFileName
	 * @return
	 */
	private String getExcelTemplatePath(String templatePath, String excelFileName) {
		StringBuilder path = new StringBuilder();
		path.append(templatePath);
		path.append(excelFileName);

		URL url = getClass().getClassLoader().getResource(path.toString());
		return url.getPath();
	}
}
