package execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NykaaExecution {

	@Test(groups="Shoping")
	public void nykaaTest() {
		WebDriver c= new ChromeDriver();
		c.manage().window().maximize();
		c.get("https://www.nykaa.com/");
		
	}
	@Test(groups="Shoping")
	public void tiraTest() {
		WebDriver c= new ChromeDriver();
		c.manage().window().maximize();
		c.get("https://www.tirabeauty.com/");
	}
	@Test(groups="Food")
	public void ZomatoTest() {
		WebDriver c=new ChromeDriver();
		c.manage().window().maximize();
		c.get("https://www.zomato.com/india");
	}
	@Test(groups="Food")
	public void swiggyTest() {
		WebDriver c=new ChromeDriver();
		c.manage().window().maximize();
		c.get("https://www.swiggy.com/");
	}
	@Test(groups="Shoping")
	public void myntraTest() {
		WebDriver c=new ChromeDriver();
		c.manage().window().maximize();
		c.get("https://www.myntra.com/s");
	}
	@Test(groups="Entatainment")
	public void jioCenmaTest() {
		WebDriver c=new ChromeDriver();
		c.manage().window().maximize();
		c.get("https://www.jiocinema.com/");
	}
	

}
