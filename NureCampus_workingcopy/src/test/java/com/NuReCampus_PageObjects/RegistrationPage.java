package com.NuReCampus_PageObjects;

import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.ReusableTestUtilities;


public class RegistrationPage extends ReusableTestUtilities{
	
    public static WebDriver driver;
    boolean loginbuttonenabled;
    String mobilealertmessage="An account with this mobile number is already registered. Please use another mobile number to create your account.";
    String emailalertmessage="An account with this email is already registered. Please use another email to create your account.";
    
    String insititueurlalertmsg="Already Exists!";
    
	public RegistrationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	
	}
	 String FullName="Full Name";
	   String Email="Email Id";
	   String phoneNumber1="Phone Number";
	   String InstitutionName="Institution Name";
	   String instituteUrlContent="URL";
	   String titleRegistration="Just few clicks away from creating your Institution";
	   String domainRegistrationContent=".nurecampus.com";
		String phoneNumbercontent="Phone Number";
		String registrationNurecampusTtile="Welcome to"; 
	
	By logoRegistrationForm=By.xpath("//img[@src='assets/img/Logo-white.svg']");
	//By titleInRegistrationForm=By.xpath("//nc-dynamic-text[text()=' Just few clicks away from creating your Institution ']");
	By titleInRegistrationForm=By.cssSelector("nc-dynamic-text[key='registerTitle']");           
	By registrationNureCampusTitle=By.xpath("//nc-dynamic-text[text()='  Welcome to  ']");
	By msgInregistrationform=By.xpath("//nc-dynamic-text[text()=' Please fill in the below details to create your account for free ']");
	By fullNameInRegistration=By.xpath("//nc-dynamic-text[text()=' Full Name ']");
	By emailidInRegistration=By.xpath("//nc-dynamic-text[text()=' Email Id ']");
	By phonenumInRegistration=By.xpath("//nc-dynamic-text[text()=' Phone Number   ']");
	By instituteNameInRegistration=By.xpath("//nc-dynamic-text[text()='  Institution Name  ']");
	
	By urlInRegistration=By.xpath("//nc-dynamic-text[text()=' URL  ']");
	By domainRegistration=By.xpath("//span[text()=' .nurecampus.com']");
	//By invalidmobilenumerrormsg=By.xpath("//div[text()='Invalid Mobile Number')]");
	By errormessageintextfield=By.cssSelector("div[class='ng-star-inserted']");
	
	
	By fullname=By.xpath("//input[@id='fullName']");
	By email=By.xpath("//input[@id='email']");
	By phone=By.xpath("//input[@id='phone']");
	By instituename=By.xpath("//input[@id='nameOfYourInstitution']");
	By institueurl=By.xpath("//input[@id='instituteUrl']");
	//By tickmarkforURL=By.cssSelector("div.group-success");
	//div.full-width.text-center.submit-btn-register
	By tickmarkforURL=By.cssSelector("div.full-width.text-center.submit-btn-register");
	//By createaccountbutton=By.xpath("//button[@type='submit']");
	By createaccountbutton=By.xpath("//nc-dynamic-text[@alt='Create My Account']");
	By Successmesaaga=By.cssSelector("h4.success-msg");
	By mobilealreadyexists=By.xpath("//p[@class='m-0']");
	By emailalreadyexists=By.xpath("//p[@class='m-0']");
	By emailidexistsmsg=By.xpath("//p[contains(text(),'Email already exists')]");
	By institueurlexistsmsg=By.xpath("//div[contains(text(),'The URL')]");
	By Termsandconditionscheckbox=By.xpath("//div[@class='p-checkbox-box']");
	
	public String getemailattribute()
	{
		return driver.findElement(email).getAttribute("value");
		
		
	}
	
	
	public void verifyRegistrationFormContent() throws InterruptedException {
        
    	
    	Thread.sleep(5000);
    	 boolean Registrationpagelogo=driver.findElement(logoRegistrationForm).isDisplayed();
		 Assert.assertTrue(Registrationpagelogo);
		 
		
		
		 Thread.sleep(2000);
		 String titleRegistrationformpage=driver.findElement(titleInRegistrationForm).getText();
		 Assert.assertEquals(titleRegistration, titleRegistrationformpage);
		 //System.out.println(titleRegistrationformpage);
		 
		 Thread.sleep(2000);
		 String  registrationpageTitle=driver.findElement(registrationNureCampusTitle).getText();
		 Assert.assertEquals(registrationNurecampusTtile, registrationpageTitle);
		 //System.out.println(registrationpageTitle);
		 Thread.sleep(3000);
		 
		 Thread.sleep(2000);
		 String msgRegistrationForm=driver.findElement(msgInregistrationform).getText();
		 //System.out.println(msgRegistrationForm);
		 
		 Thread.sleep(3000);
		//Vaidate Fullname Field
		 String FullNameRegistration=driver.findElement(fullNameInRegistration).getText();
		 Assert.assertEquals(FullName, FullNameRegistration);
		 //System.out.println(FullNameRegistration);
		 
		 Thread.sleep(2000);
		 //Vaidate Email Field
		 String emailRegistration=driver.findElement(emailidInRegistration).getText();
		 Assert.assertEquals(Email, emailRegistration);
		 //System.out.println(emailRegistration);
		 
		 Thread.sleep(3000);
		//Vaidate phoneNumber Field
		 String phoneNumberRegistration=driver.findElement(phonenumInRegistration).getText();
		 Assert.assertEquals(phoneNumbercontent, phoneNumberRegistration);
		 //System.out.println(phoneNumberRegistration); 
		 
		 Thread.sleep(2000);
		//Vaidate InstituteName Field
		 String instituteNameRegistration=driver.findElement(instituteNameInRegistration).getText();
		 Assert.assertEquals(InstitutionName, instituteNameRegistration);
		 //System.out.println(instituteNameRegistration);
		 
		 Thread.sleep(2000);
		//Vaidate InstituteURL Field
		 String instituteUrlRegistration=driver.findElement(urlInRegistration).getText();
		 Assert.assertEquals(instituteUrlContent, instituteUrlRegistration);
		 //System.out.println(instituteUrlRegistration);
		 
		 Thread.sleep(2000);
		 //domain url registration
		 String urlDomailRegistration=driver.findElement(domainRegistration).getText();
		 Assert.assertEquals(domainRegistrationContent, urlDomailRegistration);
		 //System.out.println(urlDomailRegistration);
		 windowsscrollfordropdwown();
    	
    }
	
	
	public void enterRegistrationDetails(String fullName, String emailId,String phNum, String instituteName,String url) throws InterruptedException
	{ 
		Random r = new Random();
		int num = r.nextInt(10);
		driver.findElement(fullname).sendKeys(fullName+num);
		//fullNameTb.sendKeys(fullName+num);
		String[] str = emailId.split("@");
		String updateMail = str[0] + num + "@" + str[1];
		driver.findElement(email).sendKeys(updateMail);		
		driver.findElement(phone).sendKeys(phNum);		
		driver.findElement(instituename).sendKeys(instituteName);
		driver.findElement(institueurl).sendKeys(url+num);
		driver.findElement(tickmarkforURL).click();
		windowsscrollfordropdwown();
		
	
		Thread.sleep(15000);
		loginbuttonenabled = driver.findElement(createaccountbutton).isEnabled();
		
		Thread.sleep(8000);
	}
	
	public void termsandconditionscheck()
	{
	driver.findElement(Termsandconditionscheckbox).click();
	}
	
