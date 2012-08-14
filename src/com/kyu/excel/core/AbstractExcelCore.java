package com.kyu.excel.core;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;

/**
 * @FileName : AbstractExcelCore.java
 * @Project : sample_project
 * @Date : 2012. 8. 14.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public abstract class AbstractExcelCore implements ExcelCore {

	/** 엑셀 workboox 객체 */
	protected Workbook workbook;

	/**
	 * 브라우저에서 엑셀 다운로드
	 */
	@Override
	public void downloadExcel(HttpServletResponse response, String fileName) throws Exception {
		BufferedOutputStream bf = null;
		try {
			response.setHeader("Content-disposition", "attachment;filename=" + encodeFileName(fileName));
			response.setContentType("application/x-msexcel");
			bf = new BufferedOutputStream(response.getOutputStream());
			workbook.write(bf);
			bf.flush();

		} finally {
			if (bf != null) {
				try {
					bf.close();
				} catch (IOException e) {}
			}
		}
	}

	/**
	 * 엑셀 file write
	 */
	@Override
	public void writeExcel(String savePath) throws Exception {
		BufferedOutputStream bf = null;
		try {
			bf = new BufferedOutputStream(new FileOutputStream(new File(savePath)));
			workbook.write(bf);
			bf.flush();

		} finally {
			if (bf != null) {
				try {
					bf.close();
				} catch (IOException e) {}
			}
		}
	}

	/**
	 * <pre>
	 * encodeFileName
	 *
	 * <pre>
	 * @param filename
	 * @return
	 * @throws Exception
	 */
	private String encodeFileName(String filename) throws Exception {
		try {
			return URLEncoder.encode(filename, "UTF-8");
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
}
