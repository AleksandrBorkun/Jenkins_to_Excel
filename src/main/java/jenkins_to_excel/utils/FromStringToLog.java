package jenkins_to_excel.utils;

import java.util.List;

import org.openqa.selenium.WebElement;
import jenkins_to_excel.entity.ErrorList;
import jenkins_to_excel.entity.ErrorLog;

public class FromStringToLog {

	/*
	 * 
	 * Creating_by
	 * 
	 * Oleksandr_Borkun on 3/16/2017
	 * 
	 * 
	 */

	private ErrorLog errorLog;
	private String log;
	private String testName;
	private String error;

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public void prepareForWriting(List<WebElement> webElementsWithErrorLog) {

		/// Here must be a code of getting testCaseName and errorMsg from a log

		for (int i = 0; i < webElementsWithErrorLog.size(); i++) {

			log = webElementsWithErrorLog.get(i).getText();

			if (!log.contains("DSL") && log.length() > 3 && !log.contains("SetUp")) {

				testName = log.substring(log.indexOf(log.substring(0, 3)), log.indexOf('\n'));
				error = log.substring(log.indexOf("Details") + 8, log.indexOf("Stack Trace") - 2);
				setErrorLog(testName, error);

			} else {
				continue;
			}
		}

	}

	private void setErrorLog(String testCaseName, String errorMsg) {

		errorLog = new ErrorLog();

		errorLog.setErrorMsg(errorMsg);
		errorLog.setTestCaseName(testCaseName);

		ErrorList.addErrorToList(errorLog);

	}
}
