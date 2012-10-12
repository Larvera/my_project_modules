package com.kyu.component.test.servlet.vo.tree;

import java.util.List;

/**
 * @FileName : SiteVO.java
 * @Project : sample_project
 * @Date : 2012. 10. 10.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class SiteVO {

	private String siteName;
	private String siteId;

	private List<InventoryVO> inventoryList;

	/**
	 * @return the inventoryList
	 */
	public List<InventoryVO> getInventoryList() {
		return inventoryList;
	}

	/**
	 * @param inventoryList the inventoryList to set
	 */
	public void setInventoryList(List<InventoryVO> inventoryList) {
		this.inventoryList = inventoryList;
	}

	/**
	 * @return the siteName
	 */
	public String getSiteName() {
		return siteName;
	}

	/**
	 * @param siteName
	 *            the siteName to set
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	/**
	 * @return the siteId
	 */
	public String getSiteId() {
		return siteId;
	}

	/**
	 * @param siteId
	 *            the siteId to set
	 */
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

}
