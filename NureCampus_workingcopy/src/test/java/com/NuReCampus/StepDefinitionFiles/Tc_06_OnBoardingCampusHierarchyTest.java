package com.NuReCampus.StepDefinitionFiles;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;

import com.NuReCampus_PageObjects.CampusHierarchyPage;
import com.NuReCampus_PageObjects.ConfigurationPage;
import com.NuReCampus_PageObjects.NextButtonPage;
import com.NuReCampus_PageObjects.OnboardingPage;
import com.NuReCampus_PageObjects.PreviousButtonPage;
import com.NuReCampus_PageObjects.SelectModulePage;
import com.NuReCampus_PageObjects.UsersAndRolesPage;

import io.cucumber.java.en.Then;
import utilities.VariableUtilities;

public class Tc_06_OnBoardingCampusHierarchyTest {

	VariableUtilities variableUtilities;
	OnboardingPage onboardingPage;
	utilities.ConfigReader configReader;
	SelectModulePage selctPage;
	ConfigurationPage configPage;
	NextButtonPage nxtPage;
	PreviousButtonPage prevPage;
	CampusHierarchyPage campusHierarchyPage;	
	UsersAndRolesPage usersandrolesPage;
	
	public Tc_06_OnBoardingCampusHierarchyTest(VariableUtilities variableUtilities)
	{
		this.variableUtilities=variableUtilities;
		this.onboardingPage=variableUtilities.allpageObjects.getonboardingpage();
		this.selctPage=variableUtilities.allpageObjects.getselectModulepage();
		this.configPage=variableUtilities.allpageObjects.getconfigurationepage();
		this.nxtPage=variableUtilities.allpageObjects.getNextbuttonpage();
		this.prevPage=variableUtilities.allpageObjects.getPreviousbuttonpage();
		this.configReader=variableUtilities.configReader;
		this.campusHierarchyPage=variableUtilities.allpageObjects.getCampushierarchypage();
		this.usersandrolesPage=variableUtilities.allpageObjects.getUsersandrolespage();
				
		
		
	}
	
	
	
	@Then("Verify groups not exist in campus Hierarchy")
	public void verify_groups_not_exist_in_campus_hierarchy() {
		
		boolean flag = campusHierarchyPage.validateNoGroupPresent();
		Assert.assertTrue(flag);
		System.out.println("Group not present");
	}
	
	
	@Then("Create a parent group")
	public void create_a_parent_group() throws EncryptedDocumentException, IOException {
		
		String title = campusHierarchyPage.getAddNewGroupTitle();
		System.out.println(title);
		Assert.assertTrue(title.contains("Add A New Group"));
		boolean flag = campusHierarchyPage.validateAllStaticHeadersOfNewGroupCreation();
		Assert.assertTrue(flag);
		String resourceName = campusHierarchyPage.getStaticParentResourceName();
		Assert.assertTrue(resourceName.contains("Campus"));
		
	
		//String groupName = ConfigReader.getDataFromExcel("TC_01_OnBoarding_Module", 15, 1);
		System.out.println(variableUtilities.groupName);
		System.out.println(variableUtilities.msg);
		
			
		
		//String msg = ConfigReader.getDataFromExcel("TC_01_OnBoarding_Module", 16, 1);
		
		
		String sucessMsgforfirstParent = campusHierarchyPage.createParentGroup(variableUtilities.groupName, variableUtilities.msg);
		System.out.println(sucessMsgforfirstParent);
		
		Assert.assertTrue(sucessMsgforfirstParent.contains("Added User Group successfully!"));
	}
	
