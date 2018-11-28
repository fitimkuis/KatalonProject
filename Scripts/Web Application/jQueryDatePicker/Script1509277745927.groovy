import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testdata.InternalData as InternalData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


WebUI.openBrowser('')
/*
WebUI.openBrowser('')

WebUI.navigateToUrl('http://2008.kelvinluck.com/assets/jquery/datePicker/v2/demo/datePicker.html')

WebUI.waitForJQueryLoad(1)

WebUI.click(findTestObject('jQueryDatePicker/Page_jQuery-datePicker/a_Choose-date'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/jQueryDatePicker/Page_jQuery datePicker Next Month/next month'))
attribute = WebUI.getAttribute(findTestObject('Object Repository/jQueryDatePicker/Page_jQuery datePicker Next Month/day 1'), 'text')
println attribute

WebUI.click(findTestObject('Object Repository/jQueryDatePicker/Page_jQuery datePicker Next Month/day 1'))
*/
/////WebUI.click(findTestObject("jQueryDatePicker/Page_jQuery datePicker next year/datePickerNextYear"))

//InternalData data = findTestData('November/November days')

/*
'Use Javascript to make an alert'
WebUI.executeJavaScript("alert('This is an alert')", null)  
'Verify if the created alert is present'
WebUI.verifyAlertPresent(5)
*/

TestObject to = findTestObject('jQueryDatePicker/Page_jQuery datePicker Next Month/day 1')
int x = 1;

WebUI.navigateToUrl('http://2008.kelvinluck.com/assets/jquery/datePicker/v2/demo/datePicker.html')
WebUI.click(findTestObject('jQueryDatePicker/Page_jQuery-datePicker/a_Choose-date'))

WebUI.click(findTestObject('Object Repository/jQueryDatePicker/Page_jQuery datePicker Next Month/next month'))
WebUI.click(findTestObject('Object Repository/jQueryDatePicker/Page_jQuery datePicker Next Month/day 1'))
//for (def index : (0..data.getRowNumbers() - 1)) {
//int counter = 0;
for (int z=0;z<31;z++) {
	'Change xpath property to new value'
	//to.findProperty('text').setValue(day)
	//to.findProperty('xpath').setValue('//*[text()='+day)
	
	String txtval = x++
	println txtval
	
	//TestObject dynamicObject = new TestObject().addProperty("text", ConditionType.EQUALS, day)
	
    //WebUI.openBrowser('')

    //WebUI.navigateToUrl('http://2008.kelvinluck.com/assets/jquery/datePicker/v2/demo/datePicker.html')

    //WebUI.waitForJQueryLoad(1)

    WebUI.click(findTestObject('jQueryDatePicker/Page_jQuery-datePicker/a_Choose-date'))

    //WebUI.click(findTestObject('Object Repository/jQueryDatePicker/Page_jQuery datePicker Next Month/next month'))
	
	//LinkToSearch = WebUI.modifyObjectProperty(findTestObject('jQueryDatePicker/Page_jQuery datePicker Next Month/day 1'), 'text','equals',dynamicObject, true)
	//WebUI.click(LinkToSearch, FailureHandling.STOP_ON_FAILURE)
	
	LinkToSearch = WebUI.modifyObjectProperty(findTestObject('jQueryDatePicker/Page_jQuery datePicker Next Month/day 1'), 'text','equals',txtval, true)
	WebUI.click(LinkToSearch, FailureHandling.STOP_ON_FAILURE)
    //WebUI.click(findTestObject('jQueryDatePicker/Page_jQuery datePicker Next Month/day 1'), x++, index)
	//WebUI.delay(3)
	//WebUI.closeBrowser()
	/*counter++;
	if (counter >= 31){
		break;
	}*/
}
WebUI.closeBrowser()