package basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Vtiger {

	public static void main(String[] args) throws IOException {
		WebDriver c=new ChromeDriver();
		c.manage().window().maximize();
		c.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
//		TO READ DATA FROM EXTERNAL FILE
		FileInputStream fis= new FileInputStream("src\\test\\resources\\data1.properties");
		
//		Step 2: TO READ DATA FROM PROPERTY FILE
		Properties p=new Properties();
		
//		Step 3:TO FETCH THE LOCATION OF PROPERTY FILE
		p.load(fis);
		
//		Step 4:LOAD(READ) ALL THE KEYS PRESENT IN THE PROPERTY FILE
		String URL=p.getProperty("urlSkillrary");
		String USERNAME=p.getProperty("email");
		String PASSWORD=p.getProperty("pass");
		
//		Step 5:
		c.get(URL);
		
//		Step 6:
		c.findElement(By.linkText("LOGIN")).click();
		c.findElement(By.id("email")).sendKeys(USERNAME);
		c.findElement(By.id("password")).sendKeys(PASSWORD);
		c.findElement(By.id("last")).click();
		
		
	}

}
