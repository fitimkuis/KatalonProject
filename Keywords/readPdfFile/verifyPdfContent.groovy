package readPdfFile

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper
import org.testng.Assert

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class verifyPdfContent {

	@Keyword
	public String readPdfFileVerify(String pdfUrl){

		URL TestURL = new URL(pdfUrl);
		BufferedInputStream bis = new BufferedInputStream(TestURL.openStream());
		PDDocument doc = PDDocument.load(bis);
		String pdfText = new PDFTextStripper().getText(doc);
		doc.close();
		bis.close();
		println(pdfText);
		return pdfText;
		/*
		 Assert.assertTrue(pdfText.contains("Open the setting.xml, you can see it is like this:"));
		 Assert.assertTrue(pdfText.contains("Please add the following sentence in setting.xml before"));
		 Assert.assertTrue(pdfText.contains("You can see that I have modified the setting.xml, and if open the file in IE, it is like this:"));
		 println "PDF IS GOOD TO GO...\r";*/
	}

	@Keyword
	public String getDiffrence(String str1, String str2){

		if (str1 == null) {
			return str2;
		}
		if (str2 == null) {
			return str1;
		}
		int at = indexOfDifference(str1, str2);
		if (at == -1) {
			return "";
		}
		return str2.substring(at);
	}

	public static int indexOfDifference(String str1, String str2) {
		if (str1 == str2) {
			return -1;
		}
		if (str1 == null || str2 == null) {
			return 0;
		}
		int i;
		for (i = 0; i < str1.length() && i < str2.length(); ++i) {
			if (str1.charAt(i) != str2.charAt(i)) {
				break;
			}
		}
		if (i < str2.length() || i < str1.length()) {
			return i;
		}
		return -1;
	}

	@Keyword
	public List<String> findNotMatching(String sourceStr, String anotherStr){
		StringTokenizer at = new StringTokenizer(sourceStr, " ");
		StringTokenizer bt = null;
		int i = 0, token_count = 0;
		String token = null;
		boolean flag = false;
		List<String> missingWords = new ArrayList<String>();
		while (at.hasMoreTokens()) {
			token = at.nextToken();
			bt = new StringTokenizer(anotherStr, " ");
			token_count = bt.countTokens();
			while (i < token_count) {
				String s = bt.nextToken();
				if (token.equals(s)) {
					flag = true;
					break;
				} else {
					flag = false;
				}
				i++;
			}
			i = 0;
			if (flag == false)
				missingWords.add(token);
		}
		return missingWords;
	}
}
