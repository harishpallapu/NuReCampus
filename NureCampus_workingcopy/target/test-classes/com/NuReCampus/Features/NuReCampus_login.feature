Feature: Online_NureCampus_Login_Module 

@Login_with_valid_credentials
Scenario Outline:NuReCampus_Login|TC_01_User_checks_the_authenticity_of_the_credentials_received_on_registered_email_address 
#Given User will go to registered email 
#Then User Verify login Creditial and login button in the email
Given User launches the browser and hit the Login page Url
#Then User Verify Login page all the content is displayed
And User enter <Username> and <Password> got on his email and click on login button
Then User lands on onboardingpage

Examples:     
      |Username|Password|
      |kondal.rao@3i-infotech.com|info@1234|
      
@Login_with_invalid_credentials
Scenario Outline:NuReCampus_Login|TC_02_User_tampered_the_login_Credential_received_on_registered_email_address
#Given User will go to registered email 
#Then User Verify login Creditial and login button in the email
Given User launches the browser and hit the Login page Url
#Then User Verify Login page all the content is displayed
And User enter <Username> and <Password> got on his email and click on login button
But User lands on loginpage 
 Examples:     
      |Username|Password|
     
      |kondal.rao@3i-infotech.com|info@123|
      
@login_backward__forward
Scenario Outline:NuReCampus_Login|TC_03_User_checks_the_authenticty_using_browser_back_and_forward_actions 
#Given User will go to registered email 
#Then User Verify login Creditial and login button in the email
Given User launches the browser and hit the Login page Url
#Then User Verify Login page all the content is displayed
#And User enter <Username> and <Password> got on his email and click on login button
#When User logout from the session
Then User clicks browser Backward button and check the login page is redirected
Then User clicks browser Forward button and check the login page is redirected





Examples:     
      |Username|Password|
      |sayyed.shahin@3i-infotech.com|info@1234|      
     

      