package com.kyu.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kyu.generator.db.DBInfo;
import com.kyu.generator.db.DBType;


/**
 * @FileName : VoGenerator.java
 * @Project : sample_project
 * @Date : 2012. 7. 9.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class VoGenerator {

	/**
	 * <pre>
	 * main
	 *
	 * <pre>
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		VoGenerator generator = new VoGenerator();
		generator.job();
	}

	/**
	 * <pre>
	 * job
	 *
	 * <pre>
	 * @param tableNames
	 */
	public void job() {
		// param 셋팅
		Map<String, List<String>> paramMap = makeTableNames();

		DBInfo dbInfo = new DBInfo();
		dbInfo.setDbType(DBType.MYSQL);
		dbInfo.setJdbcUrl("");
		dbInfo.setId("");
		dbInfo.setPw("");

		// table 리스트 추출
		TableDictionary dictionary = new TableDictionary();
		List<TableDictionaryRowVO> tableRowList = dictionary.getTableList(paramMap, dbInfo);

		// table 정보 추출
		CodeGenerator code = new CodeGenerator();
		String generatorVO = code.createCode(tableRowList);

		// VO 파일 생성
		String javaFileName = code.getClassName();
		new FileCreator().createFile(generatorVO, javaFileName, ".java");

		System.out.println("##job## (Finished VO File) javaFileName=" + javaFileName);
	}

	/**
	 * <pre>
	 * makeTableNames
	 *
	 * <pre>
	 * @return
	 */
	private Map<String, List<String>> makeTableNames() {
		Map<String, List<String>> paramMap = new HashMap<String, List<String>>();

		// table names
		List<String> tableNames = new ArrayList<String>();
		tableNames.add("TBL_MEDIA_GROUP_MAPPING");

		// schema names
		List<String> schemaNames = new ArrayList<String>();
		schemaNames.add("TAD");
		schemaNames.add("TAD_LOG");

		paramMap.put("databaseInfo", Arrays.asList("localhost", "test", "1111"));
		paramMap.put("tableName", tableNames);
		paramMap.put("schemaName", schemaNames);
		return paramMap;
	}
}
