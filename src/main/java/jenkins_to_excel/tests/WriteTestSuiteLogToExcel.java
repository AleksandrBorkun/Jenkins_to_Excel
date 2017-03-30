package jenkins_to_excel.tests;

import org.testng.annotations.Test;

import jenkins_to_excel.tests.dataProvider.DataProvederForWritingLog;

public class WriteTestSuiteLogToExcel extends BaseTest{

	/*
	 * 	Created by Oleksandr_Borkun 3/21/2017 
	 */


	@Test(dataProviderClass = DataProvederForWritingLog.class, dataProvider = "logToExcel")
	public void writeToExcelTest(String jobName){
		baseStep.goToTestSuitePage(jobName).writeRusultToExcel();
		
	}

}
