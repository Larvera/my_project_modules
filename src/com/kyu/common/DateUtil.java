package com.kyu.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;

/**
 * @FileName : DateUtil.java
 * @Project : sample_project
 * @Date : 2012. 9. 25.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class DateUtil {

	/**
	 * 한글 년월일을 취득
	 *
	 * @param yyyyMMdd
	 * @return Date
	 */
	public static String getHangulYyyyMMdd(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일");
		return sdf.format(date);
	}

	/**
	 * 한글 년월일을 취득
	 *
	 * @param yyyyMMdd
	 * @return Date
	 */
	public static String getHangulYyyyMMdd(String yyyyMMdd) {
		Date date = getDateToString(yyyyMMdd);
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일");
			return sdf.format(date);
		} else {
			return StringUtils.EMPTY;
		}
	}

	/**
	 * 입력한 포멧으로 날자를 출력 한다.
	 *
	 * @param yyyyMMdd
	 *            , fomat
	 * @return Date
	 */
	public static String getYyyyMMddaFomat(String yyyyMMdd, String fomat) {
		Date date = getDateToString(yyyyMMdd);
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(fomat);
			return sdf.format(date);
		} else {
			return StringUtils.EMPTY;
		}
	}

	/**
	 * 한글 년월을 취득
	 *
	 * @param yyyyMMdd
	 * @return Date
	 */
	public static String getHangulYyyyMM() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월");
		return sdf.format(new Date());
	}

	/**
	 * 문자열 날짜를 데이트형으로 변환
	 *
	 * @param yyyyMMdd
	 * @return Date
	 */
	public static Date getDateToString(String yyyyMMdd) {
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		try {
			return df.parse(yyyyMMdd);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * <pre>
	 * getDateToString2
	 *
	 * <pre>
	 * @param yyyyMM
	 * @return
	 */
	public static Date getDateToString2(String yyyyMM) {
		DateFormat df = new SimpleDateFormat("yyyyMM");
		try {
			return df.parse(yyyyMM);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 시스템 현재 연도 취득
	 *
	 * @return 시스템 현재 연도
	 */
	public static String getSystemYear() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return sdf.format(new Date());
	}

	/**
	 * 시스템 현재 월 취득
	 *
	 * @return 시스템 현재 월
	 */
	public static String getSystemMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		return sdf.format(new Date());
	}

	/**
	 * 시스템 현재 일 취득
	 *
	 * @return 시스템 현재 일
	 */
	public static String getSystemDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		return sdf.format(new Date());
	}

	/**
	 * 시스템 현재 년월 취득
	 *
	 * @return 시스템 현재 월
	 */
	public static String getSystemYearMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		return sdf.format(new Date());
	}

	/**
	 * 시스템 현재 년월일 취득
	 *
	 * @return 시스템 현재 월
	 */
	public static String getSystemYearMonthDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(new Date());
	}

	/**
	 * 현재 날짜시간을 기준으로 해당 날짜포멧 문자열 취득
	 *
	 * @return 포멧 문자열
	 */
	public static String getCurrentDate(String formatter) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatter);
		return sdf.format(new Date());
	}

	/**
	 * 현재 날짜시간을 기준으로 특정 시간만큼 이동한 날짜포멧 문자열 취득
	 *
	 * @param movedHour
	 * @param dateFormat
	 * @return
	 */
	public static String getCurrentDateMoveHour(int movedHour, String dateFormat) {
		Date today = new Date();
		Date movedDate = new Date(today.getTime() + (1000 * 60 * 60 * movedHour));

		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(movedDate);
	}

	/**
	 * 현재 날짜시간을 기준으로 특정 일만큼 이동한 날짜포멧 문자열 취득
	 *
	 * @param movedHour
	 * @param dateFormat
	 * @return
	 */
	public static String getCurrentDateMoveDate(int moveDate, String dateFormat) {
		Calendar today = Calendar.getInstance();
		today.set(Calendar.DAY_OF_MONTH, today.get(Calendar.DAY_OF_MONTH) + moveDate);

		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(today.getTime());
	}

	/**
	 * 현재 날짜시간을 기준으로 특정 일만큼 이동한 날짜포멧 문자열 취득
	 *
	 * @param movedHour
	 * @param dateFormat
	 * @return
	 */
	public static String getCurrentDateMoveMonth(int moveMonth, String dateFormat) {
		Calendar today = Calendar.getInstance();
		today.set(Calendar.MONTH, today.get(Calendar.MONTH) + moveMonth);

		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(today.getTime());
	}

	/**
	 * 특정 일 수만큼 날짜 이동하기.
	 *
	 * @param orgDate
	 * @param moveDateCnt
	 * @return
	 */
	public static Date getMoveDate(Date orgDate, int moveDateCnt) {
		Date movedDate = new Date();
		movedDate.setTime(orgDate.getTime() + ((long) moveDateCnt * 60 * 60 * 24 * 1000));
		return movedDate;
	}

	/**
	 * <pre>
	 * getMoveMonth
	 * 특정 월 수 만큼 이동
	 *
	 * <pre>
	 * @param orgDate
	 * @param moveDateCnt
	 * @return
	 */
	public static Date getMoveMonth(Date orgDate, int moveDateCnt) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(orgDate);
		calendar.add(2, moveDateCnt);
		return calendar.getTime();
	}

	/**
	 * 날짜를 특정 format으로 String 변환.
	 *
	 * @param orgDate
	 * @param formatter
	 * @return
	 */
	public static long getDateToLong(Date orgDate, String formatter) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatter);
		return Long.parseLong(sdf.format(orgDate));
	}

	public static String getDateToString(Date orgDate, String formatter) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatter);
		String strDate = sdf.format(orgDate);
		return strDate;
	}

	public static String addDateStr(int amount, String pattern) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(2, amount);
		return date2str(pattern, calendar.getTime());
	}

	/**
	 * <pre>
	 * addDayStr
	 * 현재 날짜시간을 기준으로 특정 시간만큼 이동한 날짜포멧 문자열 취득
	 *
	 * <pre>
	 * @param interval
	 * @param pattern
	 * @return
	 */
	public static String addDayStr(int interval, String pattern) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, interval);
		return date2str(pattern, calendar.getTime());
	}

	public static String date2str(String pattern, Date date) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		return df.format(date);
	}

	public static String getDate2str(String pattern, String date) {
		return date2str(pattern, getDateToString(date));
	}

	/**
	 * <pre>
	 * getDayOfWeek
	 * 요일 추출
	 *
	 * <pre>
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static int getDayOfWeek(String date) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date day = df.parse(date);

		Calendar cal = Calendar.getInstance();
		cal.setTime(day);

		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek;
	}

	/**
	 * <pre>
	 * getDiffDate
	 * 종료일 - 시작일 차이 추출
	 *
	 * <pre>
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	public static int getDiffDate(String startDate, String endDate) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date start = format.parse(startDate);
		Date end = format.parse(endDate);
		long startCurTime = start.getTime();
		long endCurTimeTemp = end.getTime();
		long diffDate = endCurTimeTemp - startCurTime;

		int result = (int) (diffDate / 86400000);
		return result;
	}

	public static Calendar getCalendar(String dateString) {
		Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT+09:00"), Locale.KOREA);
		calendar.setTime(string2Date(dateString, "yyyyMMdd"));

		return calendar;
	}

	public static Date string2Date(String s, String format) {
		java.util.Date d = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			d = sdf.parse(s, new ParsePosition(0));
		} catch (Exception e) {
			throw new RuntimeException("Date format not valid.");
		}
		return d;
	}

	public static String getDayInterval(String dateString, String format, int distance) {
		Calendar cal = getCalendar(dateString);
		cal.roll(Calendar.DATE, distance);
		Date d = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(d);
	}

	public static void main(String[] args) {
		String date = getDayInterval("2012-02-02", "yyyy-MM-dd", -1);
		System.out.println(date);
	}
}
