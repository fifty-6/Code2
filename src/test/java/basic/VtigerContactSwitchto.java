package basic;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VtigerContactSwitchto {

	public static void main(String[] args) throws InterruptedException{
		WebDriver c=new ChromeDriver();
		c.manage().window().maximize();
		c.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		c.get("http://localhost:8888/");
		c.findElement(By.name("user_name")).sendKeys("admin");
		c.findElement(By.name("user_password")).sendKeys("root");
		c.findElement(By.id("submitButton")).click();
		
		c.findElement(By.xpath("//a[text()='Contacts']")).click();
		c.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
		c.findElement(By.name("lastname")).sendKeys("Sarkar");
		
		//Click on + icon on organization name
		c.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		
		//transfer the control from parent to child
		
		Set<String> ids= c.getWindowHandles();
		
		for(String s:ids)
		{
			String purl=c.switchTo().window(s).getCurrentUrl();
			System.out.println(purl);
		}
		Thread.sleep(2000);
		
//		Send Organization name
		c.findElement(By.id("search_txt")).sendKeys("halwa");
		
//		Click on Search NOW button
		c.findElement(By.name("search")).click();
		
		Thread.sleep(2000);
		c.findElement(By.xpath("//a[text()='Halwa1']")).click();
		
		for(String s:ids)
		{
			String child=c.switchTo().window(s).getCurrentUrl();
			String parent="http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing";
			
			if(child.contains(parent))
			{
				break;
			}
			
			
		}
		c.findElement(By.id("jscal_trigger_birthday")).click();
		
		

	}

}
