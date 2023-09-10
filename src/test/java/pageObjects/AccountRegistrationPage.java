package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver) 
	{
		super (driver);
	}
	
	@FindBy(id = "gender-female") WebElement gender;
	@FindBy(name = "FirstName") WebElement firstname;
	@FindBy(name = "LastName") WebElement lastname;
	@FindBy(xpath = "//select[@name='DateOfBirthDay']") WebElement drpdate;
	@FindBy(xpath = "//select[@name = 'DateOfBirthMonth']") WebElement drpmonth;
	@FindBy(xpath = "//select[@name = 'DateOfBirthYear']") WebElement drpyear;
	@FindBy(name = "Email") WebElement email;
	@FindBy(name = "Password") WebElement password;
	@FindBy(name = "ConfirmPassword") WebElement confpassword;
	@FindBy(name = "register-button") WebElement registerbtn;
	@FindBy(xpath = "//div[@class='result']") WebElement result;
	
	public void clickongenderbtn(){
		gender.click();
	}
	public void setfirstname(String fname) {
		firstname.sendKeys(fname);
	}
	
	public void setlastname(String lname) {
		lastname.sendKeys(lname);
	}
	
	public void setdate(String date) {
		new Select(drpdate).selectByVisibleText(date);
	}
	
	public void setmonth(String month) {
		new Select(drpmonth).selectByVisibleText(month);
	}
	
	public void setyear(String year) {
		new Select(drpyear).selectByVisibleText(year);
	}
	
	public void setemail(String Email) {
		email.sendKeys(Email);
	}
	
	public void setpassword(String Pass) {
		password.sendKeys(Pass);
	}
	
	public void setconfpassword(String confpass) {
		confpassword.sendKeys(confpass);
	}
	
	public void clickonresgiser() {
		registerbtn.click();
	}
	
	public String getresult() {
		try
		{
			return (result.getText());
		}
		catch(Exception e) {
			return (e.getMessage());
		}
	}
}
