package com.NuReCampus_PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampusHierarchyPage {

	WebDriver driver;
	@FindBy(xpath = "//nc-dynamic-text[text()='  Great ']")
	private WebElement campusHirarchyTitle ;
	
	@FindBy(xpath = "//nc-dynamic-text")
	private List<WebElement> AllCampusHirarchyContent ;
	
	@FindBy(xpath = "//a[@class='ng-star-inserted']")
	private WebElement parentGroupElement ;
	
	@FindBy(xpath = "(//a[@class='ng-star-inserted active'])[2]")
	private WebElement DltChildGroupElement ;
	
	
	@FindBy(xpath = "(//a[@class='ng-star-inserted active'])[1]")
	private WebElement DltParentGroupElement ;
	
	
	@FindBy(xpath = "//nc-dynamic-text[text()=' Campus Hierarchy ']")
	private WebElement fromCampusTableHirarchyTitle ;
	
	@FindBy(xpath = "//h6[text()='Campus']")
	private WebElement fromGridTableCampusTitle ;
	
	@FindBy(xpath = "//div[@class='grid-menu']")
	private List<WebElement> gridMenu ;
	
	@FindBy(xpath = "//div[@class='grid-col ng-star-inserted']/descendant::button[@class='grid-create-btn']")
	private WebElement fromGridTableCampusCreatGroup ;
	
	@FindBy(xpath = "(//div[@class='grid-col ng-star-inserted']/descendant::button[@class='grid-create-btn'])[2]")
	private WebElement fromParentToChildCreatGroup ;
	
	@FindBy(xpath = "(//div[@class='grid-col ng-star-inserted']/descendant::button[@class='grid-create-btn'])[3]")
	private WebElement fromChildToSubChildCreatGroup ;
	
	//div/nc-dynamic-text[text()=' Add A New Group ']
	@FindBy(xpath = "//div/nc-dynamic-text[text()=' Add A New Group ']")
	private WebElement addANewGroupPopUpTitle ;
	
	@FindBy(xpath = "//div[@class='ng-tns-c18-39 p-dialog-content']")
	private WebElement allContentOfaddNewGroup ;
	
	@FindBy(xpath = "//div[@class='col-12']/descendant::nc-dynamic-text")
	private List<WebElement> allStaticContentTitle ;
	
	@FindBy(xpath = "(//div[@class='col-12']/descendant::nc-dynamic-text)[1]")
	private WebElement groupNameTxt ;
	
	@FindBy(xpath = "//input[@id='name']")
	private WebElement groupNameTb ;
	
	@FindBy(xpath = "(//div[@class='col-12']/descendant::nc-dynamic-text)[2]")
	private WebElement parentResourceTxt ;
	
	@FindBy(xpath = "//input[@name='parentGroupName']")
	private WebElement defaultparentGroupNameTb ;
	
	@FindBy(xpath = "(//div[@class='col-12']/descendant::nc-dynamic-text)[3]")
	private WebElement discriptionTxt ;
	
	@FindBy(xpath = "//input[@id='parentGroupName']")
	private WebElement parentStaticGroupNameTb ;
	
	
	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement discriptionTb ;
	
	@FindBy(xpath = "//nc-dynamic-text[text()=' Cancel  ']")
	private WebElement addGroupcancelButton ;
	
	@FindBy(xpath = "//nc-dynamic-text[text()=' Add New Group Button ']")
	private WebElement addNewGroupButton ;
	
	@FindBy(xpath = "//div/p[text()='Added User Group successfully!']")
	private WebElement addUserGroupSuccessfullyMsg ;
	
	@FindBy(xpath = "//div/a[@class='ng-star-inserted']")
	private WebElement newGroupVisibleInGrid;
	
	@FindBy(xpath = " //button/nc-dynamic-text[text()=' Campus Hierarchy Delete Button ']")
	private WebElement campusHierarchyDeleteButtonTb;
	
	@FindBy(xpath = "//p[@class='blue-para']")
	private WebElement youAreAboutToDltTxt;
	
	@FindBy(xpath = "//p[@class='pink-para']")
	private List<WebElement> redLineDltcontentdiscriptionTxt;
	
	
	@FindBy(xpath = "//form[@class='ng-tns-c18-11']")
	private WebElement totalDltPopUpContent;
	
	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement deleteGroupPopUpCancelButton;
	
	@FindBy(xpath = "//button[text()='Yes, I Am Sure. Delete The Records']")
	private WebElement yesSureDeleteDRecordsPopUpButton;
	
	@FindBy(xpath = "//div/p[text()='Group is deleted.']")
	private WebElement groupIsDeletedMessageTxt;
	
	@FindBy(xpath = "//p[@class='m-0']")
	private WebElement parentHavingSubgroupDeleteMessageTxt;
	
	@FindBy(xpath = "//button[@class='next-btn ng-star-inserted']")
	private WebElement clickNextAddUsersButton;
	
	@FindBy(xpath = "//button[@class='prev-btn ng-star-inserted']")
	private WebElement clickPreviousCampusHierarchyButton;
	
	@FindBy(xpath = "(//h6)[2]")
	private WebElement parentGroupName;
	
	@FindBy(xpath = "(//h6)[3]")
	private WebElement secondParentGroupName;
	
	public CampusHierarchyPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	
	public String getCampusHierarchyTitle()
	{
		return campusHirarchyTitle.getText();
		
	}
	
	
	public String validateCampusHirarchyUrl() {
		//return campusHirarchyTitle.getText();
		return driver.getCurrentUrl();
		
	}
	
	public boolean validateNoGroupPresent()
	{
		boolean flag=false;
		try {
			parentGroupElement.click();
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Group not present");
			flag=true;
			Assert.assertTrue(flag);
		}
		return flag;
	}
	
	public String getAddNewGroupTitle() 
	{
		fromGridTableCampusCreatGroup.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String title=addANewGroupPopUpTitle.getText();
		return title;
	}
	public boolean validateAllStaticHeadersOfNewGroupCreation()
	{
		ArrayList<String> arr1 =new ArrayList<String>();
		for(WebElement ele : allStaticContentTitle)
		{
			arr1.add(ele.getText());
		}
		ArrayList<String> arr2 =new ArrayList<String>();
		arr2.add("Group Name");
		arr2.add("Parent Resource");
		arr2.add("Discription");
		System.out.println(arr1);
		System.out.println(arr2);
		boolean flag=true;
		for(String str1: arr1)
		{
			if(!arr2.contains(str1))
			{
				flag=false;
			}
		}
		
		return flag;
	}
	public String getStaticParentResourceName()
	{
		
		return parentStaticGroupNameTb.getAttribute("value");
		
	}
	
	
	
	public String createParentGroup(String groupName, String msg)
	{
		groupNameTb.sendKeys(groupName);
		discriptionTb.sendKeys(msg);
		addNewGroupButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sucessMsg = addUserGroupSuccessfullyMsg.getText();
		return sucessMsg;
		
	}
	public String getParentGroupNameFromGrid()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parentGroupElement.click();
		return parentGroupName.getText();
		
		
	}
	
	
	
	public String createChildGroup(String groupName, String msg)
	{
		
		fromParentToChildCreatGroup.click();

		groupNameTb.sendKeys(groupName);
		discriptionTb.sendKeys(msg);
		addNewGroupButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sucessMsg = addUserGroupSuccessfullyMsg.getText();
		return sucessMsg;
		
	}
	
	public String getSecondParentGroupFromGrid()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parentGroupElement.click();
		return secondParentGroupName.getText();
		
		
	}
	
	
	public String createSecondParentChildGroup(String groupName, String msg)
	{
		fromChildToSubChildCreatGroup.click();
		
		groupNameTb.sendKeys(groupName);
		discriptionTb.sendKeys(msg);
		addNewGroupButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sucessMsg = addUserGroupSuccessfullyMsg.getText();
		return sucessMsg;
		
	}
	
	public void clickAddUserNextButton()
	{
		clickNextAddUsersButton.click();
	}
	
	public void clickcmpPreviousButton()
	{
		clickPreviousCampusHierarchyButton.click();
	}
	
	public void selectParentGroup()
	{
		parentGroupElement.click();
	}
	
	public void deleteCampusHierarchy()
	{
		campusHierarchyDeleteButtonTb.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getBlueConentInDltPopup()
	{
		return youAreAboutToDltTxt.getText();
		
	}
	public boolean getRedContentInDltPopup()
	{
		ArrayList<String> arr1 =new ArrayList<String>();
		for(WebElement ele : redLineDltcontentdiscriptionTxt)
		{
			arr1.add(ele.getText());
		}
		ArrayList<String> arr2 =new ArrayList<String>();
		arr2.add("These changes are irreversible and can not be undone.");
		arr2.add("Are you sure you want to proceed?");
		System.out.println(arr1);
		System.out.println(arr2);
		boolean flag=true;
		for(String str1: arr1)
		{
			if(!arr2.contains(str1))
			{
				flag=false;
			}
		}
		
		return flag;
	}
	
	
	public void clickYesIamSureButton()
	{
		yesSureDeleteDRecordsPopUpButton.click();
	}
	
	public String validateGroupCannotDltMsg()
	{
		String message = parentHavingSubgroupDeleteMessageTxt.getText();
		return message;
	}
	
	public String deleteSecondParentChildGroupAndValidate()
	{
		parentGroupElement.click();
		campusHierarchyDeleteButtonTb.click();
		yesSureDeleteDRecordsPopUpButton.click();
		
		String Dltmessage = groupIsDeletedMessageTxt.getText();
		return Dltmessage;
		
	}
	 public String deleteChildGroupAndValidate()
	 {
		 DltChildGroupElement.click();
		 campusHierarchyDeleteButtonTb.click();
		 yesSureDeleteDRecordsPopUpButton.click();
		 
		 String Dltmessage = groupIsDeletedMessageTxt.getText();
		 return Dltmessage;
	 }
	 
	 public String deleteParentGroupAndValidate()
	 {
		 DltParentGroupElement.click();
		 campusHierarchyDeleteButtonTb.click();
		 yesSureDeleteDRecordsPopUpButton.click();
		 
		 String Dltmessage = groupIsDeletedMessageTxt.getText();
		 return Dltmessage;
	 }
	 
	 public void clickCancelDltButton()
	 {
		 deleteGroupPopUpCancelButton.click();
	 }
	 
	 public void validateParentGroupNotDlted()
	 {
		 String Dltmessage = groupIsDeletedMessageTxt.getText();
		 Assert.assertTrue(Dltmessage.contains("Group is deleted."));
		 System.out.println("Parent group is deleted successfully");
	 }
	 
	 public boolean validateParentIsNotDeleted()
	 {
	 parentGroupElement.getText();
		 boolean flag=false;
			try {
				parentGroupElement.getText();
				System.out.println("Group is present");
			}
			catch(NoSuchElementException e)
			{
				System.out.println("Group not present");
				flag=true;
				
			}
			return flag;
	 }
	 
	 
}
