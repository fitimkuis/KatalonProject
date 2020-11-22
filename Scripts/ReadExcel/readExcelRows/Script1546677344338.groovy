import com.kms.katalon.core.util.KeywordUtil

KeywordUtil log = new KeywordUtil()

List<String> excelValues = new ArrayList<String>();
List<String> headerValues = new ArrayList<String>();

String path = System.getProperty("user.dir")+"\\ExcelFiles\\SmoobuBookings - 2019-5-20.xls";
println path

//int rows = CustomKeywords.'readExcelRows.ReadRows.getCountOfRows'(path)
//println rows

/*headerValues = CustomKeywords.'readExcelRows.ReadRows.readExcelRows'(0, 1, path)
System.out.println("Header values")
for (String temp : headerValues) {
	System.out.print(temp + "\t");
	log.logInfo(temp + "\t")
}*/

excelValues = CustomKeywords.'readExcelRows.ReadRows.readExcelRows'(1, 2, path)
System.out.println("Row 2 values")
for (String temp : excelValues) {
	//System.out.print(temp + "\t");
	//log.markPassed(path)(temp + "\t")
}
//println headerValues
println excelValues

/*
path = "C:\\Users\\fitim\\Desktop\\data\\readExcelSheet.xls"
excelValues = CustomKeywords.'readExcelRows.ReadRows.readExcelRows'(0, 10, path)
System.out.println("Rows from 1 to 10")
for (String temp : excelValues) {
	System.out.print(temp + "\t");
	log.logInfo(temp + "\t")
}

excelValues = CustomKeywords.'readExcelRows.ReadRows.readExcelRows'(2, 5, path)
System.out.println("Rows from 3 to 5")
for (String temp : excelValues) {
	System.out.print(temp + "\t");
	log.logInfo(temp + "\t")
}

excelValues = CustomKeywords.'readExcelRows.ReadRows.readExcelRows'(1, 4, path)
System.out.println("Rows from 2 to 4")
for (String temp : excelValues) {
	System.out.print(temp + "\t");
	log.logInfo(temp + "\t")
}

excelValues = CustomKeywords.'readExcelRows.ReadRows.readExcelRows'(3, 4, path)
System.out.println("Only row 4")
for (String temp : excelValues) {
	System.out.print(temp + "\t");
	log.logInfo(temp + "\t")
}
*/
