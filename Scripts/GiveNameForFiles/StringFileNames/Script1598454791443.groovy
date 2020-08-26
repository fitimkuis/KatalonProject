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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable


File folder = new File("C:/Users/fitim/Desktop/files");
File[] listOfFiles = folder.listFiles();

List<String> files = new ArrayList<>()
Map<String, String> map = new HashMap<String, String>();


for (File file : listOfFiles) {
	if (file.isFile()) {
		//System.out.println(file.getName());
		//String path = file.getAbsolutePath();
		//System.out.println(file.getAbsolutePath());
		map.put(file.getName(),file.getAbsolutePath())
	}
}

Iterator<String> iterator = map.keySet().iterator();

while(iterator.hasNext()){
	String key   = iterator.next();
	String value = map.get(key);
	println("key: "+key+" value: "+value)
}

