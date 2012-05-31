
package com.kyu.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.kyu.common.Conf;


/**
 * @FileName : Logger.java
 * @Project : sample_project
 * @Date : 2012. 5. 31.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class LogFileWriter {

	/** log path */
	private static String LOG_DIRECTORY_PATH;
	/** 로그 suffix file name */
	private static String LOG_SUFFIX_FILE_NAME;
	/** log prefix file name */
	private static String LOG_PREFIX_FILE_SUFFIX;
	/** encoding */
	private static String CHARACTER_SET = "UTF-8";

	/**
	 * 객체 생성 방지
	 */
	private LogFileWriter() {
	}

	/**
	 * <pre>
	 * init
	 * 설정 셋팅
	 * <pre>
	 */
	public static void init() {
		LOG_DIRECTORY_PATH = Conf.getValue("log.directory.path");
		LOG_SUFFIX_FILE_NAME = Conf.getValue("file.name.prefix");
		LOG_PREFIX_FILE_SUFFIX = Conf.getValue("file.name.suffix");
	}

	/**
	 * <pre>
	 * logWrite
	 *
	 * </pre>
	 * @param msg
	 * @throws Exception
	 */
	public static void logWrite(RequestLogData requestLogData) throws Exception {
		BufferedWriter bufferedWriter = null;
		String logMsg = null;
		try {
			// log directory 생성
			makeLogDirectory();

			// log 파일 생성
			File fileName = makeLogFile();

			// 로그 메시지 생성
			logMsg = getLogMsg(requestLogData);

			bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true), CHARACTER_SET));
			bufferedWriter.write(logMsg);
			bufferedWriter.newLine();
			bufferedWriter.flush();

		} catch (IOException ex) {
			System.out.println("##appendLogger## (exception failed) logMsg=" + logMsg);
			ex.printStackTrace();
		} finally {
			if (bufferedWriter != null) {
				try {
					bufferedWriter.close();
				} catch (IOException ex) {}
			}
		}
	}

	/**
	 * <pre>
	 * getLogMsg
	 * 로그 메시지 생성
	 * <pre>
	 * @param requestLogData
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private static String getLogMsg(RequestLogData requestLogData) throws Exception {
		StringBuilder msgBuf = new StringBuilder();

		Class<RequestLogData> clazz = (Class<RequestLogData>) requestLogData.getClass();
		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			Object value = field.get(requestLogData);

			msgBuf.append(value);
			msgBuf.append(",");
		}

		String msg = cutSeparator(msgBuf.toString(), ",");
		return msg;
	}

	/**
	 * <pre>
	 * cutSeparator
	 * 마지막 , 삭제
	 * <pre>
	 * @param msg
	 * @param separator
	 * @return
	 */
	private static String cutSeparator(String msg, String separator) {
        if(msg.endsWith(separator)) {
        	return msg.substring(0, msg.length() - separator.length());
        } else {
        	return msg;
        }
	}

	/**
	 * <pre>
	 * makeLogDirectory
	 * 로그 디렉토리 생성
	 * <pre>
	 */
	private static void makeLogDirectory() {
		File logFile = new File(LOG_DIRECTORY_PATH);
		if (logFile.exists() == false) {
			logFile.mkdirs();
		}
	}

	/**
	 * <pre>
	 * makeLogFile
	 * 로그 파일 경로 path 생성
	 * <pre>
	 * @param date
	 * @return
	 */
	private static File makeLogFile() {
		String date = getCurrentDataByFormat("yyyyMMdd"); // 현재 일자

		StringBuilder path = new StringBuilder();
		path.append(LOG_DIRECTORY_PATH);
		path.append(LOG_SUFFIX_FILE_NAME);
		path.append(date);
		path.append(LOG_PREFIX_FILE_SUFFIX);

		File logFile = new File(path.toString());
		return logFile;
	}

	/**
	 * <pre>
	 * getCurrentDataByFormat
	 * 현재 년월일까지 반환
	 * </pre>
	 * @param format
	 * @return
	 */
	private static String getCurrentDataByFormat(String format) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(cal.getTime());
	}

	/**
	 * <pre>
	 * main
	 *
	 * <pre>
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder();
		builder.append("test");
		builder.append(2222);

	}
}
