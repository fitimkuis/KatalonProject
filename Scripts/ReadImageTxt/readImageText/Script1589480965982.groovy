import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testdata.InternalData as InternalData
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable


import java.text.DateFormat
import java.text.SimpleDateFormat

import com.kms.katalon.core.configuration.RunConfiguration

import net.sourceforge.tess4j.Tesseract; 
import net.sourceforge.tess4j.TesseractException;

def eurotext = RunConfiguration.getProjectDir() + "/Include/tessdata/eurotext.png"
def filename = RunConfiguration.getProjectDir() + "/Include/tessdata/image.png"

def screenshots = RunConfiguration.getProjectDir() + "/Include/screenshots/"

/*def text = CustomKeywords.'demo.PythonKeywords.getimagetext'(eurotext)
for (String a in text){
	println(a)
}*/

int ind = 0
def shot = "demoshot"+ind+".png"
def tempshot = "tempshot"+ind+".png"

WebUI.openBrowser(null)
WebUI.navigateToUrl(GlobalVariable.URL_Application)
WebUI.takeScreenshot(screenshots+""+shot)
def path = screenshots+""+shot
print(path)
WebUI.delay(2)
//def text = CustomKeywords.'demo.PythonKeywords.getimagetext'(path)
//print(text[0])
//ind++
WebUI.closeBrowser()


def temppath = RunConfiguration.getProjectDir() + "/Screenshots/"+tempshot
def imagepath = RunConfiguration.getProjectDir() + "/Screenshots/"+shot
println(imagepath)
def ret = CustomKeywords.'demo.PythonKeywords.getimagetext'(imagepath, temppath)
println(ret[0])

def text = CustomKeywords.'demo.PythonKeywords.readimage'(temppath)
for (String s in text){
	if (s.contains('CURA Healthcare Service')){
		println("WORD WAS THERE!!!")
		break
	}
	println(s)
}
ind++






/*
DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
Date currentDate = new Date();
// convert date to calendar
Calendar c = Calendar.getInstance();
c.setTime(currentDate);
// manipulate date
c.add(Calendar.YEAR, 1);
c.add(Calendar.MONTH, 1);
c.add(Calendar.DATE, 1); //same with c.add(Calendar.DAY_OF_MONTH, 1);
c.add(Calendar.HOUR, 1);
c.add(Calendar.MINUTE, 1);
c.add(Calendar.SECOND, 1);

// convert calendar to date
Date currentDatePlusOne = c.getTime();

System.out.println(dateFormat.format(currentDatePlusOne));
*/

/*try {

    File image = new File("C:\\Users\\fitim\\IdeaProjects\\JideaProjects\\src\\main\\images\\image.png");
    Tesseract tesseract = new Tesseract();
    // the path of your tess data folder
    // inside the extracted file
    //String text = tesseract.doOCR(new File("C:\\Users\\fitim\\IdeaProjects\\JideaProjects\\src\\main\\images\\image.png"));
    tesseract.setDatapath("C:/Users/fitim/IdeaProjects/JideaProjects/src/main/tessdata");
    // path of your image file
    String text = tesseract.doOCR(image);
    System.out.print(text);
}
catch (TesseractException e) {
    e.printStackTrace();
}*/

	
//ReadText();
public void ReadText() throws TesseractException {

	File image = new File("C:\\Users\\fitim\\IdeaProjects\\JideaProjects\\src\\main\\java\\com\\read.image\\eurotext.png");
	Tesseract tesseract = new Tesseract();
	tesseract.setDatapath("C:/Users/fitim/IdeaProjects/JideaProjects/src/main/tessdata");
	tesseract.setLanguage("eng");
	tesseract.setPageSegMode(1);
	tesseract.setOcrEngineMode(1);
	String result = tesseract.doOCR(image);
	System.out.println(result);
}
