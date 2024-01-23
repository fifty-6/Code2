package testNGTool;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AssertFalse {
@Test
public void myntraFailTest() {
	WebDriver c=new ChromeDriver();
	c.manage().window().maximize();
	c.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	c.get("https://www.myntra.com/");
	WebElement stf=c.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
	
	Assert.assertFalse(stf.isSelected());	//False Condition---------Failure
	
//	Assert.assertFalse(stf.isDisplayed());	//True Condition----------Passed	
}
@Test
public void myntraPassTest() {
	WebDriver c=new ChromeDriver();
	c.manage().window().maximize();
	c.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	c.get("https://www.myntra.com/");
	WebElement stf=c.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
	
	Assert.assertTrue(stf.isSelected());	//False Condition ---------Failure
//	Assert.assertTrue(stf.isDisplayed());	//True Condition----------Passed
	Reporter.log("Hello",true);
	
	
	
}
}
