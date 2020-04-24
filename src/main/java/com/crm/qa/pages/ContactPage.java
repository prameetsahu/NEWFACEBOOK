package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactLbel;
	
	@FindBy(id="first_name")
	WebElement first_Name;
	
	@FindBy(id="surname")
	WebElement last_Name;
	
	@FindBy(name="client_lookup")
	WebElement companyName;
	
	@FindBy(xpath="//td[@align='center']/input[2]")
	WebElement saveBtn;
	

	public ContactPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactLavel(){
		return contactLbel.isDisplayed();
		
	}
	
	////a[text()='aaa '] //parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']
	public void selectContactsByName(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"'] //parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow'] //input[@name='contact_id']")).click();
		
	
	}
	
	public void craeteNewContact(String title, String fName,String lName,String cmpny){
		WebElement dropdown=driver.findElement(By.name("title"));
		Select sel=new Select(dropdown);
		sel.selectByVisibleText(title);
		first_Name.sendKeys(fName);
		last_Name.sendKeys(lName);
		companyName.sendKeys(cmpny);
		saveBtn.click();
		
}}
