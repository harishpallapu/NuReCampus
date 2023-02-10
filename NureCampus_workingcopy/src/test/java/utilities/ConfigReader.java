package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class ConfigReader {
	
	private Properties pobj ;
	public static Workbook wb ;
	WebDriver driver;

	public ConfigReader(WebDriver driver) {

		this.driver = driver;

	}
	public Properties init_Property() {
			
			pobj = new Properties();
			
			try {
				FileInputStream fis = new FileInputStream("./src/test/resources/config/config.properties");
				pobj.load(fis);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return pobj ;
		}
		
		public static String getDataFromExcel(String SheetName,int rowNum , int cellNum) throws EncryptedDocumentException, IOException
		{
			
			FileInputStream fisexcel=new FileInputStream("./src/test/resources/TestData.xlsx");
			wb=WorkbookFactory.create(fisexcel);
			String data=wb.getSheet(SheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
			return data;
		}
		
		public static void setDataInExcel(String SheetName, int rowNum, int cellNum, String message) throws IOException
		{
			FileInputStream fisexcel=new FileInputStream("./src/test/resources/TestData.xlsx");
			wb=WorkbookFactory.create(fisexcel);
			wb.getSheet(SheetName).getRow(rowNum).createCell(cellNum).setCellValue(message);
			FileOutputStream fosexcel=new FileOutputStream("./src/test/resources/TestData.xlsx");
			wb.write(fosexcel);
			fosexcel.flush();
		}
		
		public static Object[][] getMultipleDataFromFExcel(String sheetName)
		{
			
			Sheet sh=wb.getSheet(sheetName);
			Object[][] arr=new Object[sh.getLastRowNum()+1][sh.getRow(0).getLastCellNum()];
			for(int i=0; i<sh.getLastRowNum()+1; i++)
			{
				for(int j=0; j<sh.getRow(i).getLastCellNum(); j++)
				{
					arr[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
				}
			}
			return arr;
			
		}
	
	}


