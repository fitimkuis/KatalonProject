package my

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.TestObjectXpath
import com.kms.katalon.core.testobject.SelectorMethod
import com.kms.katalon.core.util.KeywordUtil

import java.util.regex.Pattern
import java.util.regex.Matcher
/**
 * 
 * @author kazurayam
 *
 */
class TestObjectTransformer {

	private static boolean DEBUG = false

	/**
	 * This accepts a test object with xpath in the format of
	 *     <code>//button[@id="staticId1:dynamicId:staticId2"]/span</code>
	 * where 'staticId' 'dyanmicId' 'staticId2' are character sequence
	 * 1. of word characters: [a-zA-Z_0-9]
	 * 2. of length > 0 and length < 20
	 * 
	 * then it transform the expression into another expression of
	 *     <code>//button[starts-with(@id,"staticId1") and (substring(@id,string-length(@id)-string-length("staticId2")+1)="staticId2")]/span<code>
	 * 
	 * then it generates a TestObject instance with the XPath generated above, 
	 * 
	 * finally it returns the new TestObject
	 * 
	 * Michal.Pachucki wanted this
	 * 
	 * @param testObject a TestObject with XPath in the above mentioned format, which was generated by WebRecorder possibly
	 * @returns new TestObject
	 */
	@Keyword
	static TestObject toMichalPachuckiXpath(TestObject testObject, FailureHandling flowControl) {
		try {
			Pattern p = Pattern.compile(/\/\/button\[@id=['"](\w{1,20}):(\w{1,20}):(\w{1,20})['"]\]\/span/)
			return transformTestObject(testObject, { expr ->
				Matcher m = p.matcher(expr)
				if (m.matches()) {
					def staticId1 = m.group(1)
					def dynamicId = m.group(2)
					def staticId2 = m.group(3)
					def newExpr = '//button[starts-with(@id,\"' + staticId1 +
							'\") and (substring(@id,string-length(@id)-string-length(\"' + staticId2 +
							'\")+1)=\"' + staticId2 + '\")]/span'
					if (DEBUG) println "\n>>> newExpr \"${newExpr}\"\n"
					return newExpr
				} else {
					if (DEBUG) ">>> source expr \"${expr}\" does not match the pattern ${p.toString()}\n"
					return expr
				}
			})
		} catch (Exception e) {
			e.printStackTrace()
			stepFailed("failed to transform a test object: " +
					TestObjectFormatter.format(testObject),
					flowControl)
		}
	}


	/**
	 * taking a source TestObject, will create a new TestObject and return it.
	 * XPath expression of the source is transformed by the logic (Groovy Closure) and set into the resulting TestObject.
	 *  
	 * @param source TestObject instance as source. It should have Selector Method=XPATH or BASIC. CSS is not supported.
	 * @param logic a Groovy Closure which transforms input xpath expression into another xpath expression
	 */
	private static TestObject transformTestObject(TestObject source, Closure logic) {
		Objects.requireNonNull(source.getObjectId())
		TestObject newTO = new TestObject(source.getObjectId() + "*")
		if (source.getSelectorMethod() == SelectorMethod.XPATH) {
			newTO.setSelectorMethod(SelectorMethod.XPATH)
			List<TestObjectXpath> toxList = new ArrayList<>()
			for (TestObjectXpath tox : source.getActiveXpaths()) {
				TestObjectXpath newTox = new TestObjectXpath()
				newTox.setName(tox.getName())
				newTox.setCondition(tox.getCondition())
				// xpath expression is transformed by the logic
				newTox.setValue(logic.call(tox.getValue()))
				toxList.add(newTox)
			}
			newTO.setXpaths(toxList)
		} else if (source.getSelectorMethod() == SelectorMethod.BASIC) {
			newTO.setSelectorMethod(SelectorMethod.BASIC)
			List<TestObjectProperty> topList = new ArrayList<>()
			for (TestObjectProperty top : source.getActiveProperties()) {
				TestObjectProperty newTop = new TestObjectProperty()
				newTop.setName(top.getName())
				newTop.setCondition(top.getCondition())
				newTop.setValue(logic(top.getValue()))
				topList.add(newTop)
			}
			newTO.setProperties(topList)
		} else if (source.getSelectorMethod() == SelectorMethod.CSS) {
			throw new UnsupportedOperationException("SelectionMethod.CSS is not yet supported")
		} else {
			throw new RuntimeException("unknow selectionMethod")
		}
		//newTestObject.setSelectorMethod(SelectorMethod.BASIC)
		return newTO
	}

	static def stepFailed(String message, FailureHandling flowControl) {
		if (flowControl == FailureHandling.OPTIONAL) {
			println "#stepFailed('${message}',FailureHandling.OPTIONAL)"
			KeywordUtil.logInfo(message)
		} else if (flowControl == FailureHandling.CONTINUE_ON_FAILURE) {
			println "#stepFailed('${message}',FailureHandling.CONTINUE_ON_FAILURE)"
			KeywordUtil.logInfo(message)
			KeywordUtil.markFailed(message)
		} else {
			// in the case where flowControl == FailureHandling.STOP_ON_FAILURE
			println "#stepFailed('${message}',FailureHandling.STOP_ON_FAILURE)"
			KeywordUtil.logInfo(message)
			KeywordUtil.markFailedAndStop(message)
		}
	}
}