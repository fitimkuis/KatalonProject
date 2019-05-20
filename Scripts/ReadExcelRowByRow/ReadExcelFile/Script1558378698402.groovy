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

//String path = "C:\\Users\\fitim\\KatalonFromGitHub\\KatalonProject\\ExcelFiles\\SmoobuBookings - 2019-5-20.xls";

String path = System.getProperty("user.dir")+"\\ExcelFiles\\SmoobuBookings - 2019-5-20.xls";
List<String> headerValues = new ArrayList<String>();
List<String> excelValues = new ArrayList<String>();
int processRows = 5;  //how many rows to get processed
int start = 0;
int end = 1;

headerValues = CustomKeywords.'excelHelper.ExcelUtil.ExcelHelper'(20, start, end, path)//get header values

//increase start & end to get data rows
start = 1;
end = 2;

for (int x = 0; x < processRows; x++) {
	excelValues = CustomKeywords.'excelHelper.ExcelUtil.ExcelHelper'(headerValues.size(), start, end, path)
	int i = 0;

	for (String s : headerValues) {
		if (excelValues.get(i).equals("**No Value**")) {
			System.out.println("Row " + start + " Header " + headerValues.get(i) + " has not value ");
		} else {
			System.out.println("Row " + start + " Header " + headerValues.get(i) + " has value " + excelValues.get(i));
		}
		i++;
	}
	start++;
	end++;
}