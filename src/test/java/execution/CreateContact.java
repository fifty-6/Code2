package execution;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContact {

	public static void main(String[] args) throws InterruptedException{
		WebDriver c=new ChromeDriver();
		c.manage().window().maximize();
		c.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		c.get("https://demo.vtiger.com/vtigercrm/index.php");
		c.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(2000);
		c.findElement(By.xpath("(//span[@class='app-icon fa fa-bars'])[1]")).click();
		Thread.sleep(2000);
		WebElement marketing=c.findElement(By.xpath("//span[text()=' MARKETING']"));
		Actions a=new Actions(c);
		Thread.sleep(2000);
		a.moveToElement(marketing).perform();
		Thread.sleep(2000);
		c.findElement(By.xpath("(//span[text()=' Contacts'])[1]")).click();
		Thread.sleep(2000);
		c.findElement(By.id("Contacts_listView_basicAction_LBL_ADD_RECORD")).click();
		Thread.sleep(2000);
		c.findElement(By.id("Contacts_editView_fieldName_lastname")).sendKeys("Sarkar");
		Thread.sleep(2000);
		c.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(3000);
		c.findElement(By.xpath("//span[@title='Vtiger Demo Administrator(admin)']")).click();
		Thread.sleep(2000);
		c.findElement(By.xpath("//a[text()='Sign Out']")).click();
		Thread.sleep(7000);
		c.quit();
		

	}

}
