package com.kyu.excel.test.schema;

import java.util.ArrayList;
import java.util.List;

/**
 * @FileName : TableSchemaVO.java
 * @Project : sample_project
 * @Date : 2012. 9. 20.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class TableVO {

	/** 테이블명 */
	private String tableName;
	/** 테이블 comment */
	private String tableComment;
	/** column 리스트 */
	private final List<ColumnVO> columnList = new ArrayList<ColumnVO>();

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName
	 *            the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @return the tableComment
	 */
	public String getTableComment() {
		return tableComment;
	}

	/**
	 * @param tableComment
	 *            the tableComment to set
	 */
	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

	/**
	 * @return the columnList
	 */
	public List<ColumnVO> getColumnList() {
		return columnList;
	}

	/**
	 * @param columnList
	 *            the columnList to set
	 */
	public void addColumn(ColumnVO columnVO) {
		columnList.add(columnVO);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TableSchemaVO [tableName=" + tableName + ", tableComment=" + tableComment + ", columnList="
				+ columnList + "]";
	}
}
