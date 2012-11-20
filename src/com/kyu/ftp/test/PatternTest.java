package com.kyu.ftp.test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;


/**
 * @FileName : PatternTest.java
 * @Project : sample_project
 * @Date : 2012. 4. 25.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class PatternTest {

	@Test
	public void file패턴매치테스트() {
		Pattern p = Pattern.compile("tad_daily.+20120425.csv");
		Matcher m = p.matcher("tad_daily_age_20120425.csv");
		boolean b = m.matches();

		assertThat(b, is(true));
	}
}
