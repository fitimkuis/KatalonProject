import static com.kms.katalon.core.testdata.TestDataFactory.findTestData

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.InternalData as InternalData

import com.kms.katalon.core.util.KeywordUtil

BigDecimal price = new BigDecimal("9.99")
BigDecimal tax = new BigDecimal("0.30")
BigDecimal total = price.add(tax)
println total


//get instance of internal datafile
InternalData data = findTestData('SpamData/someSpamTestData')
//int colNumbers = data.columnNumbers

//get column names from the datafile
def colNames = data.columnNames
println "column names "+colNames

def ro = data.getRowNumbers()

/*
//add column name to list
List<String> columns = new ArrayList<>()
for (String cname: colNames){
	columns.add(cname)
}
println "columns in List "+columns*/

//println colNumbers
//String column

KeywordUtil log = new KeywordUtil();

/*ArrayList[] list = new ArrayList[ro];
for(int i=0; i<ro; i++)
{
	list[i] = new ArrayList<String>();
}*/

//Create a dynamic list of lists
List<List<String>> lists = new ArrayList<List<String>>();
for (int i = 0; i < ro; i++) {
	List<String> list = new ArrayList<>();
	lists.add(list);
}
// Now you can use lists.get(0) etc to get at each list

/*
List <String> row1 = new ArrayList<>()
List <String> row2 = new ArrayList<>()
List <String> row3 = new ArrayList<>()
List <String> row4 = new ArrayList<>()

List<ArrayList> allCol = new ArrayList<ArrayList>();//Create a list of lists
allCol.add(row1)
allCol.add(row2)
allCol.add(row3)
allCol.add(row4)*/

int row = 1  //values start from row 1
//int rowCount = 1
int colCount = 0

//loop rows
for (def index : (0..data.getRowNumbers() - 1)) {
	//loop columns
	for (String col : colNames){
		//check is there value in the column cell
		if (data.getValue(col, row).equals("")){
			println "header: "+col+" has not value!!!! "+data.getValue(col, row)+ " row: "+row
			log.markWarning("column: "+col+" has not value!!!! "+data.getValue(col, row)+ " row: "+row);
			//allCol.get(colCount).add(data.getValue(col, row))
			lists.get(colCount).add(data.getValue(col, row))
			//log.markError("column "+col+" has not value!!!! "+data.getValue(col, row)+ " row "+row);
			//throw new com.kms.katalon.core.exception.StepErrorException("column "+col+" has not value!!!! "+data.getValue(col, row)+ " row "+row)
		}else{
			println "header: "+col+ " row: "+row+" value: "+data.getValue(col, row)
			//allCol.get(colCount).add(data.getValue(col, row))
			lists.get(colCount).add(data.getValue(col, row))
			println colCount	
		}
		
	}
	colCount++
	row++
}
/*println "row 1 contents "+row1
println "row 2 contents "+row2
println "row 3 contents "+row3
println "row 4 contents "+row4*/


List <String> colRows1 = new ArrayList<>()
List <String> colRows2 = new ArrayList<>()
List <String> colRows3 = new ArrayList<>()
List <String> colRows4 = new ArrayList<>()

//loop col1
for (ArrayList s: lists){
	colRows1.add(0, s.get(0))
}
//loop col2
for (ArrayList s: lists){
	colRows2.add(0, s.get(1))
}
//loop col3
for (ArrayList s: lists){
	colRows3.add(0, s.get(2))
}
//loop col4
for (ArrayList s: lists){
	colRows4.add(0, s.get(3))
}

colRows1.removeAll(Arrays.asList("")) 
colRows2.removeAll(Arrays.asList(""))  
colRows3.removeAll(Arrays.asList(""))  
colRows4.removeAll(Arrays.asList(""))  
println colRows1
println colRows2
println colRows3
println colRows4

println "count of rows in column name first: "+colRows1.size()
println "count of rows in column name second: "+colRows2.size()
println "count of rows in column name third: "+colRows3.size()
println "count of rows in column name fourth: "+colRows4.size()


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