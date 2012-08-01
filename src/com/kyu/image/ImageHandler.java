package com.kyu.image;


/**
 * @FileName : ImageHandler.java
 * @Project : sample_project
 * @Date : 2012. 7. 26.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class ImageHandler {

	/**
	 * <pre>
	 * job
	 * 이미지 resize handle
	 * <pre>
	 * @param data
	 * @return
	 */
	public boolean job(ImageInfoData data) {
		boolean isSuccess = false;
		try {
			ImageResizer resizer = new ImageResizer();
			String orgImgPath = data.getOrgImgPath();

			// 이미지 사이즈 체크
			isSuccess = resizer.sizeCheck(orgImgPath);
			if (isSuccess) {
				resizer.process(data); // 이미지 resize
			}

		} catch (Exception ex) {
			System.out.println("##job## (exception failed) data=" + data);
			isSuccess = false;
		}

		return isSuccess;
	}
}
