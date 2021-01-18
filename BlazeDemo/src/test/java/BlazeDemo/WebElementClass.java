package BlazeDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebElementClass {

	public void dropBox(WebDriver driver, String xpath, String str) throws InterruptedException {
		WebElement element = driver.findElement(By.xpath(xpath));
		Select items = new Select(element);
		items.selectByVisibleText(str);
		Thread.sleep(1000);
	}
	
	public void clickButton(WebDriver driver, String xpath) throws InterruptedException {
		driver.findElement(By.xpath(xpath)).click();;
		Thread.sleep(1000);
	}
	
	public void setText(WebDriver driver, String xpath, String text) throws InterruptedException {
	WebElement txtPlaceholder = driver.findElement(By.xpath(xpath));
	txtPlaceholder.clear();
	txtPlaceholder.sendKeys(text);
	}
	
	public String getText(WebDriver driver, String xpath) throws InterruptedException {
	return driver.findElement(By.xpath(xpath)).getText();
	}
}