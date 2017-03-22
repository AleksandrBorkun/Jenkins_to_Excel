package jenkins_to_excel.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;



/*
 * 	Created by Oleksandr_Borkun 3/21/2017 
 */

public class ExplicitWait {

	 private final WebDriver driverWait;
	    private final Wait<WebDriver> wait;

	    public ExplicitWait(WebDriver driver) {
	        this.driverWait = driver;
	        wait = new WebDriverWait(this.driverWait, 5).ignoring(StaleElementReferenceException.class, WebDriverException.class)
	                .withMessage("Element was not found by locator ");
	    }

	    public ExplicitWait(WebDriver driver, int time) {
	        this.driverWait = driver;
	        wait = new WebDriverWait(driver, time).ignoring(StaleElementReferenceException.class, WebDriverException.class)
	                .withMessage("Element was not found by locator ");
	    }

	    public void waitForElementDisappearing(By by) {
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	    }

	    public void waitForElementIsClickable(WebElement element) {
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	    }

	    public void waitForElementAppearing(WebElement element){
	        wait.until(ExpectedConditions.visibilityOf(element));
	    }

	    public void waitForElementsAppearing(List<WebElement> elementList){
	        new WebDriverWait(driverWait, 5).until(ExpectedConditions.visibilityOfAllElements(elementList));
	    }


	    public void magicWaiter(){
	        try {
	            Thread.sleep(500);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	
	
}
