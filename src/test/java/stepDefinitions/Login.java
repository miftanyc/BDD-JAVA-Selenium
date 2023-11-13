package stepDefinitions;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;
import utils.PropertiesFileReader;

public class Login{

	public WebDriver driver;
	private HomePage homepage;
	private LoginPage loginpage;
	private AccountPage accountpage;
	private Properties testData;
	private DriverFactory driverFactory;
	private CommonUtils commonUtils;
	
	
	@Given("User will be navigated to the login page")
	public void User_will_be_navigated_to_the_login_page() {
		
		driverFactory = new DriverFactory();
		driver = driverFactory.returnDriver();
		
		testData = PropertiesFileReader.testDataPropertiesLoader();
		
		homepage = new HomePage(driver);
		loginpage = new LoginPage(driver);
		accountpage = new AccountPage(driver);
		
		homepage.clickOnMyAccount();
		homepage.clickOnLogin();
		
	}
	
	
	@When("^user will provide a valid Email address (.+) in the Email address field$")
	public void user_provide_Existing_Product_into_search_box_field(String validEmail){
		
		loginpage.provideEmailAddress(validEmail);
	}
	
	@And("^User will provide a valid Password (.+) in the password field$")
	public void User_will_provide_a_valid_Password_in_the_password_field(String validPassword){
		
		loginpage.providePassword(validPassword);
	}

	@And("click on the Login button")
	public void click_on_the_login_button() {
		
		loginpage.clickLoginButton();
	}

	@Then("user will be able to successfully log in to the account page")
	public void user_will_be_able_to_successfully_log_in_to_the_account_page() {
		
		Assert.assertTrue(accountpage.isLoginSuccessfull());
		
	}

	@When("user will provide an invalid Email address in the Email address field")
	public void user_will_provide_an_invalid_email_address_in_the_email_address_field() {
		commonUtils = new CommonUtils();
		loginpage.provideEmailAddress(commonUtils.generateEmailAddress());
	}

	@And("User will provide an invalid Password {string} in the password field")
	public void user_will_provide_an_invalid_password_in_the_password_field(String invalidPassword) {
		
		loginpage.providePassword(invalidPassword);
	}

	@Then("user will not be able to log in and get a proper warning message about credential mismatch")
	public void user_will_not_be_able_to_log_in_and_get_a_proper_warning_message_about_credential_mismatch() {
	   
		Assert.assertEquals(testData.getProperty("noMatchEmailWarning"), loginpage.getNoMatchWarningMessage());
	}


	@When("user will leave the Email address field blank")
	public void user_will_leave_the_email_address_field_blank() {
		
		//Intentionally Kept Blank
	}

	@When("User will leave the Password field blank")
	public void user_will_leave_the_password_field_blank() {
		
		//Intentionally Kept Blank
	}



}