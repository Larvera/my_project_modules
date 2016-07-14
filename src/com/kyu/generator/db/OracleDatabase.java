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

	/* (non-Javadoc)
	 * @see com.kyu.generator.db.Database#getConnection()
	 */
	@Override
	public Connection getConnection(String jdbcUrl, String userId, String password) {
		Connection conn = null;
		return conn;
	}
}
