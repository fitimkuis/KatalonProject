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
import org.testng.Assert as Assert
import java.nio.file.Paths as Paths
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

WebUI.openBrowser('')

WebUI.navigateToUrl('http://www.testingdiaries.com/selenium-webdriver-read-pdf-content/')

//WebUI.click(findTestObject('99_RPDF/Page_Selenium WebDriver Read PDF Co (1)/a_this location'))
WebUI.click(findTestObject('Page_SeleniumWebDriverRead-PDF-Co/a_this-location'))

//CustomKeywords.'tools.pdfReader.ReadPDF'('http://www.axmag.com/download/pdfurl-guide.pdf')
String pdfContent = CustomKeywords.'readPdfFile.verifyPdfContent.readPdfFileVerify'('http://www.axmag.com/download/pdfurl-guide.pdf')

Assert.assertTrue(pdfContent.contains('Open the setting.xml, you can see it is like this:'))

Assert.assertTrue(pdfContent.contains('Please add the following sentence in setting.xml before'))

Assert.assertTrue(pdfContent.contains('You can see that I have modified the setting.xml, and if open the file in IE, it is like this:'))

println('PDF IS GOOD TO GO...\r')

WebUI.closeBrowser()

//WebUI.callTestCase(findTestCase('GetTestReports/showTestReports'), [:], FailureHandling.CONTINUE_ON_FAILURE)

