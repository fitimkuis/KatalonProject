import com.kms.katalon.core.logging.KeywordLogger

String path = System.getProperty("user.dir")+"\\demoData.txt";

List l = CustomKeywords.'readFile.read.readFileInList'(path)

String s = l.get(1);
KeywordLogger log = new KeywordLogger()
log.logInfo("DEBUG value is "+s)

  Iterator<String> itr = l.iterator();
  while (itr.hasNext()){
	System.out.println(itr.next());
  }
	
return s

	
