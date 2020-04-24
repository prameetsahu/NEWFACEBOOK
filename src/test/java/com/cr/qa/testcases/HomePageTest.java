package com.cr.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utility.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactPage contactspage;
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
    public void setUp(){
  	  initialization();
  	  testutil=new TestUtil();
  	  loginpage=new LoginPage();
   	  contactspage=new ContactPage();
  	  homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
  	  
} 
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePagetTitle=homepage.verifyHomePageTitle();
		Assert.assertEquals(homePagetTitle, "CRMPRO", "Home page title not matched");
	}

	/*@Test(priority=2)
	public void verifyUserNameTest(){
		testutil.switchToFrame();
		Assert.assertTrue(homepage.verifyUserLavelName());
		
	}*/
	@Test(priority=2)
	public void verifyContactsLinkTest(){
		testutil.switchToFrame();
		contactspage=homepage.clickOnContactsLink();
	}
	
	 @AfterMethod
     public void tearDown(){
   	  driver.quit();
     }
}
