package com.kyu.file;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @FileName : FileDataDAO.java
 * @Project : sample_project
 * @Date : 2012. 7. 11.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class FileDataDAO {

	private final static int LOOP_CNT = 100000;

	private final List<TableRowDataVO> dataList = new ArrayList<TableRowDataVO>();

	/**
	 *
	 */
	public FileDataDAO() {
		initTableData();
	}

	/**
	 * <pre>
	 * initDate
	 * 데이터 셋팅
	 * <pre>
	 */
	public void initTableData() {
		for (int i = 0; i < LOOP_CNT; i++) {
			TableRowDataVO rowDataVO = new TableRowDataVO();
			rowDataVO.setClick(100);
			rowDataVO.setImp(100000);
			rowDataVO.setCtr(0.3);
			rowDataVO.setName("광고");
			rowDataVO.setRegDate(new Date());

			dataList.add(rowDataVO);
		}
	}

	/**
	 * <pre>
	 * getTotalRowCnt
	 * total row 수
	 * <pre>
	 * @return
	 */
	public int getTotalRowCnt() {
		return LOOP_CNT;
	}

	/**
	 * <pre>
	 * getRowData
	 *
	 * <pre>
	 * @return
	 */
	public List<TableRowDataVO> getRowData() {
		List<TableRowDataVO> dataList = new ArrayList<TableRowDataVO>();

		return dataList;
	}
}
