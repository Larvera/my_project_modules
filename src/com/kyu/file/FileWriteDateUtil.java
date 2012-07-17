package com.kyu.file;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @FileName : BigDataFileDateUtil.java
 * @Project : sample_project
 * @Date : 2012. 7. 16.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class FileWriteDateUtil {

	/**
	 * <pre>
	 * dateParseFormat
	 *
	 * <pre>
	 * @param strDate
	 * @param format
	 * @return
	 * @throws Exception
	 */
	public static String dateParseFormat(String strDate, String format) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = sdf.parse(strDate);

		SimpleDateFormat transSdf = new SimpleDateFormat(format);
		String formatDate = transSdf.format(date);
		return formatDate;
	}

	/**
	 * <pre>
	 * getCurrentDate
	 * 포멧에 맞는 날짜 반환
	 * <pre>
	 * @param format
	 * @return
	 */
	public static String getCurrentDate(String format) {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(d);
	}

	/**
	 * <pre>
	 * yesterDay
	 * 어제 날짜 추출
	 * <pre>
	 * @return
	 */
	public static String yesterDay() {
		String date = getCurrentDate("yyyyMMdd");
		long chStart = 0;
		DateFormat df = new SimpleDateFormat("yyyyMMdd");

		try {
			chStart = df.parse(date).getTime();
			chStart -= 86400000; // 하루 전
			Date aa = new Date(chStart);
			date = df.format(aa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
}
