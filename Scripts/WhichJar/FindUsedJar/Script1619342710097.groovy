
import java.util.jar.JarFile
import java.util.regex.Matcher
import java.util.regex.Pattern
import java.util.zip.ZipEntry

import org.apache.xerces.dom.NodeImpl




URL u = NodeImpl.class.getResource("/" + NodeImpl.class.getName().replaceAll("\\.", "/") + ".class");
System.out.println("*************"+u);

def s = resourceLookup("org.apache.xerces.dom.NodeImpl")
//def s = resourceLookup("org.w3c.dom.NodeList")
//def s = resourceLookup("org.w3c.dom.UserDataHandler")
println s

private String resourceLookup(String lookupResourceName) {
	
		
		try {
	
			if (lookupResourceName == null || lookupResourceName.length()==0) {
				return "";
			}
			// "/java/lang/String.class"
	
			// Check if entered data was in java class name format
			if (lookupResourceName.indexOf("/")==-1) {
				lookupResourceName = lookupResourceName.replaceAll("[.]", "/");
				lookupResourceName =  "/" + lookupResourceName + ".class";
			}
	
			URL url = this.getClass().getResource(lookupResourceName);
			if (url == null) {
				return("Unable to locate resource "+ lookupResourceName);
	
			}
	
			String resourceUrl = url.toExternalForm();
	
			Pattern pattern =
				Pattern.compile("(zip:|jar:file:/)(.*)!/(.*)", Pattern.CASE_INSENSITIVE);
	
			String jarFilename = null;
			String resourceFilename = null;
			Matcher m = pattern.matcher(resourceUrl);
			if (m.find()) {
				jarFilename = m.group(2);
				resourceFilename = m.group(3);
			} else {
				return "Unable to parse URL: "+ resourceUrl;
	
			}
	
			if (!jarFilename.startsWith("C:") ){
			  jarFilename = "/"+jarFilename;  // make absolute path on Linux
			}
	
			File file = new File(jarFilename);
			Long jarSize=null;
			Date jarDate=null;
			Long resourceSize=null;
			Date resourceDate=null;
			if (file.exists() && file.isFile()) {
	
				jarSize = file.length();
				jarDate = new Date(file.lastModified());
	
				try {
					JarFile jarFile = new JarFile(file, false);
					ZipEntry entry = jarFile.getEntry(resourceFilename);
					resourceSize = entry.getSize();
					resourceDate = new Date(entry.getTime());
				} catch (Throwable e) {
					return ("Unable to open JAR" + jarFilename + "   "+resourceUrl +"\n"+e.getMessage());
	
				}
	
			   return "\nresource: "+resourceFilename+"\njar: "+jarFilename + "  \nJarSize: " +jarSize+"  \nJarDate: " +jarDate.toString()+"  \nresourceSize: " +resourceSize+"  \nresourceDate: " +resourceDate.toString()+"\n";
	
	
			} else {
				return("Unable to load jar:" + jarFilename+ "  \nUrl: " +resourceUrl);
	
			}
		} catch (Exception e){
			return e.getMessage();
		}
	
	
	}