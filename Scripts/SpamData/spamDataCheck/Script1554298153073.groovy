import static com.kms.katalon.core.testdata.TestDataFactory.findTestData

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.InternalData as InternalData
import com.kms.katalon.core.util.KeywordUtil


//get instance of internal datafile
InternalData data = findTestData('SpamData/someSpamTestData')
//int colNumbers = data.columnNumbers

//get columns name from the datafile
def colNames = data.columnNames
println "column names "+colNames

/*
//add column name to list
List<String> columns = new ArrayList<>()
for (String cname: colNames){
	columns.add(cname)
}
println "columns in List "+columns*/

//println colNumbers
String column

KeywordUtil log = new KeywordUtil();


int row = 1  //values start from row 1

//loop rows
for (def index : (0..data.getRowNumbers() - 1)) {
	//loop columns
	for (String col : colNames){
		//check is there value in the column cell
		if (data.getValue(col, row).equals("")){
			println "column: "+col+" has not value!!!! "+data.getValue(col, row)+ " row: "+row
			log.markWarning("column: "+col+" has not value!!!! "+data.getValue(col, row)+ " row: "+row);
			//log.markError("column "+col+" has not value!!!! "+data.getValue(col, row)+ " row "+row);
			//throw new com.kms.katalon.core.exception.StepErrorException("column "+col+" has not value!!!! "+data.getValue(col, row)+ " row "+row)
		}else{
			println "column: "+col+ " row: "+row+" value: "+data.getValue(col, row)
		}
	}
	row++
}

/*
for (def index : (0..data.getRowNumbers() - 1)) {
	for (int k = 0; k < colNumbers; k++){
	//for (String col: data){
		column = data.internallyGetValue(columns.get(k), x)
		//column = data.getValue(col, index)
		if (column.equals("")){
			//println "column has not value!!!! "+column+ " row "+x
			println "column has not value!!!! "+columns.get(k)+ " row "+x
			//log.markWarning("column "+columns.get(k)+ " row "+x+" has not data "+column);
			//log.markError("column "+k+ " row "+x+" has not data "+column);
			//throw new com.kms.katalon.core.exception.StepErrorException("cell is null")
		}else{
			println "column "+k+ " row "+x+" data "+column
			//println "column "+col+ " row "+x+" data "+column
		}
		y++
	}
	if (y >= data.getRowNumbers() - 1)
		x++
		y=0	
}

*/