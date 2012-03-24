package com.kyu.generator;

import java.util.ArrayList;

public class CodeGenerator {

	private String className = "";
	
	
	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
	} 


	public String createCode(ArrayList list) {
		StringBuffer code = new StringBuffer();
		code.append("public class ");
		System.out.println("클래스 지정합니다. : " + ((TableInfo)list.get(0)).getTableName());
		this.setClassName(((TableInfo)list.get(0)).getTableName());
		code.append(this.getClassName() + " { \n");
		
		//property 생성
		for(int idx=0; idx < list.size() ; idx++){
			String dataType = "";
			String columnName = "";
			String columnComment = "";
			if(((TableInfo)list.get(idx)).getDataType().startsWith("NUM")){
				if(Integer.parseInt(((TableInfo)list.get(idx)).getDataLength().toString()) < 10 ){
					dataType = "int";
				} else {
					dataType = "long";
				}
			}else if(((TableInfo)list.get(idx)).getDataType().startsWith("VAR") 
					|| ((TableInfo)list.get(idx)).getDataType().startsWith("CHAR")
					|| ((TableInfo)list.get(idx)).getDataType().startsWith("CLOB") 
					|| ((TableInfo)list.get(idx)).getDataType().startsWith("DATE")){
				dataType = "String";
			}else if(((TableInfo)list.get(idx)).getDataType().startsWith("BICDEC")){
				dataType = "long";
			}
			
			columnName = ((TableInfo)list.get(idx)).getColumns().toLowerCase();
			columnComment = ((TableInfo)list.get(idx)).getColumnComments();
			
			if(null != columnComment) {
				code.append("\t/** " + columnComment + " */ \n");
			} else {
				code.append("\n");
			}
			code.append("\tprivate " + dataType + " " + columnName + ";\n"); 
			code.append("\n ");
			
			
			
		}
	
		for(int idx=0; idx < list.size() ; idx++){
			String dataType = "";
			String columnName = "";
			String columnComment = "";
			if(((TableInfo)list.get(idx)).getDataType().startsWith("NUM")){
				if(Integer.parseInt(((TableInfo)list.get(idx)).getDataLength().toString()) < 10 ){
					dataType = "int";
				} else {
					dataType = "long";
				}
			}else if(((TableInfo)list.get(idx)).getDataType().startsWith("VAR") 
					|| ((TableInfo)list.get(idx)).getDataType().startsWith("CHAR")
					|| ((TableInfo)list.get(idx)).getDataType().startsWith("CLOB") 
					|| ((TableInfo)list.get(idx)).getDataType().startsWith("DATE")){
				dataType = "String";
			}else if(((TableInfo)list.get(idx)).getDataType().startsWith("BICDEC")){
				dataType = "long";
			}
			
			columnName = ((TableInfo)list.get(idx)).getColumns().toLowerCase();
			columnComment = ((TableInfo)list.get(idx)).getColumnComments();
		
			//setter
			code.append("\tpublic void set" + changeInitCap(columnName) + "(" + dataType + " " + columnName + ") { \n");
			code.append("\t\tthis." + columnName + " = " + columnName + ";\n");
			code.append("\t}\n");
			
			//컬럼 comment
			if(null != columnComment) {
				code.append("\t/** " + columnComment + " */ \n");
			} else {
				code.append("\n");
			}
			//getter
			code.append("\tpublic " + dataType + " get" + changeInitCap(columnName) + "() { \n");
			code.append("\t\treturn " + columnName + ";\n");
			code.append("\t}\n\n");
		}
		code.append("}\n");		
		return code.toString();
	}
	/**
	 * 첫 글자를 대문자로 치환 
	 * @param str
	 * @return
	 */
	public String changeInitCap(String str){
		
		char[] arrChar = str.toCharArray();
		arrChar[0] = Character.toUpperCase(arrChar[0]);
		
		return String.valueOf(arrChar);
	}
	
}
