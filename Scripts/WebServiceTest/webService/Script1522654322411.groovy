import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonOutput
import groovy.json.JsonSlurper

def response = WS.sendRequest(findTestObject('WebServiceReqs/webRequest'))
def responseText = response.getResponseText()
//println responseText

println JsonOutput.prettyPrint(responseText)

def jsonSlurper = new JsonSlurper()
def object = jsonSlurper.parseText(responseText)
int jsonSize = object.MRData.CircuitTable.Circuits.circuitId.size()

KeywordLogger log = new KeywordLogger()
log.logInfo("count of json side "+jsonSize)

//println "count of json side "+jsonSize

for (int i = 0; i < jsonSize+1; i++){
	println(object.MRData.CircuitTable.Circuits.circuitId[i])
}
//def text = {"applications":[{"name":"test123","id":"c1257c5","description":"test","type":"generic","version":"0.1"},{"name":"Asset_1","id":"a9e0bce","description":"sfsdgdg","type":"generic","version":"0.1"},{"name":"Asset_2","id":"a9e0cd2","description":"sffgdgf","type":"generic","version":"0.1"}]}

def json = new JsonSlurper().parseText('{"applications":[{"name":"test123","id":"c1257c5","description":"test","type":"generic","version":"0.1"},{"name":"Asset_1","id":"a9e0bce","description":"sfsdgdg","type":"generic","version":"0.1"},{"name":"Asset_2","id":"a9e0cd2","description":"sffgdgf","type":"generic","version":"0.1"}]}')
println(json.applications[1].id)
/*println JsonOutput.prettyPrint(text)
def jsonSlurper = new JsonSlurper()
def object = jsonSlurper.parseText(text)*/

//assert object.response[0].id == 'c1257c5'
//println object.get("applications").get(0).get("id")
//JsonSlurper slurper = new JsonSlurper()
//Map parsedJson = slurper.parseText(response)
//println parsedJson.get("applications").get(0).get("id")

println "response: $response"
def cookiez = response.getHeaderFields()['Set-Cookie']
println cookiez
WS.verifyResponseStatusCode(response, 200)
WS.containsString(response, 'Bahrain International Circuit', false)

