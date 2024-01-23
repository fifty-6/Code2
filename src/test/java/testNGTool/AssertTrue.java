package testNGTool;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertTrue {
	@Test
	public void ajioTest() throws InterruptedException{
		WebDriver c=new ChromeDriver();
		c.manage().window().maximize();
		c.get("https://www.ajio.com/");
		c.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement stf=c.findElement(By.name("searchVal"));
		stf.sendKeys("Perfumes");
		stf.sendKeys(Keys.ENTER);
		WebElement ckbx=c.findElement(By.xpath("//label[@for='Men']"));
		ckbx.click();
		Thread.sleep(5000);
		Assert.assertTrue(ckbx.isSelected());
		System.out.println("Good morning");
	}

}
