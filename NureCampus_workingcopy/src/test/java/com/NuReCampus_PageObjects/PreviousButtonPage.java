package com.NuReCampus_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class PreviousButtonPage {

	@FindBy(xpath = "//div[@class='onboarding-process-footer']/button[@class='prev-btn ng-star-inserted']")
	private WebElement PreviousBtn;
	
	@FindBy(xpath = "//button[@class='prev-btn ng-star-inserted']")
	private WebElement previousConfigButton;
	
	@FindBy(xpath = "//div[@class='onboarding-process-footer']/button[@class='prev-btn ng-star-inserted']")
	private WebElement configPreviousBtn;
	
	@FindBy(xpath = "//span[@class='primary']/nc-dynamic-text[@type='message']")
	private WebElement welcomeTxt;
	
	public PreviousButtonPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickPreviousButton()
	{
		PreviousBtn.click();
		//JavaClassUtility.waitUntilElementVisible(welcomeTxt);
	}
	public void configPreviousButton()
	{
		configPreviousBtn.click();
		
		
	}
	
}
