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

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import com.testautomationguru.utility.PDFUtil;

import com.kms.katalon.core.util.KeywordUtil
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.HashMap;
import java.util.Map;


KeywordUtil logger = new KeywordUtil()

String pdfFilePath = System.getProperty("user.dir")+"\\pdfFiles\\pdfcontent.pdf";
//PDFUtil pdfUtil = new PDFUtil();
//String content = pdfUtil.getText(pdfFilePath,1);
//println content
println pdfFilePath

List<String> content = new ArrayList<>()

String text = ""
PDDocument document = PDDocument.load(new File(pdfFilePath));
if (!document.isEncrypted()) {
	PDFTextStripper stripper = new PDFTextStripper();
	text = stripper.getText(document);
	System.out.println("Text:" + text);
	content.add(text)
}
document.close();

def lines = text.split("(\r\n|\r|\n)", -1);

//for testing purpose
Map<String, String> rules = new HashMap<>();

String regex = "CR001 Description 1 Person 1 GREEN"
//String pattern1 = '([\\S\\s+]) Person ([\\S\\s])([\\S\\s])([\\S\\s]+)';
String pattern1 = '([CR\\d]+) * Description ([\\S\\s]) Person ([\\S\\s])([\\S\\s]+)';
Pattern r1 = Pattern.compile(pattern1);
Matcher m1 = r1.matcher(regex);
String rule = ""
String outcome1 = ""
if (m1.find( )) {
   System.out.println("Found value: " + m1.group(0) );
   System.out.println("Found value: " + m1.group(1) ); //rule
   rule = m1.group(1).replaceAll("\\s","")
   System.out.println("Found value: " + m1.group(2) );
   System.out.println("Found value: " + m1.group(3) );
   System.out.println("Found value: " + m1.group(4) ); //outcome
   outcome1 = m1.group(4).replaceAll("\\s","")
   rules.put(rule, outcome1)
   //outcome = outcome.replaceAll("\\s","");
   if (outcome1.equals("YELLOW")){
	   logger.markWarning("value is wrong should be GREEN")
   }
}else {
   System.out.println("NO MATCH");
}
for (Map.Entry<String, String> entry : rules.entrySet()){
	String k = entry.getKey();
	String v = entry.getValue();
	System.out.println("Key: " + k + ", Value: " + v);
}
//for testing purpose

String pattern = '^.*Person ([\\S\\s])([\\S\\s])([\\S\\s]+)';
String searchString = "YELLOW"
// Create a Pattern object
Pattern r = Pattern.compile(pattern);
// Now create matcher object.
for(String line:lines){
	Matcher m = r.matcher(line);
	if (m.find( )) {
	   System.out.println("Found value: " + m.group(0) );
	   System.out.println("Found value: " + m.group(1) );
	   System.out.println("Found value: " + m.group(2) );
	   System.out.println("Found value: " + m.group(3) );
	   String outcome = m.group(3)
	   //outcome = outcome.replaceAll("\\s","");
	   if (m.group(3).replaceAll("\\s","").equals(searchString)){
		   logger.markWarning("value is wrong should be GREEN")
	   }
	}else {
	   System.out.println("NO MATCH");
	}
}

/*
println content
int ind = 0
for (String s : content){
	
	if (s.contains("YELLOW")){
		
		//logger.markFailed("value is wrong ")
		logger.markWarning("value is wrong should be GREEN")
	}
}
*/