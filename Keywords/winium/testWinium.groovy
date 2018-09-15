package winium

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.winium.DesktopOptions
import org.openqa.selenium.winium.WiniumDriver
import java.net.MalformedURLException
import java.net.URL

public class testWiniumClass {

	@Keyword
	public void testWiniumExe(){

		DesktopOptions option = new DesktopOptions();

		option.setApplicationPath("C:\\Windows\\System32\\calc.exe");

		WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"), option);

		Thread.sleep(2000);

		driver.findElement(By.name("Seitsemän")).click();

		driver.findElement(By.name("Plus")).click();

		driver.findElement(By.name("Kahdeksan")).click();

		driver.findElement(By.name("On yhtä suuri kuin")).click();

		Thread.sleep(2000);

		String output = driver.findElement(By.id("CalculatorResults")).getAttribute("Name");

		System.out.println("Result after addition is: "+output);

		Thread.sleep(2000);

		driver.close();

		/*WiniumDriver driver = null
		 String appPath = "C:/windows/system32/calc.exe"
		 DesktopOptions option = new DesktopOptions()
		 option.setApplicationPath(appPath)
		 option.setDebugConnectToRunningApp(false)
		 option.setLaunchDelay(2)
		 //Winium.Desktop.Driver.exe --port 9000
		 driver = new WiniumDriver(new URL("http://127.0.0.1:9000"),option)
		 Thread.sleep(1000)
		 WebElement window = driver.findElementByClassName("CalcFrame")
		 WebElement menuItem = window.findElement(By.id("MenuBar")).findElement(By.name("View"))
		 menuItem.click()
		 driver.findElementByName("Scientific").click()
		 window.findElement(By.id("MenuBar")).findElement(By.name("View")).click()
		 driver.findElementByName("History").click()
		 window.findElement(By.id("MenuBar")).findElement(By.name("View")).click()
		 driver.findElementByName("History").click()
		 window.findElement(By.id("MenuBar")).findElement(By.name("View")).click()
		 driver.findElementByName("Standard").click()
		 driver.findElementByName("4").click()
		 driver.findElementByName("Add").click()
		 driver.findElementByName("5").click()
		 driver.findElementByName("Equals").click()
		 driver.close()*/
	}
}
