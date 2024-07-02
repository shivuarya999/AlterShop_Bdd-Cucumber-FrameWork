package stepdefinitions;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;



@SuppressWarnings("deprecation")
public class SearchSteps {
	WebDriver driver;

	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}

	@After
	public void teardown(Scenario scenario) {

		String scenarioName = scenario.getName().replace(" ", "_");

		if(scenario.isFailed()) {

			byte[] srcscreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcscreenshot, "image/png", scenarioName);
		}else  {
			byte[] srcscreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcscreenshot, "image/png", scenarioName);

		}



		driver.quit();
	}
	@Given("I am on the home page")
	public void i_am_on_the_home_page() {

		driver.get("https://betashop.alter.game/");
	}

	@When("I search for product")
	public void i_search_for_product() {
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='auto-suggestion-search']"));
		searchBox.sendKeys("watch");
		driver.findElement(By.xpath("//div[@class='flex justify-start']")).click();
	}

	@Then("I should see the search results")
	public void i_should_see_the_search_results() {

		String expected ="WATCH FOR TEST";
		String results = driver.findElement(By.xpath("//span[text()='Watch for TEST']")).getText();
		Assert.assertEquals(results, expected);	
	}

	//	@Given("I am on the search results page")
	//	public void i_am_on_the_search_results_page() {
	//		// Assuming the previous step already performed a search
	//	}
	//
	//	@When("I apply filter {string}")
	//	public void i_apply_filter(String filter) {
	//		WebElement filterElement = driver.findElement(By.id(filter));
	//		filterElement.click();
	//	}
	//
	@Then("I should see the filtered Categories")
	public void i_should_see_the_filtered_categories() {
		WebElement category = driver.findElement(By.xpath("//span[text()='Categories']"));
		Actions act = new Actions(driver);
		act.moveToElement(category).build().perform();
	}
	@Then("I should see the filtered All Categories")
	public void i_should_see_the_filtered_all_categories() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='col-span-2 flex flex-col items-start text-white ']//span[text()='All Categories']")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//h1[text()='All Categories']")).getText());
	}

	@Then("I should see the filtered All Body")
	public void i_should_see_the_filtered_all_body() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='col-span-2 flex flex-col items-start text-white ']//span[text()='Body']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//h1[text()='Body']")).isDisplayed();
	}


//	@Then("I should see the asset details page")
//	public void i_should_see_the_asset_details_page() {
//		driver.findElement(By.xpath("//div[@class='row-span-2 cursor-pointer']")).click();
//		driver.findElement(By.xpath("//h1[text()='Body']")).isDisplayed();
//		driver.navigate().back();
//}
	@Then("I should see the filtered All Building")
	public void i_should_see_the_filtered_all_building() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='col-span-2 flex flex-col items-start text-white ']//span[text()='Buildings']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//h1[text()='Buildings']")).isDisplayed();
	}

	@Then("I should see the filtered All IndoorAsset")
	public void i_should_see_the_filtered_all_indoor_asset() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='col-span-2 flex flex-col items-start text-white ']//span[text()='Indoor Assets']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//h1[text()='Indoor Assets']")).isDisplayed();
		
	}

	@Then("I should see the filtered All OutdoorAsset")
	public void i_should_see_the_filtered_all_outdoor_asset() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='col-span-2 flex flex-col items-start text-white ']//span[text()='Outdoor Assets']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//h1[text()='Outdoor Assets']")).isDisplayed();
	}

	@Then("I should see the filtered AlterLand")
	public void i_should_see_the_filtered_alter_land() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='col-span-2 flex flex-col items-start text-white ']//span[text()='Alter Land']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//h1[text()='Alter Land']")).isDisplayed();
	}


	@Then("I should see the creator's assets")
	public void i_should_see_the_creator_s_assets() {
		WebElement creatorAssets = driver.findElement(By.id("creator_profile"));
		assert(creatorAssets.isDisplayed());
	}


}
