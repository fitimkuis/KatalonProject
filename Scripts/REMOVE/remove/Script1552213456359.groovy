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



List<String> resp = new ArrayList<>(Arrays.asList("available", "available", "available", "available"))
println resp[0]

String spam = "20190319_200741_1553018936546"
spam1 = spam.substring(0,8)
spam2 = spam.substring(9,15)
println spam1
println spam2

WebUI.openBrowser('')

WebUI.navigateToUrl('https://eonasdan.github.io/bootstrap-datetimepicker/')

WebUI.click(findTestObject('Object Repository/DatePicker/Page_/REMOVE/Page_/span_Minimum Setup_glyphicon glyphicon-calendar'))

WebUI.click(findTestObject('DatePicker/Page_/select-year-month'))

WebUI.click(findTestObject('DatePicker/Page_/select-year'))

WebUI.click(findTestObject('DatePicker/Page_/select-year-from-table'))

WebUI.click(findTestObject('DatePicker/Page_/select-month'))

WebUI.click(findTestObject('Object Repository/DatePicker/Page_/REMOVE/Page_/td_10'))

WebUI.closeBrowser()

