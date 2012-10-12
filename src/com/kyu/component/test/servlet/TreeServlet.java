package com.kyu.component.test.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.kyu.component.test.servlet.vo.tree.GroupVO;
import com.kyu.component.test.servlet.vo.tree.InventoryVO;
import com.kyu.component.test.servlet.vo.tree.SiteVO;

/**
 * @FileName : TreeServlet.java
 * @Project : sample_project
 * @Date : 2012. 10. 10.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
@WebServlet("/tree.do")
public class TreeServlet extends HttpServlet {

	/**  */
	private static final long serialVersionUID = -7762944327896324597L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException,
			IOException {

		// inven
		List<InventoryVO> invenList = makeInvenList();

		// site
		List<SiteVO> siteList = makeSiteList(invenList);

		// group
		List<GroupVO> groupList = makeGroupList(siteList);

		req.setAttribute("groupList", groupList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/tree.jsp");
		dispatcher.forward(req, res);
	}

	/**
	 * <pre>
	 * makeGroupList
	 *
	 * <pre>
	 * @param siteList
	 */
	private List<GroupVO> makeGroupList(List<SiteVO> siteList) {
		List<GroupVO> groupList = new ArrayList<GroupVO>();
		GroupVO group = new GroupVO();
		group.setGroupName("A");
		group.setSiteList(siteList);

		GroupVO group2 = new GroupVO();
		group2.setGroupName("B");

		groupList.add(group);
		groupList.add(group2);

		return groupList;
	}

	/**
	 * <pre>
	 * makeSiteList
	 *
	 * <pre>
	 * @param invenList
	 * @return
	 */
	private List<SiteVO> makeSiteList(List<InventoryVO> invenList) {
		List<SiteVO> siteList = new ArrayList<SiteVO>();
		SiteVO site = new SiteVO();
		site.setSiteId("1");
		site.setSiteName("Nate");
		site.setInventoryList(invenList);

		SiteVO site2 = new SiteVO();
		site2.setSiteId("2");
		site2.setSiteName("Naver");

		siteList.add(site);
		siteList.add(site2);
		return siteList;
	}

	/**
	 * <pre>
	 * makeInvenList
	 *
	 * <pre>
	 * @return
	 */
	private List<InventoryVO> makeInvenList() {
		List<InventoryVO> invenList = new ArrayList<InventoryVO>();
		InventoryVO inven = new InventoryVO();
		inven.setInvenId("1");
		inven.setInvenName("mNATE_Main");
		inven.setInvenSize("480x72");

		InventoryVO inven2 = new InventoryVO();
		inven2.setInvenId("2");
		inven2.setInvenName("mNATE_Sub");
		inven2.setInvenSize("480x72");

		invenList.add(inven);
		invenList.add(inven2);
		return invenList;
	}
}
