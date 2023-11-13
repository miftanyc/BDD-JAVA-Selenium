package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class AccountPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	
	//Constructor
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
		
	
	
	//Object
	
	@FindBy(linkText="Edit your account information")
	private WebElement editYourAccountInformationHyperlink;
	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement accountCreatedSuccessfullyMessage;
	
	
	
	//Actions	
	public boolean isLoginSuccessfull() {	
		boolean loginSuccess = elementUtils.displayStatusOfElement(editYourAccountInformationHyperlink,CommonUtils.EXPLICIT_WAIT_TIME);
		return loginSuccess;
	}
	
	public String accountCreatedSuccessfullyMessage() {	
		String successMessage = elementUtils.getTextFunction(accountCreatedSuccessfullyMessage, CommonUtils.EXPLICIT_WAIT_TIME);
		return successMessage;
	}
}
