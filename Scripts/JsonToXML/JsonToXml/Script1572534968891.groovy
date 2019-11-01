import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable


import groovy.json.JsonSlurper
import groovy.xml.MarkupBuilder

String json = '''
{
    "name": "sampleConfiguration",
    "description": "SampleDesc",
    "version": "1.0",
    "parameters": [
    {
        "name": "sampleParameter",
        "description": "parameter description",
        "value": "20",
        "enabled": "1"
    },
    {
        "name": "items",
        "description": "parameter with subparameters",
        "value":[
            {
                "name": "item",
                "description": "nested parameter",
                "value": "13"
            },
            {
                "name": "item",
                "description": "nested parameter 2",
                "value": "TEST"
            }
        ]
    }
]}'''

def json2 = System.getProperty("user.dir")+"\\Include\\json\\test.json";

def inputFile = new File(json2)
def slurper = new JsonSlurper()
String data = slurper.parse(inputFile)

String jsonVal = "\'''"+data+"\'''";

String value = "\'''Ram\'''";
System.out.println("Value - " + jsonVal );

println data

jsonToXml(json)
jsonToXml(data)


public void jsonToXml(String json){

	def xml = new JsonSlurper().parseText(json).with { j ->
		new StringWriter().with { sw ->
			new MarkupBuilder(sw)."$name"(version: version, description:description) {
				params {
					parameters.each { p ->
						if(p.value instanceof List) {
							"$p.name"(description:p.description) {
								p.value.each { v ->
									"$v.name"(description: v.description, v.value)
								}
							}
						}
						else {
							"$p.name"(description:p.description, p.value)
						}
					}
				}
			}
			sw.toString()
		}
	}
	
	println xml
}