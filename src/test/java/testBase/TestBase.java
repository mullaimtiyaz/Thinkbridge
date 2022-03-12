package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	private WebDriver driver;
	
	@BeforeClass
	public void setupApplication()
	{

		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
		
		driver.get("https://jt-dev.azurewebsites.net/#/SignUp");
		
	}
	
	
	@AfterClass
	public void closeApplication()
	{
		driver.quit();
		
	}
	
	public WebDriver getDriver() {
        return driver;
    }
	
}