	@Then("Create Child group in a parent")
	public void create_child_grop_in_a_parent() throws EncryptedDocumentException, IOException {
		String parentGroupName = campusHierarchyPage.getParentGroupNameFromGrid();
		System.out.println("###########"+parentGroupName);
		Assert.assertTrue(parentGroupName.contains(variableUtilities.groupName));
		/*String groupName = ConfigReader.getDataFromExcel("TC_01_OnBoarding_Module", 17, 1);
		System.out.println(groupName);
		String msg = ConfigReader.getDataFromExcel("TC_01_OnBoarding_Module", 18, 1);*/
		
		
		String sucessMsgforsecondParent = campusHierarchyPage.createChildGroup(variableUtilities.childgroupName, variableUtilities.childdecriptionmsg);
		Assert.assertTrue(sucessMsgforsecondParent.contains("Added User Group successfully!"));
		System.out.println("Added user group successfully");

	}
	@Then("Create second parent child group in parent")
	public void create_second_parent_child_group_in_parent() throws EncryptedDocumentException, IOException {
		String secondParentGroupName = campusHierarchyPage.getSecondParentGroupFromGrid();
		Assert.assertTrue(secondParentGroupName.contains(variableUtilities.childgroupName));
		/*String groupName = ConfigReader.getDataFromExcel("TC_01_OnBoarding_Module", 19, 1);
		String msg = ConfigReader.getDataFromExcel("TC_01_OnBoarding_Module", 20, 1);*/
		
		
		String sucessMsg = campusHierarchyPage.createSecondParentChildGroup(variableUtilities.secondchild, variableUtilities.secondchildmsg);
		Assert.assertTrue(sucessMsg.contains("Added User Group successfully!"));
		System.out.println("Added user group successfully");
	}
	@Then("click on Add users Next button")
	public void click_on_add_users_next_button() {
		
		campusHierarchyPage.clickAddUserNextButton();
	}
	
	@Then("Verify Users and roles page loaded fully")
	public void verify_users_and_roles_page_loaded_fully() {

		String title= usersandrolesPage.validateUserAndRolesTitle();
		Assert.assertTrue(title.contains("Awesome"));
		System.out.println("users and roles module loaded sucessfully");
	}

	@Then("click on Previous campus hierarchy button")
	public void click_on_previuos_campus_hierarchy_button() {
		campusHierarchyPage.clickcmpPreviousButton();

	}
	@Then("Select Parent group")
	public void select_Parent_group() {
		
		campusHierarchyPage.selectParentGroup();
		
	}
	




	@Then("Click on Delete button")
	public void click_on_delete_button() {
		
		campusHierarchyPage.deleteCampusHierarchy();

	}
	
	@Then("Verify Delete PopUp content")
	public void verify_Delete_PopUp_content() {
		String blueContent = campusHierarchyPage.getBlueConentInDltPopup();
		Assert.assertTrue(blueContent.contains("You are about to delete the group"));
		boolean flag = campusHierarchyPage.getRedContentInDltPopup();
		Assert.assertTrue(flag);
		System.out.println("Delete content popup validate successfully");
	}
	
	
	@Then("Click on Yes I am sure button")
	public void click_on_yes_i_am_sure_button() {
		campusHierarchyPage.clickYesIamSureButton();
	
	}
	
	@Then("Verify Group cannot be deleted message")
	public void verify_group_cannot_be_deleted_message() {
		String message = campusHierarchyPage.validateGroupCannotDltMsg();
		Assert.assertTrue(message.contains("This group has subGroups, you can't delete this group."));
		System.out.println("validate msg successfully");
	}

	@Then("Delete child group and verify message")
	public void delete_child_group_and_verify_message() {
		String Dltmessage = campusHierarchyPage.deleteChildGroupAndValidate();
		Assert.assertTrue(Dltmessage.contains("Group is deleted."));
		System.out.println("Child Group is deleted successfully");
	}
	
	@Then("Delete parent group and verify message")
	public void delete_parent_group_and_verify_message() {
		String Dltmessage = campusHierarchyPage.deleteParentGroupAndValidate();
		 Assert.assertTrue(Dltmessage.contains("Group is deleted."));
		 System.out.println("Parent Group is deleted successfully");
	}


	@Then("Delete SubChild group and verify message")
	public void delete_sub_child_group_and_verify_message() {
		
		String Dltmessage = campusHierarchyPage.deleteSecondParentChildGroupAndValidate();
		Assert.assertTrue(Dltmessage.contains("Group is deleted."));
		System.out.println("SubChild Group is deleted successfully");
	}


	@Then("click on Cancel button")
	public void click_on_cancel_button() {
		campusHierarchyPage.clickCancelDltButton();
	}

	@Then("Verify ParentGroup is not deleted")
	public void verify_parent_group_is_not_deleted() {
		
		boolean flag = campusHierarchyPage.validateParentIsNotDeleted();
		Assert.assertFalse(flag);
	}

}
