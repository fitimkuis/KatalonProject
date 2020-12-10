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

List<String> cell1Values = new ArrayList<String>();
List<String> cell2Values = new ArrayList<String>();
String REGEX = "\\r?\\n";
pat = Pattern.compile(REGEX);
for (int i = 0; i < cell2.size();i++){
	def result = pat.split(cell2.get(i));
		
	for(String data:result){
		if (i % 2 == 0){
			cell1Values.add(data)
		}
		else{
			cell2Values.add(data)
		}
	}
}

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