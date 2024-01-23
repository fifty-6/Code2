package testNGTool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssert101 {
	@Test

	public void MyntraTest() {
		SoftAssert s=new SoftAssert();
		WebDriver c=new ChromeDriver();
		c.manage().window().maximize();
		c.get("https://www.myntra.com/");
		
		String actual=c.getCurrentUrl();
		System.out.println(actual);
		
		String expected="https://www.ajio.com/pune";
		
		s.assertEquals(actual,expected);
		System.out.println("Good morning");
		s.assertAll();

	}
	
}
