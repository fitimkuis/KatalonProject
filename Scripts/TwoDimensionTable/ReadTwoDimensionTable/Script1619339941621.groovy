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