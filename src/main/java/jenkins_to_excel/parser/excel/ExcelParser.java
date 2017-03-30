package jenkins_to_excel.parser.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import jenkins_to_excel.entity.ErrorLog;

/*
 * 
 *	Creating_by
 * 
 *  Oleksandr_Borkun on 3/16/2017
 * 
 * 
 */
public class ExcelParser {


	private HSSFWorkbook workBook = new HSSFWorkbook();
	private HSSFSheet sheet;
	private HSSFRow row;
	
	
	public void writeExcel(List<ErrorLog> list, String testSuiteName){
		 	this.sheet = workBook.createSheet(testSuiteName);
			createRow(0);
			addTwoValueInExcel(testSuiteName, Integer.toString(list.get(0).getValueOfFallingTest()));
			
		for(int i = 0; i < list.size(); i++){
			createRow(i+1);
			addTwoValueInExcel(list.get(i).getTestCaseName(), list.get(i).getErrorMsg());			
		}
		
		writeDataToFile();
		
		try {
			workBook.close();
		} catch (IOException e) {							//need to create method
			System.out.println("is no open book");
		}
	
		
	}
	
	private File createFile(){
		
		return new File("src\\main\\resources\\excelReport2.xls");
	}
	
	private void writeDataToFile(){
		
		try {
			
			FileOutputStream writer = new FileOutputStream("src\\main\\resources\\excelReport2.xls", true);
			workBook.write(writer);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	private HSSFRow getRow(){
		return row;
	}
	
	private void createRow(int num){	
		row = sheet.createRow(num);	
	}
	
	private HSSFCell createFirstCell(){
		return getRow().createCell(1);	
	}	
	private HSSFCell createSecondCell(){
		return getRow().createCell(2);		
	}
	

	private void addTwoValueInExcel(String key, String value){		
		createFirstCell().setCellValue(key);
		createSecondCell().setCellValue(value);				
	}
	
}
