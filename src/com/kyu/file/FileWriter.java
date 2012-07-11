package com.kyu.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @FileName : FileWriter.java
 * @Project : sample_project
 * @Date : 2012. 7. 11.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class FileWriter {

	/**
	 * <pre>
	 * writeMsg
	 *
	 * <pre>
	 * @param msg
	 * @param path
	 * @throws Exception
	 */
	protected void writeMsg(String msg, String path) throws Exception {
		BufferedWriter bf = null;
		try {
			bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path), true), "UTF-8"));
			bf.write(msg);
			bf.flush();
		} catch (Exception ex) {
			System.out.println("##writeMsg## (exception failed)");
			throw ex;
		} finally {
			if (bf != null) {
				try {
					bf.close();
				} catch (IOException ex) {}
			}
		}
	}
}
