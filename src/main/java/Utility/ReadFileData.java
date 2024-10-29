package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFileData {

	public static String readConfigData(String value) throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("D:\\IJ-PROJECTS\\EcommerceRetail-Domain\\src\\main\\resources\\TestData\\config.properties");
		prop.load(file);
		return prop.getProperty(value);
	}
	
	public static String readExcelData(int rowNum, int colNum) throws EncryptedDocumentException, IOException {
		
		FileInputStream file = new FileInputStream("D:\\IJ-PROJECTS\\EcommerceRetail-Domain\\src\\main\\resources\\TestData\\Retail-DomainData.xlsx");
		Sheet sheet = WorkbookFactory.create(file).getSheet("Sheet1");
        return sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		
		
		
	}
	
}
