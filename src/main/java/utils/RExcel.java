package utils;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;




public class RExcel {
	@Test
	public Object[][] excelRead() throws IOException, InvalidFormatException {
		XSSFWorkbook book = new XSSFWorkbook(new File("./data/test.xlsx"));
		XSSFSheet sheet = book.getSheetAt(0);
		int CellNum = sheet.getRow(0).getLastCellNum();
		int lastRowNum = sheet.getLastRowNum();
		Object[][] data = new Object[lastRowNum][CellNum];
		for (int i = 1; i <=lastRowNum; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < lastRowNum; j++) {
				/*CellType cell = row.getCell(j).getCellTypeEnum();
				if (cell==CellType.NUMERIC) {
					data[i-1][j] = (int) row.getCell(j).getNumericCellValue();
				} else if (cell==CellType.STRING) {
					data[i-1][j] = row.getCell(j).getStringCellValue();
				}*/
				System.out.println(row.getCell(j).getStringCellValue());
				//System.out.println(data[i-1][j]);
			}
		}
		book.close();
		return data;		
	}
}

/*switch (cell) {
				case CellType.:
					
					break;

				default:
					break;
				}*/