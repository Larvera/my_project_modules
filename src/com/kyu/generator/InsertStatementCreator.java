package com.kyu.generator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.lang.StringUtils;

import com.kyu.generator.db.DBInfo;
import com.kyu.generator.db.DBType;
import com.kyu.generator.db.Database;
import com.kyu.generator.db.DatabaseFactory;


/**
 * @FileName : InsertStatementCreator.java
 * @Project : my_project_modules
 * @Date : 2016. 7. 14.
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class InsertStatementCreator {

	/**
	 * <pre>
	 * main
	 *
	 * <pre>
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("parameter pattern : db_host=xxxxxx,db_port=xxx,db_id=xxx,db_pw=xxx,db_schema=xxx,db_tables=xxx|xxx|xxx");
        String inputData = scanner.nextLine();

        String[] paramDatas = StringUtils.split(inputData, ",");
        Properties props = new Properties();
        for (String paramData : paramDatas) {
			String[] keyAndValue = StringUtils.split(paramData, '=');
			props.put(keyAndValue[0], keyAndValue[1]);
		}

		InsertStatementCreator insertStatementCreator = new InsertStatementCreator();
		insertStatementCreator.job(props);
	}

	/**
	 * <pre>
	 * job
	 *
	 * <pre>
	 * @param tableNames
	 */
	public void job(Properties props) {
		String dbHost = props.getProperty("db_host");
		String dbPort = props.getProperty("db_port");
		String dbSchema = props.getProperty("db_schema");
		String dbId = props.getProperty("db_id");
		String dbPw = props.getProperty("db_pw");
		String dbTables = props.getProperty("db_tables");
		String jdbcUrl = String.format("jdbc:mysql://%s:%s/%s?allowMultiQueries=true", dbHost, dbPort, dbSchema);

		// db 정보
		DBInfo dbInfo = new DBInfo();
		dbInfo.setDbType(DBType.MYSQL);
		dbInfo.setJdbcUrl(jdbcUrl);
		dbInfo.setId(dbId);
		dbInfo.setPw(dbPw);

		// insert문 추출 대상 테이블
		List<String> tables = Arrays.asList(StringUtils.split(dbTables, "|"));

		List<String> schemaNames = new ArrayList<String>();
		schemaNames.add(dbSchema);

		Connection conn = null;
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;

		try {
			// get db connection
			Database database = DatabaseFactory.createInstance(dbInfo.getDbType());
			conn = database.getConnection(dbInfo.getJdbcUrl(), dbInfo.getId(), dbInfo.getPw());

			// 대상 테이블 사이즈만큼 for문
			for (int idx = 0; idx < tables.size(); idx++) {
				Map<String, List<String>> paramMap = new HashMap<String, List<String>>();
				paramMap.put("tableName", Arrays.asList(tables.get(idx)));
				paramMap.put("schemaName", schemaNames);

				// table 컬럼 리스트 추출
				TableDictionary dictionary = new TableDictionary();
				List<TableDictionaryRowVO> tableColumnList = dictionary.getTableList(paramMap, dbInfo);

				// table 데이터 추출
				String selectSql = getSelectQuery(tableColumnList);
				pstmt = conn.prepareStatement(selectSql);
				resultSet = pstmt.executeQuery();

				// table meta data
				ResultSetMetaData metaData = resultSet.getMetaData();
				int columnCount = metaData.getColumnCount();
				String tableName = metaData.getTableName(1);
				String catalogName = metaData.getCatalogName(1);

				System.out.println("##############################################################");
				System.out.println("## 테이블 : " + tableName);
				System.out.println("##############################################################");
				StringBuilder insertSql = new StringBuilder();
				while (resultSet.next()) {
					insertSql.append("insert into ");
					insertSql.append(catalogName + "." + tableName);
					insertSql.append(" ( ");

					// 컬럼 이름
					for (int i = 1; i <= columnCount; i++) {
						String columnName = metaData.getColumnName(i);
						insertSql.append(columnName);
						if (i != columnCount) {
							insertSql.append(",");
						}
					}

					insertSql.append(" ) values ( ");

					// 컬럼 데이터
					for (int i = 1; i <= columnCount; i++) {
						String columnData = resultSet.getString(i);
						insertSql.append("'");
						insertSql.append(columnData);
						insertSql.append("'");
						if (i != columnCount) {
							insertSql.append(",");
						}
					}
					insertSql.append(" ); \n");
				}

				// 파일 생성
				new FileCreator().createFile(insertSql.toString(), idx + "_" + tableName, ".sql");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	/**
	 * <pre>
	 * getQuery
	 *
	 * <pre>
	 * @return
	 */
	private String getSelectQuery(List<TableDictionaryRowVO> list) {
		StringBuilder sql = new StringBuilder();
		sql.append("select ");

		for (int i = 0; i < list.size(); i++) {
			TableDictionaryRowVO tableDictionaryRowVO = list.get(i);
			String columnName = tableDictionaryRowVO.getColumn();
			sql.append(columnName);
			if (i != (list.size() - 1)) {
				sql.append(", ");
			}
		}
		sql.append(" from ");
		sql.append(list.get(0).getTableName());
		return sql.toString();
	}
}
