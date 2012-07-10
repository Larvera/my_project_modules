package com.kyu.generator.db;


/**
 * @FileName : DatabaseFactory.java
 * @Project : sample_project
 * @Date : 2012. 7. 9.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class DatabaseFactory {

	/**
	 * <pre>
	 * createInstance
	 *
	 * <pre>
	 * @param dbCode
	 * @return
	 */
	public static Database createInstance(DBType dbType) {
		Database database = null;
		if (DBType.ORACLE.equals(dbType)) { // oracle
			database = new OracleDatabase();
		} else if (DBType.MYSQL.equals(dbType)) { // mysql
			database = new MysqlDatabase();
		}
		return database;
	}
}
