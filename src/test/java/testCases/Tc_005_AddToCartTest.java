package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class Tc_005_AddToCartTest extends BaseClass {

	@Test
	public void addtocart_test() {
		logger.info("Starting Tc_005_AddtocartTest");
		
		try
		{
			HomePage hp = new HomePage(driver);
			hp.enterProductname("mac");
			hp.clickonsearchbtn();
			
			SearchPage sp = new SearchPage(driver);
			if(sp.isProductExist())
			{
				sp.clickonproduct();
				sp.setquantity("3");
				sp.clickonaddtocartbtn();
			}
			
			Assert.assertEquals(sp.ckeckconfmsg(), true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("Starting Tc_005_AddtocartTest");
	}
}
