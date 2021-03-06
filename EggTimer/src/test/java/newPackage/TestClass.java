package newPackage;

import java.time.Instant;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestClass extends BaseClass{

	
	@Test
	public void eggtimer() throws InterruptedException { 

		driver.get("http://e.ggtimer.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		WebElementClass webelement = new WebElementClass();
		
		int timeinSecs=25;
		String before=null;
		String after=null;
		int counter=0;
		// Enter time
		webelement.setText(driver, "//*[@id=\"EggTimer-start-time-input-text\"]", String.valueOf(timeinSecs));
		Thread.sleep(1000);
		
		// Click Start
		webelement.clickButton(driver, "//*[@data-for=\"startpage\"]");
		
			long t1=Instant.now().getEpochSecond();
			long t2;
			while(true) {
			after=driver.findElement(By.xpath("//*[@Class=\"ClassicTimer-time\"]/span")).getText().replace(" seconds", "").replace(" second", "");
			
			if (!after.equals(before)) {
				before=after;
				t2=Instant.now().getEpochSecond();
				System.out.println(before + " " + (t2-t1));		
				if ((t2-t1) != 0) {
					Assert.assertEquals((t2-t1),1);
				}
				t1=t2;
			}
			Thread.sleep(1000);
			if (Integer.parseInt(after) == 0) {
		    	driver.switchTo().alert().accept();
		    	break;
			}

			}
	}
	
	@AfterMethod
	public void close() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
