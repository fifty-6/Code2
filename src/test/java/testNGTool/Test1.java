package testNGTool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test1 {

		@Test(invocationCount=2,priority=2)
		public void swiggyTest() throws InterruptedException {
			
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.swiggy.com/");
			Thread.sleep(5000);
			driver.quit();
		}
		
		@Test(invocationCount=1,priority=1)
		public void zomatoTest() throws InterruptedException{
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.zomato.com/india");
			Thread.sleep(4000);
			driver.quit();
		}
		
		@Test(invocationCount=3,priority=3)
		public void facebookTest() throws InterruptedException {
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.facebook.com/");
			Thread.sleep(3000);
			driver.quit();
		}

}
