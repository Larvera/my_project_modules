package com.kyu.generator.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @FileName : MysqlDatabase.java
 * @Project : sample_project
 * @Date : 2012. 7. 9.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class MysqlDatabase implements Database {

	/**
	 * <pre>
	 * getConnection
	 *
	 * <pre>
	 * @param jdbcUrl
	 * @param userId
	 * @param password
	 * @return
	 */
	@Override
	public Connection getConnection(String jdbcUrl, String userId, String password) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, userId, password);
		} catch (Exception ex) {
			System.out.println("##getConnection## exception failed");
			ex.printStackTrace();
		}

		return conn;
	}
}
