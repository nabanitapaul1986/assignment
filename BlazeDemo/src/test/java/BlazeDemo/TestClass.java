package BlazeDemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestClass extends BaseClass{

	
	@Test
	public void blazedemotest() throws InterruptedException { 
		
		WebElementClass webelement = new WebElementClass();
		
		webelement.dropBox(driver,"//*[@name='fromPort']","San Diego"); 
		
		webelement.dropBox(driver,"//*[@name='toPort']","Dublin"); 
		
		webelement.clickButton(driver,"//*[@value='Find Flights']"); 
		
		
		//Find cheapest price & row number
		
			List<WebElement> rows = driver.findElements(By.xpath("/html/body/div/table/tbody/tr"));
			
		List<WebElement> cols = driver.findElements(By.xpath("/html/body/div/table/thead/tr/th"));
		
		float lowestCost=0;
		int row_num=0;
		
		for (int i=1; i<=rows.size(); ++i) {
			if (i==1) {
				lowestCost=Float.parseFloat(driver.findElement(By.xpath("/html/body/div/table/tbody/tr[" + i + "]/td[" + cols.size() + "]")).getText().replace("$", ""));
				row_num=i;
				}
			else {
				if (lowestCost > Float.parseFloat(driver.findElement(By.xpath("/html/body/div/table/tbody/tr[" + i + "]/td[" + cols.size() + "]")).getText().replace("$", ""))) {
					
					lowestCost=Float.parseFloat(driver.findElement(By.xpath("/html/body/div/table/tbody/tr[" + i + "]/td[" + cols.size() + "]")).getText().replace("$", ""));
					row_num=i;
					}		
				}
			}
		
		
			// Choose flight
		String flightToSelect = "/html/body/div/table/tbody/tr[" + row_num + "]/td[1]";
		webelement.clickButton(driver,flightToSelect);
		
		// Fill Customer details
		webelement.setText(driver, "//*[@id='inputName']", "Nabanita Paul");
		webelement.setText(driver, "//*[@id='address']", "Dodda Kammanahalli");
		webelement.setText(driver, "//*[@id='city']", "Bangalore");
		webelement.setText(driver, "//*[@id='state']", "Karnataka");
		webelement.setText(driver, "//*[@id='zipCode']", "560076");
		webelement.dropBox(driver,"//*[@id='cardType']","American Express"); 
		webelement.setText(driver, "//*[@id='creditCardNumber']", "2222333388881111");
		webelement.setText(driver, "//*[@id='creditCardMonth']", "08");
		webelement.setText(driver, "//*[@id='creditCardYear']", "2023");
		webelement.setText(driver, "//*[@id='nameOnCard']", "Nabanita Paul");
		Thread.sleep(2000);
		
		webelement.clickButton(driver,"//*[@value='Purchase Flight']");
		
		System.out.println("Booking confirmation id: " + webelement.getText(driver, "//*[@class=\"table\"]/tbody/tr[1]/td[2]"));
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void close() throws InterruptedException {
			driver.close();
	}

}