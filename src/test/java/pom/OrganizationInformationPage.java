package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	
//	ORGANIZATION NAME
	@FindBy(name="accountname")
	private WebElement orgName;

	public WebElement getOrgName() {
		return orgName;
	}
	
//	ASSIGNED TO RADIO BTN
	@FindBy(xpath="(//input[@name='assigntype'])[2]")
	private WebElement assignedGroupRadioBtn;
	
	public WebElement getAssignedGroupRadioBtn() {
		return assignedGroupRadioBtn;
	}
	
//	ASSIGNED TO DROPDOWN
	@FindBy(name="assigned_group_id")
	private WebElement assignedDrpdwn;
	
	public WebElement getAssignedDrpdwn() {
		return assignedDrpdwn;
	}
	
//	MEMBER OF PLUS ICON
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement memberOfPlusicon;
	
	public WebElement getMemberOfPlusIcon() {
		return memberOfPlusicon;
	}
	
//	ORGANIZATION SEARCHTF
	@FindBy(id="search_txt")
	private WebElement Orgsearchtf;


	public WebElement getOrgsearchtf() {
		return Orgsearchtf;
	}
	
//	ORGANIZATION SEARCH BTN
	@FindBy(name="search")
	private WebElement OrgSearchBtn;
	
	public WebElement getOrgSearchBtn() {
		return OrgSearchBtn;
	}
	
//	CLICK ON THE ORG NAME
	@FindBy(xpath="//a[text()='Halwa1']")
	private WebElement ClickOrgName;
	
	public WebElement getClickOrgName() {
		return ClickOrgName;
	}
	
//	INDUSTRY DROPDOWN
	@FindBy(name="industry")
	private WebElement industryDrpdwn;
	
	public WebElement getIndustryDrpdwn() {
		return industryDrpdwn;
	}
	
//	SAVE BUTTON
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement Savebtn;
	
	public WebElement getSavebtn() {
	return Savebtn;
	}
	

//	CREATE CONSTRUCTOR
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

}
