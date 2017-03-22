package jenkins_to_excel.utils;

import java.util.List;

import jenkins_to_excel.entity.ErrorList;
import jenkins_to_excel.entity.ErrorLog;

public class FromStringToLog {

/*
 * 
 *	Creating_by
 * 
 *  Oleksandr_Borkun on 3/16/2017
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

	public List<ErrorLog> prepareForWriting(){
		
///Here must be a code of getting testCaseName and errorMsg from a log
		
		for(int i=0;i<10;i++){
			setErrorLog("Testing "+i , "Error Code: 10010"+i);
		}
		
		
		return ErrorList.getErrorList();
	}
	
	private void setErrorLog(String testCaseName, String errorMsg){
	
		errorLog = new ErrorLog();
		
		errorLog.setErrorMsg(errorMsg);
		errorLog.setTestCaseName(testCaseName);
		
		ErrorList.addErrorToList(errorLog);
		
	}
}
