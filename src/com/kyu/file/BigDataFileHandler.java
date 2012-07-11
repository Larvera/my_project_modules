package com.kyu.file;

import java.lang.reflect.Field;

/**
 * @FileName : BigDataFileHandler.java
 * @Project : sample_project
 * @Date : 2012. 7. 11.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class BigDataFileHandler {

	public void createFileProcess() {

	}

	private static String makeTableInfoMsg(Object obj) throws Exception {
		StringBuilder builder = new StringBuilder();

		Class<?> clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();

		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			field.setAccessible(true);

			Object value = field.get(obj);
			builder.append(value);
			builder.append(",");
		}
		return builder.toString();
	}

	/**
	 * <pre>
	 * stringReplace
	 * 특수문자 삭제
	 *
	 * </pre>
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public String stringReplace(String str) throws Exception {
		if (str == null) {
			return null;
		}

		String strTemp = null;
		String filterWord = ",|\r|\n";
		String[] arrWord = filterWord.split("\\|");

		for (int i = 0; i < arrWord.length; i++) {
			strTemp = str.replaceAll(arrWord[i], "");
			str = strTemp;
		}
		return str;
	}
}
