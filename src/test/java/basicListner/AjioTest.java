package basicListner;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonUtils.Listenerimplementation;

@Listeners(Listenerimplementation.class)
public class AjioTest {

	@Test
	public void PerfumeTest() throws InterruptedException {
	WebDriver c=new ChromeDriver();
	c.manage().window().maximize();
	c.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	c.get("https://www.ajio.com");
	}
	
}
