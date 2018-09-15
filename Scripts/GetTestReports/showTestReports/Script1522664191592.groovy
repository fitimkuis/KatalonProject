import java.nio.file.Paths

//Thread.sleep(20000)
String fileName = CustomKeywords.'readGmail.getGmail.getGmailAttachment'()
println("**************DEBUG returned filename *************** "+fileName)
CustomKeywords.'readGmail.unZip.unzipFile'(fileName)
String zip = fileName.substring(0, 29);
println("*********DEBUG zipfile*******"+zip)
String path = Paths.get(".").toAbsolutePath().normalize().toString();
path = path.replace("\\", "/");
String url = path+"/extractedFiles/"+zip+"/Report.html"
println("*********DEBUG url*******"+url)
//String url = path+"/extractedFiles/"+zip+"/Report.html"
CustomKeywords.'readGmail.openWebHtml.openHtmlPage'(url)

