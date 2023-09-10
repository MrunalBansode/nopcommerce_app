package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountpage;
import testBase.BaseClass;
import utilities.Dataprovider;

public class Tc_003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = Dataprovider.class)
	public void test_loginddt(String email, String password, String exp)
	{
		 logger.info("**** Starting Tc_002_LoginTest ****");
		 
		try
		{
        
		HomePage hp = new HomePage(driver);
		hp.clicklogin();
		logger.info("Clicked on Login link");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.settxtemail(email);
		lp.settxtpassword(password);
		lp.clickonloginbtn();
		
		MyAccountpage AP = new MyAccountpage(driver);
		boolean targetpage = AP.isMyaccountpagesExists();
		
		if(exp.equals("Valid"))
		{
			if(targetpage==true)
			{
				AP.clickonlogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equals("Invalid"))
		{
			if(targetpage==true)
			{
				AP.clickonlogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("**** Finish Tc_002_LoginTest ****");
		
	}
	
}
