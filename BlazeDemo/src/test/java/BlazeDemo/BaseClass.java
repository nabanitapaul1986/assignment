package BlazeDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	public WebDriver driver;
	
	@BeforeSuite
	public void Setup() {
		
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://blazedemo.com/");
	}
	
//	@AfterMethod
//	public void close() throws InterruptedException {
//			driver.close();
//	}

}
