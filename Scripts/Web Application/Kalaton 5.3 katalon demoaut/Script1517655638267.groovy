import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(null)

WebUI.setViewPortSize(700, 500)

WebUI.navigateToUrl('http://demoaut.katalon.com/')

//WebUI.click(findTestObject("katalon_5_3_katalon_demo"))
WebUI.click(findTestObject('Object Repository/katalon_5_3_katalon_demo/Page_CURA Healthcare Service/a_Make Appointment'))

WebUI.setEncryptedText(findTestObject('katalon_5_3_katalon_demo/Page_CURA Healthcare Service/input_username'), 'gdcc432nhE0fy+OnPxrtHw==')

WebUI.setEncryptedText(findTestObject('katalon_5_3_katalon_demo/Page_CURA Healthcare Service/input_password'), 'g3/DOGG74jC3Flrr3yH+3D/yKbOqqUNM')

WebUI.click(findTestObject('Object Repository/katalon_5_3_katalon_demo/Page_CURA Healthcare Service/button_Login'))

WebUI.selectOptionByValue(findTestObject('Object Repository/katalon_5_3_katalon_demo/Page_CURA Healthcare Service/select_Tokyo CURA Healthcare C'), 
    'Seoul CURA Healthcare Center', false)

WebUI.check(findTestObject('Object Repository/katalon_5_3_katalon_demo/Page_CURA Healthcare Service/input_hospital_readmission'))

WebUI.check(findTestObject('Object Repository/katalon_5_3_katalon_demo/Page_CURA Healthcare Service/input_programs'))

WebUI.click(findTestObject('Object Repository/katalon_5_3_katalon_demo/Page_CURA Healthcare Service/input_visit_date'))

WebUI.click(findTestObject('Object Repository/katalon_5_3_katalon_demo/Page_CURA Healthcare Service/td_28'))

WebUI.setText(findTestObject('Object Repository/katalon_5_3_katalon_demo/Page_CURA Healthcare Service/textarea_comment'), 
    'Hello Katalon users')

WebUI.click(findTestObject('Object Repository/katalon_5_3_katalon_demo/Page_CURA Healthcare Service/button_Book Appointment'))

//WebUI.verifyElementText(findTestObject('katalon_5_3_katalon_demo/Page_CURA Healthcare Service/p_Please be informed that your'), 
//    'Cat Please be informed that your appointment has been booked as following:')
//WebUI.verifyElementText(findTestObject('Object Repository/katalon_5_3_katalon_demo/Page_CURA Healthcare Service/p_Please be informed that your'), 
//    'Cat Please be informed that your appointment has been booked as following:', FailureHandling.CONTINUE_ON_FAILURE)

//WebUI.click(findTestObject('Object Repository/katalon_5_3_katalon_demo/Page_CURA Healthcare Service/a_Go to Homepage'))

WebUI.closeBrowser()

