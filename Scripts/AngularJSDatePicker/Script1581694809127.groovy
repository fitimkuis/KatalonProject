import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')

WebUI.navigateToUrl('https://material.angularjs.org/latest/demo/datepicker')

myNewObject = new TestObject("myNewObject")
myNewObject1 = new TestObject("myNewObject1")
myNewObject2 = new TestObject("myNewObject2")
myNewObject3 = new TestObject("myNewObject3")

'Change xpath property to new value'
def css = "body > main > md-content > div.docs-ng-view.layout-padding.ng-scope.flex-noshrink > docs-demo:nth-child(1) > div > div > section > demo-include > div > md-content > div:nth-child(1) > div:nth-child(1) > md-datepicker > div > button"

def css_14 = "#md-5-month-2020-1-14 > span"

def day = 22
def month = 2
def xpath_20 = "//td[@id='md-2-month-2020-1-20']/span"
def xpath_day = "//td[@id='md-"+month+"-month-2020-1-"+day+"']/span"

def css_inputBox = "body > main > md-content > div.docs-ng-view.layout-padding.ng-scope.flex-noshrink > docs-demo:nth-child(1) > div > div > section > demo-include > div > md-content > div:nth-child(1) > div:nth-child(1) > md-datepicker > div > input"

myNewObject.addProperty("css", ConditionType.EQUALS, css, true)
WebUI.click(myNewObject)

WebUI.delay(2)

myNewObject1.addProperty("xpath", ConditionType.EQUALS, xpath_day, true)
WebUI.click(myNewObject1)

WebUI.delay(2)

myNewObject3.addProperty("css", ConditionType.EQUALS, css_inputBox, true)
def text = WebUI.getAttribute(myNewObject3, 'value')
println text

WebUI.closeBrowser()

//LinkToSearch = WebUI.modifyObjectProperty(findTestObject('jQueryDatePicker/Page_jQuery-datePicker/day'), 'text','equals',txtval, true)
//WebUI.click(LinkToSearch, FailureHandling.OPTIONAL)


