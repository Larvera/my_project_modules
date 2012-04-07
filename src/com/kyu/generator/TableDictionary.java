package com.kyu.generator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TableDictionary {

	public ArrayList getTableList(String[] tableName) {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList list = new ArrayList();

		try {
			String jdbc_url = "jdbc:oracle:thin:@ip번호:SID명";
			String db_id = "유저아이디";
			String db_pwd = "패스워드";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(jdbc_url, db_id, db_pwd);

			if (con != null) {
				String params = "";
				for (int i = 0; i < tableName.length; i++) {
					if (tableName[i].toString().endsWith(",")) {
						params += "'" + tableName[i].toString().substring(0, tableName[i].toString().length() - 1)
								+ "',";
					} else {
						params += "'" + tableName[i].toString() + "',";
					}
					System.out.println("table name = " + tableName[i].toString());
				}

				if (params.endsWith(",")) {
					params = params.substring(0, params.length() - 1);
				}
				System.out.println("tables : " + params);

				String sql = "SELECT b.comments tableComments,  " + "       a.table_name tableName,    "
						+ "       c.comments columnComments, " + "       a.column_name columns,     "
						+ "       (CASE a.nullable WHEN 'Y' THEN 'Y' END) nullFlag , "
						+ "       a.data_type dataType , " + "       a.data_length dataLength , "
						+ "       a.column_id columnId "
						+ "  FROM user_tab_columns a, user_tab_comments b, user_col_comments c "
						+ " WHERE (a.table_name = b.table_name) "
						+ "   AND (a.table_name = c.table_name AND a.column_name = c.column_name) "
						+ "   AND b.table_type = 'TABLE'" + "   AND a.TABLE_NAME in (" + params.toUpperCase() + ")";

				System.out.println("SQL : " + sql);

				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					TableInfo tbInfo = new TableInfo();

					tbInfo.setTableComments(rs.getString(1));
					tbInfo.setTableName(rs.getString(2));
					tbInfo.setColumnComments(rs.getString(3));
					tbInfo.setColumns(rs.getString(4));
					tbInfo.setNullFlag(rs.getString(5));
					tbInfo.setDataType(rs.getString(6));
					tbInfo.setDataLength(rs.getString(7));
					tbInfo.setColumnId(rs.getString(8));

					list.add(tbInfo);
				}
			}
			rs.close();
			pstmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
