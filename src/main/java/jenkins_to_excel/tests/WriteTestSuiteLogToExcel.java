package jenkins_to_excel.tests;

import org.testng.annotations.Test;

public class WriteTestSuiteLogToExcel extends BaseTest{

	/*
	 * 	Created by Oleksandr_Borkun 3/21/2017 
	 */


	@Test
	public void writeToExcelTest(){
		baseStep.goToTestSuitePage().writeRusultToExcel();
		
	}

}
