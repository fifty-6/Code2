package basicPOM;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import CommonUtils.WebDriverUtils;
import pom.ContactInformationPage;
import pom.ContactsPage;
import pom.HomePage;
import pom.LoginPage;

public class BasePage {
	
public static void main(String[] args) throws IOException, InterruptedException {
	

	WebDriverUtils wutils=new WebDriverUtils();
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://localhost:8888/");
	
	LoginPage lp=new LoginPage(driver);
	lp.Login("admin", "root");
	
	HomePage hp=new HomePage(driver);
	hp.Home();
	
	ContactsPage cp=new ContactsPage(driver) ;
		cp.getPlusicon().click();
		
	ContactInformationPage cip=new ContactInformationPage(driver);
	cip.getFirstnametf().sendKeys("Sanket");
	cip.getLastnametf().sendKeys("Sarkar");
	
	cip.getBirthday().sendKeys("1999-11-11");
	cip.getRadiobtn().click();
	wutils.handleDropdownByVisableText(cip.getAssignTodropdown(), "Support Group");
//	Thread.sleep(2000);
	cip.getOrgplusicon().click();
//	Thread.sleep(2000);
	wutils.switching(driver, "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
	cip.getOrgsearchtf().sendKeys("Halwa1");
	cip.getOrgSearchBtn().click();
	cip.getClickOrgName().click();
	wutils.switching(driver, "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
	cip.getSavebtn().click();
	wutils.toTakeScreenshot(driver,"Contact");
	
	Thread.sleep(7000);
	driver.quit();
	}
}
