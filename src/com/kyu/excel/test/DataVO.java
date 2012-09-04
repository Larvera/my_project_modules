package com.kyu.excel.test;

/**
 * @FileName : DataVO.java
 * @Project : sample_project
 * @Date : 2012. 9. 4.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class DataVO {
	private int count;
	private long imp;
	private long click;
	private long amount;
	private String test;

	/**
	 * @return the test
	 */
	public String getTest() {
		return test;
	}
	/**
	 * @param test the test to set
	 */
	public void setTest(String test) {
		this.test = test;
	}
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * @return the imp
	 */
	public long getImp() {
		return imp;
	}
	/**
	 * @param imp the imp to set
	 */
	public void setImp(long imp) {
		this.imp = imp;
	}
	/**
	 * @return the click
	 */
	public long getClick() {
		return click;
	}
	/**
	 * @param click the click to set
	 */
	public void setClick(long click) {
		this.click = click;
	}
	/**
	 * @return the amount
	 */
	public long getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(long amount) {
		this.amount = amount;
	}
}
