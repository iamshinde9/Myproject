package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	 
	private static XSSFWorkbook wb;
	private static XSSFSheet sheet;
	
    public static void setExcelFile(String filePath, String sheetName) throws IOException {
    	
    	FileInputStream fis=new FileInputStream(filePath);
    	wb=new XSSFWorkbook(fis);
    	sheet=wb.getSheet(sheetName);
    	
    }
    public static String getCellData(int rowNum, int colNum) {
    	XSSFRow row=sheet.getRow(rowNum);
    	XSSFCell cell=row.getCell(colNum);
    	return cell.getStringCellValue();
    }
    
    public static int getRowCount() {
    	return sheet.getLastRowNum();
    }

}
