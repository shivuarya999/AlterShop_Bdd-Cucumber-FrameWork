package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Elementsreuse;



public class HomePage {


	WebDriver driver;
	public Elementsreuse  elementsReuse;

	public HomePage(WebDriver driver) {
		this.driver=driver;

		PageFactory.initElements(driver, this);
		elementsReuse = new Elementsreuse(driver);
	}

	@FindBy(xpath="//span[text()='My Account']")
	WebElement MyAccount;
	@FindBy(linkText ="Login")
	WebElement LoginOption;
	@FindBy(linkText ="Register")
	WebElement RegisterOption;


	public void myAccount() {
//		MyAccount.click();
		elementsReuse.clickOnElement(MyAccount, 30);

	}

	public void loginOption() {
//		LoginOption.click();
		elementsReuse.clickOnElement(LoginOption, 30);
	}
	public void registerOption() {
		elementsReuse.clickOnElement(RegisterOption, 30);
//		RegisterOption.click();

	}
}
