package jenkins_to_excel.page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
/*
 * 	Created by Oleksandr_Borkun 3/21/2017 
 */


public class TestSuiteLogPage extends BasePage {

	@FindBys(@FindBy(xpath = "//table/following::node()/tr//td[@class='pane']"))
	private List<WebElement> tableRows;

	@FindBys(@FindBy(xpath = "//table/following::node()/img[@class = 'icon-document-add icon-sm']"))
	List<WebElement> plusButtonsList;

	public void getValueFromTables() {

		jsExecutor.clickForSubElement(plusButtonsList); // all pluses click
		wait.magicWaiter(); // wait while loading indicator disappearing

		webElementConverter.prepareForWriting(tableRows); // add information about every failed case to list

	}

}
