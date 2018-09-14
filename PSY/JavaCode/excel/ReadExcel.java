package com.demo.excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

public class ReadExcel {
	public static String getCellValue(){
		
		String pathOfFile = null;
		String sheetName = null;
		int rowNum;
		int cellNum;
		try{
			File file = new File(pathOfFile);
			FileInputStream fileInputStream = new FileInputStream(file); 
			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
	while (rowIterator.hasNext()) {
		Row row = rowIterator.next();
		Iterator<Cell> cellIterator = row.cellIterator();
	while (cellIterator.hasNext()) {
		Cell cell = cellIterator.next();
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC:
			System.out.print(cell.getNumericCellValue() + "(Integer)\t");
			break;
		case Cell.CELL_TYPE_STRING:
			System.out.print(cell.getStringCellValue() + "(String)\t");
			break;
		}
	}
	System.out.println("");
}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sheetName;
	}



}
