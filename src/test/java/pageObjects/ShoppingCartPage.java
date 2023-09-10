package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage extends BasePage {

	public ShoppingCartPage(WebDriver driver) {
		super (driver);
	}
	
	@FindBy(xpath = "//span[@class='cart-label']") WebElement shopingcart;
	
	@FindBy(xpath = "//button[normalize-space()='Go to cart']") 
	WebElement gotocartbtn;
	
	@FindBy(xpath = "//a[@id='open-estimate-shipping-popup']") WebElement estimateshopping;
	
	@FindBy(id = "CountryId") WebElement selectcountry;
	
	@FindBy(id = "ZipPostalCode") WebElement pinco;
	
	@FindBy(id = "StateProvinceId") WebElement state;
	
	@FindBy(xpath = "//div[@class='estimate-shipping-row shipping-option active']//label")
	WebElement shipmth;
	
	@FindBy(xpath = "//button[normalize-space()='Apply']") WebElement apply;
	
	@FindBy(xpath = "//tr[@class='order-total']//td[@class='cart-total-right']")
	WebElement beforetotalprice;
	
	@FindBy(xpath = "//input[@id='termsofservice']") WebElement agreecheckboxbtn;
	
	@FindBy(xpath = "//button[@id='checkout']") WebElement checkoutbtn;
	
	@FindBy(xpath = "//button[normalize-space()='Checkout as Guest']")
	WebElement checkoutasguestbtn;
	
	public void clickonshopingcart() {
		shopingcart.click();
     }
	
	public void clickongotocart() {
		gotocartbtn.click();
	}
	
	public void clickonestimateshopping() {
		estimateshopping.click();
		
	}
	
	public void selectcountryname(String coun) {
		new Select(selectcountry).selectByVisibleText(coun);
	}
	
	public void setpincode(String pinno) {
		pinco.sendKeys(pinno);
	}
	
	public void selectstate(String st) {
		new Select(state).selectByVisibleText(st);
	}
	
	public void clickonshipmethod() {
		shipmth.click();
	}
	
	public void clickonapply() {
		apply.click();
	}
	
	public String getbeforetotalprice() {
		return beforetotalprice.getText();
	}
	
	public void clickonagreecheckboxbtn() {
		 agreecheckboxbtn.click();
	}
	
	public void clickoncheckout() {
		 checkoutbtn.click();
	}
	
	public void clickonbtn() {
		checkoutasguestbtn.click();
	}
	
}
