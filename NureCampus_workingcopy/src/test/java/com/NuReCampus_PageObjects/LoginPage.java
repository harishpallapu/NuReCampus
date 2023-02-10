package com.NuReCampus_PageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;


public class LoginPage{
public WebDriver driver;



	  
	//String useName="sayyed.shahin@3i-infotech.com";
	//String passWord="info@1234";
	
	
	
	//String loginButton="Login";
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
		
	}
	
	
	By Username=By.xpath("//input[@id='username']");
	By Password=By.xpath("//input[@type='password']");
	By loginbtn=By.cssSelector("button.blue-submit-btn");
	By usernameContent=By.xpath("//*[text()=' Username ']");
	By PasswordContent=By.xpath("//nc-dynamic-text[text()=' Password  ']");
	By invalidCredentialsmsg=By.xpath("//p[text()='Invalid Credentials']");
	By forgotPassWord=By.xpath("//nc-dynamic-text[@alt='Forgot Password?']");
	By loginbtnContent=By.xpath("//nc-dynamic-text[text()='  Login          ']");
	By logoutbtn=By.xpath("//img[@src='assets/img/Signout-ico.svg']");
	//By profileicon=By.cssSelector(".user-profile");
	By profileicon=By.xpath("//div[@class='user-profile']");
	
	
	public boolean verifyusernamecontent() throws InterruptedException {		
	
		return driver.findElement(usernameContent).isDisplayed();
		
		
		
		
		 
		
		
		
	}
	
	public boolean verifyPasswordContent() throws InterruptedException {		
		/*
		String passwordfilledlabel=driver.findElement(PasswordContent).getText();
		return passwordfilledlabel;
	*/
		return driver.findElement(PasswordContent).isDisplayed();
		
		
	}
public boolean verifyForgotPassWord() throws InterruptedException {		
		
		/*
		String forgotPassWordfieldlabel=driver.findElement(forgotPassWord).getText();
		return forgotPassWordfieldlabel	;*/
	return driver.findElement(forgotPassWord).isDisplayed();
		
	}
public boolean nureCampusLoginbutton() throws InterruptedException {		
	
	
	/*
	String loginbutonlabel=driver.findElement(loginbtnContent).getText();
	return loginbutonlabel;*/
	
	
	return driver.findElement(loginbtnContent).isDisplayed();
	
}
	
	
	
	
	
	public void logincredentials(String username, String password) throws InterruptedException {		
	
		driver.findElement(Username).sendKeys(username);
		driver.findElement(Password).sendKeys(password);
		Boolean loginbuttonenabled= driver.findElement(By.cssSelector("button.blue-submit-btn")).isEnabled();
		Assert.assertTrue(loginbuttonenabled);
		driver.findElement(By.cssSelector("button.blue-submit-btn")).click();
		
		
	}
	

	  public String landingpageurl(){
	    	
		 return driver.findElement(By.xpath("//p[text()='Invalid username or password']")).getText();
	    
	    
		
		}
	  
	  public void clickprofileicon()
	  
	  {
		  driver.findElement(profileicon).click();
		  
	  }
	  public void clicklogoutbutton() {
		  
		  driver.findElement(logoutbtn).click();
	  }
	
	  
}
 
	




	



	
	
	
	
	
