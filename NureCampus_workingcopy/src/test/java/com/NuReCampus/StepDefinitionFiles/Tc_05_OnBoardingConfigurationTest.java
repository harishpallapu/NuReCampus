package com.NuReCampus.StepDefinitionFiles;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.NuReCampus_PageObjects.SelectModulePage;
import com.NuReCampus_PageObjects.ConfigurationPage;
import com.NuReCampus_PageObjects.OnboardingPage;
import com.NuReCampus_PageObjects.NextButtonPage;
import com.NuReCampus_PageObjects.PreviousButtonPage;
import com.NuReCampus_PageObjects.CampusHierarchyPage;






import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.VariableUtilities;

public class Tc_05_OnBoardingConfigurationTest {
	VariableUtilities variableUtilities;
	OnboardingPage onboardingPage;
	utilities.ConfigReader configReader;
	SelectModulePage selctPage;
	ConfigurationPage configPage;
	NextButtonPage nxtPage;
	PreviousButtonPage prevPage;
	CampusHierarchyPage campusHirarchyPage;
	

	public Tc_05_OnBoardingConfigurationTest(VariableUtilities variableUtilities)
	{
		this.variableUtilities=variableUtilities;
		this.onboardingPage=variableUtilities.allpageObjects.getonboardingpage();
		this.selctPage=variableUtilities.allpageObjects.getselectModulepage();
		this.configPage=variableUtilities.allpageObjects.getconfigurationepage();
		this.nxtPage=variableUtilities.allpageObjects.getNextbuttonpage();
		this.prevPage=variableUtilities.allpageObjects.getPreviousbuttonpage();
		this.configReader=variableUtilities.configReader;
		this.campusHirarchyPage=variableUtilities.allpageObjects.getCampushierarchypage();
				
		
		
	}
	
	
	 @Then("User retrieves login and configuration and campushierarchy testdata from excel sheet {string} and rownum {int} for Onboarding")
	 public void User_retrieves_login_and_configuration_and_campushierarchy_testdata_from_excel_sheet_and_rownum_for_Onboarding(String SheetName,Integer Rownumber) throws InterruptedException, InvalidFormatException, IOException
	 
	 
	 {
		 
	List<Map<String,String>> registrationdata=variableUtilities.excelReader.getData("./src/test/resources/TestData3.xlsx", SheetName);
	
	variableUtilities.username=registrationdata.get(Rownumber).get("username");
	variableUtilities.password=registrationdata.get(Rownumber).get("password");
	variableUtilities.instituewebsite=registrationdata.get(Rownumber).get("instituewebsite");
	variableUtilities.logoimage=registrationdata.get(Rownumber).get("logoimage");
	variableUtilities.backgroundimage=registrationdata.get(Rownumber).get("backgroundimage");
	variableUtilities.reportheaderimage=registrationdata.get(Rownumber).get("reportheaderimage");
	variableUtilities.dataFlag2=registrationdata.get(Rownumber).get("dataflag2");
	variableUtilities.extension=registrationdata.get(Rownumber).get("extension");
	variableUtilities.emailaddressid=registrationdata.get(Rownumber).get("emailaddressid");
	variableUtilities.phonenumber=registrationdata.get(Rownumber).get("phonenumber");
	variableUtilities.groupName=registrationdata.get(Rownumber).get("groupName");
	variableUtilities.msg=registrationdata.get(Rownumber).get("msg");
	variableUtilities.childgroupName=registrationdata.get(Rownumber).get("childgroupName");
	variableUtilities.childdecriptionmsg=registrationdata.get(Rownumber).get("childdecriptionmsg");
	variableUtilities.secondchild=registrationdata.get(Rownumber).get("secondchild");
	variableUtilities.secondchildmsg=registrationdata.get(Rownumber).get("secondchildmsg");
	
	
	
	System.out.println(variableUtilities.instituewebsite);
	System.out.println(variableUtilities.logoimage);
	System.out.println(variableUtilities.backgroundimage);
	System.out.println(variableUtilities.reportheaderimage);
	System.out.println(variableUtilities.emailaddressid);
	System.out.println(variableUtilities.phonenumber);
	System.out.println(variableUtilities.dataFlag2);
	//System.out.println(variableUtilities.groupName);
	
	
	 }
	
