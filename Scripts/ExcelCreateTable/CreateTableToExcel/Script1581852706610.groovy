import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleInfo;

ExcelTableTest.createTable()

public class ExcelTableTest {
	
	  public static void createTable() throws FileNotFoundException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Architecture");
	
		XSSFTable table = sheet.createTable();
		//XSSFTable table = sheet.createTable(null); //since apache poi 4.0.0
		CTTable cttable = table.getCTTable();
	
		cttable.setDisplayName("Table1");
		cttable.setId(1);
		cttable.setName("Test");
		cttable.setRef("A1:C11");
		cttable.setTotalsRowShown(false);
	
		CTTableStyleInfo styleInfo = cttable.addNewTableStyleInfo();
		styleInfo.setName("TableStyleMedium2");
		styleInfo.setShowColumnStripes(false);
		styleInfo.setShowRowStripes(true);
	
		CTTableColumns columns = cttable.addNewTableColumns();
		columns.setCount(3);
		for (int i = 1; i <= 3; i++) {
		  CTTableColumn column = columns.addNewTableColumn();
		  column.setId(i);
		  column.setName("Column" + i);
		}
	
		for (int r = 0; r < 2; r++) {
		  XSSFRow row = sheet.createRow(r);
		  for(int c = 0; c < 3; c++) {
			XSSFCell cell = row.createCell(c);
			if(r == 0) { //first row is for column headers
			  cell.setCellValue("Column"+ (c+1)); //content **must** be here for table column names
			} else {
			  cell.setCellValue("Data R"+ (r+1) + "C" + (c+1));
			}
		  }
		}
	
		try {
			FileOutputStream outputStream = new FileOutputStream("ExcelTableTest.xlsx") 
			workbook.write(outputStream);
		}catch(Exception e){
			println e
	  }
	}
}