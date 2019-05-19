import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

def expectedValue = "user4"
def prop = CustomKeywords.'com.properties.PropertiesUtil.GetProperty'(expectedValue)
println "property fetch "+prop

//get all properties
Properties props = new Properties();
props = CustomKeywords.'com.properties.PropertiesUtil.GetAllProperties'()
//println props

// Java 8 , print key and values
//allProps.forEach(key, value) -> System.out.println("Key : " + key + ", Value : " + value));

 /*Set<String> keys = props.stringPropertyNames();
 for (String key : keys) {
	 System.out.println(key + " : " + props.getProperty(key));
 }*/
 
 /*Set<Entry<Object, Object>> entries = props.entrySet();
 for (Entry<Object, Object> entry : entries) {
   System.out.println(entry.getKey() + " : " + entry.getValue());
 }*/
 
 Map<String, String> sortedMap = new TreeMap(props);
 
	 //output sorted properties (key=value)
	 for (String key : sortedMap.keySet()) {
		 System.out.println(key + "=" + sortedMap.get(key));
	 }