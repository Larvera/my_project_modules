package com.kyu.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @FileName : VoFileCreator.java
 * @Project : sample_project
 * @Date : 2012. 7. 9.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class VoFileCreator {

	/** root directory */
	private final String rootPath = "C:/";
	/** 파일 이름 */
	private String fileName;

	/**
	 * <pre>
	 * createFile
	 * VO 파일 생성
	 * <pre>
	 * @param generatorVO
	 * @param tableName
	 */
	public void createFile(String generatorVO, String tableName) {
		fileName = tableName + ".java";
		BufferedWriter bw = null;
		try {
			File file = new File(rootPath, fileName);
			bw = new BufferedWriter(new FileWriter(file));

			bw.write(generatorVO);
			bw.flush();

		} catch (IOException ex) {
			System.out.println("##createFile## (exception failed) rootPath=" + rootPath + ", fileName=" + fileName);
			ex.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {}
			}
		}
	}

}
