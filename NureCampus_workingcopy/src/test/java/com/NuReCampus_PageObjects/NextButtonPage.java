package com.NuReCampus_PageObjects;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class NextButtonPage {

	@FindBy(xpath = "//div[@class='onboarding-process-footer justify-content-end']/button")
	private WebElement nextBtn;
	
	@FindBy(xpath = "//div[@class='onboarding-process-footer']/button[@class='next-btn ng-star-inserted']")
	private WebElement ConfignextBtn;
	
	@FindBy(xpath = "//div[@class='onboarding-process-footer justify-content-end']")
	private WebElement FullnextBtn;
	
	@FindBy(xpath = "//span[@class='primary']/nc-dynamic-text[text()=' Cofiguration Title ']")
	private WebElement CofigurationTitleTxt;
	@FindBy(xpath = "//span[@class='primary']/nc-dynamic-text[@type='message']")
	private WebElement configurationTxt;
	
	WebDriver driver;
	public NextButtonPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickNextButton() throws InterruptedException
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nextBtn.click();
	
		
	}
	public void validateConfigurationPage() {
		String pageheading = configurationTxt.getText();
		Assert.assertTrue(pageheading.contains("Cofiguration "));
		System.out.println("configuration fields load properly");
	}
	
	public void configNextButton()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(ConfignextBtn));
		ConfignextBtn.click();
	}
}