	 @Then("User furnishes configuration details")
		public void User_furnishes_configuration_details( ) throws InterruptedException {
			configPage.configpagedata(variableUtilities.instituewebsite,variableUtilities.emailaddressid, variableUtilities.phonenumber);
			
			//String uploadLogoImagepath = System.getProperty("user.dir")+"\\src\\test\\resources\\Images\\Image1.jpg";
			Thread.sleep(2000);
			String uploadLogoImagepath = System.getProperty("user.dir")+variableUtilities.logoimage;
			
			
			configPage.uploadLogoImage(uploadLogoImagepath);
			configPage.uploadLogovalidations(variableUtilities.dataFlag2);
			
			//String uploadBackgroundpath = System.getProperty("user.dir")+"\\src\\test\\resources\\Images\\Image2.jpg";
			Thread.sleep(2000);
			String uploadBackgroundpath = System.getProperty("user.dir")+variableUtilities.backgroundimage;
			
			configPage.uploadBackgroundImage(uploadBackgroundpath,variableUtilities.dataFlag2,variableUtilities.extension);
			//String uploadReportHeaderImagepath = System.getProperty("user.dir")+"\\src\\test\\resources\\Images\\Image3.jpg";
			Thread.sleep(2000);
			String uploadReportHeaderImagepath = System.getProperty("user.dir")+variableUtilities.reportheaderimage;
			
			configPage.uploadReportHeaderImage(uploadReportHeaderImagepath,variableUtilities.dataFlag2,variableUtilities.extension);
			

			Thread.sleep(5000);
			
			
			
		}
	 @Then("Check filesize error message for upload image and header report image")
	 public void Check_filesize_error_message_for_upload_image_and_header_report_image()
	 {
		String filesizeexception=configPage.getEnterRequiredFieldErrorMsg();
		 Assert.assertTrue(filesizeexception.contains("Image size should not be more than 2 MB"));
		 
	 }
	 
	 @Then("Check filesize error message for background image")
	 public void Check_filesize_error_message_for_background_image()
	 {
		String filesizeexception=configPage.getEnterRequiredFieldErrorMsg();
		 Assert.assertTrue(filesizeexception.contains("Image size should not be more than 4 MB"));
		 
	 }	 
	 
	 @Then("Check supported fileextension message")
	 public void Check_supported_fileextension_message() {
		 
		String invalidextensionexception=configPage. getInvalidUploadExtensionError();
		 Assert.assertTrue(invalidextensionexception.contains("gifImage.gif: Invalid file type,"));
			
		String Allowedfileexception=configPage.	getAllowedFileListMsg();
		 Assert.assertTrue(Allowedfileexception.contains("allowed file types: image/jpg, image/jpeg, image/png."));
			
	 }
	 
	 @And("User selects Hindi language") 
	 public void User_selects_Hindi_language()
	 {
		 configPage.selectHindiLanguage();
		 
	 }
	 
	 @And("Refresh the current page")
	 public void Refresh_the_current_page() throws IOException
	 {
		 variableUtilities.baseTestComponents.invokebrowser().navigate().refresh();
		 
	 }
	 
	  @Then("User check all the page content is loaded succesfully")
	  public void User_check_all_the_page_content_is_loaded_succesfully() {
		  
		//  configPage.validateConfigurationTitleAndAllContent();
		  Boolean flag=	configPage.validateConfigurationTitleAndAllContent();
			 Assert.assertTrue(flag);
		        System.out.println("All Content Name Validate");
		        System.out.println("All fields load properly...");
		        
		        Boolean flag2=   configPage.validateBlankAllUploadImageValue();
		        
		        		 Assert.assertTrue(flag2);
	  
	  }
	 

	  
	@Then("User check the autosaveddata")
	  public void User_check_the_autosaveddata() {
		  
		Boolean flag=configPage.validateExistingDataFromPreviousPage(variableUtilities.instituewebsite, variableUtilities.emailaddressid, variableUtilities.phonenumber);
		Assert.assertTrue(flag);
			    
	  }
	  
	  
	  
	 @When("Click on Campus Hirarchy Next button")
	 public void Click_on_Campus_Hirarchy_Next_button() {
		 
		 nxtPage.configNextButton();
	 }
	
