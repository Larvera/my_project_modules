package com.kyu.excel.test.parse;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import com.kyu.excel.ExcelHandler;
import com.kyu.excel.core.parse.ExcelValue;

/**
 * @FileName : Main.java
 * @Project : sample_project
 * @Date : 2012. 9. 24.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class Main {

	/**
	 * <pre>
	 * main
	 *
	 * <pre>
	 * @param args
	 */
	public static void main(String[] args) {
		Main main = new Main();
		main.job();
	}

	/**
	 * <pre>
	 * job
	 *
	 * <pre>
	 */
	public void job() {
		String filePath = "E:/test/excel/card.xls";
		try {
			FileInputStream fileInputStream = new FileInputStream(new File(filePath));
			List<ExcelValue> excelValueList = ExcelHandler.parse(fileInputStream, ParseVO.class);
			System.out.println("##job## excelValueList=" + excelValueList);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
