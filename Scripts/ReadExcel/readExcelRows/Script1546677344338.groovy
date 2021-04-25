import com.kms.katalon.core.util.KeywordUtil

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

KeywordUtil log = new KeywordUtil()

List<String> excelValues = new ArrayList<String>();
List<String> headerValues = new ArrayList<String>();

String path = System.getProperty("user.dir")+"\\ExcelFiles\\SmoobuBookings-2020-sheet2.xlsx";
println path



//create two list arrays
List <String> idArray = new ArrayList<>()
List <String> amountArray = new ArrayList<>()

int counter = 1
int counter2 = 1
int sheet = 2


String path2 = System.getProperty("user.dir")+"\\ExcelFiles\\SmoobuBookings-2020-sheet3-1.xlsx";
List<String> cell1 = new ArrayList<String>();
List<String> cell2 = new ArrayList<String>();

def columns = CustomKeywords.'readExcelRows.ReadRows.getCountOfColumns'(path2, sheet)
columns = columns+1
println("****count of columns ****"+columns)

excelValues = CustomKeywords.'readExcelRows.ReadRows.readExcelRows'(0, 2, path2, sheet)

for(int i = 0; i< excelValues.size(); i++){
	
	if (i % 2 == 0){
		cell1.add(excelValues.get(i))
	}
	else{
		cell2.add(excelValues.get(i))
	}
}

List<String> cell1Regex = new ArrayList<String>();
List<String> cell2Regex = new ArrayList<String>();
//regex values from cell1
String pattern = "Confirmation number :(\\d+)";
// Create a Pattern object
Pattern r = Pattern.compile(pattern);

for (int i = 0; i < cell1.size(); i++){
	Matcher m = r.matcher(cell1.get(i));
	if (m.find( )) {
		System.out.println("Found value: " + m.group(1) );
		cell1Regex.add(m.group(1))
	 } else {
		System.out.println("NO MATCH");
	 }
	
}

//create list of lists count of added cells in second column
List<List<String>> lists = new ArrayList<List<String>>();
for (int i = 0; i < cell2.size(); i++) {
	List<String> list = new ArrayList<>();
	lists.add(list);
}
println ("count of lists in a list "+lists.size())
println ("lists in a list "+lists)

List<String> cell1Values = new ArrayList<String>();
List<String> cell2Values = new ArrayList<String>();


String REGEX = "\\r?\\n";
pat = Pattern.compile(REGEX);
for (int i = 0; i < lists.size();i++){
	def result = pat.split(cell2.get(i));
		
	for(String data:result){
		if (i % 2 == 0){
			cell1Values.add(data)
			lists.get(i).add(data)
		}
		else{
			cell2Values.add(data)
			lists.get(i).add(data)
		}
	}
}

//create list of lists count of added cells in second column
List<List<String>> valueLists = new ArrayList<List<String>>();
for (int i = 0; i < cell2.size(); i++) {
	List<String> list = new ArrayList<>();
	valueLists.add(list);
	// Use the list further...
}

List <String> values = new ArrayList<>()
List <String> valuesList1 = new ArrayList<>()
List <String> valuesList2 = new ArrayList<>()
println ("lists in a list "+lists)
int z = 0
int index = 0
int cnt = (cell1Values.size()*2) / 2
println cnt
int count1 = 0
int count2 = 0
int cnt2 = cell1Values.size()*2
println cnt2
println lists.get(1).get(0)
List<List<String>> valuesLists = new ArrayList<List<String>>();
for (int i = 0; i < cnt2; i++){
	if (i < cnt){
		values.add(lists.get(z).get(count1).replaceAll("[^0-9]", ""))
		count1++
		//println count1
		if (i == cnt-1){
			valuesLists.add(values)
		}
	}
	if (i >= cnt){
		z = 1
		values.add(lists.get(z).get(count2).replaceAll("[^0-9]", ""))
		count2++
		//println count2
		if (i == cnt2){
			valuesLists.add(values)
		}
	}
}
println ("***********valueLists values "+values+"*************")
println ("************************")
println ("***********valueList of lists values "+valuesLists+"*************")
println ("************************")
List <String> list1 = new ArrayList<>()
List <String> list2 = new ArrayList<>()
for (int i = 0; i < cell1Values.size(); i++){
	list1.add(cell1Values.get(i).replaceAll("[^0-9]", ""))
}
for (int i = 0; i < cell2Values.size(); i++){
	list2.add(cell2Values.get(i).replaceAll("[^0-9]", ""))
}

