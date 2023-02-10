##Scenario: Testcase: Online onboarding module

Feature: Online_Nure_CampusHierarchy_Module


  @OnboardingModule_NoModuleselection
  Scenario Outline:NuReCampus_OnBoarding_Module|TC_01_verify_No_Module_Select_Message_Is_Displayed  
  
  Given User launches the browser and hit the Campus Login page Url
  Then User retrieves testdata from excel sheet "<SheetName>" and rownum <Rownumber> for Onboarding
  When User furnishes login details and click on login button
  Then User will be Redirect to Onboarding Module
  Then user deSelect all module
  And Verify No module select message
  
   Examples:
  |SheetName|Rownumber|
  |TC_Login_Module|0|
  
 
    @OnboardingModule_allmodulenames_allmodulesprices
   Scenario Outline:Online_Nure_OnBoarding_M0dule|TC_02_verify_module_Name_price
  Given User launches the browser and hit the Campus Login page Url
  Then User retrieves testdata from excel sheet "<SheetName>" and rownum <Rownumber> for Onboarding
  When User furnishes login details and click on login button
 	Then Verify all module Name
 	And Verify all module price
 	And Verify Total price
  
   Examples:
  |SheetName|Rownumber|
  |TC_Login_Module|0|
  
 @OnboardingModule_nomoduleselection_next_alertmessage
 	Scenario Outline:Online_Nure_OnBoarding_Module|TC_03_Verify_Alert_Message
  Given User launches the browser and hit the Campus Login page Url
 	Then User retrieves testdata from excel sheet "<SheetName>" and rownum <Rownumber> for Onboarding
  When User furnishes login details and click on login button
  Then user deSelect all module
  And User click Next button
  And verify the alert message
  
   Examples:
  |SheetName|Rownumber|
  |TC_Login_Module|0|
  
  
 @OnboardingModule_Next_Previous
  Scenario Outline:Online_Nure_OnBoarding_Module|TC_04_Select_module_redirect_to_configuration
  Given User launches the browser and hit the Campus Login page Url
 	Then User retrieves testdata from excel sheet "<SheetName>" and rownum <Rownumber> for Onboarding
  When User furnishes login details and click on login button 
  Then User click Next button
  And verify all field load properly 
  And User click Previous button
  And User will be Redirect to Onboarding Module
    Examples:
  |SheetName|Rownumber|
  |TC_Login_Module|0|
  
   
  
  
  
  