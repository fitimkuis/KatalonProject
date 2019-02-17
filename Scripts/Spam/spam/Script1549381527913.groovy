import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormatter
import org.joda.time.format.ISODateTimeFormat

import com.kms.katalon.core.exception.StepErrorException
import com.kms.katalon.core.util.KeywordUtil


for (int count = 3; count >= 0; count--) {
	KeywordUtil.logInfo("count: $count")
}
KeywordUtil.logInfo("done")

//WebUI.openBrowser('')

//import com.gargoylesoftware.htmlunit.javascript.host.intl.DateTimeFormat
//import com.github.jaiimageio.plugins.tiff.BaselineTIFFTagSet.DateTime


/*
WebUI.openBrowser('https://www.katalon.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.katalon.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
selenium.openWindow("openWindow", "google")
selenium.selectWindow("google")
selenium.open("https://www.google.com/")
selenium.runScript("window.test = 5")
selenium.runScript("return window.test ${testvar}")
System.out.println("${testvar}");
// selenium.()
*/
//runScript javascript{alert(" 'DO YOU LIKE ALL THESE EXAMPLES? :) IF YES THEN SUBSCRIBE VIA EMAIL TO GET MORE SUCH EXAMPLES ON YOUR EMAIL ID' ")}
String expectedString = "two"

List<String> myArray = new ArrayList<>()
myArray.add("one")
myArray.add("two")
myArray.add("three")

if (myArray.contains(expectedString)){
	println "Value is in array"
}
else{
	println "Value is not in array"
}

boolean val = false

//try {
	for (String item: myArray){
		if (item.equals(expectedString)){
			println "Value is in array: "+item
			val = true
			break;
		}
	}
		if (!val){
			throw new com.kms.katalon.core.exception.StepErrorException('test failed expected string is not in array')
		}
	/*} catch (com.kms.katalon.core.exception.StepErrorException e){
		this.println(e)
	} catch (Exception e){
		this.println ("Test Failed general issue")
	} finally {
		println "expected string is in array "
	}*/


def firstEventDateTime= "2019-02-04T12:01:08.397106+00:00";
def parsedFirstDateTime = Date.parse("yyyy-MM-dd'T'HH:mm:ss", firstEventDateTime);
println parsedFirstDateTime; //Mon Feb 04 12:01:08 EET 2019

DateTimeFormatter jodaFormatter = ISODateTimeFormat.dateTime();
DateTime jodaParsed = jodaFormatter
		.parseDateTime("2013-05-17T16:27:34.9+05:30");
Date date2 = jodaParsed.toDate();
System.out.println("Date & Day:" + jodaParsed.getDayOfMonth() + "-" + jodaParsed.getMonthOfYear() + "-" + jodaParsed.getYear() + " " + jodaParsed.getHourOfDay() + ":" + jodaParsed.getMinuteOfHour()+" "+jodaParsed.dayOfWeek().getAsText());

def extractedValue = ""
def url = "https://here.comes.token"+extractedValue+".rest.of.ulr.parameters"

//WebElement element = WebUI.executeJavaScript("document.getElementById('someId').readOnly=false;", true)

