/*import org.python.core.Py;
import org.python.core.PyException;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.core.__builtin__;
import org.python.util.PythonInterpreter;*/

import static java.util.Collections.shuffle;
import static java.util.stream.Collectors.joining;

import java.text.Collator;
import java.text.RuleBasedCollator;
import java.util.stream.IntStream;

import com.kms.katalon.core.configuration.RunConfiguration


List<String> list = new ArrayList<String>();
list.add("AA-10");
list.add("AA-1");
list.add("AA-2");
list.add("AA-2 (1)");

//String result = list.join(",")

StringBuilder sb = new StringBuilder()
for (String item: list) {
	if (sb.length() > 0 ) {
	  sb.append(", ");
	}
   sb.append(item)
}
String result = sb.toString()

CustomKeywords.'demo.PythonKeywords.helloWorld'(11, 15)

//CustomKeywords.'demo.PythonKeywords.testDemo'(5, 5)

CustomKeywords.'demo.PythonKeywords.sortList'(result)

/*
def pythonDir = RunConfiguration.getProjectDir() + "/python"

Runtime.getRuntime().exec("python "+pythonDir+"/test.py",""+result)

ProcessBuilder pb = new ProcessBuilder("C:/Users/fitim/AppData/Local/Programs/Python/Python37/python",pythonDir+"/test.py",""+result);
Process p = pb.start();
BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));

System.out.println(".........start   process.........");
String line = "";
while ((line = bfr.readLine()) != null){
	System.out.println("Python Output: " + line);
}*/


RuleBasedCollator localRules = (RuleBasedCollator) Collator.getInstance();
String extraRules = IntStream.range(0, 100).mapToObj(String.&valueOf).collect(joining(" < "));
RuleBasedCollator c = new RuleBasedCollator(localRules.getRules() + " & " + extraRules);

//List<String> a = asList("1-2", "1-02", "1-20", "10-20", "fred", "jane", "pic01", "pic02", "pic02a", "pic 5", "pic05", "pic   7", "pic100", "pic100a", "pic120", "pic121");
shuffle(list);
list.sort(c);
System.out.println(list);

/*
def arguments = ["sort.py", "arg1", "arg2", "arg3"];
PythonInterpreter.initialize(System.getProperties(), System.getProperties(),arguments);
org.python.util.PythonInterpreter python = new org.python.util.PythonInterpreter();
StringWriter out = new StringWriter();
python.setOut(out);
python.execfile("sort.py");
String outputStr = out.toString();
System.out.println(outputStr);*/