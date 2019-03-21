import java.nio.file.Paths

String fileName = CustomKeywords.'readGmail.getGmail.getGmailAttachment'()
println("**************DEBUG returned filename *************** "+fileName)
CustomKeywords.'readGmail.unZip.unzipFile'(fileName)
String zip = fileName.substring(0, 29);
println("*********DEBUG zipfile*******"+zip)
String path = Paths.get(".").toAbsolutePath().normalize().toString();
path = path.replace("\\", "/");
spam1 = zip.substring(0,8)
spam2 = zip.substring(9,15)
completeUrl = spam1+"_"+spam2
println completeUrl
String url = path+"/extractedFiles/"+zip+"/"+completeUrl+".html"
CustomKeywords.'readGmail.openWebHtml.openHtmlPage'(url)

