package com.kyu.image.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @FileName : ImageType.java
 * @Project : sample_project
 * @Date : 2012. 7. 26.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public enum ImageType {

	// 바 배너
	BAR_BANNER("com.kyu.image.BarBannerResizer") {
		@Override
		public List<String> imageSizeList() {
			List<String> imageSizeList = new ArrayList<String>();
			imageSizeList.add("100x200");
			imageSizeList.add("200x300");
			return imageSizeList;
		}
	}
	// 전면 배너
	, FULL_BANNER("com.kyu.image.FullBannerResizer") {
		@Override
		public List<String> imageSizeList() {
			List<String> imageSizeList = new ArrayList<String>();
			imageSizeList.add("100x200");
			imageSizeList.add("200x300");
			return imageSizeList;
		}
	};

	/**
	 * constructor
	 */
	private ImageType(String className) {
		this.className = className;
	}

	/** class path */
	private String className;

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * <pre>
	 * sizeList
	 *
	 * <pre>
	 * @return
	 */
	public abstract List<String> imageSizeList();
}
