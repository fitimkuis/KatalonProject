import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

def x1 = 2
def x2 = 1

Calendar c = Calendar.getInstance();
Calendar cal = Calendar.getInstance();
int monthMaxDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
println "Current month count of dates: "+monthMaxDays
Date nowDate = new Date();
cal.setTime(nowDate);
cal.add(Calendar.MONTH, 1);
int nextMonthDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
println "Next month count of dates: "+nextMonthDays
int day = c.get(Calendar.DATE);
int validDays = monthMaxDays - day
println "Valid calendar days in month: "+validDays

def start = "//*[@placeholder = 'Start date' and @class = 'ant-calendar-range-picker-input']"
def end = "//*[@placeholder = 'End date' and @class = 'ant-calendar-range-picker-input']"

Random right = new Random();
Random left = new Random();


for(int i = 0; i < validDays+1; i++){
	
	WebUI.openBrowser('')
	
	WebUI.navigateToUrl('https://ant.design/components/date-picker/')
	
	WebUI.waitForPageLoad(60)
	
	WebUI.waitForElementPresent(findTestObject('Object Repository/Page_DatePicker - Ant Design/input_Examples_ant-calendar-range-picker-input'),30)

	WebUI.click(findTestObject('Object Repository/Page_DatePicker - Ant Design/input_Examples_ant-calendar-range-picker-input'))
	
	//WebUI.click(findTestObject('Object Repository/Page_DatePicker - Ant Design/div_28'))
	
	def s = right.nextInt((validDays - 2) + 1) + 2;
	def e = left.nextInt((nextMonthDays - 1) + 1) + 1;
		
	def xpath = "//*/text()[normalize-space(.)='"+s+"']/parent::*"
	
	//WebDriver driver = DriverFactory.getWebDriver()
	//List<WebElement> fields = driver.findElements(By.className("ant-calendar-date"))
	//List elements = WebUI.executeJavaScript("return document.getElementsByClassName('ant-calendar-date');", null)
	//println fields
		
	def xpath2 = "(.//*[normalize-space(text()) and normalize-space(.)='Sa'])[2]/following::div["+e+"]"
	
	x1++
	x2++
	
	WebUI.click(makeTO(xpath))
	
	//WebUI.click(findTestObject('Object Repository/Page_DatePicker - Ant Design/input_Examples_ant-calendar-range-picker-input'))
	
	WebUI.click(makeTO(xpath2))
			
	WebUI.delay(2)
	def startDate = WebUI.getAttribute(makeTO(start),'value')
	println startDate
	def endDate = WebUI.getAttribute(makeTO(end),'value')
	println endDate
	
	WebUI.closeBrowser()
}




static TestObject makeTO(String xpath) {
	TestObject to = new TestObject()
	to.addProperty("xpath", ConditionType.EQUALS, xpath)
	return to
  }


