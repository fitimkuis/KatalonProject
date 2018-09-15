import java.nio.file.Paths

import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.context.TestCaseContext

class AfterTestCaseRun {
	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	@AfterTestCase
	def sampleAfterTestCase(TestCaseContext testCaseContext) {
		println testCaseContext.getTestCaseId()
		println testCaseContext.getTestCaseStatus()
		
		/*Thread.sleep(60000)
		String fileName = CustomKeywords.'readGmail.getGmail.getGmailAttachment'()
		println('**************DEBUG returned filename *************** ' + fileName)
		CustomKeywords.'readGmail.unZip.unzipFile'(fileName)	
		String zip = fileName.substring(0, 15)	
		String path = Paths.get('.').toAbsolutePath().normalize().toString()	
		path = path.replace('\\', '/')	
		String url = ((path + '/extractedFiles/') + zip) + '/Report.html'	
		CustomKeywords.'readGmail.openWebHtml.openHtmlPage'(url)*/
	}
}