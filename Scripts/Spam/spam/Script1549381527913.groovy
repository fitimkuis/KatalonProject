import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormatter
import org.joda.time.format.ISODateTimeFormat
import org.openqa.selenium.WebElement

//import com.gargoylesoftware.htmlunit.javascript.host.intl.DateTimeFormat
//import com.github.jaiimageio.plugins.tiff.BaselineTIFFTagSet.DateTime


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

