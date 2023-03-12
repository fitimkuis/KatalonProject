package com.csv

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadCsvFile {
	

	@Keyword
	public ArrayList<String> splitUrl(String s) {
		ArrayList<String> list = new ArrayList<>();
		int spaceIndex = 0;
		while (true) {
			int httpIndex = s.indexOf("http", spaceIndex);
			if (httpIndex < 0) {
				break;
			}

			spaceIndex = s.indexOf(" ", httpIndex);
			if (spaceIndex < 0) {
				list.add(s.substring(httpIndex));
				break;
			} else {
				list.add(s.substring(httpIndex, spaceIndex));
			}
		}
		return list;
	}


	@Keyword
	public ArrayList<String> readLinksFrom(String path){

		ArrayList<String> list = new ArrayList<>();

		CSVReader reader = null;
		try
		{
			//parsing a CSV file into CSVReader class constructor
			reader = new CSVReader(new FileReader(path));
			String [] nextLine;
			//reads one line at a time
			while ((nextLine = reader.readNext()) != null)
			{
				for(String token : nextLine)
				{
					System.out.print(token);
					list.add(token);
				}
				System.out.print("\n");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
}
