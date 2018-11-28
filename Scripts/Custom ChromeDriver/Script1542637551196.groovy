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

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities
import com.kms.katalon.core.webui.driver.DriverFactory

//Set chromedriver path
/*ChromeOptions options = new ChromeOptions();
DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability(ChromeOptions.CAPABILITY, options);
System.setProperty("webdriver.chrome.driver", "C:\\Users\\fitim\\Desktop\\ajuri\\chromedriver.exe");
ChromeDriver driver = new ChromeDriver(capabilities);
DriverFactory.changeWebDriver(driver)*/

WebUI.openBrowser('')
WebUI.navigateToUrl('http://www.google.com')
//WebUI.openBrowser('http://www.google.com')
WebUI.closeBrowser()

ChromeOptions options = new ChromeOptions();
DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability(ChromeOptions.CAPABILITY, options);
System.setProperty("webdriver.chrome.driver", "C:\\Users\\fitim\\Desktop\\ajuri\\chromedriver.exe");
ChromeDriver driver = new ChromeDriver(capabilities);
DriverFactory.changeWebDriver(driver)

WebUI.openBrowser('')
WebUI.navigateToUrl('http://www.google.com')
//WebUI.openBrowser('http://www.google.com')
WebUI.closeBrowser()

