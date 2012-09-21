package com.kyu.excel.test.schema;

/**
 * @FileName : ColumnVO.java
 * @Project : sample_project
 * @Date : 2012. 9. 20.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class ColumnVO {

	/** rownum */
	private Integer rowNum;
	/** 컬럼명 */
	private String columnName;
	/** 데이터 타입 */
	private String dataType;
	/** 데이터 타입 길이 */
	private long dataTypeLength;
	/** not null 여부 */
	private String notNull;
	/** PK 여부 */
	private String columnKey;
	/** default 값 */
	private String columnDefault;
	/** 컬럼 commnet */
	private String columnComment;
	/** 비고 */
	private String extra;
	/**
	 * @return the rowNum
	 */
	public Integer getRowNum() {
		return rowNum;
	}
	/**
	 * @param rowNum the rowNum to set
	 */
	public void setRowNum(Integer rowNum) {
		this.rowNum = rowNum;
	}
	/**
	 * @return the columnName
	 */
	public String getColumnName() {
		return columnName;
	}
	/**
	 * @param columnName the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	/**
	 * @return the dataType
	 */
	public String getDataType() {
		return dataType;
	}
	/**
	 * @param dataType the dataType to set
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	/**
	 * @return the dataTypeLength
	 */
	public long getDataTypeLength() {
		return dataTypeLength;
	}
	/**
	 * @param dataTypeLength the dataTypeLength to set
	 */
	public void setDataTypeLength(long dataTypeLength) {
		this.dataTypeLength = dataTypeLength;
	}
	/**
	 * @return the notNull
	 */
	public String getNotNull() {
		return notNull;
	}
	/**
	 * @param notNull the notNull to set
	 */
	public void setNotNull(String notNull) {
		this.notNull = notNull;
	}
	/**
	 * @return the columnKey
	 */
	public String getColumnKey() {
		return columnKey;
	}
	/**
	 * @param columnKey the columnKey to set
	 */
	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}
	/**
	 * @return the columnDefault
	 */
	public String getColumnDefault() {
		return columnDefault;
	}
	/**
	 * @param columnDefault the columnDefault to set
	 */
	public void setColumnDefault(String columnDefault) {
		this.columnDefault = columnDefault;
	}
	/**
	 * @return the columnComment
	 */
	public String getColumnComment() {
		return columnComment;
	}
	/**
	 * @param columnComment the columnComment to set
	 */
	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}
	/**
	 * @return the extra
	 */
	public String getExtra() {
		return extra;
	}
	/**
	 * @param extra the extra to set
	 */
	public void setExtra(String extra) {
		this.extra = extra;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ColumnVO [rowNum=" + rowNum + ", columnName=" + columnName + ", dataType=" + dataType
				+ ", dataTypeLength=" + dataTypeLength + ", notNull=" + notNull + ", columnKey=" + columnKey
				+ ", columnDefault=" + columnDefault + ", columnComment=" + columnComment + ", extra=" + extra + "]";
	}
}
