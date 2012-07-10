package com.kyu.generator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.kyu.generator.db.DBType;
import com.kyu.generator.db.Database;
import com.kyu.generator.db.DatabaseFactory;
import com.kyu.generator.db.QueryLoad;

public class TableDictionary {

	/**
	 * <pre>
	 * getTableList
	 * 테이블 컬럼 정보 추출
	 *
	 * <pre>
	 * @param tableNames
	 * @return
	 */
	public List<TableRowVO> getTableList(Map<String, List<String>> paramMap, DBType dbType) {
		Connection conn = null;
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		List<TableRowVO> tableRowList = new ArrayList<TableRowVO>();

		try {
			Database database = DatabaseFactory.createInstance(dbType);
			conn = database.getConnection();

			if (conn != null) {
				QueryLoad queryLoad = new QueryLoad();
				String sql = queryLoad.getQuery(dbType.getQueryId());

				String resultQuery = paramMapping(paramMap, sql);
				pstmt = conn.prepareStatement(resultQuery);
				resultSet = pstmt.executeQuery();

				while (resultSet.next()) {
					TableRowVO rowVO = new TableRowVO();

					rowVO.setTableComment(resultSet.getString(1));
					rowVO.setTableName(resultSet.getString(2));
					rowVO.setColumnComment(resultSet.getString(3));
					rowVO.setColumn(resultSet.getString(4));
					rowVO.setDataType(resultSet.getString(5));
					rowVO.setDataLength(resultSet.getString(6));

					tableRowList.add(rowVO);
				}
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

		return tableRowList;
	}

	/**
	 * <pre>
	 * makeParam
	 *
	 * <pre>
	 * @param tableNames
	 * @return
	 */
	private String makeParam(List<String> tableNames) {
		StringBuilder tableBuf = new StringBuilder();
		for (String tableName : tableNames) {
			tableBuf.append("'");
			tableBuf.append(tableName);
			tableBuf.append("'");
			tableBuf.append(",");
		}

		String paramInfo = tableBuf.toString();
		String param = paramInfo.substring(0, paramInfo.length() - 1);
		return param;
	}

	/**
	 * <pre>
	 * getMessageMaping
	 *
	 * <pre>
	 * @param paramMap
	 * @param query
	 * @return
	 */
	private String paramMapping(Map<String, List<String>> paramMap, String sql) {
		Iterator<String> iterator = paramMap.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			List<String> paramList = paramMap.get(key);
			String param = makeParam(paramList);

			sql = sql.replace("#" + key + "#", param);
		}

		return sql;
	}
}
