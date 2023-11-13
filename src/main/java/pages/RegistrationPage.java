package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegistrationPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	
	//Constructor
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
			
	
	
	//Object
		@FindBy(id="input-firstname")
		private WebElement firstName;
		
		
		@FindBy(id="input-lastname")
		private WebElement lastName;
		
		
		@FindBy(id="input-email")
		private WebElement emailField;
		
		
		@FindBy(id="input-telephone")
		private WebElement telephoneField;
		
		
		@FindBy(id="input-password")
		private WebElement passwordField;
		
		
		@FindBy(id="input-confirm")
		private WebElement passwordField2;
		
		@FindBy(name="agree")
		private WebElement policyCheckBox;
		
		@FindBy(xpath="//input[@type='submit']")
		private WebElement registrationbutton;
		
		@FindBy(xpath="//label[@class='radio-inline']/input[@type='radio'][@value='1']")
		private WebElement radiobuttonNewslatter;
		
		@FindBy(xpath="//div[contains(@class, 'alert')]")
		private WebElement privacyPolicyWarning;
		
		@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
		private WebElement firstNameWarning;
		
		@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
		private WebElement lastNameWarning;
		
		@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
		private WebElement emailWarning;
		
		@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
		private WebElement phoneWarning;
		
		@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
		private WebElement passwordWarning;
		
		@FindBy(xpath="//div[contains(@class, 'alert')]")
		private WebElement alreadyRegisteredEmailWarning;
		
		
		
		//Actions
		public void firstNameTextBox(String firstname) {
			elementUtils.sendKeyFunction(firstname, firstName, CommonUtils.EXPLICIT_WAIT_TIME);	
		}
		
		public void lastNameTextBox(String lastname) {
			elementUtils.sendKeyFunction(lastname, lastName, CommonUtils.EXPLICIT_WAIT_TIME);
		}
		
		public void emailTextBox(String emailtext) {	
			elementUtils.sendKeyFunction(emailtext, emailField, CommonUtils.EXPLICIT_WAIT_TIME);			
		}
		
		public void telephoneTextBox(String phonenumber) {			
			elementUtils.sendKeyFunction(phonenumber, telephoneField, CommonUtils.EXPLICIT_WAIT_TIME);		
		}
		
		public void passwrodTextBox(String passwordText) {	
			elementUtils.sendKeyFunction(passwordText, passwordField, CommonUtils.EXPLICIT_WAIT_TIME);		
		}
		
		public void passwordConfirmTextBox(String passwordText2) {			
			elementUtils.sendKeyFunction(passwordText2, passwordField2, CommonUtils.EXPLICIT_WAIT_TIME);			
		}
		
		public void policyCheckBox() {			
			elementUtils.clickOnFunction(policyCheckBox, CommonUtils.EXPLICIT_WAIT_TIME);			
		}
		
		public void selectNewsLatterRadioButton() {			
			elementUtils.clickOnFunction(radiobuttonNewslatter, CommonUtils.EXPLICIT_WAIT_TIME);			
		}
		
		public void registrationOption() {			
			elementUtils.clickOnFunction(registrationbutton, CommonUtils.EXPLICIT_WAIT_TIME);		
		}
		
		public String privacyPolicyWarningMessage() {
			String privacyPolicyWarningText = elementUtils.getTextFunction(privacyPolicyWarning, CommonUtils.EXPLICIT_WAIT_TIME);
			return privacyPolicyWarningText;	
		}
		
		public String firstNameWarningMessage() {
			String firstNameWarningText = elementUtils.getTextFunction(firstNameWarning, CommonUtils.EXPLICIT_WAIT_TIME);
			return firstNameWarningText;
		}
		
		public String lastNameWarningMessage() {
			String lastNameWarningText = elementUtils.getTextFunction(lastNameWarning, CommonUtils.EXPLICIT_WAIT_TIME);
			return lastNameWarningText;
		}
		
		
		public String emailWarningMessage() {
			String emailWarningText = elementUtils.getTextFunction(emailWarning, CommonUtils.EXPLICIT_WAIT_TIME);
			return emailWarningText;
		}
		
		public String phoneWarningMessage() {
			String phoneWarningText = elementUtils.getTextFunction(phoneWarning, CommonUtils.EXPLICIT_WAIT_TIME);
			return phoneWarningText;
		}
		
		public String passwordWarningMessage(){
			String passwordWarningText = elementUtils.getTextFunction(passwordWarning, CommonUtils.EXPLICIT_WAIT_TIME);
			return passwordWarningText;
		}
		
		public String alreadyRegisteredEmailWarningMessage() {
			String alreadyRegisteredEmailWarningMessageText = elementUtils.getTextFunction(alreadyRegisteredEmailWarning, CommonUtils.EXPLICIT_WAIT_TIME);
			return alreadyRegisteredEmailWarningMessageText;
		}
		
}
