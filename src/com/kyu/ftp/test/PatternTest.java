package com.kyu.ftp.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @FileName : PatternTest.java
 * @Project : sample_project
 * @Date : 2012. 4. 25.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class PatternTest {

	public static void main(String[] args) {
		Pattern p = Pattern.compile("tad_daily.+20120425.csv");
		Matcher m = p.matcher("tad_daily_age_20120425.csv");
		boolean b = m.matches();
		System.out.println(b);
	}
}
