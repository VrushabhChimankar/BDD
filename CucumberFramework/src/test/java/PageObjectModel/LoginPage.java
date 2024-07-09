package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Email") WebElement email;
	@FindBy(id = "Password") WebElement pass;
	@FindBy(xpath = "//button[text()='Log in']") WebElement Loginbtn;
	@FindBy(linkText = "Logout") WebElement logout;
	
	public void EnterMail(String emailAdd) {
		
		email.clear();
		email.sendKeys(emailAdd);
	}
	
	public void EnterPass(String pwd) {
		pass.clear();
		pass.sendKeys(pwd);
	}
	
	public void ClickLogin() {
		Loginbtn.click();
	}
	
	public void ClickLogout() {
		logout.click();
	}
	
	
	
	
}
