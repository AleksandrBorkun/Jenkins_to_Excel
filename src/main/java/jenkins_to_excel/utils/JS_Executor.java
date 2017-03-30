package jenkins_to_excel.utils;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JS_Executor {

	private WebDriver driver;
	private JavascriptExecutor executor;

	public JS_Executor(WebDriver driver) {
		this.driver = driver;
		executor = (JavascriptExecutor) driver;
	}

	public void clickForSubElement(List<WebElement> webElementsList) {

		for (WebElement tmp : webElementsList) {
			executor.executeScript("arguments[0].click();", tmp);
		}
	}
}