package pomskillrary;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseSkillraryPage {

	public static void main(String[] args) throws InterruptedException {
		WebDriver c=new ChromeDriver();
		c.manage().window().maximize();
		c.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		c.get("https://demoapp.skillrary.com/");
		
		LoginPage lp=new LoginPage();
		PageFactory.initElements(c, lp);
		lp.getLoginTxt().click();
		Thread.sleep(2000);
		lp.getEmailTf().sendKeys("Sanket");
		Thread.sleep(2000);
		c.navigate().refresh();
		Thread.sleep(2000);
		lp.getEmailTf().sendKeys("admin");
		
		Thread.sleep(7000);
		c.quit();

	}

}
