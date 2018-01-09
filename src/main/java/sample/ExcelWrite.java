package sample;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	public static void main(String[] args) throws IOException, InvalidFormatException {
		XSSFWorkbook wbook = new XSSFWorkbook();
		XSSFSheet sheetName = 	wbook.createSheet("Wbook");
	
		String newFrnd = "koushik";

		int rowA = 0;
		int columnA = 0;

		Row row = sheetName.createRow(rowA);
		Cell cell = row.createCell(columnA);
		cell.setCellValue(newFrnd);
		FileOutputStream fo = new FileOutputStream("./data/insta.xlsx");
		wbook.write(fo);

		fo.close();
		wbook.close();
	}
}