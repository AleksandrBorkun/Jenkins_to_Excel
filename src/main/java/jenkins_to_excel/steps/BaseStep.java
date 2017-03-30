package jenkins_to_excel.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import jenkins_to_excel.entity.ErrorList;
import jenkins_to_excel.page.BasePage;
import jenkins_to_excel.page.TestSuiteLogPage;
import jenkins_to_excel.parser.excel.ExcelParser;

public class BaseStep {

	/*
	 * Created by Oleksandr Borkun 3/21/2017
	 * 
	 */
	static final Logger log = LogManager.getRootLogger();
	final WebDriver driver;
	private BasePage basePage;
	private String name; 														// to
																				// property
																				// or
																				// excel
	TestSuiteLogPage testsuitePage;
	ExcelParser parser;
	boolean isFalliedTestsAppearing;

	public BaseStep(WebDriver driver) {
		this.driver = driver;
		basePage = new BasePage();
		testsuitePage = new TestSuiteLogPage();
		parser = new ExcelParser();
	}

	public void openLastJob(){
		log.info("Open Last Job");
		basePage.openLastJob();
		
	}
	
	public void getJobsName() {
		log.info("Get Jobs Name for Data Provider");
		basePage.getJobsName();
	}

	public BaseStep goToTestSuitePage(String jobName) { // move to new step
		this.name = jobName;												// class

		log.info("open TestSuiteName page " + jobName);
		isFalliedTestsAppearing = basePage.goToTestSuitePage(jobName);

		if (isFalliedTestsAppearing) {
			log.info("try to click all pluses");
			testsuitePage.getValueFromTables();
		} else {
			return this;
		}
		return this;
	}

	public void writeRusultToExcel() {

		parser.writeExcel(ErrorList.getErrorList(), name);

	}

}
