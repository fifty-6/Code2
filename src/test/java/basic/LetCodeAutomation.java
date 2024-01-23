package basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LetCodeAutomation {

	public static void main(String[] args) throws FileNotFoundException , IOException , InterruptedException {
		WebDriver c=new ChromeDriver();
		c.manage().window().maximize();
		c.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		Step 1:To Read data from external File
		FileInputStream fis=new FileInputStream("src\\test\\resources\\LetCode.properties");
		
//		Step 2:To read data from propertiy file
		Properties p= new Properties();
		
//		Step 3:To load data from property file
		p.load(fis);
		
//		Step 4:To Load the Key from property file
		String URL= p.getProperty("url");
		String FULLNAME=p.getProperty("fullname");
		String APPEND=p.getProperty("append");
		String INSIDE=p.getProperty("inside");
		String CLRTXT=p.getProperty("clrtxt");
		
//		Step 5:The URL
		c.get(URL);
		
//		Step 6: SENDING DATA
		c.findElement(By.linkText("Edit")).click();
		c.findElement(By.id("fullName")).sendKeys(FULLNAME);
		WebElement clr=c.findElement(By.id("join"));
		clr.clear();
		clr.sendKeys(APPEND);
		WebElement getme=c.findElement(By.id("getMe"));
		getme.clear();
		getme.sendKeys(INSIDE);
		WebElement clrme=c.findElement(By.id("clearMe"));
		clrme.clear();
		clrme.sendKeys(CLRTXT);
		
		
		Thread.sleep(6000);
		c.quit();
		
		
		
		
	}

}
