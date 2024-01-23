package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;
	
		@FindBy(xpath="//a[text()='Contacts']")
		private WebElement Contactbtn;

		public WebElement getContactbtn() {
			return Contactbtn;
		}
		
		@FindBy(xpath="(//a[text()='Organizations'])[1]")
		private WebElement OrgBtn;
		
		
		public WebElement getOrgBtn() {
			return OrgBtn;
		}

		//		CREATE CONSTRUCTOR
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver,this);
			
		}
		
//		CREATE A METHOD CONTACT BTN
		public ContactsPage Home() {
			Contactbtn.click();
			return new ContactsPage(driver);
		}
		
//		CREATE A METHOD ORGNIZATION BTN
		public OrganizationPage OrgHome() {
			OrgBtn.click();
			return new OrganizationPage(driver);
		}
		

}
