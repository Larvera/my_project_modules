package com.kyu.generator;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

public class VoGenerator { 

	public static void main(String[] args) throws SQLException, NamingException {
		
		// 테이블 정보를 가져온다 
		TableDictionary dictionary = new TableDictionary();
		ArrayList list = dictionary.getTableList(args);
		
		/*
		for (int idx = 0; idx < list.size(); idx++) {
			System.out.println("list idx : " + idx);
			System.out.println("list 테이블명 : " + ((TableInfo)list.get(idx)).getTableComments());
			System.out.println("list 영문테이블명 : " + ((TableInfo)list.get(idx)).getTableName());
			System.out.println("list 컬럼명 : " + ((TableInfo)list.get(idx)).getColumnComments());
			System.out.println("list 컬럼 : " + ((TableInfo)list.get(idx)).getColumns());
			System.out.println("list 널체크 : " + ((TableInfo)list.get(idx)).getNullFlag());
			System.out.println("list 타입 : " + ((TableInfo)list.get(idx)).getDataType());
			System.out.println("list 길이 : " + ((TableInfo)list.get(idx)).getDataLength());
			System.out.println("list 오더 : " + ((TableInfo)list.get(idx)).getColumnId());
		}
		*/
		CodeGenerator code = new CodeGenerator();
		String generatorVo = code.createCode(list);
		System.out.println("Generator Value Object = \n\n" + generatorVo);
		VoFileCreator.getInstance().createFile(generatorVo, code.getClassName());
		//t_notice, t_agent_ip_info, t_code_mast
	}
}
