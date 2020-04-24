package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		try{
			prop=new Properties();
			FileInputStream ip= new FileInputStream("/Users/PRAMEET/workspace/FacebookSiteTest/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public static void initialization(){
		String browserName= prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","D:\\Prameet 2020\\Eclips STUFFS\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver","D:\\Prameet 2020\\Eclips STUFFS\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url")); 
	}
	}


