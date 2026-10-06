package Utils;

import java.io.FileInputStream; 
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	public ExcelDataProvider() throws Exception {		
		String path = "C:\\Users\\Bharat-Sargar\\eclipse-workspace\\Novio_Master\\TestData\\Data.xlsx";
		FileInputStream fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
			
	}
	public String getStringData(String Sheetname,int row, int cell) {
		return wb.getSheet(Sheetname).getRow(row).getCell(cell).getStringCellValue();
	}
		

}
