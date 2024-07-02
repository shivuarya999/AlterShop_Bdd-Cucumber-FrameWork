package Utilities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Elementsreuse {


	WebDriver driver;

	public Elementsreuse(WebDriver driver) {
		this.driver=driver;
	}


	public WebElement waitForElement(WebElement element,long durationInSeconds) {

		WebElement webelement = null;

		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webelement=wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return webelement;
		
	}

	public void clickOnElement(WebElement element,long durationInSeconds) {

		WebElement webElement=waitForElement(element, durationInSeconds);

		webElement.click();	

	}

	public void typeTextIntoField(WebElement element,String textToBeTyped,long durationInSeconds) {

		WebElement webElement=waitForElement(element, durationInSeconds);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeTyped);

	}

	public void selectOptionInDropDown(WebElement element,String dropDownOption,long durationInSeconds) {

		WebElement webElement=waitForElement(element, durationInSeconds);

		Select select = new Select(webElement);
		select.deselectByVisibleText(dropDownOption);

	}

	public void acceptAlert(long durationInSeconds) {

		Alert alert=waitForAlert(durationInSeconds);
		alert.accept();

	}

	public void dismissAlert(long durationInSeconds) {
		Alert alert=waitForAlert(durationInSeconds);
		alert.dismiss();
	}

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

	public void mouseOverAndClick(WebElement element,long durationInSeconds) {

		WebElement webElement=waitVisibilityOfElement(element, durationInSeconds);
		
		Actions action = new  Actions(driver);
		action.moveToElement(webElement).click().build().perform();
	}


	public WebElement waitVisibilityOfElement(WebElement element,long durationInSeconds) {

		WebElement webElement=null;
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}

		return webElement;

	}
	
	public void javaScriptClick(WebElement element,long durationInSeconds) {
		
		WebElement webElement=waitVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", webElement);
		}
	
	public void javaScriptTextType(WebElement element,String TextType,long durationInSeconds){
		
		WebElement webElement=waitVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='"+TextType+"';", webElement);
		}
		
		
		
	}


