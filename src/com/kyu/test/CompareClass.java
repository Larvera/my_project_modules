package com.kyu.test;

/**
 * @FileName : CompareClass.java
 * @Project : sample_project
 * @Date : 2012. 4. 16.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class CompareClass {

	public static void main(String[] args) {

		CompareClass compareClass = new CompareClass();
		System.out.println(compareClass.hashCode());
		System.out.println(compareClass.getClass());
		System.out.println(CompareClass.class);

		if (compareClass.getClass().equals(CompareClass.class)) {
			System.out.println("true!!!");
		}

		if (compareClass.getClass() == CompareClass.class) {
			System.out.println("이건?");
		}
	}
}
