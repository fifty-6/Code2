package testNGTool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertTest {
	@Test
	public void ajioTest() {
	WebDriver c=new ChromeDriver();
	c.manage().window().maximize();
	c.get("https://www.ajio.com/");
	String actual=c.getCurrentUrl();
	String expected="https://www.ajio.com/pune";
	Assert.assertEquals(actual, expected);
	System.out.println("Good morning");
	}
		@Test
		public void myntraTest() {
		WebDriver c=new ChromeDriver();
		c.manage().window().maximize();
		c.get("https://www.myntra.com/");
		String actual=c.getCurrentUrl();
		String expected="https://www.myntra.com/";
		Assert.assertEquals(actual, expected);
		System.out.println("Good afternoon");
		}
}

