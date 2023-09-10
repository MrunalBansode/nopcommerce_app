package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {

	public CheckoutPage(WebDriver driver) {
		super (driver);
	}
	
	@FindBy(id = "BillingNewAddress_FirstName") WebElement firstname;
	
	@FindBy(id = "BillingNewAddress_LastName") WebElement lastname;
	
	@FindBy(id = "BillingNewAddress_Email") WebElement emailadd ;
	
	@FindBy(xpath = "//select[@id='BillingNewAddress_CountryId']") 
	WebElement drpcountry ;
	
	@FindBy(id = "BillingNewAddress_City") WebElement city;
	
	@FindBy(id = "BillingNewAddress_Address1") WebElement add1;
	
	@FindBy(id = "BillingNewAddress_Address2") WebElement add2;
	
	@FindBy(id = "BillingNewAddress_ZipPostalCode") WebElement pincode;
	
	@FindBy(id = "BillingNewAddress_PhoneNumber") WebElement phoneno;
	
	@FindBy(xpath = "//button[@onclick='Billing.save()']") 
	WebElement continuebtn ;
	
	@FindBy(id = "shippingoption_1") WebElement sheppingmethod;
	
	@FindBy(xpath = "//button[@class='button-1 shipping-method-next-step-button']")
	WebElement continue2 ;
	
	@FindBy(xpath = "//input[@id='paymentmethod_0']") WebElement paymentmthod ;
	
	@FindBy(xpath = "//button[@class='button-1 payment-method-next-step-button']")
	WebElement continue3;
	
	@FindBy(xpath = "//button[@class='button-1 payment-info-next-step-button']")
	WebElement continue4;
	
	@FindBy(xpath = "$(\"tr[class='order-total'] td[class='cart-total-right']\")")
	WebElement totalprice;
	
	@FindBy(xpath = "//button[normalize-space()='Confirm']") WebElement confbtn;
	
	@FindBy(xpath = "//div[@class='section order-completed']//div[@class='title']")
	WebElement confmsg;
	
	//
	
	public void setfirstname(String Fname) {
		firstname.sendKeys(Fname);
	}
	
	public void setlastname(String Lname) {
		lastname.sendKeys(Lname);
	}
	
	public void setemailid(String emailid) {
		emailadd.sendKeys(emailid);
	}
	
	public void setcountry(String Country) {
		new Select(drpcountry).selectByVisibleText(Country);
	}
	
	public void setcity(String City) {
		city.sendKeys(City);
	}
	
	public void setadd1(String add) {
		add1.sendKeys(add);
	}
	
	public void setadd2(String add1) {
		add2.sendKeys(add1);
	}
	
	public void setpincode(String pin) {
		pincode.sendKeys(pin);
	}
	
	public void setphoneno(String pno) {
		phoneno.sendKeys(pno);
	}
	
	public void clickoncontinue() {
		continuebtn.click();
	}
	
	public void clickonshippingmth() {
		sheppingmethod.click();
	}
	
	public void clickonconti2() {
		continue2.click();
	}
	
	public void clickonpaymentmth() {
		paymentmthod.click();
	}
	
	public void clickonconti3() {
		continue3.click();
	}
	
	public void clickonconti4() {
		continue4.click();
	}
	
	public String gettotalprice() {
		return totalprice.getText();
	}
	
	public void clickonconfbtn() {
		confbtn.click();
	}
	
	public boolean isorderplaced() {
		if(confmsg.getText().equals("Your order has been successfully processed!")) 
		{	
			return true;
		}
		else 
		{
			return false;
		}
	}
}
