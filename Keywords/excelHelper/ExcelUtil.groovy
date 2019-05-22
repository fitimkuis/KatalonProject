package excelHelper

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

import org.apache.poi.ss.usermodel.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.*;

import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {

	@Keyword
	public List<String> ExcelHelper(int colCount, int start, int end, String path) throws IOException, InvalidFormatException {

		List<String> excelValues = new ArrayList<String>();
		int MY_MINIMUM_COLUMN_COUNT = colCount;

		Workbook book = WorkbookFactory.create(new File(path));

		//Get first/desired sheet from the workbook
		Sheet sheet = book.getSheetAt(0);

		// Create a DataFormatter to format and get each cell's value as String
		DataFormatter dataFormatter = new DataFormatter();

		// Decide which rows to process
		int rowStart = start;
		//System.out.println("row start "+rowStart);
		int rowEnd = end;
		//System.out.println("row end "+rowEnd);

		for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
			Row r = sheet.getRow(rowNum);
			if (r == null) {
				// This whole row is empty
				// Handle it as needed
				continue;
			}

			int lastColumn = Math.max(r.getLastCellNum(), MY_MINIMUM_COLUMN_COUNT);
			//System.out.println("last column "+lastColumn);

			for (int cn = 0; cn < lastColumn; cn++) {
				Cell c = r.getCell(cn, Row.RETURN_BLANK_AS_NULL);
				if (c == null) {
					excelValues.add("**No Value**");
					// The spreadsheet is empty in this cell
				} else {
					// Do something useful with the cell's contents
					excelValues.add(dataFormatter.formatCellValue(c));
				}
			}
		}

		//System.out.println("Row "+rowStart+ " values "+excelValues);
		return excelValues;
	}
}
