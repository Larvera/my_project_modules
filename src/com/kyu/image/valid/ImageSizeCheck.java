package com.kyu.image.valid;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.kyu.image.core.ImageInfoData;
import com.kyu.image.core.ImageType;
import com.kyu.image.core.ImageValid;

/**
 * @FileName : ImageSizeCheck.java
 * @Project : sample_project
 * @Date : 2012. 8. 9.
 * @작성자 : 이남규
 * @프로그램설명 : 이미지 사이즈 체크
 */
public class ImageSizeCheck implements ImageValid {

	/**
	 * 이미지 사이즈 체크
	 */
	@Override
	public boolean valid(ImageInfoData data) throws IOException {
		String orgImgPath = data.getOrgImgPath();
		BufferedImage originalImage = ImageIO.read(new File(orgImgPath));
		int originWidth = originalImage.getWidth();
		int originHeight = originalImage.getHeight();

		// validation width, height 정보
		int validWidth = ImageType.BAR_BANNER.validWidthSize();
		int validHeight = ImageType.BAR_BANNER.validHeightSize();

		// validation check
		if (originWidth == validWidth && originHeight == validHeight) {
			return true;
		}

		System.out.println("##valid## (image size check failed) originWidth=" + originWidth + ", originHeight=" + originHeight + ", validWidth=" + validWidth + ", validHeight=" + validHeight + ", orgImgPath=" + orgImgPath);
		return false;
	}
}
