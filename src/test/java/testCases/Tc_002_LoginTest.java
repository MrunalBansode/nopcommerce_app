package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountpage;
import testBase.BaseClass;

public class Tc_002_LoginTest extends BaseClass{

	@Test
	public void test_login() {
		try
		{
			logger.info("*****Starting Tc_002_LoginTest******");
			
			HomePage hp = new HomePage(driver);
			hp.clicklogin();
			logger.info("Clicked on login link");
			
			LoginPage lp = new LoginPage(driver);
			logger.info("Providing login details");
			
			lp.settxtemail(rb.getString("email"));
			lp.settxtpassword(rb.getString("password"));
			lp.clickonloginbtn();
			
			logger.info("clicked on login button");
			
			MyAccountpage mp = new MyAccountpage(driver);
			boolean targetpage = mp.isMyaccountpagesExists();
			Assert.assertEquals(targetpage, true, "invalid login details");
			
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***Finished Tc_002_LoginTest***");
	}
}
