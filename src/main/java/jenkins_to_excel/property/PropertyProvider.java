package jenkins_to_excel.property;

import java.util.ResourceBundle;

/*
 * 	Created by Oleksandr_Borkun 3/21/2017 
 */


public class PropertyProvider {

    private static final String CONFIG_PATH = "test";
    private static final ResourceBundle bundle = ResourceBundle.getBundle(CONFIG_PATH);

    public static String getProperty(String propertyName) {
        return bundle.getString(propertyName);
    }
    
}
