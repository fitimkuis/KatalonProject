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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


String pathXlsx = System.getProperty("user.dir")+"\\ExcelFiles\\two_dimension_table.xlsx";
println pathXlsx

List<String> headerValuesXlsx = new ArrayList<String>();
List<String> excelValuesXlsx = new ArrayList<String>();

def sheet = "Taul1"
//header count
start = 0;
end = 1;
counter = CustomKeywords.'excelHelper.ExcelUtilForXlsx.ExcelHelperGetColumnCountXlsx'(pathXlsx, sheet)
println ("DEBUG*******************Columns "+counter)
headerValuesXlsx = CustomKeywords.'excelHelper.ExcelUtilForXlsx.ReadFile'(counter, start, end, pathXlsx, sheet)
println ("DEBUG*******************Header Values "+headerValuesXlsx)
rowCount = CustomKeywords.'excelHelper.ExcelUtilForXlsx.getRowCount'(pathXlsx, sheet)
rowCount--
println ("DEBUG*******************Rows "+rowCount)

//get rows
//row count
start = 1;
end = 2;
for (int z = 0; z < rowCount; z++) {
	excelValuesXlsx = CustomKeywords.'excelHelper.ExcelUtilForXlsx.ReadFile'(headerValuesXlsx.size(), start, end, pathXlsx, sheet)
	//excelValuesXlsx = CustomKeywords.'excelHelper.UpdateXlsxFile.ExcelHelperReadXlsx'(headerValuesXlsx.size(), start, end, pathXlsx, truefalse)
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



//##################################################
List<String> excel2ValuesXlsx = new ArrayList<String>();
start2 = 1
end2 =2
counter = CustomKeywords.'excelHelper.ExcelUtilForXlsx.ExcelHelperGetColumnCountXlsx'(pathXlsx, sheet)
rowCount = CustomKeywords.'excelHelper.ExcelUtilForXlsx.getRowCount'(pathXlsx, sheet)
println(counter)
println(rowCount)

//create list of lists count of added cells in second column
List<List<Object>> lists = new ArrayList<List<Object>>();
for (int i = 0; i < rowCount; i++) {
	List<String> list = new ArrayList<>();
	lists.add(list);
}
println ("count of lists in a list "+lists.size())
println ("lists in a list "+lists)

int column = 0
for (int i = 0;i < rowCount; i++) {
	excel2ValuesXlsx = CustomKeywords.'excelHelper.ExcelUtilForXlsx.ReadFile'(2, start2, end2, pathXlsx, sheet)
	lists.get(i).add(excel2ValuesXlsx)
	start2++
	end2++
	column++
}

println(lists)

for (String s : lists) {
	println(s)
}

//print one of values pair
println(lists.get(0).get(0))

//#################################################################################


List<List<Object>> exlPgm = [
	["Administrative", "Payer"],
	["Advance", "Payer 1"],
	["Complex", "Line 1"]
	]

println "--------------- demo 1 ----------------------"
for (int i = 0; i < exlPgm.size(); i++) {
	List<Object> row = exlPgm.get(i)
	for (int j = 0; j < row.size(); j++) {
		println "i=${i},j=${j} \'" + row.get(j) + "\'"
	}
}

println "\n--------------- demo 2 ----------------------"
for (int i = 0; i < exlPgm.size(); i++) {
	for (int j = 0; j < exlPgm[i].size(); j++) {
		println "[${i}][${j}] \'" + exlPgm[i][j] + "\'"     // array-like syntax sugar
	}
}

println "\n--------------- demo 3 ----------------------"
// list.each { groovy closure}
exlPgm.eachWithIndex { row, i ->
	row.eachWithIndex { cell, j ->
		println "[${i}][${j}] \'" + cell + "\'"
	}
}