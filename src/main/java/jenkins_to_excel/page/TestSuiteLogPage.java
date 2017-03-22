package jenkins_to_excel.page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
/*
 * 	Created by Oleksandr_Borkun 3/21/2017 
 */


public class TestSuiteLogPage extends BasePage{
	
	@FindBys(@FindBy(xpath = "//table[@class = 'pane sortable bigtable']"))
	private List<WebElement> tablesWithResult;

	@FindBys(@FindBy(xpath = "//table/following::node()/img[@class = 'icon-document-add icon-sm']"))
	List <WebElement> img;
	
	public void getValueFromTables(){
		
		for(WebElement plus: img){
			wait.magicWaiter();
			wait.waitForElementAppearing(plus);
			wait.waitForElementIsClickable(plus);
			plus.click();
			
			
			/*
			 * 
			 * some code here 
			 * 
			 */
		}
				
	}
	
}
