package com.kyu.mail.test;


/**
 * @FileName : PathTest.java
 * @Project : sample_project
 * @Date : 2012. 4. 3.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class PathTest {

	public static void main(String[] args) {

		String path = PathTest.class.getResource("").getPath();
		System.out.println(path);

	}
}
