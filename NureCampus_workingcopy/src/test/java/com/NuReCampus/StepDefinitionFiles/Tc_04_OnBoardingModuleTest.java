package com.NuReCampus.StepDefinitionFiles;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.NuReCampus_PageObjects.ConfigurationPage;
import com.NuReCampus_PageObjects.SelectModulePage;
import com.NuReCampus_PageObjects.OnboardingPage;
import com.NuReCampus_PageObjects.NextButtonPage;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.VariableUtilities;

public class Tc_04_OnBoardingModuleTest {

	VariableUtilities variableUtilities;
	OnboardingPage onboardingPage;
	utilities.ConfigReader configReader;
	SelectModulePage selctPage;
	ConfigurationPage configPage;
	NextButtonPage nxtPage;
	public Tc_04_OnBoardingModuleTest(VariableUtilities variableUtilities)
	{
		this.variableUtilities=variableUtilities;
		this.onboardingPage=variableUtilities.allpageObjects.getonboardingpage();
		this.selctPage=variableUtilities.allpageObjects.getselectModulepage();
		this.configPage=variableUtilities.allpageObjects.getconfigurationepage();
		this.nxtPage=variableUtilities.allpageObjects.getNextbuttonpage();
		this.configReader=variableUtilities.configReader;
	}
	
	
	 @Given("User launches the browser and hit the Campus Login page Url")
	    public void User_launches_the_browser_and_hit_the_Campus_Login_page_Url() throws Throwable {
		 Assert.assertTrue(onboardingPage.geturl().contains("https://erp.campuslabs.in/qa/dashboard-login"));
	 
	 }
	 @Then("User retrieves testdata from excel sheet {string} and rownum {int} for Onboarding")
	 public void User_retrieves_testdata_from_excel_sheet_and_rownum_for_Onboarding(String SheetName,Integer Rownumber) throws InterruptedException, InvalidFormatException, IOException
	 
	 
	 {
		 
	List<Map<String,String>> registrationdata=variableUtilities.excelReader.getData("./src/test/resources/TestData3.xlsx", SheetName);
	
	
	variableUtilities.username=registrationdata.get(Rownumber).get("username");
	variableUtilities.password=registrationdata.get(Rownumber).get("password");
	
	 }
	
	@When("User furnishes login details and click on login button")
		 public void User_furnishes_login_details_and_click_on_login_button() throws InterruptedException {
		onboardingPage.logincredentials(variableUtilities.username, variableUtilities.password);
		
		
		  
		 
		 } 
	@Then("User will be Redirect to Onboarding Module")
	public void user_will_be_redirect_to_onboarding_module() throws EncryptedDocumentException, IOException {
	
		String welcm= onboardingPage.validateOnBoardingPage();
		Assert.assertTrue(welcm.contains("Welcome"));
		System.out.println("Module fields load properly");
		
		Boolean flag=onboardingPage.validateOnboardingPageStaticContent();
		Assert.assertTrue(flag);
	}

/*
	@And("click on next button")
	public void click_on_next_button() throws InterruptedException {
		
		nxtPage.clickNextButton();
		Thread.sleep(2000);
	}
	
	@And("back to previuos button")
	public void back_to_previuos_button() {
		PreviousButtonPage prevPage=new PreviousButtonPage(DriverFactory.getDriver());
		prevPage.clickPreviousButton();
		nxtPage.clickNextButton();
	}*/

	@Then("user deSelect all module")
	public void user_de_select_all_module() {
		 selctPage.checkModuleSelection();
	
	}

	@Then("Verify No module select message")
	public void verify_no_module_select_message() {
		onboardingPage.validateNoModuleSelectMsg();
	   
	}

	@Then("user select all module")
	public void user_select_all_module() {
		selctPage.checkModuleSelection();
		
	}

	@Then("Verify all module Name")
	public void verify_all_module_name() {
	    
		Boolean flag=onboardingPage.validateSelectedMadule();
		Assert.assertTrue(flag);
		System.out.println("All Module Name Validate");
	}
	@Then("Verify all module price")
	public void verify_all_module_price() {
		Boolean flag=onboardingPage.validatePriceList();
		Assert.assertTrue(flag);
		System.out.println("All Price Validate");
		
	}
	@Then("Verify Total price")
	public void verify_total_price() {
		String msg1= onboardingPage.validateTotalMsg();
		Assert.assertTrue(msg1.contains("Total after trial"));
		
		String price= onboardingPage.validateTotalPrice();
		Assert.assertTrue(price.equals("15000"));
		
		
		
		//onboardingPage.validateTotalMsgAndPrice();
		
	}
	@Then("User click Next button")
	public void user_click_next_button() throws InterruptedException, IOException {
		nxtPage.clickNextButton();
		/*String CurrentURl=variableUtilities.baseTestComponents.invokebrowser().getCurrentUrl();
		if(CurrentURl.matches("https://erp.campuslabs.in/qa/onboarding/configuration"))
		{
			nxtPage.validateConfigurationPage();
		
		}*/
		
		
	}

	@Then("verify the alert message")
	public void verify_the_alert_message() {
		String altMsg= onboardingPage.validateAlertMsg();
		
		Assert.assertTrue(altMsg.contains("Please select atleast one Module"));
		
	}
	@Then("User redirect to Configuration")
	public void user_redirect_to_configuration() {
	  
		
	}

	@Then("verify all field load properly")
	public void verify_all_field_load_properly() {
	   
		//onboardingPage.validateConfigurationTitle();
	Boolean flag=	configPage.validateConfigurationTitleAndAllContent();
		 Assert.assertTrue(flag);
	        System.out.println("All Content Name Validate");
	        System.out.println("All fields load properly...");
	}
	@Then("User click Previous button")
	public void user_click_previous_button() {
		
		configPage.clickPreviousButton();
		onboardingPage.validateOnBoardingPage();
		
	}

	







}
