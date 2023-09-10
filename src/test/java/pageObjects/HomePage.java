package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver)
	{
		super (driver);
	}
	
	@FindBy(className = "ico-register") WebElement Register;
	
	@FindBy(xpath = "//a[normalize-space()='Log in']") WebElement Login;
	
	@FindBy(id = "small-searchterms") WebElement search;
	
	@FindBy(xpath = "//button[normalize-space()='Search']") WebElement searchbtn;
	
	public void clickRegister() {
		Register.click();
	}
	
	public void clicklogin() {
		Login.click();
	}
	
	public void enterProductname(String pname) {
		search.sendKeys(pname);
	}
	
	public void clickonsearchbtn() {
		searchbtn.click();
	}
}
