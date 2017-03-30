package jenkins_to_excel.tests.dataProvider;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

public class DataProvederForWritingLog {

	/*
	 * Created by Oleksandr_Borkun on 3/22/207
	 * 
	 */
	public static List<String> jobsName = new ArrayList();

	@DataProvider(name = "logToExcel")
	public Object[][] logToExcel() {

		Object[][] obj = new Object[3][1];

		for (int i = 0; i < 3; i++) {
			obj[i][0] = jobsName.get(i);
		}

		return obj;

	}
}
