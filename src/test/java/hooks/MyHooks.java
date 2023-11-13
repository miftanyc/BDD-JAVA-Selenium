package hooks;

import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.PropertiesFileReader;

public class MyHooks {

	WebDriver driver;
	
	
	@Before
	public void setUp() {
		DriverFactory driverFactory = new DriverFactory();
		Properties config = PropertiesFileReader.configPropertiesLoader();
		driverFactory.initializeBrowserAndNavigateToPage(config.getProperty("browserName"));
		driver = driverFactory.returnDriver();
		
	}
	
	
	@After
	public void tearDown(Scenario scenario) {
		
		if(scenario.isFailed()) {
			String scenarioName = scenario.getName().replace(" ", "_");
			byte[] srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenshot, "image/png", scenarioName);
		}
		
		driver.quit();
	}
		
	
	public String generateEmailAddress() {
		Date date = new Date();
		String datePart = date.toString().replace(" ", "_").replace(":", "_");
		String generatedEmail = "miftanyc+qa"+datePart+"@gmail.com";
		return generatedEmail;
	}
	
	
}
