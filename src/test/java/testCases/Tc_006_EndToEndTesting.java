package testCases;



import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AccountRegistrationPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountpage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class Tc_006_EndToEndTesting extends BaseClass {

	@Test
	public void endtoendtesting() throws InterruptedException {
		
		SoftAssert sa = new SoftAssert();
		
		HomePage hp = new HomePage(driver);
		hp.clickRegister();
		
		AccountRegistrationPage ar = new AccountRegistrationPage(driver);
		
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
		
		sa.assertEquals(confresult, "Your registration completed", "Test Failed");
	
		hp.clicklogin();
		
		LoginPage lp = new LoginPage(driver);
		
		lp.settxtemail(rb.getString("email"));
		lp.settxtpassword(rb.getString("password"));
		lp.clickonloginbtn();
		
		MyAccountpage mp = new MyAccountpage(driver);
		boolean targetpage = mp.isMyaccountpagesExists();
		sa.assertEquals(targetpage, true, "invalid login details");
		
		mp.clickonlogout();
		
		hp.enterProductname("mac");
		
		hp.clickonsearchbtn();
		
		SearchPage sp = new SearchPage(driver);
		boolean targetpage1 = sp.isProductExist();
		sa.assertEquals(targetpage1, true, "product is not displayed");
		
		if(sp.isProductExist())
		{
			sp.clickonproduct();
			sp.setquantity("3");
			sp.clickonaddtocartbtn();
		}
		
		sa.assertEquals(sp.ckeckconfmsg(), true);
		
		Thread.sleep(10000);
		
		ShoppingCartPage scp = new ShoppingCartPage(driver);
		scp.clickonshopingcart();
		scp.clickongotocart();
		Thread.sleep(1000);
		
		scp.clickonestimateshopping();
		Thread.sleep(2000);
		scp.selectcountryname("India");
		scp.setpincode("123456");
		scp.selectstate("Other");
		scp.clickonshipmethod();
		scp.clickonapply();
		Thread.sleep(3000);	
		
		String beforetotalprice = scp.getbeforetotalprice();
		System.out.println(beforetotalprice);
		Thread.sleep(10000);
		
		scp.clickonagreecheckboxbtn();
		scp.clickoncheckout();
		scp.clickonbtn();
		
		CheckoutPage cp = new CheckoutPage(driver);
		Thread.sleep(3000);
		cp.setfirstname(randomString().toUpperCase());
		
		cp.setlastname(randomString().toUpperCase());
		
		cp.setemailid(randomString()+"@gmail.com");
		
		cp.setcountry("India");
		
		cp.setcity("Pune");
		
		cp.setadd1("Address 1");
		
		cp.setadd2("Address 2");
		
		cp.setpincode("234567");
		
		cp.setphoneno("1234567890");
		
		cp.clickoncontinue();
		
		cp.clickonshippingmth();
		
		cp.clickonconti2();
		Thread.sleep(5000);
		cp.clickonpaymentmth();
		Thread.sleep(5000);
		cp.clickonconti3();
		Thread.sleep(5000);
		cp.clickonconti4();
		Thread.sleep(5000);
		String totalprice = cp.gettotalprice();
		System.out.println(totalprice);
		sa.assertEquals(totalprice, "$5,400.00" );
		
	    cp.clickonconfbtn();
	    
	    Thread.sleep(3000);
	    
	    boolean orderconf = cp.isorderplaced();
	    System.out.println(orderconf);
	    sa.assertEquals(cp.isorderplaced(), true);
	    
	    sa.assertAll();
		
		
	}
}
