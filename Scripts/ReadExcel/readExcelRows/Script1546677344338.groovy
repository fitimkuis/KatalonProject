import com.kms.katalon.core.util.KeywordUtil

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

KeywordUtil log = new KeywordUtil()

List<String> excelValues = new ArrayList<String>();
List<String> headerValues = new ArrayList<String>();

//String path = System.getProperty("user.dir")+"\\ExcelFiles\\SmoobuBookings-2019-5-20.xls";
String path = System.getProperty("user.dir")+"\\ExcelFiles\\SmoobuBookings-2020-sheet2.xlsx";
println path

//int rows = CustomKeywords.'readExcelRows.ReadRows.getCountOfRows'(path)
//println rows

/*headerValues = CustomKeywords.'readExcelRows.ReadRows.readExcelRows'(0, 1, path)
System.out.println("Header values")
for (String temp : headerValues) {
	System.out.print(temp + "\t");
	log.logInfo(temp + "\t")
}*/
List <String> idArray = new ArrayList<>()
List <String> amountArray = new ArrayList<>()

int counter = 1
int counter2 = 1
int sheet = 1

def count = CustomKeywords.'readExcelRows.ReadRows.getCountOfRows'(path, sheet)

excelValues = CustomKeywords.'readExcelRows.ReadRows.readExcelRows'(1, count+1, path, sheet)
//System.out.println("Row 2 values")
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
//println idArray
//println amountArray

//combine two list and get keys/value from map without duplicates
Map<String,String> map = combineListsIntoOrderedMap2 (idArray, amountArray);
//System.out.println(map);

//create multimap where all duplicate keys added
MultiValuedMap<String,String> map0 = combineListsIntoOrderedMap3 (idArray, amountArray);
//System.out.println(map0);

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




key1 = (Collection<String>) map0.get(map.keySet().toArray()[0])
key2 = (Collection<String>) map0.get(map.keySet().toArray()[1])
key3 = (Collection<String>) map0.get(map.keySet().toArray()[2])

println("*********"+(Collection<String>) map0.get(map.keySet().toArray()[0]))
println("*********"+(Collection<String>) map0.get(map.keySet().toArray()[1]))
println("*********"+(Collection<String>) map0.get(map.keySet().toArray()[2]))

Optional<String> firstElement = key1.stream().findFirst();
println firstElement

def amount = 0.0

for(String s : key1) {
	System.out.println(s);
	amount += Double.parseDouble(s) 
}
System.out.println(amount);

amount = 0.0
for(String s : key2) {
	System.out.println(s);
	amount += Double.parseDouble(s)
}
System.out.println(amount);

amount = 0.0

for(String s : key3) {
	System.out.println(s);
	amount += Double.parseDouble(s)
}
System.out.println(amount);

//def amount = Double.parseDouble((Collection<String>) map0.get(map.keySet().toArray()[0]))
//println amount



//println GroovyCollections.transpose([idArray, amountArray]).collect {le -> [(le[0]):le[1]]}.collectEntries { it }



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


Map<String,String> combineListsIntoOrderedMap (List<String> keys, List<String> values) {
	if (keys.size() != values.size())
		throw new IllegalArgumentException ("Cannot combine lists with dissimilar sizes");
	Map<String,String> map = new LinkedHashMap<String,String>();
	for (int i=0; i<keys.size(); i++) {
		map.put(keys.get(i), values.get(i));
	}
	return map;
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
//println excelValues

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
