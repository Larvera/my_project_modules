package com.kyu.component.test.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kyu.common.Conf;
import com.kyu.excel.ExcelHandler;
import com.kyu.excel.enumtype.ExcelBaseType;
import com.kyu.excel.generator.JXLSExcelGenerator;
import com.kyu.excel.test.DataVO;
import com.kyu.excel.test.ReportVO;

/**
 * @FileName : ExcelDownload.java
 * @Project : sample_project
 * @Date : 2012. 9. 21.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
@WebServlet("/excelDownload")
public class ExcelDownload extends HttpServlet {

	/**  */
	private static final long serialVersionUID = -7604808459653742123L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		try {
			Conf.init();
			ReportVO data = getData();

			// excel download
			JXLSExcelGenerator excelGenerator = new JXLSExcelGenerator();
			ExcelHandler.excelDownload(data, excelGenerator, ExcelBaseType.REPORT_CAMPAIGN, response);

		} catch (IOException e) {
			e.printStackTrace();
		}
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
