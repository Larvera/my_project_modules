package com.kyu.generator;

import java.util.List;

/**
 * @FileName : CodeGenerator.java
 * @Project : sample_project
 * @Date : 2012. 7. 9.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class CodeGenerator {

	/** 클래스 name */
	private String className;

	public String getClassName() {
		return className;
	}

	/**
	 * <pre>
	 * createCode
	 *
	 * <pre>
	 * @param tableRowList
	 * @return
	 */
	public String createCode(List<TableRowVO> tableRowList) {
		StringBuilder code = new StringBuilder();
		code.append("public class ");
		className = tableRowList.get(0).getTableName();
		code.append(className + " { \n");

		// member field 생성
		for (TableRowVO tableVO : tableRowList) {
			String dataType = getDataType(tableVO);
			String columnName = tableVO.getColumn().toLowerCase();
			String columnComment = tableVO.getColumnComment();

			if (columnComment != null) {
				code.append("\t/** " + columnComment + " */ \n");
			} else {
				code.append("\n");
			}
			code.append("\tprivate " + dataType + " " + columnName + ";\n");
			code.append("\n ");
		}

		// setter, getter 생성
		for (TableRowVO rowVO : tableRowList) {
			String dataType = getDataType(rowVO);
			String columnName = rowVO.getColumn().toLowerCase();
			String columnComment = rowVO.getColumnComment();

			// setter
			code.append("\tpublic void set" + changeInitCap(columnName) + "(" + dataType + " " + columnName + ") { \n");
			code.append("\t\tthis." + columnName + " = " + columnName + ";\n");
			code.append("\t}\n");

			if (columnComment != null) {
				code.append("\t/** " + columnComment + " */ \n");
			} else {
				code.append("\n");
			}

			// getter
			code.append("\tpublic " + dataType + " get" + changeInitCap(columnName) + "() { \n");
			code.append("\t\treturn " + columnName + ";\n");
			code.append("\t}\n\n");
		}

		code.append("}\n");
		return code.toString();
	}

	/**
	 * <pre>
	 * getDataType
	 *
	 * <pre>
	 * @param tableVO
	 * @param dataType
	 * @return
	 */
	private String getDataType(TableRowVO tableVO) {
		String dataType = null;
		String type = tableVO.getDataType();

		if (type.startsWith("int")) {
			dataType = "int";
		} else if (type.startsWith("bigint")) {
			dataType = "long";
		} else if (type.startsWith("double")) {
			dataType = "double";
		} else if (type.startsWith("char") || type.startsWith("varchar")
				|| type.startsWith("datetime") || type.startsWith("date")) {
			dataType = "String";
		}

		return dataType;
	}

	/**
	 * <pre>
	 * changeInitCap
	 * 첫 글자 대문자로 치환
	 *
	 * <pre>
	 * @param str
	 * @return
	 */
	public String changeInitCap(String str) {
		char[] arrChar = str.toCharArray();
		arrChar[0] = Character.toUpperCase(arrChar[0]);
		return String.valueOf(arrChar);
	}

}
