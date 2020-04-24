package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'User: Demo User']")
	WebElement userNameLavel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
    WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
    WebElement newContactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
    WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
    WebElement tasksLink;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyUserLavelName(){
		return userNameLavel.isDisplayed();
	}
	
	public ContactPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactPage();
	}
	
	public DealPage clickOnDealsLink(){
		dealsLink.click();
		return new DealPage();
	}
	
	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContact(){
		Actions act=new Actions(driver);
		act.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
	}

}
