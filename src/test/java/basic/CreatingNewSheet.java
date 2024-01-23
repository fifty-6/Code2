//If Excel is not opening on Eclipse Then use this by Copying the path from properties Location 
package basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CreatingNewSheet {

	public static void main(String[] args) throws EncryptedDocumentException , IOException{		
		
		//		Step 1: To Fetch data from external File
//		FileInputStream fis=new FileInputStream("src\\test\\resources\\Skillrary.xlsx");
		FileInputStream fis=new FileInputStream("C:\\Users\\sanki\\OneDrive\\Desktop\\Selenium\\Notes\\Frameworks\\Practice.xlsx");
		
//		Step 2: To fetch data from ExcelFile
		Workbook wb=WorkbookFactory.create(fis);
		
//		Step 3: To get the control of the sheet
		Sheet sh = wb.createSheet("HelloWorld1");				//getSheet(String name)
		
//		Step 4: To get the row
		Row r=sh.createRow(0);									//createRow(int RowNum)
		
//		Step 5: To get data from Column
		Cell cl=r.createCell(0);								//createCell(int column)
		
//		Step 6: Enter The Data
		cl.setCellValue("Sanket Sarkar");						//SetCellValue("String value")
		
//		Step 7: To write data in external file
		FileOutputStream fos=new FileOutputStream("C:\\Users\\sanki\\OneDrive\\Desktop\\Selenium\\Notes\\Frameworks\\Practice.xlsx");
		
//		Step 8: To Write data to excel
		wb.write(fos);
		
	}

}
