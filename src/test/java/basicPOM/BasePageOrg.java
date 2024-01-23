package basicPOM;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import CommonUtils.ExcelUtil;
import CommonUtils.WebDriverUtils;
import pom.HomePage;
import pom.LoginPage;
import pom.OrganizationInformationPage;
import pom.OrganizationPage;

public class BasePageOrg {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverUtils wutils=new WebDriverUtils();
		ExcelUtil eutils=new ExcelUtil();
		String ORGNAME=eutils.getDataFromExcel("Organization", 0, 1);
		String GROUP=eutils.getDataFromExcel("Organization", 1, 1);
		String INDUSTRY=eutils.getDataFromExcel("Organization", 2, 1);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		
		LoginPage lp=new LoginPage(driver);
		lp.Login("admin", "root");
		
		HomePage hp=new HomePage(driver);
		hp.OrgHome();
		
		OrganizationPage op=new OrganizationPage(driver);
		op.getOrgPlusBtn().click();
		
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		oip.getOrgName().sendKeys(ORGNAME);
		oip.getAssignedGroupRadioBtn().click();
		wutils.handleDropdownByVisableText(oip.getAssignedDrpdwn(), GROUP);
		oip.getMemberOfPlusIcon().click();
		wutils.switching(driver,"http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
		oip.getOrgsearchtf().sendKeys("Halwa1");
		oip.getOrgSearchBtn().click();
		oip.getClickOrgName().click();
		wutils.okPopup(driver);
		wutils.switching(driver, "http://localhost:8888/index.php?module=Accounts&action=EditView&return_action=DetailView&parenttab=Marketing");
		wutils.handleDropdownByValue(oip.getIndustryDrpdwn(),INDUSTRY);
		oip.getSavebtn().click();
		wutils.explicitWaitTitle(driver, 10," Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM");
		wutils.toTakeScreenshot(driver,"Organization");
		Thread.sleep(8000);
		driver.quit();
		
	}

}
