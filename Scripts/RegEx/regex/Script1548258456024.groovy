
import java.sql.Timestamp
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


Map<String,String> queryParameters(String urlString) {
	URL url = new URL(urlString)
	// get all query params as list
	def queryParams = url.query?.split('&') // safe operator for urls without query params
	// transform the params list to a Map spliting
	// each query param
	if (queryParams != null) {
		return queryParams.collectEntries { param -> param.split('=').collect { URLDecoder.decode(it,'UTF-8') }}
	} else {
		return [:]
	}
}

String queryParameter(String urlString, String name) {
	def mapParams = queryParameters(urlString)
	return mapParams[name]
}

String line = "2013-10-27T13:00:00.325234Z";
DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss.SSSSSS'Z'");
LocalDateTime time = LocalDateTime.parse(line, dateFormat);
Timestamp ts = Timestamp.valueOf(time);
System.out.println(ts);

/*String s = "2017-12-29-05.04.18.104071";
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");//Yes, it works without .SSSSSS
Timestamp ts = new Timestamp(sdf.parse(s).getTime());
//ts.setNanos(Integer.valueOf(s.substring(20)) * 1000);
System.out.println(ts.toString());*/

String input = 'http://somewebsite.com/path?nonce=17&cmac=2e1224422baa44134e87cdff2303d417'
String nonce = queryParameter(input,'nonce')
String cmac  = queryParameter(input,'cmac')

println "queryParameters is ${queryParameters(input)}"
println "nonce is ${nonce}"
println "cmac is ${cmac}"

WebUI.verifyMatch(nonce, '[0-9]*\\d', true)
WebUI.verifyMatch(cmac , '[a-f0-9]{32}', true)
