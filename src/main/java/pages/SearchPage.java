package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class SearchPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	
	//Constructor
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
		
	
		
	//Object
	@FindBy(xpath="//div[@id='search']/input")
	private WebElement searchBox;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;
	
	@FindBy(xpath="//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']")
	private WebElement productAvailableElement;
	
	@FindBy(xpath="//div[@id='content']/p[2]")
	private WebElement noMatchProductMessageElement;
	
	
	
	//Actions
	public void typeProductInSearchBox(String productname) {
		elementUtils.sendKeyFunction(productname, searchBox, 0);
		
	}
	
	
	public void clickSearchButton() {
		elementUtils.clickOnFunction(searchButton, 0);
	}
	
	public boolean isProductDisplayed() {
		boolean isDisplayedproduct = elementUtils.displayStatusOfElement(productAvailableElement, 0);
		return isDisplayedproduct;
	}
	
	public String noMatchProductMessage() {
		String noMatchProductMessageText = elementUtils.getTextFunction(noMatchProductMessageElement, 0);
		return noMatchProductMessageText;
	}
}
