package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


	public class ElementUtils {
	
		public WebDriver driver;
		
		public ElementUtils(WebDriver driver) {
			this.driver = driver;
		}
		
		
		//Click, SendKey and DrowDown Function
		public WebElement waitForElementToBeClickable(WebElement element,long durationInSeconds) {
			
			WebElement webElement = null;
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
				webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
			}catch(Throwable e) {
				e.printStackTrace();
			}
			
			return webElement;
			
		}
		
		
		public void clickOnFunction(WebElement element, long durationInSeconds) {
			WebElement webElement = waitForElementToBeClickable(element, durationInSeconds);
			webElement.click();
		}
		
		
		public void sendKeyFunction(String dataProvider, WebElement element, long durationInSeconds) {
			WebElement webElement = waitForElementToBeClickable(element, durationInSeconds);
			webElement.click();
			webElement.sendKeys(dataProvider);
			
		}
		
		
		public String getTextFunction(WebElement element,long durationInSeconds) {
			WebElement webElement = waitForElementToBeClickable(element,durationInSeconds);
			String getText = webElement.getText();
			return getText;
		}
		
		
		public void TypeTextFunction(String textToBeTyped, WebElement element, long durationInSeconds) {
			WebElement webElement = waitForElementToBeClickable(element, durationInSeconds);
			webElement.click();
			webElement.clear();
			webElement.sendKeys(textToBeTyped);
			
		}
		
		
		public void selectDropdownOption(String dropDownOption, WebElement element, long durationInSeconds) {
			WebElement webElement = waitForElementToBeClickable(element, durationInSeconds);
			Select select = new Select(webElement);
			select.selectByVisibleText(dropDownOption);
		}
		
		
		
		// Alert Function
		public Alert waitForAlert(long durationInSeconds) {
			
			Alert alert = null;
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
				alert = wait.until(ExpectedConditions.alertIsPresent());
			}catch(Throwable e) {
				e.printStackTrace();
			}
			return alert;
		}
		
		
		public void acceptAlert(long durationInSeconds) {
			Alert alert = waitForAlert(durationInSeconds);
			alert.accept();
		}
		
		public void dismissAlert(long durationInSeconds) {
			Alert alert = waitForAlert(durationInSeconds);
			alert.dismiss();
		}
		
		
		//Mouse and Hover, Status Of Element, Javascript Execution
		public WebElement waitForVisibilityOfElement(WebElement element,long durationInSeconds) {
			
			WebElement webElement = null;
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
				webElement = wait.until(ExpectedConditions.visibilityOf(element));
			}catch(Throwable e) {
				e.printStackTrace();
			}
			
			return webElement;
			
		}
		
		
		public void mouseHoverAndClick(WebElement element,long durationInSeconds) {
			
			WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
			Actions action = new Actions(driver);
			action.moveToElement(webElement).click().perform();
			
		}
		
		
		public boolean displayStatusOfElement(WebElement element,long durationInSeconds) {
			
			try{
				WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
				boolean status = webElement.isDisplayed();
				return status;
			}catch(Throwable e) {
				return false;
			}
			
			
		}
		
		
		public void javascriptClick(WebElement element,long durationInSeconds) {
			
			WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", webElement);
			
		}
		
		
		public void javascriptType(String textToBeTyped, WebElement element,long durationInSeconds) {
			
			WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].value='"+textToBeTyped+"'", webElement);
			
		}
		
	}
	
	