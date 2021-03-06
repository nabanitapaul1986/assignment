package newPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class WebElementClass extends TestClass {
	
	public void clickButton(WebDriver driver, String xpath) throws InterruptedException {
		driver.findElement(By.xpath(xpath)).click();;
		Thread.sleep(1000);
	}
	
	public void setText(WebDriver driver, String xpath, String text) throws InterruptedException {
	WebElement txtPlaceholder = driver.findElement(By.xpath(xpath));
	txtPlaceholder.clear();
	txtPlaceholder.sendKeys(text);
	}
	
}