public boolean createmyaccountbuttonisnotenabled() {
	boolean flag=true;
	
	try {
		driver.findElement(createaccountbutton).click();
		
		
		
	}catch(NoSuchElementException e)
	 {
		
		System.out.println("create my account is enabled");
		 flag=false;
	}
	return flag;
}
	
	public void validationRegistrationformdetailsField(String dataflag) throws InterruptedException {
		
    	
    	if(dataflag.contains("Valid")) {
    		//Thread.sleep(2000);
    		boolean enabledsign=driver.findElement(By.xpath("//*[@src='assets/img/tick.svg']")).isEnabled();
    		//System.out.println("registration form text box field is enabled");
    		Thread.sleep(2000);
    		termsandconditionscheck();
    		Assert.assertTrue(loginbuttonenabled);	 
    		driver.findElement(createaccountbutton).click();	
    	}
    	if(dataflag.contains("withoutcheckbox")) {
    		//Thread.sleep(2000);
    		boolean enabledsign=driver.findElement(By.xpath("//*[@src='assets/img/tick.svg']")).isEnabled();
    		//System.out.println("registration form text box field is enabled");
    		Thread.sleep(2000);    
    		Assert.assertTrue(createmyaccountbuttonisnotenabled());	
    	}
    	
    	else if(dataflag.contains("Invalid Phonenumber")) {
    		Thread.sleep(2000);
    		//String errorMsgInvalidtxt= driver.findElement(By.xpath("//input-error-section/div/div")).getText();
    		
    		String errorMsgInvalidtxt= driver.findElement(errormessageintextfield).getText(); 
    		termsandconditionscheck();
    		//System.out.println(errorMsgInvalidtxt);
    		Assert.assertTrue(createmyaccountbuttonisnotenabled());
    	}
    	
    	else if(dataflag.contains("Invalid fullname length") && dataflag.contains("Invalid institutename length")) {
    		Thread.sleep(2000);
    		//String errorMsgInvalidtxt= driver.findElement(By.xpath("//input-error-section/div/div")).getText();
    		
    		String errorMsgInvalidtxt= driver.findElement(By.xpath("//div[text()=' Minimum length should be 3 ']")).getText();
    		termsandconditionscheck();
    		System.out.println(errorMsgInvalidtxt);
    		Assert.assertTrue(!loginbuttonenabled);
    	}	
    	
    	else if(dataflag.contains("Invalid fullname specialchars") && dataflag.contains("Invalid institutename specialchars")) {
    		Thread.sleep(2000);
    		//String errorMsgInvalidtxt= driver.findElement(By.xpath("//input-error-section/div/div")).getText();
    		
    		String errorMsgInvalidcharacters= driver.findElement(By.xpath("//div[contains(text(),'Entered ')]")).getText();
    		termsandconditionscheck();
    		System.out.println(errorMsgInvalidcharacters);
    		
    		Assert.assertTrue(!loginbuttonenabled);
    	
	} 
    	
    	//Invalid email
    	else if(dataflag.contains("Invalid_email")) {
    		Thread.sleep(2000);

    		//String errorMsgInvalidtxt= driver.findElement(By.xpath("//input-error-section/div/div")).getText();
    		String errorMsgInvalidtxt= driver.findElement(errormessageintextfield).getText();
    		termsandconditionscheck();
    		System.out.println(errorMsgInvalidtxt);
    		Assert.assertTrue(createmyaccountbuttonisnotenabled());
    	}    	
    	
    	else if(dataflag.contains("missing_in_institutionname") && dataflag.contains("missing_in_emailaddress")
    			&& dataflag.contains("missing_in_fullname") && dataflag.contains("missing_in_mobile")) {
    		Thread.sleep(2000);
    		termsandconditionscheck();
    		//String errorMsgInvalidtxt= driver.findElement(By.xpath("//input-error-section/div/div")).getText();
    		Assert.assertTrue(!loginbuttonenabled);
    	}    	
    	
    		
    	
	}
	
	
	public String validateRegistrationSuccessMsg() {
		return driver.findElement(Successmesaaga).getText();
				
				//.contains(" Thank you for submitting the information.Your URL creation process is started. We’ll revert within 48 hours."));
	}
	
	public String geturl()
	{
		
		return driver.getCurrentUrl();
	}
	
	public void enterRegistrationDetail(String fullName, String emailId,String phNum, String instituteName,String url,String dataflag) throws InterruptedException
	{ 
		//Random r = new Random();
		//int num = r.nextInt(10);
		driver.findElement(fullname).sendKeys(fullName);
		//fullNameTb.sendKeys(fullName+num);
		//String[] str = emailId.split("@");
		//String updateMail = str[0] + num + "@" + str[1];
		driver.findElement(email).sendKeys(emailId);		
		driver.findElement(phone).sendKeys(phNum);		
		driver.findElement(instituename).sendKeys(instituteName);
		driver.findElement(institueurl).sendKeys(url);
		driver.findElement(tickmarkforURL).click();
		Thread.sleep(15000);
		loginbuttonenabled = driver.findElement(createaccountbutton).isEnabled();
		boolean enabledsign=driver.findElement(By.xpath("//*[@src='assets/img/tick.svg']")).isEnabled();
		windowsscrollfordropdwown();
		termsandconditionscheck();
		
		//System.out.println("registration form text box field is enabled");
		Thread.sleep(2000);				
		if(dataflag.contains("Duplicate_emailid")) {
    		//Thread.sleep(2000);
    		//String errorMsgInvalidtxt= driver.findElement(By.xpath("//input-error-section/div/div")).getText();
			//Thread.sleep(8000);
			
			Assert.assertTrue(loginbuttonenabled);	 
			driver.findElement(createaccountbutton).click();
    		String emailexception=driver.findElement(emailalreadyexists).getText();
    		Assert.assertEquals(emailexception,emailalertmessage );
		}
    		else if(dataflag.contains("Duplicate_instituteurl")) {
    		String InstituteURLexception=driver.findElement(errormessageintextfield).getText();
    		System.out.println(InstituteURLexception);
    		Assert.assertTrue(createmyaccountbuttonisnotenabled());
    		
    			
		
		
		
		}    	
    		else if(dataflag.contains("Duplicate_MobileNumber")) {
    			Assert.assertTrue(loginbuttonenabled);	 
    			driver.findElement(createaccountbutton).click();
    			String mobileexception=driver.findElement(mobilealreadyexists).getText();		
    			Assert.assertEquals(mobileexception,mobilealertmessage );
    		}
		
	}
		
	}


	