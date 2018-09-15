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

}
