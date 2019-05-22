package com.pdf.reader

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import java.io.BufferedInputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadPdfFromBrowser {

	WebDriver driver;
	PDDocument pdDoc;

	@Keyword
	public String PdfReaderUtil(){
		
		String pdfFileInText = "";

		driver=new ChromeDriver();

		driver.get("http://www.vandevenbv.nl/dynamics/modules/SFIL0200/view.php?fil_Id=5515");

		Thread.sleep(5000);
		URL url = new URL(driver.getCurrentUrl());
		BufferedInputStream fileToParse = new BufferedInputStream(
				url.openStream());

		pdDoc = PDDocument.load(fileToParse);
		pdDoc.getClass();

		if (!pdDoc.isEncrypted()) {

			PDFTextStripperByArea stripper = new PDFTextStripperByArea();
			stripper.setSortByPosition(true);

			PDFTextStripper tStripper = new PDFTextStripper();

			pdfFileInText = tStripper.getText(pdDoc);

			// split by whitespace
			/*String lines[] = pdfFileInText.split("\\r?\\n");
			for (String line : lines) {
				System.out.println(line);
			}*/
		}
		driver.close();
		return pdfFileInText;
	}
}

