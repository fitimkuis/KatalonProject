/*import org.python.core.Py;
import org.python.core.PyException;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.core.__builtin__;
import org.python.util.PythonInterpreter;*/

import java.text.Collator;
import java.text.RuleBasedCollator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Collections.shuffle;
import static java.util.stream.Collectors.joining;

List<String> list = new ArrayList<String>();
list.add("AA-10");
list.add("AA-1");
list.add("AA-2");
list.add("AA-2 (1)");

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