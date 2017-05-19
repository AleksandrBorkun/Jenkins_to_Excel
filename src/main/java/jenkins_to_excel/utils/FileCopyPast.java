package jenkins_to_excel.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/*
 * 	Created by Oleksandr_Borkun 3/21/2017 
 */


public class FileCopyPast {
	//1 2 2 1 1 2 
	   public static void copy(File source, File dest) throws IOException {
	        FileUtils.copyFile(source, dest);
	    }
}
