package com.kyu.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class VoFileCreator {

	private static VoFileCreator voFileCreat = new VoFileCreator();

	private VoFileCreator() {
	} 

	public static VoFileCreator getInstance() {
		return voFileCreat;
	}

	String rootPath = "C:/"; // 루트 디렉토리
	String filename;


	public void createFile(String generatorVo, String tableName) {
		filename = tableName + ".java";

		try {
			File file = new File(rootPath, filename);
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));

			bw.write(generatorVo);
			bw.flush();
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
			e.getMessage();
			
		}
	}

}
