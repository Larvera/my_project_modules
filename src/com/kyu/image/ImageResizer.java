package com.kyu.image;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;


/**
 * @FileName : AbstractImageResizer.java
 * @Project : sample_project
 * @Date : 2012. 7. 26.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class ImageResizer {

	/** 원본 이미지 객체 */
	private BufferedImage originalImage;
	/** 원본 이미지 가로 사이즈 */
	private int originWidth;
	/** 원본 이미지 세로 사이즈 */
	private int originHeight;

	/**
	 * <pre>
	 * sizeCheck
	 * 원본 이미지 가로, 세로 사이즈 체크
	 * <pre>
	 * @param orgImgPath
	 * @return
	 * @throws IOException
	 */
	public boolean sizeCheck(String orgImgPath) throws IOException {
		boolean isSuccess = false;

		originalImage = ImageIO.read(new File(orgImgPath));
		originWidth = originalImage.getWidth();
		originHeight = originalImage.getHeight();

		// validation width, height 정보
		int validWidth = ImageType.BAR_BANNER.validWidthSize();
		int validHeight = ImageType.BAR_BANNER.validHeightSize();

		// validation check
		if (originWidth == validWidth && originHeight == validHeight) {
			isSuccess = true;
		}

		System.out.println("##valid## isSuccess=" + isSuccess + ", originWidth=" + originWidth + ", originHeight=" + originHeight + ", validWidth=" + validWidth + ", validHeight=" + validHeight + ", orgImgPath=" + orgImgPath);
		return isSuccess;
	}

	/**
	 * <pre>
	 * process
	 * 이미지 resize process
	 * <pre>
	 * @param data
	 * @throws IOException
	 */
	public void process(ImageInfoData data) throws IOException {
		int type = getImgType();
		String imgFormat = data.getImageType().imgFormat();
		List<String> imgSizeList = data.getImageType().imageSizeList();

		for (String size : imgSizeList) {
			// 가로, 세로 사이즈 추출
			Map<String, Integer> sizeMap = getSize(size);
			int width = sizeMap.get("width");
			int height = sizeMap.get("height");

			// 이미지 리사이즈
			BufferedImage resizeImage = resizeImage(type, width, height);

			// 이미지 파일 생성
			String destResizeImgFilePath = makeDestImgFilePath(data, size);
			File destFile = new File(destResizeImgFilePath);
			ImageIO.write(resizeImage, imgFormat, destFile);
		}
	}

	/**
	 * <pre>
	 * resizeImage
	 * 이미지 리사이징
	 * <pre>
	 * @param type
	 * @param width
	 * @param height
	 * @return
	 */
	private BufferedImage resizeImage(int type, int width, int height) {
		BufferedImage resizedImage = new BufferedImage(width, height, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, width, height, null);
		g.dispose();

		return resizedImage;
	}


	/**
	 * <pre>
	 * resizeImageWithHint
	 * 이미지 리사이즈
	 * <pre>
	 * @param type
	 * @param width
	 * @param height
	 * @return
	 */
	@Deprecated
	@SuppressWarnings("unused")
	private BufferedImage resizeImageWithHint(int type, int width, int height) {
		BufferedImage resizedImage = new BufferedImage(width, height, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, width, height, null);
		g.dispose();
		g.setComposite(AlphaComposite.Src);

		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		return resizedImage;
	}

	/**
	 * <pre>
	 * getSize
	 * 가로, 세로 데이터 추출
	 * <pre>
	 * @param size
	 * @return
	 */
	private Map<String, Integer> getSize(String size) {
		Map<String, Integer> sizeMap = new HashMap<String, Integer>();
		String[] sizeArr = size.split("x");

		String widthStr = sizeArr[0];
		String heightStr = sizeArr[1];
		int width = Integer.parseInt(widthStr);
		int height = Integer.parseInt(heightStr);

		sizeMap.put("width", width);
		sizeMap.put("height", height);

		return sizeMap;
	}

	/**
	 * <pre>
	 * getImgType
	 *
	 * <pre>
	 * @return
	 */
	private int getImgType() {
		int imtType = 0;
		int originalImgType = originalImage.getType(); // 원본 이미지 type
		if (originalImgType == 0) {
			imtType = BufferedImage.TYPE_INT_ARGB;
		} else {
			imtType = originalImgType;
		}
		return imtType;
	}

	/**
	 * <pre>
	 * getDestImgFilePath
	 * resize 이미지 path 생성
	 * <pre>
	 * @param orgImgPath
	 * @param imgFormat
	 * @param size
	 */
	private String makeDestImgFilePath(ImageInfoData data, String size) {
		String orgImgPath = data.getOrgImgPath();
		String imgFormat = data.getImageType().imgFormat();

		int idx = orgImgPath.lastIndexOf(".");
		String destFilePrefix = orgImgPath.substring(0, idx);

		StringBuilder destFilePathBuf = new StringBuilder();
		destFilePathBuf.append(destFilePrefix);
		destFilePathBuf.append(size);
		destFilePathBuf.append(".");
		destFilePathBuf.append(imgFormat);

		return destFilePathBuf.toString();
	}
}
