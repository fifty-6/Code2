package basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class VtigerOrgWrite {

	public static void main(String[] args) throws IOException , InterruptedException{
		WebDriver c=new ChromeDriver();
		c.manage().window().maximize();
		c.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
//		STEP:1 To read the data from External file
		FileInputStream fis=new FileInputStream("src\\test\\resources\\Vtiger.properties");
		
//		STEP:2 To read data from property file
		Properties p=new Properties();
		
//		STEP:3 To fetch location
		p.load(fis);
		
//		STEP:4 LOAD(READ) ALL THE KEYS PRESENT IN THE PROPERTY FILE
		String URL=p.getProperty("url");
		String ORG=p.getProperty("Org");
		String WEB=p.getProperty("Website");
		String PH1=p.getProperty("Primary");
		String TICKER=p.getProperty("Ticker");
		String FAX=p.getProperty("Fax");
		String MEMBER=p.getProperty("Member");
		String PH2=p.getProperty("Secondary");
		String EMP=p.getProperty("Employees");
		String PEMAIL=p.getProperty("PrimaryE");
		String SEMAIL=p.getProperty("SecondaryE");
		String OWN=p.getProperty("Ownership");
		String SIC=p.getProperty("SICode");
		String REV=p.getProperty("Revenue");
		
		String BILL=p.getProperty("Billing");
		String SHIP=p.getProperty("Shipping");
		String PO=p.getProperty("Po");
		String SPO=p.getProperty("ShippingPo");
		String BC=p.getProperty("BillingCity");
		String SC=p.getProperty("ShippingCity");
		String BS=p.getProperty("BillingState");
		String SS=p.getProperty("ShippingState");
		String BPC=p.getProperty("BillingPostalCode");
		String SPC=p.getProperty("ShippingPostalCode");
		String BCC=p.getProperty("BillingCountry");
		String SCC=p.getProperty("ShippingCountry");
		
//		Drop-downs
		String IND=p.getProperty("Industry");
		String RAT=p.getProperty("Rating");
		String TYP=p.getProperty("Type");
		
//		STEP:5
		c.get(URL);
		
//		STEP:6
		c.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(2000);
		c.findElement(By.id("appnavigator")).click();
		Thread.sleep(1000);
		WebElement mark=c.findElement(By.xpath("//span[text()=' MARKETING']"));
		Actions a=new Actions(c);
		a.moveToElement(mark).perform();
		Thread.sleep(1000);
		c.findElement(By.xpath("(//span[text()=' Organizations'])[1]")).click();
		Thread.sleep(1000);
		c.findElement(By.id("Accounts_listView_basicAction_LBL_ADD_RECORD")).click();
		Thread.sleep(2000);
		
		c.findElement(By.id("Accounts_editView_fieldName_accountname")).sendKeys(ORG);
		c.findElement(By.id("Accounts_editView_fieldName_website")).sendKeys(WEB);
		c.findElement(By.id("Accounts_editView_fieldName_phone")).sendKeys(PH1);
		c.findElement(By.id("Accounts_editView_fieldName_tickersymbol")).sendKeys(TICKER);
		c.findElement(By.id("Accounts_editView_fieldName_fax")).sendKeys(FAX);
		c.findElement(By.id("Accounts_editView_fieldName_email2")).sendKeys(SEMAIL);
		c.findElement(By.id("Accounts_editView_fieldName_otherphone")).sendKeys(PH2);
		c.findElement(By.id("Accounts_editView_fieldName_employees")).sendKeys(EMP);
		c.findElement(By.id("Accounts_editView_fieldName_email1")).sendKeys(PEMAIL);
		c.findElement(By.id("Accounts_editView_fieldName_ownership")).sendKeys(OWN);
		c.findElement(By.id("Accounts_editView_fieldName_siccode")).sendKeys(SIC);
		c.findElement(By.id("Accounts_editView_fieldName_annual_revenue")).sendKeys(REV);
		
//		MwmberOF
		c.findElement(By.id("account_id_display")).sendKeys(MEMBER);
		
//		Industry
		c.findElement(By.id("select2-chosen-2")).click();
		WebElement st=c.findElement(By.id("s2id_autogen2_search"));
		st.click();
		st.sendKeys(IND);
		st.sendKeys(Keys.ENTER);
		
//		Rating
		c.findElement(By.id("select2-chosen-4")).click();
		WebElement st1=c.findElement(By.id("s2id_autogen4_search"));
		st1.click();
		st1.sendKeys(RAT);
		st1.sendKeys(Keys.ENTER);
		
//		Type
		c.findElement(By.id("select2-chosen-6")).click();
		WebElement stf2=c.findElement(By.id("s2id_autogen6_search"));
		stf2.click();
		stf2.sendKeys(TYP);
		stf2.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		c.findElement(By.id("Accounts_editView_fieldName_emailoptout")).click();
		JavascriptExecutor j=(JavascriptExecutor)c;
		j.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		c.findElement(By.id("Accounts_editView_fieldName_notify_owner")).click();
		Thread.sleep(2000);
		
//		BILLING/SHIPPING ADDRESSES
		c.findElement(By.name("bill_street")).sendKeys(BILL);
		c.findElement(By.name("ship_street")).sendKeys(SHIP);
		c.findElement(By.id("Accounts_editView_fieldName_bill_pobox")).sendKeys(PO);
		c.findElement(By.id("Accounts_editView_fieldName_ship_pobox")).sendKeys(SPO);
		c.findElement(By.id("Accounts_editView_fieldName_bill_city")).sendKeys(BC);
		c.findElement(By.id("Accounts_editView_fieldName_ship_city")).sendKeys(SC);
		c.findElement(By.id("Accounts_editView_fieldName_bill_state")).sendKeys(BS);
		c.findElement(By.id("Accounts_editView_fieldName_ship_state")).sendKeys(SS);
		c.findElement(By.id("Accounts_editView_fieldName_bill_code")).sendKeys(BPC);
		c.findElement(By.id("Accounts_editView_fieldName_ship_code")).sendKeys(SPC);
		c.findElement(By.id("Accounts_editView_fieldName_bill_country")).sendKeys(BCC);
		c.findElement(By.id("Accounts_editView_fieldName_ship_country")).sendKeys(SCC);
		
//		SAVING
		Thread.sleep(2000);
		c.findElement(By.xpath("//button[text()='Save']")).click();
		
		
//		TAKING SCREENSHOT
		Thread.sleep(1000);
		j.executeScript("window.scrollBy(0,100)");
		Thread.sleep(2000);
		TakesScreenshot t=(TakesScreenshot)c;
		File temp=t.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Vtiger/Image.png");
		FileUtils.copyFile(temp, dest);
		
		Thread.sleep(7000);
		c.quit();
		
		
		
		

	}

}
