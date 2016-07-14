package com.kyu.generator.db;

import lombok.Data;

/**
 * @FileName : DBInfo.java
 * @Project : my_project_modules
 * @Date : 2016. 7. 14.
 * @작성자 : nklee
 * @프로그램설명 :
 */
@Data
public class DBInfo {

	private String jdbcUrl;
	private String id;
	private String pw;
	private DBType dbType;
}
