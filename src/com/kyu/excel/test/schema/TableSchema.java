package com.kyu.excel.test.schema;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.kyu.excel.ExcelHandler;
import com.kyu.excel.enumtype.ExcelBaseType;
import com.kyu.excel.generator.JXLSExcelGenerator;
import com.kyu.generator.db.DBInfo;
import com.kyu.generator.db.DBType;
import com.kyu.generator.db.Database;
import com.kyu.generator.db.DatabaseFactory;
import com.kyu.generator.db.QueryLoad;

/**
 * @FileName : TableSchema.java
 * @Project : sample_project
 * @Date : 2012. 9. 20.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class TableSchema {

	/** 컬럼 리스트 추출 SQL ID */
	private final String QUERY_ID_COLUMN_LIST = "columnList";
	/** 테이블 리스트 추출 SQL ID */
	private final String QUERY_ID_TABLE_LIST = "tableList";
	/** 스키마 */
	private final String SCHEMA_NAME = "STG_TAD_LOG";

	/**
	 * <pre>
	 * main
	 *
	 * <pre>
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		TableSchema tableSchema = new TableSchema();
		tableSchema.job();
	}

	/**
	 * <pre>
	 * job
	 *
	 * <pre>
	 */
	public void job() {
		Map<String, String> paramMap = makeParam();

		DBInfo dbInfo = new DBInfo();
		dbInfo.setDbType(DBType.MYSQL);
		dbInfo.setJdbcUrl("");
		dbInfo.setId("");
		dbInfo.setPw("");

		// 스키마 정보 추출
		SchemaVO data = getSchema(paramMap, dbInfo);

		JXLSExcelGenerator excelGenerator = new JXLSExcelGenerator();
		boolean isSuccess = ExcelHandler.createExcel(data, excelGenerator, ExcelBaseType.DB_SCHEMA);
		System.out.println("##job## isSuccess=" + isSuccess);
	}

	/**
	 * <pre>
	 * getSchema
	 * 스키마 정보 추출
	 * <pre>
	 * @param paramMap
	 * @param dbType
	 * @return
	 */
	public SchemaVO getSchema(Map<String, String> paramMap, DBInfo dbInfo) {
		Connection conn = null;
		ResultSet tableResultSet = null;
		ResultSet columnResultSet = null;
		PreparedStatement pstmt = null;

		SchemaVO schemaVO = new SchemaVO();
		List<TableVO> tableList = new ArrayList<TableVO>();

		try {
			Database database = DatabaseFactory.createInstance(dbInfo.getDbType());
			conn = database.getConnection(dbInfo.getJdbcUrl(), dbInfo.getId(), dbInfo.getPw());

			if (conn != null) {
				// 테이블 데이터 추출
				String resultQuery = getResultQuery(paramMap, QUERY_ID_TABLE_LIST);
				pstmt = conn.prepareStatement(resultQuery);
				tableResultSet = pstmt.executeQuery();

				while (tableResultSet.next()) {
					TableVO tableVO = new TableVO();
					tableVO.setTableName(tableResultSet.getString(1));
					tableVO.setTableComment(tableResultSet.getString(2));

					// 컬럼 데이터 추출
					paramMap.put("tableName", tableVO.getTableName());
					resultQuery = getResultQuery(paramMap, QUERY_ID_COLUMN_LIST);
					pstmt = conn.prepareStatement(resultQuery);
					columnResultSet = pstmt.executeQuery();

					while (columnResultSet.next()) {
						ColumnVO col = new ColumnVO();
						col.setRowNum(columnResultSet.getInt(1));
						col.setColumnName(columnResultSet.getString(2));
						col.setDataType(columnResultSet.getString(3));
						col.setDataTypeLength(columnResultSet.getLong(4));
						col.setNotNull(columnResultSet.getString(5));
						col.setColumnKey(columnResultSet.getString(6));
						col.setColumnDefault(columnResultSet.getString(7));
						col.setColumnComment(columnResultSet.getString(8));
						col.setExtra(columnResultSet.getString(9));
						// set column data
						tableVO.addColumn(col);
					}
					// set table data
					tableList.add(tableVO);
				}
				// set table list
				schemaVO.setTableList(tableList);
			}
		} catch (Exception ex) {
			System.out.println("##getTableList## (exception failed)");
			ex.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		return schemaVO;
	}

	/**
	 * <pre>
	 * getResultQuery
	 * sql 쿼리 추출
	 * <pre>
	 * @param paramMap
	 * @return
	 */
	private String getResultQuery(Map<String, String> paramMap, String queryId) {
		QueryLoad queryLoad = new QueryLoad();
		String tableSql = queryLoad.getQuery(queryId);
		String resultQuery = paramMapping(paramMap, tableSql);
		return resultQuery;
	}

	/**
	 * <pre>
	 * makeParam
	 * 스키마 name
	 * <pre>
	 * @return
	 */
	private Map<String, String> makeParam() {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("schemaName", SCHEMA_NAME);
		return paramMap;
	}

	/**
	 * <pre>
	 * appendMark
	 * 싱글 쿼테이션 마크 추가
	 * <pre>
	 * @param schemaName
	 * @return
	 */
	private String appendMark(String schemaName) {
		StringBuilder tableBuf = new StringBuilder();
		tableBuf.append("'");
		tableBuf.append(schemaName);
		tableBuf.append("'");
		return tableBuf.toString();
	}

	/**
	 * <pre>
	 * paramMapping
	 * sql 쿼리문에 파라미터 맵핑
	 * <pre>
	 * @param paramMap
	 * @param sql
	 * @return
	 */
	private String paramMapping(Map<String, String> paramMap, String sql) {
		Iterator<String> iterator = paramMap.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			String value = paramMap.get(key);
			String param = appendMark(value);

			sql = sql.replace("#" + key + "#", param);
		}

		return sql;
	}
}
