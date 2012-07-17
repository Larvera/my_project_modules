package com.kyu.file;

import java.util.List;

/**
 * @FileName : Main.java
 * @Project : sample_project
 * @Date : 2012. 7. 11.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class Main {

	/** limit size count */
	private static final int LIMIT_SIZE = 10;

	/**
	 * <pre>
	 * main
	 *
	 * <pre>
	 * @param args
	 */
	public static void main(String[] args) {
		Main main = new Main();
		main.job();
	}

	/**
	 * <pre>
	 * job
	 *
	 * <pre>
	 */
	public void job() {
		FileWriteHelper bigDataFileHandler = new FileWriteHelper();
		FileDataDAO fileDataDAO = new FileDataDAO();

		try {
			// 어제 일자
			String yesterday = FileWriteDateUtil.yesterDay();

			// 날짜별 디렉토리 생성
			String newPath = FileWriteHelper.createDatePath("E:/test/bigData", yesterday, "yyyy/MM");

			// 파일 name 추출
			String fileName = bigDataFileHandler.getFileName("test", ".csv", "20120716");

			// full path 추출
			String path = bigDataFileHandler.getPath(fileName, newPath);

			// 파일 생성
			bigDataFileHandler.makeFile(path);

			int totalMdnCnt = fileDataDAO.getTotalRowCnt();
			int loopCnt = bigDataFileHandler.getLoopCnt(totalMdnCnt, LIMIT_SIZE);
			System.out.println("##execute## newPath=" + newPath + ", totalMdnCnt=" + totalMdnCnt + ", loopCnt=" + loopCnt + ", heapSizeMB=" + getHeapMem());

			for (int i = 0; i <= loopCnt; i++) {
				int startRowIndex = bigDataFileHandler.getStartRowIdx(i, LIMIT_SIZE);

				// 파라미터 셋팅
				TableRowDataVO paramVO = new TableRowDataVO();
				paramVO.setStartRowIndex(startRowIndex);
				if (loopCnt == i) {
					paramVO.setLimitSize(totalMdnCnt);
				} else {
					paramVO.setLimitSize(startRowIndex + LIMIT_SIZE);
				}

				// limit size 만큼 데이터 추출
				List<TableRowDataVO> dataList = fileDataDAO.getRowData(paramVO);

				// message 생성
				StringBuilder msgBuf = new StringBuilder();
				for (TableRowDataVO rowDataVO : dataList) {
					try {
						String message = bigDataFileHandler.makeTableInfoMsg(rowDataVO);
						msgBuf.append(message);
						msgBuf.append("\n");
					} catch (Exception ex) {
						ex.printStackTrace();
						continue; // 메새지 생성 중 에러 발생 시 무시한다.
					}
				}

				// message file write
				bigDataFileHandler.writeMsg(msgBuf.toString(), path);
				System.out.println("##execute## loopIdx=" + i + ", startRowIndex=" + startRowIndex + ", path=" + path + ", heapSizeMB=" + getHeapMem() + ", freeMemoryMB=" + getFreeMemMB() + ", useMemoryMB=" + getUseMemMB());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * <pre>
	 * getFreeMemMB
	 *
	 * <pre>
	 * @return
	 */
	private String getFreeMemMB() {
		long freeMemory = Runtime.getRuntime().freeMemory();
		String freeMemoryMB = (freeMemory / (1024 * 1024)) + "MB";
		return freeMemoryMB;
	}

	/**
	 * <pre>
	 * getUseMemMB
	 * 여유 메모리
	 * <pre>
	 * @return
	 */
	private String getUseMemMB() {
		long heapSize = Runtime.getRuntime().totalMemory();
		long freeMemory = Runtime.getRuntime().freeMemory();
		long useMemory = heapSize - freeMemory;

		String useMemoryMB = (useMemory / (1024 * 1024)) + "MB";
		return useMemoryMB;
	}

	/**
	 * <pre>
	 * getHeapMem
	 *
	 * <pre>
	 * @return
	 */
	private String getHeapMem() {
		long heapSize = Runtime.getRuntime().totalMemory();
		String heapSizeMB = (heapSize / (1024 * 1024)) + "MB";
		return heapSizeMB;
	}
}
