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

WebUI.openBrowser(null)

WebUI.setViewPortSize(700, 500)

WebUI.navigateToUrl('http://demoaut.katalon.com/')

//WebUI.click(findTestObject("katalon_5_3_katalon_demo"))
WebUI.click(findTestObject('katalon_5_3_katalon_demo/Page_CURAHealthcareService/a_MakeAppointment'))

WebUI.setText(findTestObject('katalon_5_3_katalon_demo/Page_CURAHealthcareService/input_username'), GlobalVariable.username)

WebUI.setEncryptedText(findTestObject('katalon_5_3_katalon_demo/Page_CURAHealthcareService/input_password'), GlobalVariable.pass)

WebUI.click(findTestObject('katalon_5_3_katalon_demo/Page_CURAHealthcareService/button_Login'))

