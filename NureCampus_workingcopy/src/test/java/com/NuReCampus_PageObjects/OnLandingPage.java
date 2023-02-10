package com.NuReCampus_PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OnLandingPage {
	public static String URL = "https://erp.campuslabs.in/qa/register";
	
    public static WebDriver driver;
    
	public OnLandingPage(WebDriver driver) {
		
		this.driver = driver;
	
	}

	
	
	By getStartedForFree=By.xpath("//div/button[1]/span");
	By contactUsForDemo=By.xpath("//div/button[2]/span");
	By landingpagetxtMsg=By.xpath("//h1[@class='main-heading-landing']");
	By landingPageLogoicon=By.xpath("//img[@src='assets/img/Logo-hybrid-whiteblue.svg']");
	

	/*
	@FindBy(xpath = "//span[text()='Get Started for Free']")
	private WebElement btn_getStartedForFree;

	@FindBy(xpath = "//span[text()='Contact Us for Demo']" )
	private WebElement btn_contactUsForDemo;

	@FindBy(xpath = "//h1[text()=' Truly Made in India ERP for Education System to Organize, Manage and Unify Your Academic Institution ']")
	private WebElement txt_landingpagetxtMsg;
	
	@FindBy(xpath = "//img[@src='assets/img/Logo-hybrid-whiteblue.svg']")
	private WebElement txt_landingPageLogoicon;
*/


	
	public String  verifyCampusLandingContent() throws InterruptedException {
		
		Thread.sleep(3000);
		return driver.findElement(landingpagetxtMsg).getText();		
		
	}
	
	public String verifyGetStartedForFree() throws InterruptedException
	{
		
		
		return driver.findElement(getStartedForFree).getText();
		
	
	}
	
	
	public String verifyContactUsForDemo() throws Throwable 
	{
		
		
		return driver.findElement(contactUsForDemo).getText();
		
	}
	
	
	public boolean verifyLogoInlanding() {
		
		
		return driver.findElement(landingPageLogoicon).isDisplayed();
		
		//logger.info("User verify landing page logo successfully");
		
	}


	//validate to registration page url 
	public String clickGetStartedForFree() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(getStartedForFree).click();		
		return driver.getCurrentUrl();
		
		
		

	}

	
	public void clickContactUsForDemo() {
		//btn_contactUsForDemo.click();
       //In development stage this is functionality 
	}
	
	public String gettitleofthepage()
	{
		
		return driver.getTitle();
	}
}