package basicListner;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonUtils.Listenerimplementation;


@Listeners(Listenerimplementation.class)
public class TiraTest {

	@Test
	public void PerfumeTest() throws InterruptedException {
	WebDriver c=new ChromeDriver();
	c.manage().window().maximize();
	c.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	c.get("https://www.tirabeauty.com");
//	Assert.assertEquals("sanket","sarkar");
	WebElement stf=c.findElement(By.id("search"));
	stf.sendKeys("perfumes");
	stf.sendKeys(Keys.ENTER);
	Thread.sleep(5000);
	c.quit();
	}
	
	

}
