import java.nio.file.Paths

import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestSuiteContext

class AfterTestSuiteRun {
	/**
	 * Executes after every test suite ends.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@AfterTestSuite
	def sampleAfterTestSuite(TestSuiteContext testSuiteContext) {
		println testSuiteContext.getTestSuiteId()
		/*Thread.sleep(60000)
		String fileName = CustomKeywords.'readGmail.getGmail.getGmailAttachment'()
		println('**************DEBUG returned filename *************** ' + fileName)
		CustomKeywords.'readGmail.unZip.unzipFile'(fileName)
		String zip = fileName.substring(0, 15)
		String path = Paths.get('.').toAbsolutePath().normalize().toString()
		path = path.replace('\\', '/')
		String url = ((path + '/extractedFiles/') + zip) + '/Report.html'
		CustomKeywords.'readGmail.openWebHtml.openHtmlPage'(url)
		*/
	}
}