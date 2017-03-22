package jenkins_to_excel.entity;

import java.util.ArrayList;
import java.util.List;
/*
 * Created by Oleksandr Borkun 3/16/2017
 */
public class ErrorList {

	public static List<ErrorLog> errorList = new ArrayList();
	
	public static void addErrorToList(ErrorLog error){
		errorList.add(error);
	}
	
	
	public static List<ErrorLog> getErrorList(){
		return errorList;
	}
	
	
}
