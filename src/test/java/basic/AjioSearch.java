package basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AjioSearch {

	public static void main(String[] args) throws FileNotFoundException , IOException{
		WebDriver c=new ChromeDriver();
		c.manage().window().maximize();
		c.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		To read the data from External file
		FileInputStream fis=new FileInputStream("src\\test\\resources\\AjioSearch.properties");
		
		
//		To read data from property file
		Properties p=new Properties();
		
//		To fetch location
		p.load(fis);
		
//		Step 4:LOAD(READ) ALL THE KEYS PRESENT IN THE PROPERTY FILE
		String URL=p.getProperty("url");
		String SEARCH=p.getProperty("search");
		
//		Step 5:
		c.get(URL);
		
//		Step 6:
		WebElement stf=c.findElement(By.name("searchVal"));
		stf.sendKeys(SEARCH);
		stf.sendKeys(Keys.ENTER);
		
		
		
		
	
	}

}
//Assignmnet- Letcode> Click on Edit> Enter full name> append test and press keyboard tab -- i m better> What is inside the text box remove it and enter your location> Clear the text Add your surname