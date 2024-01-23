package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ContactInformationPage {
	
//	FIRST NAME
	@FindBy(name="firstname")
	private WebElement Firstnametf;

	public WebElement getFirstnametf() {
		return Firstnametf;
	}
	
//	LAST NAME
	@FindBy(name="lastname")
	private WebElement Lastnametf;
	
	public WebElement getLastnametf() {
		return Lastnametf;
	}
	
//	ASSIGN TYPE RADIO BTN
	@FindBy(xpath="(//input[@name='assigntype'])[2]")
	private WebElement radiobtn;

	public WebElement getRadiobtn() {
		return radiobtn;
	}
	
//	ASSIGN TYPE DROPDOWN
	@FindBy(name="assigned_group_id")
	private WebElement AssignTodropdown;
	
	public WebElement getAssignTodropdown() {
		return AssignTodropdown;
	}
	
//	BIRTHDAY
	@FindBy(name="birthday")
	private WebElement Birthday;
	
	public WebElement getBirthday() {
		return Birthday;
	}
	
//	ORGANIZATION PLUS ICON
	@FindBy(xpath="(//img[@alt='Select'])[1]")
	private WebElement Orgplusicon;
	
	public WebElement getOrgplusicon() {
		return Orgplusicon;
	}
	
//	ORGANIZATION SEARCH TEXTFIELD
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
	
//	SAVE BUTTON
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement Savebtn;
	
	public WebElement getSavebtn() {
	return Savebtn;
	}
	

//	CREATE CONSTRUCTOR
	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	
	
	
}
