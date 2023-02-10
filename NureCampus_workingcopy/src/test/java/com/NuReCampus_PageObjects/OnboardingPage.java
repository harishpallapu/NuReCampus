package com.NuReCampus_PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;


public class OnboardingPage {

	public static WebDriver driver;

	@FindBy(xpath = "//div[@class='heading-area']/h1")
	private WebElement onBoardingTxt;
	
	@FindBy(xpath = "//table/tbody/tr/td[1]")
	private List<WebElement> tableElementList;
	
	@FindBy(xpath = "//table/tbody/tr/td[2]")
	private List<WebElement> tablePriceList;
	
	@FindBy(xpath = "//span[@class='primary']/nc-dynamic-text[@type='message']")
	private WebElement welcomeTxt;
	
	
	@FindBy(xpath = "//nc-dynamic-text[text()=' No Module Selected ']")
	private WebElement noModuleSelectMsg;
	
	@FindBy(xpath = "//tfoot/tr[1]/td[1]")
	private WebElement totalMsg;
	
	@FindBy(xpath = "//tfoot/tr[1]/td[2]")
	private WebElement totalPrice;
	
	@FindBy(xpath = "//p[text()='Please select atleast one Module']")
	private WebElement alertMsg;
	
	@FindBy(xpath = "//div[@class='module active']/h3")
    private List<WebElement> allModuleContentListTitle;
	@FindBy(xpath = "//nc-dynamic-text[text()=' Cofiguration Title ']")
	private WebElement configurationTitle;
	By Username=By.xpath("//input[@id='username']");
	By Password=By.xpath("//input[@type='password']");
	By loginbtn=By.cssSelector("button.blue-submit-btn");
	

	public OnboardingPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String geturl()
	{
		
		return driver.getCurrentUrl();
	}
	
	public void logincredentials(String username, String password) throws InterruptedException {		
		
		driver.findElement(Username).sendKeys(username);
		driver.findElement(Password).sendKeys(password);
		Boolean loginbuttonenabled= driver.findElement(By.cssSelector("button.blue-submit-btn")).isEnabled();
		Assert.assertTrue(loginbuttonenabled);
		driver.findElement(By.cssSelector("button.blue-submit-btn")).click();
		
		
	}
	
	public String getOnboardingName()
	{
		return onBoardingTxt.getText();
		
	}
	
	public String getWelcomeTxtName()
	{
		return welcomeTxt.getText();
		
	}
	
	public void validateElementList()
	{
		ArrayList<String> arr1 =new ArrayList<String>();
		for(WebElement ele : tableElementList)
		{
			arr1.add(ele.getText());
		}
		ArrayList<String> arr2 =new ArrayList<String>();
		
		arr2.add("HR Staff Information");
		arr2.add("Fees Management");
		arr2.add("Examination");
		arr2.add("Admissions Management");
		arr2.add("Academic Administration");
		Assert.assertTrue(arr1.equals(arr2));
		
	}
	public boolean validateSelectedMadule()
	{
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> arr1 =new ArrayList<String>();
		for(WebElement ele : tableElementList)
		{
			arr1.add(ele.getText());
		}
		ArrayList<String> arr2 =new ArrayList<String>();
		arr2.add("HR Staff Information");
		arr2.add("Fees Management");
		arr2.add("Examination");
		arr2.add("Admissions Management");
		arr2.add("Academic Administration");
		System.out.println(arr1);
		System.out.println(arr2);
		boolean flag=true;
		for(String str1: arr1)
		{
			if(!arr2.contains(str1))
			{
				flag=false;
			}
		}
		
		
	return flag;
	}
	
	public boolean validatePriceList()
	{
		ArrayList<String> arr3 =new ArrayList<String>();
		for(WebElement ele : tablePriceList)
		{
			arr3.add(ele.getText());
		}
		ArrayList<String> arr4 =new ArrayList<String>();
		arr4.add("3000");
		arr4.add("1000");
		arr4.add("2000");
		arr4.add("4000");
		arr4.add("5000");
		boolean flag=true;
		for(String str1: arr3)
		{
			if(!arr4.contains(str1))
			{
				flag=false;
			}
		}
		
		
	return flag;
	}
	
	public void validateNoModuleSelectMsg() {
		
		String msg = noModuleSelectMsg.getText();
		System.out.println(msg);
		Assert.assertTrue(msg.contains("No Module Selected"));
	}
	
	public String validateTotalMsg()
	{
		return totalMsg.getText();
		
	}
	
	public String validateTotalPrice()
	{
		return totalPrice.getText();
		
	
	}
		
		
	
	
	
	public String validateAlertMsg() {
		return alertMsg.getText();
		
	}
	
	/*public void validateConfigurationTitle() {
		return configurationTitle.getText();		
		
		Assert.assertTrue(title.contains("Cofiguration Title"));
		System.out.println("All fields load properly...");
	}*/
	
	public String validateOnBoardingPage() {
		//String welcm = welcomeTxt.getText();
		return welcomeTxt.getText();
		
		
	}
	
	public boolean validateOnboardingPageStaticContent()
    {

        ArrayList<String> arr1 =new ArrayList<String>();
        for(WebElement ele : allModuleContentListTitle)
        {
            arr1.add(ele.getText());
        }
        ArrayList<String> arr2 =new ArrayList<String>();
       // arr2.add("");
        arr2.add("Fees Management");
        arr2.add("Examination");
        arr2.add("HR Staff Information");
        arr2.add("Admissions Management");
        arr2.add("Academic Administration");
        System.out.println(arr1);
        System.out.println(arr2);
        boolean flag=true;
        for(String str1: arr1)
        {
            if(!arr2.contains(str1))
            {
                flag=false;
            }
        }

        return flag;
    }

    }
	


