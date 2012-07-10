package com.kyu.generator.db;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @FileName : Database.java
 * @Project : sample_project
 * @Date : 2012. 7. 9.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public interface Database {

	/**
	 * <pre>
	 * getConnection
	 *
	 * <pre>
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection();

}
