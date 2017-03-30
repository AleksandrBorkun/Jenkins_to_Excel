package jenkins_to_excel.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import jenkins_to_excel.driver.FactoryDriver;
import jenkins_to_excel.property.PropertyProvider;
import jenkins_to_excel.steps.BaseStep;

/*
 * 	Created by Oleksandr_Borkun 3/21/2017 
 */

public abstract class BaseTest {

	protected WebDriver driver;
	protected BaseStep baseStep;

	@BeforeClass
	public void getJobsName() {
		this.driver = FactoryDriver.getInstance();
		driver.get(PropertyProvider.getProperty("BASE_URL"));
		this.baseStep = new BaseStep(driver);
		baseStep.getJobsName();
	}

	@BeforeMethod
	public void setUp() {
		this.driver = FactoryDriver.getInstance();
		driver.get(PropertyProvider.getProperty("BASE_URL"));
		this.baseStep = new BaseStep(driver);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		FactoryDriver.closeDriver();

	}

}
