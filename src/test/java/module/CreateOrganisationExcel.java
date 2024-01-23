package module;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
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
import CommonUtils.PropertyFileUtil;

public class CreateOrganisationExcel {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException , IOException{
		WebDriver d;
		
		
		//To get data from Property file
				PropertyFileUtil putils=new PropertyFileUtil();
				String BROWSER=putils.getDataFromPropertyFile("browser");
				String URL=putils.getDataFromPropertyFile("url");
				String USERNAME=putils.getDataFromPropertyFile("username");
				String PASSWORD=putils.getDataFromPropertyFile("password");
				
				//To get data from ExcelFile
				ExcelUtil eutils=new ExcelUtil();
				String NAME=eutils.getDataFromExcel("Organisation1", 0, 1);
				String GROUP=eutils.getDataFromExcel("Organisation1", 2, 1);
				String INDUSTRY=eutils.getDataFromExcel("Organisation1", 3, 1);
				
			
     
     
      //To launch the browser
      if(BROWSER.equalsIgnoreCase("Chrome")) {
      	 d=new ChromeDriver();	
      }
      else if (BROWSER.equalsIgnoreCase("Edge")) {
      	d=new EdgeDriver();
			
		}
      else {
      	 d=new FirefoxDriver();
      	System.out.println("defaultBrowser");
      	
      }
      d.manage().window().maximize();
      d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      
      	
      //step 5:Load the url
      d.get(URL);
      
      //step 6:Login to application
      
      d.findElement(By.name("user_name")).sendKeys(USERNAME);
      d.findElement(By.name("user_password")).sendKeys(PASSWORD);
      d.findElement(By.id("submitButton")).click();
      
      //step 7:to click on organisations
      d.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
      
      //step 8 :to click on + icons
      d.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
      
      //step 9:to enter organisation name
      d.findElement(By.name("accountname")).sendKeys(NAME);
      
      //step 10: to click on gropu radio button
      
      d.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
      
      //step 11:select support group in dropdown
     WebElement dropdown = d.findElement(By.name("assigned_group_id"));
     Select s=new Select(dropdown);
     s.selectByVisibleText(GROUP);
     
     
     //step 12:select industry in dropdown
     WebElement industrydropdown = d.findElement(By.name("industry"));
     Select s1=new Select(industrydropdown);
     s1.selectByValue(INDUSTRY);
     
     //step 13 : to click on save button
		Thread.sleep(2000);
     d.findElement(By.xpath("(//input[@name='button'])[1]")) .click();
     
     //step 14:for validation
    String title = d.getTitle();
    System.out.println(title);
    
    String expectedtitle = " Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM";

    
    //Using Explicit-wait because IF-ELSE wont support in TestNG
   
    WebDriverWait waits=new WebDriverWait(d, Duration.ofSeconds(10));
    waits.until(ExpectedConditions.titleIs(expectedtitle));
    
    
      Thread.sleep(2000);
     //step 15:mouse over on adminstrator
     
     WebElement signout = d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
     Actions ac=new Actions(d);
     ac.moveToElement(signout).perform();
     
     //step 13:to click on signout
     d.findElement(By.xpath("//a[text()='Sign Out']")).click();
     
     Thread.sleep(5000);
     d.quit();		

	}

}
