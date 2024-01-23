package basic;

//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IRCTC {

	public static void main(String[] args) throws InterruptedException, IOException, FileNotFoundException{
		WebDriver c=new ChromeDriver();
		c.manage().window().maximize();
		c.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		To READ Data from External File
//		FileInputStream fis=new FileInputStream(null);

	}

}
