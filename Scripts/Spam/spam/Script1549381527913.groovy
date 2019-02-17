import java.math.RoundingMode
import java.text.DecimalFormat

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormatter
import org.joda.time.format.ISODateTimeFormat

import com.kms.katalon.core.exception.StepErrorException
import com.kms.katalon.core.util.KeywordUtil

Double min = 5.0;  //  Set To Your Desired Min Value
Double max = 19.9; //    Set To Your Desired Max Value
double x = (Math.random()*((max-min)+1))+min; //    This Will Create A Random Number In between Your Min And Max.
double xrounded = Math.round(x * 100.0) / 100.0; // Creates Answer To The Nearest 100th, You Can Modify This To Change How It Rounds.
//System.out.println(xrounded); //    This Will Now Print Out The Rounded, Random Number.

double leader = 20

List<Double> list = new ArrayList<Double>();
for (int j = 0; j < 5; j++){
	x = (Math.random()*((max-min)+1))+min
	list.add(xrounded = Math.round(x * 100.0) / 100.0)
}
/*list.add(8.5)
list.add(7.6)
list.add(6.8)
list.add(5.4)
list.add(6.7)
list.add(4.4)
list.add(9.2)*/

List<Double> offset = new ArrayList<Double>();

for (Double l: list){
	offset.add(leader - l)
}

/*for (Double k: offset){
	println k
}*/

//add list values to hasmap
HashMap<Double, Double> hmap = new HashMap<Double, Double>();
Iterator<Double> i1 = list.iterator();
Iterator<Double> i2 = offset.iterator();
while (i1.hasNext() && i2.hasNext()) {
   hmap.put(i1.next(), i2.next());
  }

DecimalFormat df = new DecimalFormat("#.#");
df.setRoundingMode(RoundingMode.FLOOR);
//double result = new Double(df.format(3.545555555));
//change map order by keys desc
TreeMap<Double, Double> sorted = new TreeMap<Double, Double>(Collections.reverseOrder());
// Copy all data from hashMap into TreeMap
sorted.putAll(hmap);

// Display the TreeMap which is reversed sorted
for (Map.Entry<Double, Double> entry : sorted.entrySet()){
	System.out.println("leader: "+leader+"\t points: " + entry.getKey() + "\t difference:" + df.format(entry.getValue()));
}

/*
for (Map.Entry<Double, Double> entry : hmap.entrySet()) {
	System.out.println("Key = " + entry.getKey() + ", Value = " + df.format(entry.getValue()));
}*/

//Map<Double, Double> treemap = new TreeMap<Double, Double>(Collections.reverseOrder());
//Set set = treemap.entrySet();



/*
Map<Double, Double> treeMap = new TreeMap<>(hmap);
for (Double doub : treeMap.keySet()) {
	System.out.println(doub);
}*/
 

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

