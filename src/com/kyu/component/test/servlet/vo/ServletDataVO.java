package com.kyu.component.test.servlet.vo;

/**
 * @FileName : DataVO.java
 * @Project : sample_project
 * @Date : 2012. 9. 11.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class ServletDataVO {
	private long imp;
	private long click;
	private String adsName;

	/**
	 * @return the imp
	 */
	public long getImp() {
		return imp;
	}

	/**
	 * @param imp
	 *            the imp to set
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
	 * @param click
	 *            the click to set
	 */
	public void setClick(long click) {
		this.click = click;
	}

	/**
	 * @return the adsName
	 */
	public String getAdsName() {
		return adsName;
	}

	/**
	 * @param adsName
	 *            the adsName to set
	 */
	public void setAdsName(String adsName) {
		this.adsName = adsName;
	}
}
