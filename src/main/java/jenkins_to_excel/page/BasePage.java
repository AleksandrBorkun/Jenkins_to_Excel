package jenkins_to_excel.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import jenkins_to_excel.driver.FactoryDriver;
import jenkins_to_excel.utils.ExplicitWait;
import jenkins_to_excel.utils.FromStringToLog;
import jenkins_to_excel.utils.JS_Executor;

/*
 * 	Created by Oleksandr_Borkun 3/21/2017 
 */


public class BasePage {

	private final String name = "Flintstones_Attendance_FAPControl_develop_soapui"; // to property or excel file
	
	@FindBy(xpath = "//a[contains(. , '" + name + "')]")
	private WebElement testSuiteName;
	
	@FindBy(xpath = "//a[contains(. , 'Test Result')]")
	private WebElement testSuiteResultButton;
	
	protected JS_Executor jsExecutor;
	protected ExplicitWait wait;
	protected WebDriver driver;
	protected FromStringToLog webElementConverter;
	
	public BasePage() {
		
		 driver = FactoryDriver.getInstance();
		 PageFactory.initElements(driver,this);
		 wait = new ExplicitWait(driver);
		 jsExecutor = new JS_Executor(driver);
		 webElementConverter = new FromStringToLog();
	}

	public void goToTestSuitePage(){
		
		wait.waitForElementIsClickable(testSuiteName);
		testSuiteName.click();
		wait.waitForElementIsClickable(testSuiteResultButton);
		testSuiteResultButton.click();
	}
	
	
}
