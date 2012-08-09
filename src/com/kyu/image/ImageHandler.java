package com.kyu.image;

import java.util.ArrayList;
import java.util.List;

import com.kyu.image.core.ImageInfoData;
import com.kyu.image.core.ImageResizer;
import com.kyu.image.core.ImageValid;
import com.kyu.image.valid.ImageMimeTypeCheck;
import com.kyu.image.valid.ImageSizeCheck;



/**
 * @FileName : ImageHandler.java
 * @Project : sample_project
 * @Date : 2012. 7. 26.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class ImageHandler {

	/** validation check list */
	private final List<ImageValid> validCheckList;

	/**
	 * constructor
	 */
	public ImageHandler() {
		validCheckList = new ArrayList<ImageValid>();
		validCheckList.add(new ImageMimeTypeCheck());
		validCheckList.add(new ImageSizeCheck());
	}

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
			for (ImageValid imageValid : validCheckList) {
				isSuccess = imageValid.valid(data);

				// validation check 실패의 경우
				if (isSuccess == false) {
					return false;
				}
			}

			// 이미지 resize
			ImageResizer resizer = new ImageResizer(data);
			resizer.process();

		} catch (Exception ex) {
			System.out.println("##job## (exception failed) data=" + data);
			isSuccess = false;
		}

		return isSuccess;
	}
}
