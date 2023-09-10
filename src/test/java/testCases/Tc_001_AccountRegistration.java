package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;



import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class Tc_001_AccountRegistration extends BaseClass {

	@Test
	public void test_account_Registration()
	{
		logger.debug("application logs......");
		logger.info("**** Starting TC_001_AccountRegistrationTest ****");
		try
		{
		HomePage hp = new HomePage(driver);
		
		hp.clickRegister();
		logger.info("Clicked on Register");
		
		AccountRegistrationPage ar = new AccountRegistrationPage(driver);
		logger.info("providing customer data");
		
		ar.clickongenderbtn();
		
		ar.setfirstname(randomString().toUpperCase());
		
		ar.setlastname(randomString().toUpperCase());
		
		ar.setdate("2");
		
		ar.setmonth("May");
		
		ar.setyear("2000");
		
		ar.setemail(randomString()+"@gmail.com");
		
		String p = randomalphanumeric();
		ar.setpassword(p);
		ar.setconfpassword(p);
		
		ar.clickonresgiser();
		
		String confresult = ar.getresult();
		
		logger.info("validation expected result");
		
		Assert.assertEquals(confresult, "Your registration completed", "Test Failed");
		}
		catch(Exception e)
		{
			logger.error("Test Failed");
			Assert.fail();
		}
		
		logger.info("**** Finished TC_001_AccountRegistrationTest ****");
	}
}
