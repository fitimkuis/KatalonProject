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
import com.kms.katalon.core.logging.KeywordLogger

KeywordLogger log = new KeywordLogger()

List<String> excelValues = new ArrayList<String>();
excelValues = CustomKeywords.'readExcelRows.ReadRows.readExcelRows'(0, 10)
System.out.println("Rows from 1 to 10")
for (String temp : excelValues) {
	System.out.print(temp + "\t");
	log.logInfo(temp + "\t")
}

excelValues = CustomKeywords.'readExcelRows.ReadRows.readExcelRows'(2, 5)
System.out.println("Rows from 3 to 5")
for (String temp : excelValues) {
	System.out.print(temp + "\t");
	log.logInfo(temp + "\t")
}

excelValues = CustomKeywords.'readExcelRows.ReadRows.readExcelRows'(1, 4)
System.out.println("Rows from 2 to 4")
for (String temp : excelValues) {
	System.out.print(temp + "\t");
	log.logInfo(temp + "\t")
}

excelValues = CustomKeywords.'readExcelRows.ReadRows.readExcelRows'(3, 4)
System.out.println("Only row 4")
for (String temp : excelValues) {
	System.out.print(temp + "\t");
	log.logInfo(temp + "\t")
}

