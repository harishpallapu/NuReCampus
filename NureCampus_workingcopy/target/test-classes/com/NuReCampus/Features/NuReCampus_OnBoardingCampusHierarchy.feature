##Scenario: Testcase: Online onboarding Campus Hierarchy

Feature: Online_Nure_OnBoarding_CampusHierarchy

  @tag1
  Scenario Outline:Online_Nure_OnBoarding_CampusHierarchy|TC_01_Validate_No_Groups_In_Campus_Hierarchy
   Given User launches the browser and hit the Campus Login page Url
  Then User retrieves login and configuration and campushierarchy testdata from excel sheet "<SheetName>" and rownum <Rownumber> for Onboarding
  When User furnishes login details and click on login button 
  Then User click Next button
  #And verify all field load properly
  And Click on Campus Hirarchy Next button
 # And verify campaus hirarchy page loaded fully
 Then verify campaus hirarchy page loaded succesfully
  And Verify groups not exist in campus Hierarchy
  
 Examples:
  |SheetName|Rownumber|
  |TC_Login_Module|0|
  
  @tag2
  Scenario Outline:Online_Nure_OnBoarding_CampusHierarchy|TC_02_ReDirected_to_UsersAndRoles_And_Vice-versa
  Given User launches the browser and hit the Campus Login page Url
  Then User retrieves login and configuration and campushierarchy testdata from excel sheet "<SheetName>" and rownum <Rownumber> for Onboarding
  When User furnishes login details and click on login button 
  Then User click Next button
 # And verify all field load properly
  And Click on Campus Hirarchy Next button
 # And verify campaus hirarchy page loaded fully
  And Create a parent group
  And Create Child group in a parent
  And Create second parent child group in parent
  And click on Add users Next button
  And Verify Users and roles page loaded fully
  And click on Previous campus hierarchy button
  And verify campaus hirarchy page loaded succesfully
  
   Examples:
  |SheetName|Rownumber|
  |TC_Login_Module|0|
  
  @tag3
  Scenario Outline: Online_Nure_OnBoarding_CampusHierarchy|TC_04_Verify_ParentGroup_willnotbe_Deleted_ifTheyHaveChild
  Given User launches the browser and hit the Campus Login page Url
  Then User retrieves login and configuration and campushierarchy testdata from excel sheet "<SheetName>" and rownum <Rownumber> for Onboarding
  When User furnishes login details and click on login button 
  Then User click Next button
  #And verify all field load properly
  And Click on Campus Hirarchy Next button
 # And verify campaus hirarchy page loaded fully
 # And Create a parent group
 # And Create Child group in a parent
  #And Create subchild group in parent
 	And Select Parent group
 	And Click on Delete button
 	And Verify Delete PopUp content
 	And Click on Yes I am sure button
 	And Verify Group cannot be deleted message
 	
 Examples:
  |SheetName|Rownumber|
  |TC_Login_Module|0|
  
    
  @tag4
  Scenario Outline:Online_Nure_OnBoarding_CampusHierarchy|TC_06_Verify_Delete_Cancellation_Functionality
  Given User launches the browser and hit the Campus Login page Url
  Then User retrieves login and configuration and campushierarchy testdata from excel sheet "<SheetName>" and rownum <Rownumber> for Onboarding
  When User furnishes login details and click on login button 
  Then User click Next button
 #And verify all field load properly
  And Click on Campus Hirarchy Next button
    #And Create a parent group
 	And Select Parent group
 	And Click on Delete button
 	And click on Cancel button
 	And Verify ParentGroup is not deleted
  

 Examples:
  |SheetName|Rownumber|
  |TC_Login_Module|0|
  
  
  