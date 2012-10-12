package com.kyu.component.test.servlet.vo.tree;

import java.util.List;

/**
 * @FileName : GroupVO.java
 * @Project : sample_project
 * @Date : 2012. 10. 10.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class GroupVO {

	private String groupName;
	private List<SiteVO> siteList;

	/**
	 * @return the siteList
	 */
	public List<SiteVO> getSiteList() {
		return siteList;
	}

	/**
	 * @param siteList the siteList to set
	 */
	public void setSiteList(List<SiteVO> siteList) {
		this.siteList = siteList;
	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


}