	/* @Then("upload logo image")
		public void upload_logo_image() throws InterruptedException {
			Thread.sleep(1000);
			configPage.uploadLogoImage("C:\\Users\\1003611\\eclipse-workspace1\\Online_NuRe_OnBoarding_Module\\src\\test\\resources\\Images\\Image1.jpg");
		}
		@Then("upload background image")
		public void upload_background_image() throws InterruptedException {
			Thread.sleep(1000);
			configPage.uploadBackgroundImage("C:\\Users\\1003611\\eclipse-workspace1\\Online_NuRe_OnBoarding_Module\\src\\test\\resources\\Images\\Image2.jpg");
			
		}
		@Then("upload report header image")
		public void upload_report_header_image() throws InterruptedException {
			Thread.sleep(1000);
			configPage.uploadReportHeaderImage("C:\\Users\\1003611\\eclipse-workspace1\\Online_NuRe_OnBoarding_Module\\src\\test\\resources\\Images\\Image2.jpg");
			
		}*/

	/*@And("user enter institute Website")
	public void user_enter_institute_website() throws EncryptedDocumentException, IOException {
		String website = ConfigReader.getDataFromExcel("TC_01_OnBoarding_Module", 8, 1);
		configPage.instituteWebsite(website);
	}
	*/
	


	@And("User Click on previous button")
	public void User_Click_on_previous_button() throws InterruptedException
	{
		prevPage.configPreviousButton();
		Thread.sleep(2000);
		
	}
	

	
	@Then("verify campaus hirarchy page loaded succesfully")
	public void verify_campaus_hirarchy_page_loaded_succesfully() {
		
		String title =campusHirarchyPage.validateCampusHirarchyUrl();
		Assert.assertTrue(title.equalsIgnoreCase(variableUtilities.baseTestComponents.QACampushierarchyenv));
	}
	
	@When("check the exceptions are triggered to the User")
	public void check_the_exceptions_are_triggered_to_the_User() {
		
		String websitepatternErrormismatch=configPage.validateErrorMsg();
		Assert.assertTrue(websitepatternErrormismatch.contains("Entered value doesn't match the pattern."));
		
		String emailpatternErrormismatch=configPage.validateErrorMsg();
		Assert.assertTrue(emailpatternErrormismatch.contains("Entered value doesn't match the pattern."));
		
		String phonenumberlength=configPage.validatePhoneNumError();
		Assert.assertTrue(phonenumberlength.contains("Minimum length should be 10"));	
		
		String phonepatternErrormismatch=configPage.validateErrorMsg();
		Assert.assertTrue(phonepatternErrormismatch.contains("Entered value doesn't match the pattern."));
		

	}	
	
	 @When("check mandatory fields left exception occured")
	 public void check_mandatory_fields_left_exception_occured()
	 
	 {
		 String errorMsg =  configPage.getEnterRequiredFieldErrorMsg();
		 Assert.assertTrue(errorMsg.contains("Please fill all required feilds."));
		 
	 }
	
	/*
	@Then("enter institue website {string}")
	public void enter_institue_website(String website) throws InterruptedException {
		Thread.sleep(1000);
		
		configPage.instituteWebsite(website);
	}



	
	@Then("enter institute email id {string}")
	public void enter_institute_email_id(String mailId) {
		
		configPage.enterMailId(mailId);
	}
	@Then("enter phone number {string}")
	public void enter_phone_number(String phoneNum) {
		
		configPage.enterPhoneNumber(phoneNum);
		DriverFactory.getDriver().getCurrentUrl();
	}*/

	/*
	@Then("enter institue website {string} and verify error")
	public void enter_institue_website_and_verify_error(String website) throws InterruptedException {
		Thread.sleep(1000);
		configPage.instituteWebsite(website);
		configPage.validateErrorMsg();
	}*/

/*
	@Then("enter institute email id {string} and verify error")
	public void enter_institute_email_id_and_verify_error(String mailId) {

		configPage.enterMailId(mailId);
		configPage.validateErrorMsg();
	}
	
	@Then("click on configuration previous page")
	public void click_on_configuration_previous_page() {
		prevPage.clickPreviousButton();
		
	}

	
	@Then("enter phone number {string} and verify error")
	public void enter_phone_number_and_verify_error(String phoneNum) {

		configPage.enterPhoneNumber(phoneNum);
		configPage.validateErrorMsg();
		configPage.validatePhoneNumError();
	}*/


}
