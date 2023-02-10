package com.NuReCampus_PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class SelectModulePage {
	@FindBy(xpath = "//div[@class='col-4 ng-star-inserted']")
	private List<WebElement> moduleListElement;
	
	@FindBy(xpath = "//h3[text()='HR Staff Information']")
	private WebElement HrInformationImgBox;
	
	@FindBy(xpath = "(//div[@class='module active']/div[@class='select'])[1]")
	private WebElement HrInformSelectImgIcon;
	
	@FindBy(xpath = "//h3[text()='Fees Management']")
	private WebElement FeesMgmtImgBox;
	
	@FindBy(xpath = "(//div[@class='module active']/div[@class='select'])[2]")
	private WebElement FeesMgmtSelectImgIcon;
	
	@FindBy(xpath = "//h3[text()='Examination']")
	private WebElement ExaminationImgBox;
	
	@FindBy(xpath = "//table/tbody/tr/td")
	private WebElement NoModuleMsg;
	
	@FindBy(xpath = "//table/tfoot/tr/td[text()='Total after trial']")
	private WebElement totalafterTrialTxt;
	
	@FindBy(xpath = "//table/tfoot/tr/td/b[text()='Due today']")
	private WebElement dueTodayTxt;
	
	@FindBy(xpath = "//table/tfoot/tr/td[text()='15000']")
	private WebElement toalPrice;
	
	@FindBy(xpath = "//table/tfoot/tr/td/b[text()='0.00']")
	private WebElement duePrice;
	
	@FindBy(xpath = "(//div[@class='module active']/div[@class='select'])[3]")
	private WebElement ExaminationSelectImgIcon;
	
	
	@FindBy(xpath = "//div[@class='col-4 ng-star-inserted'][4]")
	private WebElement AdmissionMgmtImgBox;
	
	@FindBy(xpath = "(//div[@class='module active']/div[@class='select'])[4]")
	private WebElement AdmissionSelectImgIcon;
	
	@FindBy(xpath = "//div[@class='col-4 ng-star-inserted'][5]")
	private WebElement AcademicAdminImgBox;
	
	@FindBy(xpath = "(//div[@class='module active']/div[@class='select'])[5]")
	private WebElement AcademicAdminSelectImgIcon;
	
	public static WebDriver driver;
	public SelectModulePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void deSelectModule()
	{
		HrInformationImgBox.click();
	
		FeesMgmtImgBox.click();
	//	javaClassUtility.mouseOverOnTheElement(ExaminationImgBox, DriverFactory.getDriver());
		ExaminationImgBox.click();
		AdmissionMgmtImgBox.click();
		AcademicAdminImgBox.click();
	}
	 public void checkModuleSelection()
	 {
			//ArrayList<String> arr1 =new ArrayList<String>();
		 
			for(WebElement Ele : moduleListElement)
			{
				Ele.click();
			}
				
	 }
	
	public void selectModule()
	{
		HrInformationImgBox.click();
		//JavaClassUtility.waitUntilElementVisible(HrInformSelectImgIcon);
		FeesMgmtImgBox.click();
		//JavaClassUtility.waitUntilElementVisible(FeesMgmtSelectImgIcon);
		ExaminationImgBox.click();
		//JavaClassUtility.waitUntilElementVisible(ExaminationSelectImgIcon);
		
		AdmissionMgmtImgBox.click();
		AcademicAdminImgBox.click();
	}

	
		
	}

