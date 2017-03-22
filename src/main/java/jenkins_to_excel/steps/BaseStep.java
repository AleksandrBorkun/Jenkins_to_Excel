package jenkins_to_excel.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import jenkins_to_excel.page.BasePage;
import jenkins_to_excel.page.TestSuiteLogPage;

public class BaseStep {

	/*
	 * Created by Oleksandr Borkun 3/21/2017
	 * 
	 */
	static final Logger log = LogManager.getRootLogger();
	final WebDriver driver;
	private BasePage basePage;
	private String name = "Flintstones_Attendance_FAPControl_develop_soapui"; // to property or excel
	TestSuiteLogPage testsuitePage;
	
	public BaseStep(WebDriver driver){
		this.driver = driver;
		basePage = new BasePage();
		testsuitePage = new TestSuiteLogPage();
	}
	
	public void goToTestSuitePage(){			//move to new step class
		
		log.info("open TestSuiteName page ("+name+")");
		basePage.goToTestSuitePage();
		
		log.info("try to click all pluses");
		testsuitePage.getValueFromTables();
	}
	
}
