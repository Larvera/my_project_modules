package com.kyu.excel.core.parse;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 * @FileName : ExcelParser.java
 * @Project : sample_project
 * @Date : 2012. 9. 24.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class ExcelParser {

	/** excel row header idx */
	private final int ROW_HEADER_IDX = 0;

	/**
	 * <pre>
	 * parse
	 * excel parse
	 * <pre>
	 * @param excelStream
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public List<ExcelValue> parse(InputStream excelStream, Class<? extends ExcelValue> clazz) throws Exception {
		List<ExcelValue> excelValueList = new ArrayList<ExcelValue>();
		POIFSFileSystem fileSystem = new POIFSFileSystem(excelStream);
		HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);

		// sheet num count
		int sheetNum = workbook.getNumberOfSheets();

		// for sheet
		for (int i = 0; i < sheetNum; i++) {
			String sheetName = workbook.getSheetName(i);
			HSSFSheet hssfSheet = workbook.getSheetAt(i);

			int rows = hssfSheet.getPhysicalNumberOfRows();
			System.out.println("##parse## sheetName=" + sheetName + ", rows=" + rows);

			for (int j = 0; j < rows; j++) {
				// excel header 데이터는 제외
				if (j == ROW_HEADER_IDX) {
					continue;
				}

				HSSFRow hssfRow = hssfSheet.getRow(j);
				ExcelValue excelValue = clazz.newInstance();

				// cell 데이터 VO에 저장
				excelValue = setCellValue(excelValue, excelValueList, hssfRow);
				// add list
				excelValueList.add(excelValue);
			}
		}

		return excelValueList;

	}

	/**
	 * <pre>
	 * setCellValue
	 * cell 데이터 저장
	 * <pre>
	 * @param clazz
	 * @param excelValueList
	 * @param hssfRow
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	private ExcelValue setCellValue(ExcelValue vo, List<ExcelValue> excelValueList, HSSFRow hssfRow) throws InstantiationException, IllegalAccessException {
		if (hssfRow != null) {
			int cells = hssfRow.getPhysicalNumberOfCells();

			// for cells
			for (int i = 0; i < cells; i++) {
				HSSFCell cell = hssfRow.getCell(i);
				if (cell != null) {
					String value = getCellData(cell);
					int columnIdx = cell.getColumnIndex();
					vo.setValue(columnIdx, value); // set value
				}
			}

		}
		return vo;
	}

	/**
	 * <pre>
	 * getCellData
	 * cell 데이터 추출
	 * <pre>
	 * @param cell
	 * @param value
	 * @return
	 */
	private String getCellData(HSSFCell cell) {
		String value = null;
		switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_FORMULA:
				value = cell.getCellFormula();
				break;
			case HSSFCell.CELL_TYPE_NUMERIC:
				long numValue = (long) cell.getNumericCellValue();
				value = String.valueOf(numValue);
				break;
			case HSSFCell.CELL_TYPE_STRING:
				value = cell.getStringCellValue();
				break;
			case HSSFCell.CELL_TYPE_BLANK:
				value = null;
				break;
			case HSSFCell.CELL_TYPE_BOOLEAN:
				value = String.valueOf(cell.getBooleanCellValue());
				break;
			case HSSFCell.CELL_TYPE_ERROR:
				value = String.valueOf(cell.getErrorCellValue());
				break;
			default:
		}

		return value;
	}
}
