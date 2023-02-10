Feature: Online_Nure_OnBoarding_Module

#@Registration_Page_Content
 #Scenario:NuReCampus_OnBoarding_Module|TC_01_Check_all_content_is_displayed_in_the_page
 #Given User launches the browser and hit the Registration page Url 
 #Then User verify registration page all the fields and content
 
 
 @Registration_with_validdata
Scenario Outline:NuReCampus_OnBoarding_Module|TC_02_Registration_in_application_with_Valid_Data  
Given User launches the browser and hit the Registration page Url
Then User retrieves testdata from excel sheet "<SheetName>" and rownum <Rownumber>
Then User enter register details and click on create account button
And User check ThankYou message displayed 
And Login to NureCampus
Then user deSelect all module
And User click Next button 
Then Check the Name of the institution is appeared 

   
  Examples:
  |SheetName|Rownumber|
  |TC_02_OnBoarding_Module_Valid|0|
 
  @Registration_with_invaliddata
  Scenario Outline:NuReCampus_OnBoarding_Module|TC_03_Registration_in_application_with_InValid_Data  
 #Given User launches the browser and hit the Registration page Url
 #Given User refreshes the browser
  Then User retrieves testdata from excel sheet "<SheetName>" and rownum <Rownumber>
  Then User enter register details and click on create account button
  #Then User check ThankYou message displayed 
  
     
   Examples:
   |SheetName|Rownumber|
    |TC_03_OnBoarding_Module_InValid|0|
    |TC_03_OnBoarding_Module_InValid|1|
    |TC_03_OnBoarding_Module_InValid|2|  
    |TC_03_OnBoarding_Module_InValid|3|   
    |TC_03_OnBoarding_Module_InValid|4|
    |TC_03_OnBoarding_Module_InValid|5|
    |TC_03_OnBoarding_Module_InValid|6|  
    |TC_03_OnBoarding_Module_InValid|7|
    |TC_03_OnBoarding_Module_InValid|8|
		  
 @Registration_with_Duplicatedata
  Scenario Outline:NuReCampus_OnBoarding_Module|TC_04_Registration_in_application_with_Duplicate_Data
  
#Given User launches the browser and hit the Registration page Url
#Given User refreshes the browser
 Then User retrieves testdata from excel sheet "<SheetName>" and rownum <Rownumber>
 But User enter register details and click on create account button and check error message for email and instituteURL
  
  
   
   Examples:
   |SheetName|Rownumber|
   |TC_04_OnBoarding_Mod_Duplicate|0|
 		|TC_04_OnBoarding_Mod_Duplicate|1|
 		|TC_04_OnBoarding_Mod_Duplicate|2|