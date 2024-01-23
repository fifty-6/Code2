package testNGTool;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MyntraSoftAssert {

	@Test
	public void myntraTest() {
		SoftAssert s=new SoftAssert();
		
		WebDriver c=new ChromeDriver();
		c.manage().window().maximize();
		c.get("https://www.myntra.com/");
		WebElement stf=c.findElement(By.className("desktop-searchBar"));
		s.assertTrue(stf.isDisplayed());
		s.assertFalse(stf.isSelected());
		s.assertAll();
		
		

	}

}
