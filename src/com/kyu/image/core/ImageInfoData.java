package com.kyu.image.core;




/**
 * @FileName : ImageInfoData.java
 * @Project : sample_project
 * @Date : 2012. 7. 26.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class ImageInfoData {

	/** 원본 이미지 */
	private String orgImgPath;
	/** 이미지 타입 */
	private ImageType imageType;

	/**
	 * @return the orgImgPath
	 */
	public String getOrgImgPath() {
		return orgImgPath;
	}

	/**
	 * @param orgImgPath
	 *            the orgImgPath to set
	 */
	public void setOrgImgPath(String orgImgPath) {
		this.orgImgPath = orgImgPath;
	}

	/**
	 * @return the imageType
	 */
	public ImageType getImageType() {
		return imageType;
	}

	/**
	 * @param imageType
	 *            the imageType to set
	 */
	public void setImageType(ImageType imageType) {
		this.imageType = imageType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ImageInfoData [orgImgPath=" + orgImgPath + ", imageType=" + imageType + "]";
	}
}
