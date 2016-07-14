package com.kyu.generator;


/**
 * @FileName : TableVO.java
 * @Project : sample_project
 * @Date : 2012. 7. 9.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class TableDictionaryRowVO {

	/** 테이블 명 */
	private String tableName;
	/** 테이블 주석 */
	private String tableComment;
	/** 컬럼 주석 */
	private String columnComment;
	/** 컬럼 */
	private String column;
	/** 데이터 타입 */
	private String dataType;
	/** 테이터 length */
	private String dataLength;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

	public String getColumnComment() {
		return columnComment;
	}

	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getDataLength() {
		return dataLength;
	}

	public void setDataLength(String dataLength) {
		this.dataLength = dataLength;
	}

	@Override
	public String toString() {
		return "TableVO [tableName=" + tableName + ", tableComment=" + tableComment + ", columnComment="
				+ columnComment + ", column=" + column + ", dataType=" + dataType + ", dataLength=" + dataLength + "]";
	}
}
