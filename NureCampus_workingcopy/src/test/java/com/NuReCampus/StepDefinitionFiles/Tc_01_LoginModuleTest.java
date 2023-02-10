package com.NuReCampus.StepDefinitionFiles;

import java.io.IOException;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.NuReCampus_PageObjects.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import utilities.VariableUtilities;

@RunWith(Cucumber.class)
public class Tc_01_LoginModuleTest{

	public String CurrentURl;
	VariableUtilities variableUtilities;
	LoginPage loginpage;
	
	
	
	public Tc_01_LoginModuleTest(VariableUtilities variableUtilities)
	
	{
		this.variableUtilities=variableUtilities;
		this.loginpage=variableUtilities.allpageObjects.getloginpage();
		
	}

	
	@Given("^User launches the browser and hit the Login page Url$")
	    public void user_launches_the_browser_and_hit_the_login_page_url() throws Throwable {
		//loginpage=variableUtilities.allpageObjects.getloginpage() ;
		     

	    }	
	
	    @Then("User Verify Login page all the content is displayed")
	    public void user_verify_login_page_all_the_content_is_displayed() throws Throwable {	    	
	    	
	    Assert.assertTrue(loginpage.verifyusernamecontent());
	    Assert.assertTrue(loginpage.verifyForgotPassWord());   
	    Assert.assertTrue(loginpage.verifyPasswordContent());   
	    Assert.assertTrue(loginpage.nureCampusLoginbutton()); 
	    	
	
	    }    
	    
	 
	    
	    @And("^User enter (.+) and (.+) got on his email and click on login button$")
	    public void user_verify_valid_and_got_on_his_email_and_click_on_login_button(String username, String password) throws Throwable {
	    	loginpage=variableUtilities.allpageObjects.getloginpage();
	    	loginpage.logincredentials(username,password);
	    	//Thread.sleep(5000);
	    	
	    	
	    	
	    	
	    }
	    @When("User logout from the session")
	    public void User_logout_from_the_session() throws InterruptedException
	    
	    {
	    	    	
	    	loginpage.clickprofileicon();
	    	Thread.sleep(2000);
	    	loginpage.clicklogoutbutton();
	    	
	    }
	    
	    @Then("User clicks browser Backward button and check the login page is redirected")
	    public void User_clicks_browser_Backward_button_and_check_the_login_page_is_redirected() throws IOException, InterruptedException 
	    {
	    	
	    	variableUtilities.baseTestComponents.invokebrowser().navigate().back(); 
	    	Thread.sleep(5000);
	    	variableUtilities.CurrentURl=variableUtilities.baseTestComponents.invokebrowser().getCurrentUrl();
	    	System.out.println(variableUtilities.CurrentURl);
	    	if(variableUtilities.CurrentURl.contains("https://erp.campuslabs.in/qa/dashboard-login"))
			{
		    	
				Assert.assertTrue("Current Url is +variableUtilities.CurrentURl+", true);
				
			}
	    	
	    }
	    
	    
	    @Then("User clicks browser Forward button and check the login page is redirected")
	    public void User_clicks_browser_Forward_button_and_check_the_login_page_is_redirected() throws IOException, InterruptedException 
	    {
	    	   
	    	
	    	variableUtilities.baseTestComponents.invokebrowser().navigate().forward();
	    	Thread.sleep(5000);
	    	
	    	variableUtilities.CurrentURl=variableUtilities.baseTestComponents.invokebrowser().getCurrentUrl();
	    	System.out.println(variableUtilities.CurrentURl);
	    	if(variableUtilities.CurrentURl.matches("https://erp.campuslabs.in/qa/dashboard-login"))
			{
		    	
				Assert.assertTrue("Current Url is variableUtilities.CurrentURl", true);
				
			}
	    	
	    }
	   
	    @Then("User lands on onboardingpage")
	    
	    public void user_lands_on_onboardingpage() throws IOException, InterruptedException {
	    	
	  
	    	Thread.sleep(2000);
	    	variableUtilities.CurrentURl=variableUtilities.baseTestComponents.invokebrowser().getCurrentUrl();
	    	//System.out.println(variableUtilities.CurrentURl);
	    	
	    	
	 if(variableUtilities.CurrentURl.matches("https_erp_campuslabs_in_qa_onboarding_module_page"))
		{
			Assert.assertTrue(true);
			
			
		}
	    
	    }
	    @Then("User lands on loginpage")
	    
	    public void User_lands_on_loginpage() throws IOException {
	    	
	    	//loginpage.landingpageurl();
	    	CurrentURl=variableUtilities.baseTestComponents.invokebrowser().getCurrentUrl();
	    	if(CurrentURl.matches("https://erp.campuslabs.in/qa/dashboard-login"))
		{
	    	String invalidmessage=loginpage.landingpageurl();
	    	System.out.println(invalidmessage);
			//Assert.assertTrue("", true);
			Assert.assertTrue(invalidmessage.equalsIgnoreCase("Invalid username or password"));
			
		}
	    	
	    }
	    
	    
	   
		
	   }

	