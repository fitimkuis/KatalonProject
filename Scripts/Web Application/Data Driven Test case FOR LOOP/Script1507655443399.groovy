import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testdata.InternalData
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

InternalData data = findTestData("Demo_Account")

for (def index : (0..data.getRowNumbers() - 1)) {
'Invoke Browser and Navigate to Demo Application'
WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.URL_Application)

'Wait till the page load'
WebUI.waitForPageLoad(10)

'Enter the value of username (From Internal Test Data)'
WebUI.setText(findTestObject('Login Page of Demo Application/input_username'), demo_username, index)
//WebUI.setText(findTestObject('Login Page of Demo Application/input_username'), 'John Doe')

'Enter the value of password (From Internal Test Data)'
WebUI.setText(findTestObject('Login Page of Demo Application/input_password'), demo_password, index)

'Click on Login Button\\r\\n'
WebUI.click(findTestObject('Login Page of Demo Application/button_Login'))

WebUI.verifyElementPresent(findTestObject('Make Appointment Page/btn_Book Appointment'), GlobalVariable.SmallTimeout)

'Close the Browser'
WebUI.closeBrowser()
}

