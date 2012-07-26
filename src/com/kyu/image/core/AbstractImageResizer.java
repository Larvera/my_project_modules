package com.kyu.image.core;

/**
 * @FileName : AbstractImageResizer.java
 * @Project : sample_project
 * @Date : 2012. 7. 26.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public abstract class AbstractImageResizer {

	public void process(ImageInfoData data) {

		// validation 체크 (가로, 세로 사이즈)
		boolean isSuccess = valid(data);
		if (isSuccess == false) {
			System.out.println("##process## (valid failed) data=" + data);
			return;
		}

		// 원본 이미지 path 파싱
		imgPathParsing();

		// 이미지 resize
		resize();
	}

	protected abstract boolean valid(ImageInfoData data);

	protected abstract void resize();

	protected abstract void imgPathParsing();
}
