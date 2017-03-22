package jenkins_to_excel.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import jenkins_to_excel.property.PropertyProvider;
import java.util.concurrent.TimeUnit;

/*
 * Created by Oleksandr Borkun 3/21/2017
 */
public class FactoryDriver {

	private static final Logger log = LogManager.getRootLogger();
	private static WebDriver driver;

	private FactoryDriver() {
	}

	private static WebDriver getActualDriver() {
		DriverType type = DriverType.valueOf(PropertyProvider.getProperty("DriverType"));
		switch (type) {
		case CHROME:
			driver = createChromeDriver();
			log.info("chrome driver created");
			break;
		case FIREFOX:
			driver = createFirefoxDriver();
			log.info("firefox driver created");
			break;
		default:
			driver = createFirefoxDriver();
			log.info("firefox driver created");
		}
		int impWait = 20; //
		int pageWait = 20; // replace this value in to the property file
		int scriptWait = 20; //
		driver.manage().timeouts().implicitlyWait(impWait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(pageWait, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(scriptWait, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public static WebDriver getInstance() {
		if (driver == null) {
			getActualDriver();
		}
		return driver;
	}

	public static void closeDriver() {
		driver.quit();
		driver = null;
		log.info("driver has been closed");
	}

	private static WebDriver createFirefoxDriver() {
		System.setProperty(PropertyProvider.getProperty("WEBDRIVER_GECKO_DRIVER"),
				PropertyProvider.getProperty("GECKODRIVER_EXE_PATH"));
		return new FirefoxDriver();
	}

	private static WebDriver createChromeDriver() {
		System.setProperty(PropertyProvider.getProperty("WEBDRIVER_CHROME_DRIVER"),
				PropertyProvider.getProperty("CHROMEDRIVER_EXE_PATH"));
		return new ChromeDriver();
	}
}
