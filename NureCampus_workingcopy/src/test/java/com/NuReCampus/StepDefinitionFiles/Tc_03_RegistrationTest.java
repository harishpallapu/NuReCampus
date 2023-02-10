package com.NuReCampus.StepDefinitionFiles;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.NuReCampus_PageObjects.ConfigurationPage;
import com.NuReCampus_PageObjects.LoginPage;
import com.NuReCampus_PageObjects.OnLandingPage;
import com.NuReCampus_PageObjects.OnboardingPage;
import com.NuReCampus_PageObjects.RegistrationPage;

import utilities.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.VariableUtilities;

public class Tc_03_RegistrationTest{
	
	VariableUtilities variableUtilities;
	OnboardingPage onboardingPage;
	RegistrationPage registrationPage;
	utilities.ConfigReader configReader;
	LoginPage loginpage;
	ConfigurationPage configPage;
	String emailidretrieved;
	
	
	
	public Tc_03_RegistrationTest(VariableUtilities variableUtilities)
	{
		this.variableUtilities=variableUtilities;
		this.registrationPage=variableUtilities.allpageObjects.getonRegistrationpage();
		this.configReader=variableUtilities.configReader;
		this.configPage=variableUtilities.allpageObjects.getconfigurationepage();
		
		this.onboardingPage=variableUtilities.allpageObjects.getonboardingpage();
		//this.loginpage=variableUtilities.allpageObjects.getloginpage();
	}

	
	
	 @Given("User launches the browser and hit the Registration page Url")
	    public void User_launches_the_browser_and_hit_the_Registration_page_Url() throws Throwable {
		
			
			Assert.assertTrue(registrationPage.geturl().contains("https://erp.campuslabs.in/qa/register"));	
		
		 
	 
	 }
	 @Then("^User verify registration page all the fields and content$")
	    public void user_verify_registration_page_all_the_fields_and_content() throws Throwable {
	    	
	    	registrationPage.verifyRegistrationFormContent();
	    	
	    }
	 
	/* @Given("User refreshes the browser")
	 public void User_refreshes_the_browser() throws IOException {
		  if (variableUtilities.baseTestComponents.invokebrowser().getCurrentUrl()="https://erp.campuslabs.in/qa/register")
			{
				variableUtilities.baseTestComponents.invokebrowser().navigate().refresh();
			}
		 
		 
	 }
	 */
	 
	 @Then("User retrieves testdata from excel sheet {string} and rownum {int}")
	 public void User_retrieves_testdata_from_excel_sheet_and_rownum(String SheetName,Integer Rownumber) throws Throwable
	 
	 
	 {
		 
		 
		 
	List<Map<String,String>> registrationdata=variableUtilities.excelReader.getData("./src/test/resources/TestData3.xlsx", SheetName);
	
	
	variableUtilities.fullname=registrationdata.get(Rownumber).get("fullname");
	variableUtilities.emailid=registrationdata.get(Rownumber).get("emailaddress");
	variableUtilities.phonenum=registrationdata.get(Rownumber).get("mobile");
	variableUtilities.InstituteName=registrationdata.get(Rownumber).get("Institutionname");
	variableUtilities.instituteurl=registrationdata.get(Rownumber).get("institutionurl");
	variableUtilities.dataFlag=registrationdata.get(Rownumber).get("dataflag");
	variableUtilities.password=registrationdata.get(Rownumber).get("password");
	
	 }
	 
	 
	//System.out.println(fullname+emailid+phonenum+InstituteName+instituteurl);
	@Then("User enter register details and click on create account button")
	 public void User_enter_register_details_and_click_on_create_account_button() throws InterruptedException {
	registrationPage.enterRegistrationDetails(variableUtilities.fullname, variableUtilities.emailid, variableUtilities.phonenum, variableUtilities.InstituteName, variableUtilities.instituteurl);
	variableUtilities.emailidretrieved=registrationPage.getemailattribute();
	registrationPage.validationRegistrationformdetailsField(variableUtilities.dataFlag);
	
	  
	 
	 } 
		 	 
	 @Then("User check ThankYou message displayed")
	 public void User_check_ThankYou_message_displayed() {
		 
		registrationPage.validateRegistrationSuccessMsg().contains("Thank you for submitting the information.");
		
	 }
	 
	 
	 
	 @And("Login to NureCampus")
	 public void Login_to_NureCampus() throws IOException, InterruptedException {
		 variableUtilities.baseTestComponents.invokebrowser().get(variableUtilities.baseTestComponents.QAloginenv);
		// String emailidretrieved=registrationPage.getemailattribute();
		 onboardingPage.logincredentials(variableUtilities.emailidretrieved,variableUtilities.password);
		
	 }
	 
	
	 @Then("Check the Name of the institution is appeared")
	 public void Check_the_Name_of_the_institution_is_appeared() {
		 
		String institutionname= configPage.getInstitutename();
	
		 System.out.println(institutionname);
		 
	 }
	 
	@Then("User enter register details and click on create account button and check error message for email and instituteURL")
	public void User_enter_register_details_and_click_on_create_account_button_and_check_error_message_for_email_and_instituteURL() throws InterruptedException
	{
		
		
		registrationPage.enterRegistrationDetail(variableUtilities.fullname, variableUtilities.emailid, variableUtilities.phonenum, variableUtilities.InstituteName, variableUtilities.instituteurl,variableUtilities.dataFlag);
	}

}



