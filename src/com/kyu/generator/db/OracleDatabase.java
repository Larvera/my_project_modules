package com.kyu.generator.db;

import java.sql.Connection;

/**
 * @FileName : OracleDatabase.java
 * @Project : sample_project
 * @Date : 2012. 7. 9.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class OracleDatabase implements Database {

	public OracleDatabase() {
	}

	/* (non-Javadoc)
	 * @see com.kyu.generator.db.Database#getConnection()
	 */
	@Override
	public Connection getConnection() {
		Connection conn = null;
		return conn;
	}
}
