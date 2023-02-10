package com.NuReCampus.StepDefinitionFiles;

import org.junit.Assert;

import com.NuReCampus_PageObjects.OnLandingPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.VariableUtilities;

public class Tc_02_OnlandingModuleTest{
	
	VariableUtilities variableUtilities;
	OnLandingPage onlandingpage;
	
	
	
	public Tc_02_OnlandingModuleTest(VariableUtilities variableUtilities)
	{
		this.variableUtilities=variableUtilities;
		this.onlandingpage=variableUtilities.allpageObjects.getonlandingpage();
	}

	
	
	 @Given("User launches the browser and hit the landing page URL")
	    public void User_launches_the_browser_and_hit_the_landing_page_URL() throws Throwable {
		Assert.assertTrue(onlandingpage.gettitleofthepage().contains("NuReCampus"));
	
	}
	 

	@Then("User check Logo appears in landing page")
	public void User_check_logo_appears_in_landing_page() throws Throwable {
		
		Assert.assertTrue(onlandingpage.verifyLogoInlanding());
		
	}

	@Then("User check title of the landing page")
    public void User_check_title_of_the_landing_page() throws Throwable {
		  Assert.assertTrue(onlandingpage.verifyCampusLandingContent().contains("Trully Made in India ERP for Education System to Organize, Manage and Unify Your Academic Institution"));     
		
	}	

	@Then("User check button label for Get Started for Free button")
	public void User_check_button_label_for_Get_Stared_for_Free_button() throws Throwable {
		
	Assert.assertTrue(onlandingpage.verifyGetStartedForFree().contains("Get Started for Free"));	     
	}

	@Then("User check button label for  Contact Us For Demo button")
	public void User_check_button_label_for_Contact_Us_For_Demo_button() throws Throwable {
	Assert.assertTrue(onlandingpage.verifyContactUsForDemo().contains("Contact Us for Demo"));	   
		
	}
	
	
	@Then("User click on Get Started For free button and redirect to Registration page")
	public void user_click_on_get_started_for_free_button_and_redirect_to_registration_page() throws Throwable {
		
		
		Assert.assertTrue(onlandingpage.clickGetStartedForFree().contains("https://erp.campuslabs.in/qa/register"));   ;
		
	 }	 
		 
	

}



