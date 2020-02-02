import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.regex.Pattern
import java.util.regex.Matcher;

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonOutput
import groovy.json.JsonSlurper

def response = WS.sendRequest(findTestObject('WebServiceReqs/webRequest'))
def responseText = response.getResponseText()
//println responseText

/*
JsonSlurper jsl = new JsonSlurper()	
RequestObject ro = new RequestObject()	
def myJson = ""	
def parsedResponse = ""	
String defaultUrl = "http://webhook.satyamphysio.in:8081/Lang.Product-en.json"	
String customUrl = "http://webhook.satyamphysio.in:8081/Lang.UserProduct-en.json"	
ro.setRestRequestMethod("GET")	
ro.setRestUrl(defaultUrl)	
ResponseObject resp = WSBuiltInKeywords.sendRequest(ro)	
if (resp.getStatusCode() == 200) {
	
  // replace BOM in response text		
	myJson = resp.getResponseText().replaceAll("\uFEFF","")		
	parsedResponse = jsl.parseText(myJson)	
	}	
*/

String jsonString = JsonOutput.prettyPrint(responseText)
println ("DEBUG jason string "+jsonString)
println JsonOutput.prettyPrint(responseText)


def jsonSlurper = new JsonSlurper()
def object = jsonSlurper.parseText(responseText)
int jsonSize = object.MRData.CircuitTable.Circuits.circuitId.size()

KeywordUtil log = new KeywordUtil()
log.logInfo("count of json side "+jsonSize)

//println "count of json side "+jsonSize
List <String> data = new ArrayList<>()

for (int i = 0; i < jsonSize; i++){
	println(object.MRData.CircuitTable.Circuits.circuitId[i])
	data.add(object.MRData.CircuitTable.Circuits.circuitId[i].toString())
}
//CustomKeywords.'spreadsheet.WriteToFile.writeToExcelJsonData'(data, 1, 2)

for (int x = 0; x < object.MRData.CircuitTable.Circuits.circuitName.size(); x++){
	println(object.MRData.CircuitTable.Circuits.circuitName[x])
	
}

for (int y = 0; y < object.MRData.CircuitTable.Circuits.circuitName.size(); y++){
	println(object.MRData.CircuitTable.Circuits.Location.country[y])
	
}
//def text = {"applications":[{"name":"test123","id":"c1257c5","description":"test","type":"generic","version":"0.1"},{"name":"Asset_1","id":"a9e0bce","description":"sfsdgdg","type":"generic","version":"0.1"},{"name":"Asset_2","id":"a9e0cd2","description":"sffgdgf","type":"generic","version":"0.1"}]}

def json = new JsonSlurper().parseText('{"applications":[{"name":"test123","id":"c1257c5","description":"test","type":"generic","version":"0.1"},{"name":"Asset_1","id":"a9e0bce","description":"sfsdgdg","type":"generic","version":"0.1"},{"name":"Asset_2","id":"a9e0cd2","description":"sffgdgf","type":"generic","version":"0.1"}]}')
println("***DEBUG**** "+json.applications[1].id)
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


def js = new JsonSlurper().parseText('{"token": "ewrerydjgkfgijrtupk,nyouktu","tokenValidityTime":"300","signInStatus": "LoginSuccessfull","accounts": [{"accNumber": "6000112216066021","balance": "0","routingNumber": "122106316"}],"profileInformation": {"first_name": "Apple","last_name": "Test","sysDate": "2020-01-30T15:46:40.969Z"}}')
println("***DEBUG**** "+js.accounts[0].accNumber)
println("***DEBUG**** "+js.accounts[0].balance)
//***DEBUG**** 6000112216066021

// Parse the response
def restResponse = '{"token": "ewrerydjgkfgijrtupk,nyouktu","tokenValidityTime":"300","signInStatus": "LoginSuccessfull","accounts": [{"accNumber": "6000112216066021","balance": "0","routingNumber": "122106316"}],"profileInformation": {"first_name": "Apple","last_name": "Test","sysDate": "2020-01-30T15:46:40.969Z"}}'
def list = new JsonSlurper().parseText( restResponse )
// Print them out to make sure
list.each { println it }
String searchToken = ""
for (String s : list){
	if (s.startsWith("token=")){
		searchToken = s
		break;
	}	
}

println searchToken
String[] parts = searchToken.split("=");
String part1 = parts[0]; // 
String part2 = parts[1]; //
println part1
println part2 //here is token ewrerydjgkfgijrtupk,nyouktu

//String pattern = "^" + searchToken+"="+searchToken+"$";
//String tk = 

