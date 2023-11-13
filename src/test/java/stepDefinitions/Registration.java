package stepDefinitions;

import java.util.Map;
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
import pages.RegistrationPage;
import utils.CommonUtils;
import utils.PropertiesFileReader;

public class Registration{

	public WebDriver driver;
	private DriverFactory driverFactory;
	private CommonUtils commonUtils;
	private HomePage homepage;
	private RegistrationPage regpage;
	private AccountPage accountpage;
	private Properties config;
	private Properties testData;

	
	@Given("user has landed to registraion page")
	public void user_has_landed_to_registraion_page() {
		driverFactory = new DriverFactory();
		commonUtils = new CommonUtils();
		driver = driverFactory.returnDriver();
		
		config = PropertiesFileReader.configPropertiesLoader();
		testData = PropertiesFileReader.testDataPropertiesLoader();
		
		homepage = new HomePage(driver);
		regpage = new RegistrationPage(driver);
		accountpage = new AccountPage(driver);
		
		homepage.clickOnMyAccount();
		homepage.clickonRegistration();
		
	}

	@When("User will provide following details in the required field")
	public void user_will_provide_following_details_in_the_required_field(io.cucumber.datatable.DataTable dataTable) {
		
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		
		String emailValue = dataMap.get("email");	
		String testingProvidedEmailAddress = null;
		if(emailValue.equalsIgnoreCase("Generated_Email")) {
			testingProvidedEmailAddress = emailValue.replace("Generated_Email", commonUtils.generateEmailAddress());
		}else if(emailValue.equalsIgnoreCase("valid_Email")) {
			testingProvidedEmailAddress = emailValue.replace("valid_Email", config.getProperty("validEmail"));
		}
		
		regpage.firstNameTextBox(dataMap.get("firstName"));
		regpage.lastNameTextBox(dataMap.get("lastName"));
		regpage.emailTextBox(testingProvidedEmailAddress);
		regpage.telephoneTextBox(dataMap.get("telephone"));
		regpage.passwrodTextBox(dataMap.get("password"));
		regpage.passwordConfirmTextBox(dataMap.get("Confirm pasword"));	
	}

	@And("user will click policy check box")
	public void user_will_click_policy_check_box() {
		
		regpage.policyCheckBox();
	}

	@And("user will click continue button")
	public void user_will_click_continue_button() {
	    
		regpage.registrationOption();
	}

	@Then("user will be resgistered as new user showing Account success message")
	public void user_will_be_resgistered_as_new_user_showing_account_success_message() {
		
		String accountSuccess = accountpage.accountCreatedSuccessfullyMessage();
		Assert.assertEquals(testData.getProperty("accountCreatedSuccessfullyMessage") , accountSuccess);
		
	}

	@And("user will click yes for newslatter check box")
	public void user_will_click_yes_for_newslatter_check_box() {
		
		regpage.selectNewsLatterRadioButton();
	}

	@Then("user will get a proper warnign about duplicate email")
	public void user_will_get_a_proper_warnign_about_duplicate_email() {
		
		String alreadyRegisteredEmail= regpage.alreadyRegisteredEmailWarningMessage();
		Assert.assertEquals(testData.getProperty("alreadyRegisteredEmailWarning") , alreadyRegisteredEmail);
		
	}

	@When("User dont enter any details into field")
	public void user_dont_enter_any_details_into_field() {
	   
		//Intentionally Kept Blank
	}

	@Then("user will get a proper warnign about every mandatory field")
	public void user_will_get_a_proper_warnign_about_every_mandatory_field() {

		String warningPrivacyPolicy 	= regpage.privacyPolicyWarningMessage();
		Assert.assertEquals(testData.getProperty("privacyPolicyWarning"), warningPrivacyPolicy);
		String warningFirstName 		= regpage.firstNameWarningMessage();
		Assert.assertEquals(testData.getProperty("firstNameWarning"), warningFirstName);
		String warningLastName 		= regpage.lastNameWarningMessage();
		Assert.assertEquals(testData.getProperty("lastNameWarning"), warningLastName);
		String warningEmail 			= regpage.emailWarningMessage();
		Assert.assertEquals(testData.getProperty("emailWarning"), warningEmail);
		String warningPhone			= regpage.phoneWarningMessage();
		Assert.assertEquals(testData.getProperty("phoneWarning"), warningPhone);
		String warningPassword 		= regpage.passwordWarningMessage();
		Assert.assertEquals(testData.getProperty("passwordWarning"), warningPassword);
	  
	}

}
