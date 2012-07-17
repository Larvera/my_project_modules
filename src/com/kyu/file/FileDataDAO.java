package com.kyu.file;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @FileName : FileDataDAO.java
 * @Project : sample_project
 * @Date : 2012. 7. 11.
 * @작성자 : 이남규
 * @프로그램설명 : 테스트 데이터 DAO
 */
public class FileDataDAO {

	private final static int LOOP_CNT = 117;

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
			rowDataVO.setImp(i + 1);
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
	 * @param paramVO
	 * @return
	 */
	public List<TableRowDataVO> getRowData(TableRowDataVO paramVO) {
		List<TableRowDataVO> subList = dataList.subList(paramVO.getStartRowIndex(), paramVO.getLimitSize());
		return subList;
	}

	/**
	 * <pre>
	 * main
	 *
	 * <pre>
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> test = new ArrayList<String>();
		test.add("1");
		test.add("2");
		test.add("3");
		test.add("4");
		test.add("5");
		test.add("6");

		List<String> subList = test.subList(1, 3);
		System.out.println(subList);
	}
}