//def j = new JsonSlurper().parseText('{"token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6Ilg1ZVhrNHh5b2pORnVtMWtsMll0djhkbE5QNC1jNTdkTzZRR1RWQndhTmsifQ.eyJpc3MiOiJodHRwczovL2thcnJpa2luaXRtLmIyY2xvZ2luLmNvbS8yYzcwZDA1NC1mMzA5LTQxMDctOWZhOC04NDQ2NDc3NjQ3NGQvdjIuMC8iLCJleHAiOjE1ODAzOTk0OTYsIm5iZiI6MTU4MDM5OTE5NiwiYXVkIjoiZDgzZDgxZDMtZGY4OC00MzQxLWJiYWQtM2FlZGI4MjZjNjc4IiwiaWRwIjoiTG9jYWxBY2NvdW50Iiwib2lkIjoiMDIzYWY0NWEtZGUwYi00MjI3LWFlYzktOGUzMTRmYWRhNjM0Iiwic3ViIjoiMDIzYWY0NWEtZGUwYi00MjI3LWFlYzktOGUzMTRmYWRhNjM0IiwibmV3VXNlciI6ZmFsc2UsInRmcCI6IkIyQ18xX2tyay10ZXN0LXNpZ25JbiIsInNjcCI6InVzZXJfaW1wZXJzb25hdGlvbiIsImF6cCI6ImQ4M2Q4MWQzLWRmODgtNDM0MS1iYmFkLTNhZWRiODI2YzY3OCIsInZlciI6IjEuMCIsImlhdCI6MTU4MDM5OTE5Nn0.ADKJhdy5xwWjSWs_gOedEUJHGCqf5xe1wUqY9zjCw2CM80ttvTPp9YMID_dd-q8wIQpUxaw6BHn6CZQFVUS4d7_YC86IabEkvpN9ABiwH52ZjgcsQCKKWg0HTl6IgD9IFsCtV5zt2qulSrT_9xDu6OJ6UKRjON-tE0R33_HywUUu4VbvR4AuS1ez1Abs3SJN8W08aVQXDpqfosKjDz7MI-p6SUgeuSpjvtXKObe8rxwWkLlU4ixu-okY8u-PQPkVv4s8iKd7H7krDatDJAneM9V7ShvPrxTHyVPyq6uXtWNZQG7yTmGb0C17mTJJRrbbRvVOIrodx96UTvCujNi7yg","refresh_token": "eyJraWQiOiJjcGltY29yZV8wOTI1MjAxNSIsInZlciI6IjEuMCIsInppcCI6IkRlZmxhdGUiLCJzZXIiOiIxLjAifQ…fDY_S6qNi1s4t9uF.he647xSrk2kUXfrrH7Qt8iJXJmMTH5zAhVR2IZfn3b1h4zGN2MfPe-OkP4jGMFmbJO5Njz5085Yh-jfdEv2ApY_GfR23gN9BV4pk2Oh2NLZBQ0AgfA9OqGjGQK1wmx4K49h0FMDyyzirRQ1hgedlXJ_OspHIC6EvvuAyHhmI7DjcW7QUn3d2J2DtzzWu-8cpaczp7EX8LrVgNbppMVU0erJQRdaUKiKvodeSOpfHs_sOW4CuMhfI0gSDpbJNwRAyt3zU73Yigmk0uzM9f9kh7MRMfpkLmaavB3FrqoLCHZhB3FaPNg3yxosPfEtLfYnlT7ishw96kzSegL-39D–qnRTQ9orO6upuF6W38xuKGmZKGq3eNc0aNoXUaPU-ujRCNroF9dVvwgS5kp_pCKYY646vAnWQ_tGGp3oxTgj7dR3RVOWiUjPaxidnziY7ShZLw89Llu7k4QFSLEO9nuY-vKCEw-8_dPwdrf7OY5D5itzA8fSyJjHYl0AnFKLJtDANXoxcR80tGtb90Y-_BUofXF8i8wKSLPfLrTYzJRiZBGNM9RGVLf3TcMfkho-vuf0Ur6fV8btxalKMGL-fCudNjD5_FD05OEXjBg9cxGkvqYvskB1PompB8gL4E3hCDdvyeQ-zMd7X6rh5eIVICdeiqjIT0Q-AsBgHyXM0Ny3uMMRD4zWvMcjSxAUUPXe0LBNwZo.jkoLvQGGAUDthGwDnIO60Q","tokenValidityTime": "300","signInStatus": "LoginSuccessfull","accounts": [{"accNumber": "6000112216066021","balance": "0","routingNumber": "122106316"}],"profileInformation": {"first_name": "Apple","last_name": "Test","sysDate": "2020-01-30T15:46:40.969Z"}}')
//println("***DEBUG**** "+j.accounts[0].accNumber)
//***DEBUG**** 6000112216066021

//println("***DEBUG**** "+j.refresh_token[0].tokenValidityTime)
