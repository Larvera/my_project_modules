package com.kyu.image.core;


/**
 * @FileName : ImageValid.java
 * @Project : sample_project
 * @Date : 2012. 8. 9.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public interface ImageValid {

	/**
	 * <pre>
	 * valid
	 * 이미지 validation 체크
	 * <pre>
	 * @return
	 */
	public boolean valid(ImageInfoData data) throws Exception;
}
