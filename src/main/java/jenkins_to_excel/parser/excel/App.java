package jenkins_to_excel.parser.excel;

import jenkins_to_excel.entity.ErrorList;
import jenkins_to_excel.utils.FromStringToLog;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExcelParser parser = new ExcelParser();
		FromStringToLog flg = new FromStringToLog();
		flg.prepareForWriting();
		
		parser.writeExcel(ErrorList.getErrorList());
		
	}

}
