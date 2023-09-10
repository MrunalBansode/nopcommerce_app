package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class Tc_004_SearchProductTest extends BaseClass{
	@Test
	public void test_productSearch() {
		logger.info("Starting Tc_004_SearchProductTest");
		
		try {
			HomePage hp = new HomePage(driver);
			hp.enterProductname("mac");
			
			hp.clickonsearchbtn();
			
			SearchPage sp = new SearchPage(driver);
			boolean targetpage = sp.isProductExist();
			Assert.assertEquals(targetpage, true, "product is not displayed");
			Thread.sleep(4000);			
		}
		catch (Exception e)
		{
			Assert.fail();
		}
		
		logger.info("Finishing Tc_004_SearchProductTest");
	}
}
