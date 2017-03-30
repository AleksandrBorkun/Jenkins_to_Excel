package jenkins_to_excel.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import jenkins_to_excel.driver.FactoryDriver;
import jenkins_to_excel.entity.ErrorList;
import jenkins_to_excel.entity.ErrorLog;
import jenkins_to_excel.tests.dataProvider.DataProvederForWritingLog;
import jenkins_to_excel.utils.ExplicitWait;
import jenkins_to_excel.utils.FromStringToLog;
import jenkins_to_excel.utils.JS_Executor;

/*
 * 	Created by Oleksandr_Borkun 3/21/2017 
 */


public class BasePage {


    @FindBys(@FindBy (xpath = "//tr/td/a[contains(. , 'Flintstones')]")) //(xpath = "//table[@id='projectstatus']/child::node()/tr[@class=' job-status-red' or class=' job-status-green']/td/a"))
    public List<WebElement>allRunJobName;

	@FindBy(xpath = "//a[contains(. , 'Test Result')]")
	private WebElement testSuiteResultButton;
	
	@FindBy(xpath = "//tr[3]/td[@style='vertical-align:middle']")
	private WebElement sizeOfFallingTest;
	
	@FindBy(xpath = "//tr[@class = 'build-row  single-line overflow-checked'][1]/td/div[2]/a")
	private WebElement lastJobButton;
	
	WebElement currentJobName;
	
	protected JS_Executor jsExecutor;
	protected ExplicitWait wait;
	protected WebDriver driver;
	protected FromStringToLog webElementConverter;
	private ErrorLog errorLog;
	
	public BasePage() {
		
		 driver = FactoryDriver.getInstance();
		 PageFactory.initElements(driver,this);
		 wait = new ExplicitWait(driver);
		 jsExecutor = new JS_Executor(driver);
		 webElementConverter = new FromStringToLog();
	}
	

	public boolean goToTestSuitePage(String jobName){
		
		currentJobName = driver.findElement(By.partialLinkText(jobName)); //find Element From DataProvider
		wait.waitForElementIsClickable(currentJobName);
		
		currentJobName.click();
			
		
		if(sizeOfFallingTest.getText().contains("(no failures)") || sizeOfFallingTest.getText().contains("(no tests)")){
			createErrorLog(jobName); // prepare log for parser
			return false;
		}
		
		wait.waitForElementIsClickable(testSuiteResultButton);
		testSuiteResultButton.click();
		return true;
	}
	
	public void getJobsName(){
		wait.waitForElementsAppearing(allRunJobName);
		for(int i = 0; i<allRunJobName.size(); i++){
			DataProvederForWritingLog.jobsName.add(allRunJobName.get(i).getText());
		}
	}
	
	private void createErrorLog(String jobName){
		errorLog = new ErrorLog();
		errorLog.setTestSuiteName(jobName);
		errorLog.setValueOfFallingTest(0);
		ErrorList.addErrorToList(errorLog);
	}
	
	public void openLastJob(){
		
	//	wait.waitForElementIsClickable(lastJobButton);
		lastJobButton.click();
		
	}
	
	
}
