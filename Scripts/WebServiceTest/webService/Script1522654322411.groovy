import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

def response = WS.sendRequest(findTestObject('WebServiceReqs/webRequest'))
WS.verifyResponseStatusCode(response, 200)
WS.containsString(response, 'Bahrain International Circuit', false)

