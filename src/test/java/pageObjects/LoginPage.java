package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super (driver);
	}
	
	@FindBy(xpath = "//input[@id='Email']") WebElement txtemail;
	
	@FindBy(xpath = "//input[@id='Password']") WebElement txtpassword;
	
	@FindBy(xpath = "//button[normalize-space()='Log in']") WebElement loginbtn;
	
	public void settxtemail(String email) {
		txtemail.sendKeys(email);
	}
	
	public void settxtpassword(String password) {
		txtpassword.sendKeys(password);
	}
	
	public void clickonloginbtn() {
		loginbtn.click();
	}
}
