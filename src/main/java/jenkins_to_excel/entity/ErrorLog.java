package jenkins_to_excel.entity;

public class ErrorLog {
	
	/*
	 * Created by Oleksandr Borkun 3/16/2017
	 */
	
	private String testCaseName;
	private String errorMsg;

	public String getTestCaseName() {
		return testCaseName;
	}
	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
	
}
