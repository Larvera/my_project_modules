/*
 * @(#)InitServlet.java	2011. 5. 28
 *
 * Copyright(c) 2009 INCROSS Ltd.
 *
 * NOTICE:
 * This source code that is confidential and proprietary to INCROSS Ltd.
 * No part of this source code may be reproduced in any form
 * whatsoever without prior approval by INCROSS Ltd.
 */
package com.kyu.common;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;



/**
 * The Class InitServlet.
 */
public class InitServlet extends HttpServlet {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** START */
	private final String START_MSG = "START";
	/** END */
	private final String END_MSG = "END";

    /* (non-Javadoc)
     * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
     */
    @Override
    public void init(ServletConfig sc) throws ServletException {
    	statLog(START_MSG);
        try {
        	Conf.init();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    }

    /* (non-Javadoc)
     * @see javax.servlet.GenericServlet#destroy()
     */
    @Override
    public void destroy() {
    	statLog(END_MSG);
    }

    /**
     * <pre>
     * statLog
     *
     * <pre>
     * @param log
     */
    public void statLog(String log) {
    	System.out.println("##########################################");
    	System.out.println("## SAMPLE PROJECT " + log);
    	System.out.println("##########################################");
    }
}
