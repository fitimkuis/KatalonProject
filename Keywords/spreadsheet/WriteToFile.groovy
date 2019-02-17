package spreadsheet

import org.apache.poi.ss.usermodel.Workbook
import com.kms.katalon.core.annotation.Keyword
import bsh.org.objectweb.asm.Label

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

public class WriteToFile {

	@Keyword
	public void SpreadSheetWrite(){

		try {
			//create .xls and create a worksheet.
			FileOutputStream fos = new FileOutputStream("C:\\Users\\fitim\\Desktop\\data\\data2excel.xls");
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet worksheet = workbook.createSheet("SheetName");

			//Create ROW-1
			HSSFRow row1 = worksheet.createRow((short) 0);

			//Create COL-A from ROW-1 and set data
			HSSFCell cellA1 = row1.createCell((short) 0);
			cellA1.setCellValue("First");
			HSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setFillForegroundColor(HSSFColor.GOLD.index);
			cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			cellA1.setCellStyle(cellStyle);

			//Create COL-B from row-1 and set data
			HSSFCell cellB1 = row1.createCell((short) 1);
			cellB1.setCellValue("Second");
			cellStyle = workbook.createCellStyle();
			cellStyle.setFillForegroundColor(HSSFColor.LIGHT_CORNFLOWER_BLUE.index);
			cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			cellB1.setCellStyle(cellStyle);

			//Create COL-C from row-1 and set data
			HSSFCell cellC1 = row1.createCell((short) 2);
			cellC1.setCellValue(true);

			//Create COL-D from row-1 and set data
			HSSFCell cellD1 = row1.createCell((short) 3);
			cellD1.setCellValue(new Date());
			cellStyle = workbook.createCellStyle();
			cellStyle.setDataFormat(HSSFDataFormat
					.getBuiltinFormat("m/d/yy h:mm"));
			cellD1.setCellStyle(cellStyle);

			//Create COL-E from row-1 and set data
			HSSFCell cellE1 = row1.createCell((short) 4);
			cellE1.setCellValue("some data here with red background");
			cellStyle = workbook.createCellStyle();
			cellStyle.setFillForegroundColor(HSSFColor.RED.index);
			cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			cellE1.setCellStyle(cellStyle);

			//Save the workbook in .xls file
			workbook.write(fos);
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Keyword
	public void writeToExcel(List <String> excel, int rows){

		try {
			//create .xls and create a worksheet.
			FileOutputStream fos = new FileOutputStream("C:\\Users\\fitim\\Desktop\\data\\data2excel2.xls");
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet worksheet = workbook.createSheet("SheetName");
			HSSFRow row;
			HSSFCell cell;
			HSSFCellStyle cellStyle;
			for (int i = 0;i < rows; i++){
				row = worksheet.createRow((short) i);
				for(int y = 0; y < excel.size(); y++){
					cell = row.createCell((short) y);
					cell.setCellValue(excel[y]);
					cellStyle = workbook.createCellStyle();
					cellStyle.setFillForegroundColor(HSSFColor.GOLD.index);
					cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
					cell.setCellStyle(cellStyle);
				}
			}

			/*
			 //Create ROW-1
			 HSSFRow row1 = worksheet.createRow((short) 0);
			 //Create COL-A from ROW-1 and set data
			 HSSFCell cellA1 = row1.createCell((short) 0);
			 cellA1.setCellValue("First");
			 HSSFCellStyle cellStyle = workbook.createCellStyle();
			 cellStyle.setFillForegroundColor(HSSFColor.GOLD.index);
			 cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			 cellA1.setCellStyle(cellStyle);
			 //Create COL-B from row-1 and set data
			 HSSFCell cellB1 = row1.createCell((short) 1);
			 cellB1.setCellValue("Second");
			 cellStyle = workbook.createCellStyle();
			 cellStyle.setFillForegroundColor(HSSFColor.LIGHT_CORNFLOWER_BLUE.index);
			 cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			 cellB1.setCellStyle(cellStyle);
			 //Create COL-C from row-1 and set data
			 HSSFCell cellC1 = row1.createCell((short) 2);
			 cellC1.setCellValue(true);
			 //Create COL-D from row-1 and set data
			 HSSFCell cellD1 = row1.createCell((short) 3);
			 cellD1.setCellValue(new Date());
			 cellStyle = workbook.createCellStyle();
			 cellStyle.setDataFormat(HSSFDataFormat
			 .getBuiltinFormat("m/d/yy h:mm"));
			 cellD1.setCellStyle(cellStyle);
			 //Create COL-E from row-1 and set data
			 HSSFCell cellE1 = row1.createCell((short) 4);
			 cellE1.setCellValue("some data here with red background");
			 cellStyle = workbook.createCellStyle();
			 cellStyle.setFillForegroundColor(HSSFColor.RED.index);
			 cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			 cellE1.setCellStyle(cellStyle);
			 */

			//Save the workbook in .xls file
			workbook.write(fos);
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Keyword
	public void writeToExcelJsonData(List <String> excel, int rows, int count){

		try {
			//create .xls and create a worksheet.
			//File file = new File("C:\\Users\\fitim\\Desktop\\data\\json_data.xls");
			//FileOutputStream fos = null;
			FileOutputStream fos = new FileOutputStream("C:\\Users\\fitim\\Desktop\\data\\json_data.xls", true);
			
			// if file doesn't exists, then create it
			/*if (!file.exists()) {
				file.createNewFile();
			}*/
			
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet worksheet = workbook.createSheet("JsonData");
			HSSFRow row;
			HSSFCell cell;
			HSSFCellStyle cellStyle;
			
			//for(int x = 0; x < count; x++){
				for (int i = 0;i < rows; i++){
				row = worksheet.createRow((short) i);
					for(int y = 0; y < excel.size(); y++){
						cell = row.createCell((short) y);
						cell.setCellValue(excel[y]);
						cellStyle = workbook.createCellStyle();
						cellStyle.setFillForegroundColor(HSSFColor.GOLD.index);
						cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
						cell.setCellStyle(cellStyle);
					}
				}
			//}

			/*
			 //Create ROW-1
			 HSSFRow row1 = worksheet.createRow((short) 0);
			 //Create COL-A from ROW-1 and set data
			 HSSFCell cellA1 = row1.createCell((short) 0);
			 cellA1.setCellValue("First");
			 HSSFCellStyle cellStyle = workbook.createCellStyle();
			 cellStyle.setFillForegroundColor(HSSFColor.GOLD.index);
			 cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			 cellA1.setCellStyle(cellStyle);
			 //Create COL-B from row-1 and set data
			 HSSFCell cellB1 = row1.createCell((short) 1);
			 cellB1.setCellValue("Second");
			 cellStyle = workbook.createCellStyle();
			 cellStyle.setFillForegroundColor(HSSFColor.LIGHT_CORNFLOWER_BLUE.index);
			 cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			 cellB1.setCellStyle(cellStyle);
			 //Create COL-C from row-1 and set data
			 HSSFCell cellC1 = row1.createCell((short) 2);
			 cellC1.setCellValue(true);
			 //Create COL-D from row-1 and set data
			 HSSFCell cellD1 = row1.createCell((short) 3);
			 cellD1.setCellValue(new Date());
			 cellStyle = workbook.createCellStyle();
			 cellStyle.setDataFormat(HSSFDataFormat
			 .getBuiltinFormat("m/d/yy h:mm"));
			 cellD1.setCellStyle(cellStyle);
			 //Create COL-E from row-1 and set data
			 HSSFCell cellE1 = row1.createCell((short) 4);
			 cellE1.setCellValue("some data here with red background");
			 cellStyle = workbook.createCellStyle();
			 cellStyle.setFillForegroundColor(HSSFColor.RED.index);
			 cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			 cellE1.setCellStyle(cellStyle);
			 */

			//Save the workbook in .xls file
			workbook.write(fos);
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

