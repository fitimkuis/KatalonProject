import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')

WebUI.navigateToUrl('https://jqueryui.com/datepicker/')

WebUI.waitForJQueryLoad(1)

WebUI.switchToFrame(findTestObject('Object Repository/DatePicker/Page_Datepicker  jQuery UI 2/iframe_demo-frame'),10)

WebUI.click(findTestObject('DatePicker/Page_Datepicker  jQuery UI 2/input_datepicker'))

WebUI.click(findTestObject('DatePicker/Page_Datepicker  jQuery UI/a_20'))

CustomKeywords.'datePicker.ReadOnly.readOnlyTrue'()

String txt = WebUI.getText(findTestObject('DatePicker/Page_Datepicker  jQuery UI 2/input_datepicker'))
println ("date is "+txt)
WebUI.verifyTextPresent(txt, false)

WebUI.closeBrowser()

