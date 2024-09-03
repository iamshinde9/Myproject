package dataProviders;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import utility.ExcelUtils;

public class ExcelDataProvider {

	@DataProvider (name="logindata")
	public Object[][]getLoginData(){
		
		try {
			
			//// Set the Excel file path and sheet name
			
			ExcelUtils.setExcelFile("C:\\Users\\Shree\\eclipse-workspace\\Myproject\\src\\test\\resources\\TestData.xlsx", "Sheet1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int rowCount=ExcelUtils.getRowCount()+1;
		int cellCount=2;						// Assuming you have 2 columns: username and password
		
		Object data[][]=new Object[rowCount][cellCount];
		
		for (int i=0; i<rowCount; i++) {				//row 0 pasun count jar 5 asel tar 4 dakhavanar
		data[i][0]=ExcelUtils.getCellData(i, 0);		//username 
		data[i][1]=ExcelUtils.getCellData(i, 1);		//password
			}
		return data;
	}
	
}
