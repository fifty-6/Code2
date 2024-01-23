package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement orgPlusBtn;
	
	public WebElement getOrgPlusBtn() {
		return orgPlusBtn;
	}
	
//	CONSTRUCTOR
	public OrganizationPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	
	

}
