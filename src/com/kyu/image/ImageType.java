package com.kyu.image;

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
	BAR_BANNER {
		@Override
		public List<String> imageSizeList() {
			List<String> imageSizeList = new ArrayList<String>();
			imageSizeList.add("100x200");
			imageSizeList.add("200x300");
			imageSizeList.add("400x500");
			imageSizeList.add("800x120");
			return imageSizeList;
		}

		@Override
		public int validWidthSize() {
			return 800;
		}

		@Override
		public int validHeightSize() {
			return 120;
		}

		@Override
		public String imgFormat() {
			return "jpg";
		}
	}
	// 전면 배너
	, FULL_BANNER {
		@Override
		public List<String> imageSizeList() {
			List<String> imageSizeList = new ArrayList<String>();
			imageSizeList.add("400x800");
			imageSizeList.add("800x1200");
			return imageSizeList;
		}

		@Override
		public int validWidthSize() {
			return 400;
		}

		@Override
		public int validHeightSize() {
			return 800;
		}

		@Override
		public String imgFormat() {
			return "png";
		}
	};

	/**
	 * <pre>
	 * imageSizeList
	 * 사이즈 리스트
	 * <pre>
	 * @return
	 */
	public abstract List<String> imageSizeList();

	/**
	 * <pre>
	 * validWidthSize
	 * 유효성 검사 가로 사이즈
	 * <pre>
	 * @return
	 */
	public abstract int validWidthSize();

	/**
	 * <pre>
	 * validHeightSize
	 * 유효성 검사 세로 사이즈
	 * <pre>
	 * @return
	 */
	public abstract int validHeightSize();

	/**
	 * <pre>
	 * imgFormat
	 * 이미지 format (JPG, PNG 등)
	 * <pre>
	 * @return
	 */
	public abstract String imgFormat();

}
