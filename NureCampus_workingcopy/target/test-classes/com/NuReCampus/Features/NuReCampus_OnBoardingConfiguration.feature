Feature: Online_Nure_OnBoarding_Configuration  
  @OnboardingConfiguration_Page_Content
Scenario Outline:Online_Nure_OnBoarding_Configuration|TC_01_User_verifies_the_Page_Content
  Given User launches the browser and hit the Campus Login page Url
  Then User retrieves login and configuration and campushierarchy testdata from excel sheet "<SheetName>" and rownum <Rownumber> for Onboarding
  When User furnishes login details and click on login button
  Then User click Next button 
  And User check all the page content is loaded succesfully

 Examples:
  |SheetName|Rownumber|
  |TC_Login_Module|0|


  @OnboardingConfiguration_with_Validdata_autosave
  Scenario Outline:Online_Nure_OnBoarding_Configuration|TC_02_User_furnish_the_configuration_details_with_valid_data
  
  Given User launches the browser and hit the Campus Login page Url
  Then User retrieves login and configuration and campushierarchy testdata from excel sheet "<SheetName>" and rownum <Rownumber> for Onboarding
  When User furnishes login details and click on login button
  #Then User click Next button 
  #And User retrieves configuration testdata from excel sheet "<SheetName>" and rownum <Rownumber>> for Onboarding
  When User furnishes configuration details 
 And Click on Campus Hirarchy Next button
 Then verify campaus hirarchy page loaded succesfully
 And User Click on previous button
  And User check the autosaveddata
  
    Examples:
  |SheetName|Rownumber|
  |TC_Login_Module|0|
  
   
  
  @OnboardingConfiguration_with_InValiddata
  Scenario Outline:Online_Nure_OnBoarding_Configuration|TC_03_User_furnish_the_configuration_details_with_Invalid_data
  
  Given User launches the browser and hit the Campus Login page Url
  Then User retrieves login and configuration and campushierarchy testdata from excel sheet "<SheetName>" and rownum <Rownumber> for Onboarding
  When User furnishes login details and click on login button
  #Then User click Next button 
  #And User retrieves configuration testdata from excel sheet "<SheetName>" and rownum <Rownumber>> for Onboarding
  When User furnishes configuration details 
 # And User selects English language 
  But check the exceptions are triggered to the User
   And Click on Campus Hirarchy Next button
   But check mandatory fields left exception occured
   
    Examples:
  |SheetName|Rownumber|
  |TC_Login_Module|1|
  
  
  @OnboardingConfiguration_with_InValiddata
  Scenario Outline:Online_Nure_OnBoarding_Configuration|TC_03_User_furnish_the_configuration_details_with_Invalid_data
  
  Given User launches the browser and hit the Campus Login page Url
  Then User retrieves login and configuration and campushierarchy testdata from excel sheet "<SheetName>" and rownum <Rownumber> for Onboarding
  When User furnishes login details and click on login button
  #Then User click Next button 
  #And User retrieves configuration testdata from excel sheet "<SheetName>" and rownum <Rownumber>> for Onboarding
  When User furnishes configuration details 
 # And User selects English language 
  But check the exceptions are triggered to the User
   And Click on Campus Hirarchy Next button
   But check mandatory fields left exception occured
   
    Examples:
  |SheetName|Rownumber|
  |TC_Login_Module|1|
  
  
  @OnboardingConfiguration_with_filesizes_UploadLogo_UploadReportHeader
  Scenario Outline:Online_Nure_OnBoarding_Configuration|TC_03_User_furnish_the_configuration_details_with_Invalid_data
  
  Given User launches the browser and hit the Campus Login page Url
  Then User retrieves login and configuration and campushierarchy testdata from excel sheet "<SheetName>" and rownum <Rownumber> for Onboarding
  When User furnishes login details and click on login button
  #Then User click Next button 
  #And User retrieves configuration testdata from excel sheet "<SheetName>" and rownum <Rownumber>> for Onboarding
  When User furnishes configuration details 
 # And User selects English language 
  Then Check filesize error message for upload image and header report image
 
  #But check the exceptions are triggered to the User
   #And Click on Campus Hirarchy Next button
   #But check mandatory fields left exception occured
   
    Examples:
  |SheetName|Rownumber|
  |TC_Login_Module|2|
 
 
  @OnboardingConfiguration_with_filesizes_UploadBackgroundImage
  Scenario Outline:Online_Nure_OnBoarding_Configuration|TC_03_User_furnish_the_configuration_details_with_Invalid_data
  
  Given User launches the browser and hit the Campus Login page Url
  Then User retrieves login and configuration and campushierarchy testdata from excel sheet "<SheetName>" and rownum <Rownumber> for Onboarding
  When User furnishes login details and click on login button
  #Then User click Next button 
  #And User retrieves configuration testdata from excel sheet "<SheetName>" and rownum <Rownumber>> for Onboarding
  When User furnishes configuration details 
 # And User selects English language 
   Then Check filesize error message for background image
 
  #But check the exceptions are triggered to the User
   #And Click on Campus Hirarchy Next button
   #But check mandatory fields left exception occured
   
    Examples:
  |SheetName|Rownumber|
  |TC_Login_Module|3|
  
  
 @OnboardingConfiguration_with_fileextensions_AllImages
  Scenario Outline:Online_Nure_OnBoarding_Configuration|TC_03_User_furnish_the_configuration_details_with_Invalid_data
  
  Given User launches the browser and hit the Campus Login page Url
  Then User retrieves login and configuration and campushierarchy testdata from excel sheet "<SheetName>" and rownum <Rownumber> for Onboarding
  When User furnishes login details and click on login button
  #Then User click Next button 
  #And User retrieves configuration testdata from excel sheet "<SheetName>" and rownum <Rownumber>> for Onboarding
  When User furnishes configuration details 
 # And User selects English language 
  Then Check supported fileextension message
  #But check the exceptions are triggered to the User
   #And Click on Campus Hirarchy Next button
   #But check mandatory fields left exception occured
   
    Examples:
  |SheetName|Rownumber|
  |TC_Login_Module|4|
  
 
 
 
 
 
  #   @OnboardingConfiguration_with_Validdata_AutoSave
  Scenario Outline:Online_Nure_OnBoarding_Configuration|TC_02_Verify_the_data_is_AutoSaved_Upon_clicking_on_previous_button
  
  #Given User launches the browser and hit the Campus Login page Url
  #Then User retrieves login and configuration and campushierarchy testdata from excel sheet "<SheetName>" and rownum <Rownumber> for Onboarding
  #When User furnishes login details and click on login button
#And User selects Hindi language  
#And Refresh the current page
#Then User click Next button 
#And User Click on previous button
  #And User retrieves configuration testdata from excel sheet "<SheetName>" and rownum <Rownumber>> for Onboarding
 # When User furnishes configuration details 
  #And User selects 
 #And Click on Campus Hirarchy Next button
 #Then verify campaus hirarchy page loaded succesfully
  #And User Click on previous button
 #And User check the autosaveddata
  
 
  
   # Examples:
  #|SheetName|Rownumber|
  #|TC_Login_Module|0|
  


  
  