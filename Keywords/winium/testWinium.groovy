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
		
		WiniumDriver d;

		//DesktopOptions option = new DesktopOptions();
		
		Random rand = new Random(System.currentTimeMillis()); // see comments!
		int port = rand.nextInt((9999 - 9000) + 1) + 9000;
		System.out.println("DEBUG port number "+port);
		//WebUI.delay(20)
		//random = Random.generateRandomInteger(1000, 9999);
		
		DesktopOptions options = new DesktopOptions();
		options.setApplicationPath("C:\\Windows\\System32\\calc.exe");
		//options.setApplicationPath("C:\\Windows\\System32\\openfiles.exe");
		//String WiniumEXEpath = System.getProperty("user.dir") + "\\Winium.Desktop.Driver.exe";
		String WiniumEXEpath = "C:\\KatalonStudio\\DataDrivenTestMaster\\Winium.Desktop.Driver.exe";
		File file = new File(WiniumEXEpath);
		if (! file.exists()) {
			throw new IllegalArgumentException("The file " + WiniumEXEpath + " does not exist");
		}
		Runtime.getRuntime().exec(file.getAbsolutePath()+" --port "+port);
		
		try {
			d = new WiniumDriver(new URL("http://localhost:"+port),options);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		//d = new WiniumDriver(new URL("http://localhost:9000"), options);

		Thread.sleep(2000);

		d.findElement(By.name("Seitsemän")).click();

		d.findElement(By.name("Plus")).click();

		d.findElement(By.name("Kahdeksan")).click();

		d.findElement(By.name("On yhtä suuri kuin")).click();

		Thread.sleep(2000);

		String output = d.findElement(By.id("CalculatorResults")).getAttribute("Name");

		System.out.println("Result after addition is: "+output);
		
		d.findElement(By.name("Sulje Laskin")).click();

		//Thread.sleep(5000);
		
		//d.quit();

		//d.close();

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
