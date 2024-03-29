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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

        String name = "01223_adsdwd.xls";
        Pattern p = Pattern.compile("([\\d]+)\\S(\\w+)(\\Sxls)");
        System.out.println(p);
        Matcher m = p.matcher(name);
        String firstGroup = "";
        String secondGroup = "";
        String thirdGroup = "";
        while(m.find()) {
            firstGroup = m.group(0);
            secondGroup = m.group(1);
            thirdGroup = m.group(2);
        }

        System.out.println("first "+firstGroup);
        System.out.println("second "+secondGroup);
        System.out.println("third "+thirdGroup);

        String finalFileName = secondGroup+"_"+thirdGroup+".xls";
        System.out.println("finalName "+finalFileName);