/*
 * @(#)Conf.java	2011. 5. 28
 *
 * Copyright(c) 2009 INCROSS Ltd.
 *
 * NOTICE:
 * This source code that is confidential and proprietary to INCROSS Ltd.
 * No part of this source code may be reproduced in any form
 * whatsoever without prior approval by INCROSS Ltd.
 */
package com.kyu.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The Class Conf.
 */
public class Conf {

	/** The m pro. */
	private static Properties mPro = null;

	/** The m pp url. */
	public static String mPpUrl = "conf.properties";

	/**
	 *
	 */
	public Conf() {
	}

	/**
	 * <pre>
	 * init
	 *
	 * <pre>
	 * @param propertyPath
	 * @throws IOException
	 */
	public static void init(String propertyPath) throws IOException {
		FileInputStream fIn = new FileInputStream(propertyPath);
		Conf conf = new Conf();
		mPro = conf.loadProperties(fIn);
	}

	/**
	 * Inits the.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void init() throws IOException {
		InputStream in = Conf.class.getClassLoader().getResourceAsStream(mPpUrl);
		Conf conf = new Conf();
		mPro = conf.loadProperties(in);
	}

	/**
	 * <pre>
	 * loadProperties
	 *
	 * <pre>
	 * @param in
	 * @return
	 * @throws IOException
	 */
	private Properties loadProperties(InputStream in) throws IOException {
		Properties properties = new Properties();
		properties.load(in);
		return properties;
	}

	/**
	 * <pre>
	 * getValue
	 *
	 * <pre>
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
		return mPro.getProperty(key);
	}

	/**
	 * <pre>
	 * getIntValue
	 *
	 * <pre>
	 * @param string
	 * @return
	 */
	public static int getIntValue(String string) {
		String value = mPro.getProperty(string);
		if (value != null)
			return Integer.parseInt(value);
		return 0;
	}
}
