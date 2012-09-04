package com.kyu.component.test.tld;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @FileName : SelectTag.java
 * @Project : sample_project
 * @Date : 2012. 9. 3.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class CustomTag extends SimpleTagSupport {

	private String username;

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	 */
	@Override
	public void doTag() throws JspException ,IOException {
		getJspContext().getOut().write("doTag!! userName=" + username);
	}
}
