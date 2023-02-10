package com.NuReCampus_PageObjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersAndRolesPage {
	WebDriver driver;

	@FindBy(xpath = "//nc-dynamic-text[text()='  Awesome  ']")
	private WebElement awesomeTitle;
	
	@FindBy(xpath = "//div[@id='pr_id_23']")
	private WebElement allDataTableContent;
	
	//table/thead/tr/th
	@FindBy(xpath = "//table/thead/tr/th")
	private WebElement allTableHeadDataContent;
	
	@FindBy(xpath = "//button[text()='Add New ']")
	private WebElement addNewTb;
	
	@FindBy(xpath = "//ul//a[text()=' Add New User']")
	private WebElement dropDownAddNewUserTb;
	
	@FindBy(xpath = "//div//nc-dynamic-text[text()='  Add  User ']")
	private WebElement addUserTxt;
	
	@FindBy(xpath = "//nc-dynamic-text[text()=' Full Name ']")
	private WebElement fullNameTxt;
	
	@FindBy(xpath = "//input[@id='fullName']")
	private WebElement enterFullNameTb;
	
	@FindBy(xpath = "//nc-dynamic-text[text()='  Email  ']")
	private WebElement emailTxt;
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement enterEmailTb;
	
	@FindBy(xpath = "//nc-dynamic-text[text()='  Role  ']")
	private WebElement roleTxt;
	
	@FindBy(xpath = "//p-dropdown[@placeholder='Select a Role']")
	private WebElement clickSelectARoleDropdownTb;
	
	@FindBy(xpath = "//p-dropdownitem[@class='p-element ng-tns-c76-41 ng-star-inserted']")
	private List<WebElement> totalDropDownItems;
	
	@FindBy(xpath = "//nc-dynamic-text[text()=' Campus Hierarchy ']")
	private WebElement campusHierarchyTxt;
	
	@FindBy(xpath = "//div[@class='heirarchy-selected']")
	private WebElement clikCampusHierarchyDropDownTb;
	
	@FindBy(xpath = "//li[@class='p-treenode p-treenode-leaf ng-star-inserted']")
	private List<WebElement> totalDropDownListOfCampusHierarchy;
	
	@FindBy(xpath = "//nc-dynamic-text[text()=' Cancel  ']")
	private WebElement AddUserCancelButton;
	
	@FindBy(xpath = "//button[@class='add']")
	private WebElement AddNewUserButton;
	
	
	public UsersAndRolesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String validateUserAndRolesTitle()
	{
		return awesomeTitle.getText();
		
	}
}
