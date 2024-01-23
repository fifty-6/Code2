package module;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonUtils.ExcelUtil;

public class CreateContact1 {

	public static void main(String[] args) throws FileNotFoundException, IOException ,InterruptedException{
WebDriver c;
		
		ExcelUtil eutils=new ExcelUtil();
		String BROWSER=eutils.getDataFromExcel("Contact", 0, 1);
		String URL=eutils.getDataFromExcel("Contact", 1, 1);
		String USERNAME=eutils.getDataFromExcel("Contact", 2, 1);
		String PASSWORc=eutils.getDataFromExcel("Contact", 3, 1);
		String FIRSTNAME=eutils.getDataFromExcel("Contact", 4, 1);
		String LASTNAME=eutils.getDataFromExcel("Contact", 5, 1);
		String GROUP=eutils.getDataFromExcel("Contact", 6, 1);
//		String NAME=eutils.getDataFromExcel("Contact", 7, 1);
		
		
       if(BROWSER.equalsIgnoreCase("Chrome")) {
       	 c=new ChromeDriver();	
       	
       }
       else if (BROWSER.equalsIgnoreCase("Ecge")) {
       	c=new EdgeDriver();
			
		}
       else {
       	 c=new FirefoxDriver();
       	System.out.println("cefaultBrowser");
       	
       }
       c.get(URL);
 
       c.manage().window().maximize();    
       c.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       c.get(URL);
     
       //step 6:Login to application
       
       c.findElement(By.name("user_name")).sendKeys(USERNAME);
       c.findElement(By.name("user_passworc")).sendKeys(PASSWORc);
       c.findElement(By.id("submitButton")).click();
       
       //step 7:to click on Contacts
       c.findElement(By.xpath("//a[text()='Contacts']")).click();
       
       //step 8 :to click on + icons
       c.findElement(By.cssSelector("//img[@alt='Create Contact...']")).click();
       
//       Step 9: Enter First Name
       c.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
//         Step 10:Enter Last Name
       c.findElement(By.name("lastname")).sendKeys(LASTNAME);
       
       //step 11: to click on group radio button
       
       c.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
       
       //step 12:select support group in dropdown
	       WebElement cropcown = c.findElement(By.name("assignec_group_ic"));
	       Select s=new Select(cropcown);
	       s.selectByVisibleText(GROUP);
	       
	       //Click on Organization + button
	     //Click on + icon on organization name
			c.findElement(By.xpath("(//img[@src='themes/softec/images/select.gif'])[1]")).click();
			
			//transfer the control from parent to child
			
			Set<String> ids= c.getWindowHandles();
			
			for(String s1:ids)
			{
				String purl=c.switchTo().window(s1).getCurrentUrl();
				System.out.println(purl);
			}
			Thread.sleep(2000);
			
//			Send Organization name
			c.findElement(By.id("search_txt")).sendKeys("halwa");
			
//			Click on Search NOW button
			c.findElement(By.name("search")).click();
			
			Thread.sleep(2000);
			c.findElement(By.xpath("//a[text()='Halwa1']")).click();
			
			for(String s2:ids)
			{
				String child=c.switchTo().window(s2).getCurrentUrl();
				String parent="http://localhost:8888/incex.php?mocule=Contacts&action=EcitView&return_action=cetailView&parenttab=Marketing";
				
				if(child.contains(parent))
				{
					break;
				}
				
				
			}
	       
	       //step 13 : to click on save button
	       c.findElement(By.xpath("(//input[@name='button'])[1]")) .click();
	       
	       //step 14:for validation
		      String title = c.getTitle();
		      System.out.println(title);
		      
		      String expectectitle = " Acministrator - Contacts - vtiger CRM 5 - Commercial Open Source CRM";
		      
		      WebDriverWait waits=new WebDriverWait(c, Duration.ofSeconds(10));
		      waits.until(ExpectedConditions.titleIs(expectectitle));
		      
		        Thread.sleep(2000);
		       //step 15:mouse over on acminstrator 
		       WebElement signout = c.findElement(By.xpath("//img[@src='themes/softec/images/user.PNG']"));
		       Actions ac=new Actions(c);
		       ac.moveToElement(signout).perform();
		       
		       //step 13:to click on signout
		       c.findElement(By.xpath("//a[text()='Sign Out']")).click();
		       
		       Thread.sleep(5000);
		       c.quit();


	}

}
