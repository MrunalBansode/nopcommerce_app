package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
	
	public SearchPage(WebDriver driver) {
		super (driver);
	}

	@FindBy (linkText = "Apple MacBook Pro 13-inch")
	WebElement searchproduct;
	
	@FindBy(xpath = "//input[@id='product_enteredQuantity_4']")
	WebElement quantity;
	
	@FindBy(xpath = "//button[@id='add-to-cart-button-4']")
	WebElement addtocartbtn;
	
	@FindBy(xpath = "//p[@class='content']") WebElement confmsg;
	
	
	 
	public boolean isProductExist() {
		
		try
		{
			return(searchproduct.isDisplayed());
		}
		catch(Exception e)
		{
			return(false);
		}
		
	}
	
	public void clickonproduct() {
		searchproduct.click();
		}
	
	public void setquantity(String qty) {
		quantity.clear();
		quantity.sendKeys(qty);
	}
	
	public void clickonaddtocartbtn() {
		addtocartbtn.click();
	}
	
	public boolean ckeckconfmsg() {
	    try
	    {
	    	return confmsg.isDisplayed();
	    }
	    catch(Exception e) {
	    	return false;
	    }
	}
	
	
}
