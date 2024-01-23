package execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class GroupExecution {
	
	@BeforeSuite
	public void BS() {
		System.out.println("BeforeSuite");
	}
	@AfterSuite
	public void AF() {
		System.out.println("AfterSuite");
	}

	@Test
	public void createOrganization() {
	WebDriver c=new ChromeDriver();
	c.get("https://www.vtiger.com/vtigercrm/");
	}
	
	@Test
	public void createContact() {
		
	}
	
}
