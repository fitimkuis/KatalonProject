import java.util.List

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
Timestamp timestamp = new Timestamp(System.currentTimeMillis());
System.out.println(sdf.format(timestamp));
String stamp = sdf.format(timestamp);

String path = System.getProperty("user.dir")+"\\ExcelFiles\\xlsData.xls";

String pathXlsx = System.getProperty("user.dir")+"\\ExcelFiles\\xlsxData.xlsx";

//Get the Latest excel file from folder
String filePath = System.getProperty("user.dir")+"\\ExcelFiles\\"
def latestExcelFile = CustomKeywords.'excelHelper.GetLatestExcelFile.getTheNewestFile'(filePath)
println latestExcelFile


String xlsPath = System.getProperty("user.dir")+"\\ExcelFiles\\"+stamp+"_FileXlsData.xls";
String xlsxPath = System.getProperty("user.dir")+"\\ExcelFiles\\"+stamp+"_FileXlsxData.xlsx";
List<String> headerValues = new ArrayList<String>();
List<String> excelValues = new ArrayList<String>();

int processRows = 2;  //how many rows to get processed
int start = 0;
int end = 1;

List <String> excelTo = new ArrayList<>()
excelTo.add("cat")
excelTo.add("dog")
excelTo.add("pig")

def valToExcel = "cow"

int addtoRow = 11
int addToColumn = 0

List <String> columns = new ArrayList<>()
columns.add("One")
columns.add("Two")
columns.add("Three")
columns.add("Four")
columns.add("Five")

String sheetName = "SheetName"
String xlsxSheetName = "TestSheet"

//int cols = CustomKeywords.'excelHelper.ExcelUtilForXlsx.ExcelHelperGetColumnCountXlsx'(xlsxPath, xlsxSheetName)
//println cols

//create xlsx
CustomKeywords.'excelHelper.ExcelUtilForXlsx.ExcelHelperGreateExcelFileWithColumnsNameXlsx'(xlsxPath, xlsxSheetName, columns)//create new excel

//create xls
CustomKeywords.'excelHelper.ExcelUtil.ExcelHelperGreateExcelFileWithColumnsName'(xlsPath, xlsxSheetName, columns)//create new excel

CustomKeywords.'excelHelper.ExcelUtil.ExcelHelperUpdateFromList'(excelTo, addtoRow, addToColumn, path, sheetName)//add or update value to cell

CustomKeywords.'excelHelper.ExcelUtil.ExcelHelperUpdateExactValue'(valToExcel, addtoRow, addToColumn, path, sheetName)//add or update value to cell

int countOfColums = CustomKeywords.'excelHelper.ExcelUtil.ExcelHelperGetColumnCount'(path, sheetName)//get count of columns

headerValues = CustomKeywords.'excelHelper.ExcelUtil.ExcelHelperRead'(countOfColums, start, end, path, sheetName)//get header values


//Xlsx
//Xlsx
List<String> headerValuesXlsx = new ArrayList<String>();
List<String> excelValuesXlsx = new ArrayList<String>();
//CustomKeywords.'excelHelper.ExcelUtil.ExcelHelperUpdateExactValue'(valToExcel, addtoRow, addToColumn, pathXlsx, sheetName)//add or update value to cell

int countOfColumsXlsx = CustomKeywords.'excelHelper.ExcelUtilForXlsx.ExcelHelperGetColumnCountXlsx'(pathXlsx, sheetName)//get count of columns
headerValuesXlsx = CustomKeywords.'excelHelper.ExcelUtilForXlsx.ExcelHelperReadXlsx'(countOfColumsXlsx, start, end, pathXlsx, sheetName)//get header values


start = 1;
end = 2;

for (int x = 0; x < processRows; x++) {
	excelValues = CustomKeywords.'excelHelper.ExcelUtil.ExcelHelperRead'(headerValues.size(), start, end, path, sheetName)
	int i = 0;

	for (String s : headerValues) {
		if (excelValues.get(i).equals("**No Value**")) {
			System.out.println("Row " + start + " Header " + headerValues.get(i) + " has not value ");
		} else {
			System.out.println("Row " + start + " Header " + headerValues.get(i) + " has value " + excelValues.get(i));
		}
		i++;
	}
	start++; //increase start & end to get data rows
	end++;
}

//Xlsx
start = 1;
end = 2;

for (int z = 0; z < processRows; z++) {
	excelValuesXlsx = CustomKeywords.'excelHelper.ExcelUtilForXlsx.ExcelHelperReadXlsx'(headerValuesXlsx.size(), start, end, pathXlsx, sheetName)
	int y = 0;

	for (String s : headerValuesXlsx) {
		if (excelValuesXlsx.get(y).equals("**No Value**")) {
			System.out.println("Row " + start + " Header " + headerValuesXlsx.get(y) + " has not value ");
		} else {
			System.out.println("Row " + start + " Header " + headerValuesXlsx.get(y) + " has value " + excelValuesXlsx.get(y));
		}
		y++;
	}
	start++; //increase start & end to get data rows
	end++;
}