package com.kyu.generator.db;

/**
 * @FileName : FTPType.java
 * @Project : sample_project
 * @Date : 2012. 4. 19.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public enum DBType {
	MYSQL("mysqlQuery"), ORACLE("oracleQuery");

	/** db별 query 추출 아이디 */
	private String queryId;

	private DBType(String queryId) {
		this.queryId = queryId;
	}

	public String getQueryId() {
		return queryId;
	}
}
