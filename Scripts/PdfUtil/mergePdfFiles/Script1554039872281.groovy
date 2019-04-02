import com.kms.katalon.core.configuration.RunConfiguration



//get pdf dir
def pdfDir = RunConfiguration.getProjectDir() + "/pdfFiles/"

try {
	//Prepare input pdf file list as list of input stream.
	List<InputStream> inputPdfList = new ArrayList<InputStream>();
	inputPdfList.add(new FileInputStream(pdfDir+"file1.pdf"));
	inputPdfList.add(new FileInputStream(pdfDir+"file2.pdf"));
	//inputPdfList.add(new FileInputStream("..\\pdf\\pdf_2.pdf"));
	//inputPdfList.add(new FileInputStream("..\\pdf\\pdf_3.pdf"));
	//inputPdfList.add(new FileInputStream("..\\pdf\\pdf_4.pdf"));


	//Prepare output stream for merged pdf file.
	OutputStream outputStream = new FileOutputStream(pdfDir+"MergeFile_12.pdf");

	//call method to merge pdf files.
	CustomKeywords.'com.pdf.util.MergePdfFiles.mergePdfFiles'(inputPdfList, outputStream);
} catch (Exception e) {
	e.printStackTrace();
}
