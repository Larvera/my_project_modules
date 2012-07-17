package com.kyu.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;

/**
 * @FileName : BigDataFileHandler.java
 * @Project : sample_project
 * @Date : 2012. 7. 11.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class FileWriteHelper {

	/**
	 * <pre>
	 * getLoopCnt
	 * loop count 추출
	 * <pre>
	 * @param totalCnt
	 * @param limitSize
	 * @return
	 */
	public int getLoopCnt(int totalCnt, int limitSize) {
		int loopCnt = totalCnt / limitSize;
		return loopCnt;
	}

	/**
	 * <pre>
	 * getStartRowIdx
	 * 데이터 추출 start index
	 * <pre>
	 * @param loopIdx
	 * @param limitSize
	 * @return
	 */
	public int getStartRowIdx(int loopIdx, int limitSize) {
		int startRowIndex = loopIdx * limitSize;
		return startRowIndex;
	}

	/**
	 * <pre>
	 * makeTableInfoMsg
	 * 리플렉션을 이용하여 메시지 생성
	 * <pre>
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public String makeTableInfoMsg(Object obj) throws Exception {
		StringBuilder builder = new StringBuilder();

		Class<?> clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();

		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			field.setAccessible(true);

			Object value = fields[i].get(obj);
			String strValule = String.valueOf(value);
			String replaceValue = stringReplace(strValule);

			builder.append(replaceValue);
			builder.append(",");
		}

		String messageInfo = builder.toString();
		String message = messageInfo.substring(0, messageInfo.length() - 1);
		return message;
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
	private String stringReplace(String str) throws Exception {
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

	/**
	 * <pre>
	 * writeMsg
	 *
	 * <pre>
	 * @param msg
	 * @param path
	 * @throws Exception
	 */
	protected void writeMsg(String msg, String path) throws Exception {
		BufferedWriter bf = null;
		try {
			bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path), true), "utf-8"));
			bf.write(msg);
			bf.flush();
		} catch (Exception ex) {
			System.out.println("##writeMsg## (exception failed)");
			ex.printStackTrace();
			throw ex;
		} finally {
			if (bf != null) {
				try {
					bf.close();
				} catch (IOException ex) {}
			}
		}
	}

	/**
	 * <pre>
	 * makeFileName
	 * 파일 이름 생성
	 * </pre>
	 * @param prefix
	 * @param suffix
	 * @return
	 * @throws Exception
	 */
	public String getFileName(String prefix, String suffix, String day) throws Exception {
		StringBuilder fileName = new StringBuilder();
		fileName.append(prefix);
		fileName.append(day);
		fileName.append(suffix);
		return fileName.toString();
	}

	/**
	 * <pre>
	 * getPath
	 *
	 * <pre>
	 * @param fileName
	 * @param directory
	 * @param newPath
	 * @return
	 * @throws Exception
	 */
	public String getPath (String fileName, String newPath) throws Exception {
		StringBuilder path = new StringBuilder();
		path.append(newPath);
		path.append(File.separator);
		path.append(fileName);
		return path.toString();
	}

	/**
	 * <pre>
	 * makeFile
	 * 파일 생성
	 * 파일이 존재하면 삭제 후 재 생성
	 * </pre>
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public void makeFile(String path) throws Exception {
		File file = new File(path);
		if (file.isFile()) {
			boolean isDelete = file.delete();
			System.out.println("##makeFile## isDelete=" + isDelete + ", path=" + path);
		}

		boolean isFileCreate = file.createNewFile();
		System.out.println("##makeFile## isFileCreate=" + isFileCreate + ", path=" + path);
	}

	/**
	 * <pre>
	 * createDatePath
	 * 날짜별 디렉토리 생성
	 * <pre>
	 * @param directory
	 * @param yesterday
	 * @param dateFormat
	 * @return
	 */
	public static String createDatePath(String directory, String yesterday, String dateFormat) throws Exception {
        StringBuilder path = new StringBuilder();
        String replacePath = null;
        char otherSeparator = File.separatorChar;

        try {
        	String newPath = FileWriteDateUtil.dateParseFormat(yesterday, dateFormat);

            path.append(directory);
            path.append(File.separator);
            path.append(newPath);

        	String pathStr = path.toString();
        	if (otherSeparator == '\\') { // Window
        		replacePath = pathStr.replace('/', '\\');
        	} else { // Unix
        		replacePath = pathStr.replace('\\', '/');
        	}

            new File(replacePath).mkdirs();

        } catch (Exception ex) {
        	System.out.println("##createDatePath## (exception failed)");
        	ex.printStackTrace();
        	throw ex;
        }
        return replacePath;
    }

	/**
	 * <pre>
	 * main
	 *
	 * <pre>
	 * @param args
	 */
	public static void main(String[] args) {
		long imp = 0;
		String.valueOf(imp);
	}
}
