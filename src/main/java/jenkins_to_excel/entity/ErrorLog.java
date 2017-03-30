package jenkins_to_excel.entity;

public class ErrorLog {
	
	/*
	 * Created by Oleksandr Borkun 3/16/2017
	 */
	
	private String testCaseName;
	private String errorMsg;
	private String testSuiteName;
	private int valueOfFallingTest;
	
	public int getValueOfFallingTest() {
		return valueOfFallingTest;
	}
	public void setValueOfFallingTest(int valueOfFallingTest) {
		this.valueOfFallingTest = valueOfFallingTest;
	}
	public String getTestSuiteName() {
		return testSuiteName;
	}
	public void setTestSuiteName(String testSuiteName) {
		this.testSuiteName = testSuiteName;
	}
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
