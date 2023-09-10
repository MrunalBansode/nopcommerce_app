package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountpage extends BasePage{

	public MyAccountpage(WebDriver driver) {
		super (driver);
	}
	
	@FindBy(xpath = "//a[@class='ico-account']") WebElement myaccount;
	
	@FindBy(xpath = "//a[normalize-space()='Log out']") WebElement logout;
	
	public boolean isMyaccountpagesExists() {
		try
		{
			return(myaccount.isDisplayed());
		}
		catch(Exception e)
		{
			return(false);
		}
	}
	
	public void clickonlogout() {
		logout.click();
	}
}
