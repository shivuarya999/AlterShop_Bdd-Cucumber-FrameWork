package Hooks;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Factory.DriverFactory;
import Utilities.UtilesFiles;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class hooks {

	WebDriver driver;
	@Before
	public void setup() throws IOException {

		Properties prop = UtilesFiles.propertiesFile();
		DriverFactory.browserLunch(prop.getProperty("Browser"));
		driver =DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));

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



}
