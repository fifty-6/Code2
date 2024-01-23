package basic;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;

public class FetchDatafromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException  {
//		Step 1: To Fetch data from external File
		FileInputStream fis=new FileInputStream("src\\test\\resources\\Skillrary.xlsx");
		
//		Step 2: To fetch data from ExcelFile
		Workbook wb=WorkbookFactory.create(fis);
		
//		Step 3: To get the control of the sheet
		Sheet sh = wb.getSheet("Sheet1");				//getSheet(String name)
		
//		Step 4: To get the row
		Row r=sh.getRow(2);								//getRow(int RowNum)
		
//		Step 5: To get data from Column
		Cell cl=r.getCell(1);							//getCell(int Column)
		
//		Step 6: To Get Data present in the cell
		String data=cl.getStringCellValue();			//getStringCellValue(String) 
		System.out.println(data);

	}

}
