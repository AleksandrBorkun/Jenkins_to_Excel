package jenkins_to_excel.utils;

import java.io.File;
import java.io.IOException;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	File dest = new File("src\\main\\resources\\excelReport3.xls");
	File from = new File("src\\main\\resources\\excelReport2.xls");
	
	try {
		FileCopyPast.copy(from, dest);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
