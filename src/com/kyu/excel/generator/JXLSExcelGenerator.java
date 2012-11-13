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
		XLSTransformer transformer = new XLSTransformer();
		try {
			// excel template read
			String templateFilePath = getExcelTemplatePath(Conf.getValue("excel.template.path"), excelFileName);
			InputStream is = new BufferedInputStream(new FileInputStream(templateFilePath));

			// excel workbook 생성
			Map<String, Object> paramMap = data.createExcelParamMap();
			workbook = transformer.transformXLS(is, paramMap);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
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
