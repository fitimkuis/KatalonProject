package compareFiles

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

public class CompareTwoCsvFiles {

	@Keyword
	public void compareTwoCsvFiles(){

		String path="C:\\Users\\fitim\\Desktop\\data\\";
		String file1="csv1.csv";
		String file2="csv2.csv";
		String file3="p3lang.csv";
		ArrayList al1=new ArrayList();
		ArrayList al2=new ArrayList();
		//ArrayList al3=new ArrayList();

		BufferedReader CSVFile1 = new BufferedReader(new FileReader(path+file1));
		String dataRow1 = CSVFile1.readLine();
		while (dataRow1 != null)
		{
			String[] dataArray1 = dataRow1.split(",");
			for (String item1:dataArray1)
			{
				al1.add(item1);
			}

			dataRow1 = CSVFile1.readLine(); // Read next line of data.
		}

		CSVFile1.close();

		BufferedReader CSVFile2 = new BufferedReader(new FileReader(path+file2));
		String dataRow2 = CSVFile2.readLine();
		while (dataRow2 != null)
		{
			String[] dataArray2 = dataRow2.split(",");
			for (String item2:dataArray2)
			{
				al2.add(item2);

			}
			dataRow2 = CSVFile2.readLine(); // Read next line of data.
		}
		CSVFile2.close();

		for(String bs:al2)
		{
			al1.remove(bs);
		}

		int size=al1.size();
		System.out.println(size);

		try
		{
			FileWriter writer=new FileWriter(path+file3);
			while(size!=0)
			{
				size--;
				writer.append(""+al1.get(size));
				writer.append('\n');
			}
			writer.flush();
			writer.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
