package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {

		
	WebDriver driver;
	private ElementUtils elementUtils;
	
	
	//Constructor
	public HomePage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

		
		
	//Object
	@FindBy(xpath= "//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	
	
	//Action
	public void clickOnMyAccount() {	
		elementUtils.clickOnFunction(myAccountDropMenu, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public void clickOnLogin() {		
		elementUtils.clickOnFunction(loginOption, CommonUtils.EXPLICIT_WAIT_TIME);			
	}
	
	public void clickonRegistration() {		
		elementUtils.clickOnFunction(registerOption, CommonUtils.EXPLICIT_WAIT_TIME);		
	}
}
