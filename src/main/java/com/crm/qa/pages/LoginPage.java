package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//page factory/object repository
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-small']")
	WebElement loginButton;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement sihnUpBtn;
	
	@FindBy(xpath="//a[@class='navbar-brand']/img[@class='img-responsive']")
	WebElement crmLogo;
	
	public LoginPage(){
		//How to initialize an element in pom
		//this means current class object
		PageFactory.initElements(driver, this);
	}
	//Action:
	public String loginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean  validateCRMImage(){
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
 
		return new HomePage();
}
	}
