package com.kyu.excel.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.kyu.common.Conf;
import com.kyu.excel.ExcelHandler;
import com.kyu.excel.enumtype.ExcelBaseType;
import com.kyu.excel.generator.JXLSExcelGenerator;

/**
 * @FileName : Main.java
 * @Project : sample_project
 * @Date : 2012. 8. 13.
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
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Conf.init();

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
		ReportVO data = getData();
		JXLSExcelGenerator excelGenerator = new JXLSExcelGenerator();
		boolean isSuccess = ExcelHandler.createExcel(data, excelGenerator, ExcelBaseType.REPORT_CAMPAIGN);
		System.out.println("##job## isSuccess=" + isSuccess);
	}

	/**
	 * <pre>
	 * getData
	 *
	 * <pre>
	 * @return
	 */
	public ReportVO getData() {
		List<DataVO> listData = new ArrayList<DataVO>();
		for (int i = 0; i < 10; i++) {
			DataVO vo = new DataVO();
			vo.setCount(i);
			vo.setAmount(10000);
			vo.setImp(10000000);
			vo.setClick(100);

			listData.add(vo);
		}

		ReportVO reportVO = new ReportVO();
		reportVO.setName("kyu");
		reportVO.setList(listData);
		return reportVO;
	}
}