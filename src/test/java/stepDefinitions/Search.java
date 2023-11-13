package stepDefinitions;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchPage;
import utils.PropertiesFileReader;

public class Search{

	public WebDriver driver;
	private DriverFactory driverFactory;
	private Properties testData;
	private SearchPage searchpage;
	
	
	@Given("User landed the search page")
	public void user_landed_the_search_page() {
		
		//in Home page user will provide the product search option
		driverFactory = new DriverFactory();
		driver = driverFactory.returnDriver();
		
		testData = PropertiesFileReader.testDataPropertiesLoader();
		
		searchpage = new SearchPage(driver);
		
	}
	
	
	@When("User provide {string} Product into search box field")
	public void user_provide_Product_into_search_box_field(String prductname) {
		String searchProduct = null;
		if (prductname.equalsIgnoreCase("Existing")) {
			searchProduct = prductname.replace("Existing", testData.getProperty("exitingProduct"));
		}else if(prductname.equalsIgnoreCase("Non Existing")) {
			searchProduct = prductname.replace("Non Existing", testData.getProperty("nonExistingProduct"));
		}
		
		searchpage.typeProductInSearchBox(searchProduct);
	}
	
	@And("User clicks on search button")
	public void user_clicks_on_search_button() {
		
		searchpage.clickSearchButton();
	}
	
	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		
		Assert.assertTrue(searchpage.isProductDisplayed());
		
	}
	
	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		
		String noMatchProduct = searchpage.noMatchProductMessage();
		Assert.assertEquals(testData.getProperty("noProductMatchMessage"), noMatchProduct);
	}
	
	@When("User dont enter any product name into search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {
	    
		//Intentionally Kept Blank
	}

}