println list1
println list2

//verify values
List<String> searched = new ArrayList<>()
/*
List<String> first = new ArrayList<>()
List<String> second = new ArrayList<>()
count1 = 0
count2 = 0
int k = 0
println valuesLists.get(0).get(0)

for (int i = 0; i < cnt2; i++){
	if (i < cnt){
		println valuesLists.get(k).get(count1)
		first.add(valuesLists.get(k).get(count1))
		count1++
	}
	if (i >= cnt){
		println valuesLists.get(k).get(count2)
		second.add(valuesLists.get(k).get(count2))
		count2++
	}
}
searched = findUsingLoop(cell1Regex.get(0), first)
println ("**found expected first value** "+searched)
searched = findUsingLoop(cell1Regex.get(1), second)
println ("**found expected second value** "+searched)
*/

searched = findUsingLoop(cell1Regex.get(0), list1)
if (searched.isEmpty()){
		println("No matches")
	}
	else{
		println ("found expected value "+searched)
	}

searched = findUsingLoop(cell1Regex.get(1), list2)
if (searched.isEmpty()){
		println("No matches")
	}
	else{
		println ("found expected value "+searched)
	}

//##################################################################
sheet = 1
def count = CustomKeywords.'readExcelRows.ReadRows.getCountOfRows'(path, sheet)

excelValues = CustomKeywords.'readExcelRows.ReadRows.readExcelRows'(1, count+1, path, sheet)

for (String temp : excelValues) {
	counter++
	if (counter % 2 != 0){
		amountArray.add(temp)
		counter = 1
	}
	else{
		idArray.add(temp)
		counter2++
		counter2 = 1
	}
}

//combine two list and get keys/value from map without duplicates
Map<String,String> map = combineListsIntoOrderedMap2 (idArray, amountArray);

//create multimap where all duplicate keys added
MultiValuedMap<String,String> map0 = combineListsIntoOrderedMap3 (idArray, amountArray);


int ind = 0

List<String> list = new ArrayList<>()

//get count of keys
for (Map.Entry<String,String> entry : map.entrySet()){
	
	list.add(entry.getKey())
	println("keys: "+entry.getKey())
}


//create list of lists to add all values by key
ArrayList[] lis = new ArrayList[list.size()];
for(int i=0; i<list.size(); i++)
{
	lis[i] = new ArrayList<String>();
	lis[i] = (Collection<String>) map0.get(map.keySet().toArray()[i])
}

println("values in excel file "+lis)

ArrayList[] doub = new ArrayList[list.size()]; //size 3
List<Double> sum = new ArrayList<>()
for (int i = 0; i < list.size(); i++ ){

	doub[i] = new ArrayList<Double>();
	
	for (int x=0;x<lis[i].size();x++){
		
		doub[i] += Double.parseDouble(lis[i].get(x))
	}
}

def val = 0.0

//sum list values 
for (int x = 0; x < doub.size(); x++){
	
	val = 0.0
	for (int i = 0; i < doub[x].size(); i++){
		val += doub[x][i]
	}
	sum.add("key : "+list.get(x)+" sum "+  val)
}

println("sum of each keys: "+sum)

public List<String> findUsingLoop(String search, List<String> list) {
	List<String> matches = new ArrayList<String>();

	for(String str: list) {
		if (str.contains(search)) {
			matches.add(str);
		}
	}

	return matches;
}

public <K, V> Map<K, V> combineListsIntoOrderedMap2 (Iterable<K> keys, Iterable<V> values) {
	
		Map<K, V> map = new LinkedHashMap<>();
	
		Iterator<V> vit = values.iterator();
		for (K k: keys) {
			if (!vit.hasNext())
				throw new IllegalArgumentException ("Less values than keys.");
	
			map.put(k, vit.next());
		}
	
		return map;
	}
	
MultiValuedMap<String,String> combineListsIntoOrderedMap3 (List<String> keys, List<String> values) {
	if (keys.size() != values.size())
		throw new IllegalArgumentException ("Cannot combine lists with dissimilar sizes");
	MultiValuedMap<String, String> map = new ArrayListValuedHashMap<String, String>();
	int index = 0
	for (String s : keys){
		map.put(keys.get(index), values.get(index));
		index++
	}
	return map;
}