package pomskillrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy(xpath="//a[text()='LOGIN']")
	private WebElement LoginTxt;

	public WebElement getLoginTxt() {
		return LoginTxt;
	}
	
	@FindBy(id="email")
	private WebElement EmailTf;

	public WebElement getEmailTf() {
		return EmailTf;
	}
	
	
	
}
