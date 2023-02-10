package com.NuReCampus_PageObjects;

import org.openqa.selenium.WebDriver;

import utilities.VariableUtilities;

public class AllPageObjects {

	public LoginPage loginpage;
	public OnLandingPage onlandingpage;
	public WebDriver driver;
	public RegistrationPage registrationPage;
	public OnboardingPage onboardingPage;
	public SelectModulePage selectModulePage;
	public ConfigurationPage configurationPage;
	public NextButtonPage nextButtonPage;
	public PreviousButtonPage previousButtonPage;
	public CampusHierarchyPage campusHierarchyPage;
	public VariableUtilities variableUtilities;
	public UsersAndRolesPage usersandrolesPage;
	
	public AllPageObjects(WebDriver driver)
	
	{
		
		this.driver=driver;
	}

	
	public LoginPage getloginpage ()
	{
		
		
		loginpage=new LoginPage(driver);
		return loginpage ;
    	
	}

	
	public  OnLandingPage getonlandingpage () {
		
		
		onlandingpage=new OnLandingPage(driver);
		return onlandingpage;
	}
public RegistrationPage getonRegistrationpage () {
		
		
		registrationPage=new RegistrationPage(driver);
		return registrationPage;
	}
	
	

public OnboardingPage getonboardingpage () {
	
	
	onboardingPage=new OnboardingPage(driver);
	return onboardingPage;
}

//SelectModulePage selectModulePage

public SelectModulePage getselectModulepage () {
	
	
	selectModulePage=new SelectModulePage(driver);
	return selectModulePage;
}

//ConfigurationPage configurationPage
public ConfigurationPage getconfigurationepage () {
	
	
	configurationPage=new ConfigurationPage(driver);
	return configurationPage;
}

//NextButtonPage nextButtonPage
public NextButtonPage getNextbuttonpage () {
	
	
	nextButtonPage=new NextButtonPage (driver);
	return nextButtonPage;
}
//PreviousButtonPage previousButtonPage
public PreviousButtonPage getPreviousbuttonpage () {
	
	
	previousButtonPage=new PreviousButtonPage (driver);
	return previousButtonPage;
}

//CampusHirarchyPage campusHierarchyPage
public CampusHierarchyPage getCampushierarchypage () {
	
	
	campusHierarchyPage=new CampusHierarchyPage(driver);
	return campusHierarchyPage;
}

//UsersAndRolesPage usersandrolesPage
public UsersAndRolesPage getUsersandrolespage () {
	
	
	usersandrolesPage=new UsersAndRolesPage(driver);
	return usersandrolesPage;
}



}


	

