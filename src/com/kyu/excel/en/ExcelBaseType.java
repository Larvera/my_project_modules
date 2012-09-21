package com.kyu.excel.en;


/**
 * @FileName : ExcelType.java
 * @Project : sample_project
 * @Date : 2012. 8. 13.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public enum ExcelBaseType {

	// 캠페인
	REPORT_CAMPAIGN("report_campaign.xls") {
		@Override
		public String downloadFileName() {
			return "캠페인.xls";
		}
	}
	// DB 스키마
	, DB_SCHEMA("db_schema.xls") {
		@Override
		public String downloadFileName() {
			return "DB.xls";
		}
	};

	private ExcelBaseType(String excelFileName) {
		this.excelFileName = excelFileName;
	}

	/** excelFileName */
	private String excelFileName;

	/**
	 * @return the excelFileName
	 */
	public String getExcelFileName() {
		return excelFileName;
	}

	/**
	 * <pre>
	 * downloadFileName
	 * 다운로드 파일 name
	 * <pre>
	 * @return
	 */
	public abstract String downloadFileName();
}

