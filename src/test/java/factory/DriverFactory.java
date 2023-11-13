package factory;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.CommonUtils;
import utils.PropertiesFileReader;

public class DriverFactory {

	static WebDriver driver;
	
	public void initializeBrowserAndNavigateToPage(String browserName) {
		Properties config = PropertiesFileReader.configPropertiesLoader();
		if(browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
		driver.get(config.getProperty("url"));
		
	}
	
	public WebDriver returnDriver() {
		return driver;
	}
}
