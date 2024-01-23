package testNGTool;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Test2 {

	@Test
	public void AjioTest() throws InterruptedException
	{
		WebDriver c=new ChromeDriver();
		c.get("https://www.ajio.com/");
		String URL=c.getCurrentUrl();
		System.out.println(URL);
		String expected="https://www.ajio.com/pune";
//		if(URL.equals(expected))
//		{
//			System.out.println("Url is same");
//		}else {
//			System.out.println("Url is not same");
//		}
		WebDriverWait waits=new WebDriverWait(c,Duration.ofSeconds(10));
		waits.until(ExpectedConditions.urlToBe(expected));
		System.out.println("Good Morning");
		
		Thread.sleep(3000);
		c.quit();
		
	}
	

}
