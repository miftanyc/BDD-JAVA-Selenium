package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;


public class LoginPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	
	//Constructor 
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	
	
	//Object
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailInputField;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement passwordInputField;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[contains(@class, 'alert-dismissible')]")
	private WebElement noMathForEmailAddressAndOrPassword;
	
	
	
	//Actions
	public void provideEmailAddress(String emailText) {		
		elementUtils.sendKeyFunction(emailText, emailInputField, CommonUtils.EXPLICIT_WAIT_TIME);		
	}
	
	public void providePassword(String passwordText) {		
		elementUtils.sendKeyFunction(passwordText, passwordInputField, CommonUtils.EXPLICIT_WAIT_TIME);		
	}
	
	public void clickLoginButton() {	
		elementUtils.clickOnFunction(loginButton, CommonUtils.EXPLICIT_WAIT_TIME);		
	}
	
	public String getNoMatchWarningMessage() {		
		String noMatch = elementUtils.getTextFunction(noMathForEmailAddressAndOrPassword, CommonUtils.EXPLICIT_WAIT_TIME);
		return noMatch;
	}
	
}
