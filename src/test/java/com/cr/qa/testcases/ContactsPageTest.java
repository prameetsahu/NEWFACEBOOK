package com.cr.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utility.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactPage contactspage;
	String sheetName="Contacts";
   public ContactsPageTest(){
	   super();
   }
   @BeforeMethod
   public void setUp(){
 	  initialization();
 	  testutil=new TestUtil();
 	  loginpage=new LoginPage();
  	  contactspage=new ContactPage();
 	  homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
 	  testutil.switchToFrame();
 	  contactspage=homepage.clickOnContactsLink();
 	 
}
   
   @Test(priority=1)
   public void verifyContactPageLavelTest(){
	   Assert.assertTrue(contactspage.verifyContactLavel(),"Lavel not verified");
   }
   
   @Test(priority=2)
   public void selectContactTest(){
	   contactspage.selectContactsByName("Aakash Patel");
   }
   
   @DataProvider
   public Object[][] getCRMTestData(){
	  Object data[][]=TestUtil.getTestData(sheetName);
	  return data;
   }
   
   @Test(priority=3,dataProvider="getCRMTestData")
   public void CreateNewContactTest(String Title,String FirstName,String LastName, String Company){
	   homepage.clickOnContactsLink();
	  // contactspage.craeteNewContact("Mr.", "Ajay", "singh", "wipro");
	   contactspage.craeteNewContact(Title,FirstName,LastName,Company);
   }
   
   @AfterMethod
   public void tearDown(){
 	  driver.quit();
   }
}
