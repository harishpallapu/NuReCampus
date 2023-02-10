package com.NuReCampus_PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ReusableTestUtilities;
import utilities.VariableUtilities;



public class ConfigurationPage extends ReusableTestUtilities {

	
	@FindBy(xpath = "//span[@class='primary']/nc-dynamic-text[text()=' Cofiguration Title ']")
	private WebElement CofigurationTitleTxt;
	
	
	@FindBy(xpath = "//div[@class='col-6']//label")
    private List<WebElement> allContentTitle;
	@FindBy(xpath = "//div[@class='p-fileupload-content']")
	private List<WebElement> blankUploadAllImageValue ;
	
	@FindBy(xpath = "(//input[@type='file'])[1]")
	private WebElement uploadLogoImg;
	
	
	@FindBy(xpath = "(//input[@type='file'])[2]")
	private WebElement uploadBackgroundImg;
	
	@FindBy(xpath = "(//input[@type='file'])[3]")
	private WebElement uploadReportHeaderImg;
	
	@FindBy(xpath = "//div[@class='onboarding-process-footer']/button[@class='prev-btn ng-star-inserted']")
	private WebElement PreviousBtn;
	
	@FindBy(xpath = "//div[@class='onboarding-process-footer']/button[@class='prev-btn ng-star-inserted']")
	private WebElement configPreviousBtn;
	
	@FindBy(xpath = "//span[@class='primary']/nc-dynamic-text[@type='message']")
	private WebElement welcomeTxt;
	
	@FindBy(xpath = "//div[contains(text(),' match the pattern.')]")
	private WebElement patternError ;
	
	@FindBy(xpath = "//div[contains(text(),' Minimum length should be 10')]")
	private WebElement phoneNumError ;
	
	/*
	@FindBy(xpath = "//div[@class='overlay text-light']")
    private List<WebElement> allUploadElement;
	*/
	
	@FindBy(xpath = "//div[@class='uplodededImageViewer']")
	private List<WebElement> allUploadElement;
	
	@FindBy(xpath = "//span[@class='p-message-detail ng-tns-c78-8 ng-star-inserted']")
	private WebElement allowedextensionErrorTxt ;
	@FindBy(xpath = "//span[@class='p-message-summary ng-tns-c78-8 ng-star-inserted']")
	private WebElement invalidextensionError ;
	

  /*  @FindBy(xpath = "//input[@id='instituteUrl']")
    private WebElement instituteWebsiteTb;

    @FindBy(xpath = "//input[@id='instituteEmail']")
    private WebElement instituteEmailTb;

    @FindBy(xpath = "//input[@id='institutePhone']")
    private WebElement institutePhoneNumTb;*/
	
	
	@FindBy(xpath = "//input[@id='instituteUrl']")
	 private WebElement instituteWebsiteTb;
	 @FindBy(xpath = "//input[@id='instituteOfficialEmail']")
	 private WebElement instituteEmailTb;
	 @FindBy(xpath = "//input[@id='institutePhone']")
	 private WebElement institutePhoneNumTb;
	 @FindBy(xpath = "//input[@id='nameOfYourInstitution']")
	 private WebElement instituteName;
	 
	
   // @FindBy(xpath = "")
   // private WebElement changeLanguageTb;
    
    @FindBy(xpath = "//p-dropdownitem//span[text()='English']")
    private WebElement selectEnglishTxt;
    
    @FindBy(xpath = "//p-dropdownitem//span[contains(text(),'Hindi')]")
    private WebElement selectHindiTxt;
	@FindBy(xpath = "//p[@class='m-0']")
 private WebElement enterRequiredFieldErrorMsg ;
	
	
	
	VariableUtilities variableUtilities;
	public ConfigurationPage(WebDriver driver) {
		//this.variableUtilities=variableUtilities;
		super(driver);
		PageFactory.initElements(driver, this);
	}	
		
	public void textvisible()
	{
		//variableUtilities.reusabletestUtilities.waitUntilElementVisible(CofigurationTitleTxt);
	}
	public void configpagedata(String website,String mailId,String phoneNum) throws InterruptedException {		
		
		instituteWebsiteTb.clear();
		instituteWebsiteTb.sendKeys(website);
		
		/*uploadLogoImg.sendKeys(logofilePath);
		uploadBackgroundImg.sendKeys(backgroundimagefilePath);
		uploadReportHeaderImg.sendKeys(reportheaderfilePath);*/
		instituteEmailTb.clear();
		instituteEmailTb.sendKeys(mailId);
		institutePhoneNumTb.clear();
		institutePhoneNumTb.sendKeys(phoneNum);
		
		
	}
	
	public boolean validateConfigurationTitleAndAllContent() {
       /* String title = CofigurationTitleTxt.getText();
        Assert.assertTrue(title.contains("Cofiguration Title"));*/

        ArrayList<String> arr1 =new ArrayList<String>();
        for(WebElement ele : allContentTitle)
        {
            arr1.add(ele.getText());
        }
        ArrayList<String> arr2 =new ArrayList<String>();
        arr2.add("Name of your institution");//change all add name contains according to UI
        arr2.add("Website address");
        arr2.add("Upload institute logo to be used in reports (Max. size 2 MB. png or jpg)");
        arr2.add("Upload image for watermark to be used in reports (Max. size 4 MB. png or jpg)");
        arr2.add("Upload image to be used in report headers (Max. size 2 MB. png or jpg)");
        arr2.add("Institute official email");
        arr2.add("Mobile number");
        arr2.add("Change language");                      
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
	

	public boolean validateBlankAllUploadImageValue() //new method added
	{
	 ArrayList<String> arr1 =new ArrayList<String>();
	 for(WebElement ele : blankUploadAllImageValue)
	{
 arr1.add(ele.getText());
 System.out.println(ele.getText());
}
ArrayList<String> arr2 =new ArrayList<String>();
 arr2.add("");
 arr2.add("");
 arr2.add("");
 boolean flag=false;
 System.out.println(arr1+"\n"+arr2);
 if(arr1.equals(arr2))
{
System.out.println("There should be blank with no data");
 flag=true;
}
 return flag;
 }


	/*public void instituteWebsite(String website)
	{
		instituteWebsiteTb.clear();
		instituteWebsiteTb.sendKeys(website);
	}*/
/*	
public void uploadLogoImage(String filePath)
	{
		uploadLogoImg.sendKeys(filePath);
	}
*/	
/*

public void uploadLogoImage( String dataflag, String filePath,String extension)//Modification done
{
 if(dataflag.contains("valid") && extension.equals("jpg") &&  extension.equals("png"))
{
 uploadLogoImg.sendKeys(filePath);
}
 
 else if(dataflag.contains("invalid") && extension.equals("jpg") &&  extension.equals("png"))
{
uploadLogoImg.sendKeys(filePath);
getEnterRequiredFieldErrorMsg();
}
 
 else if(dataflag.contains("invalid") && !extension.equals("png") && !extension.equals("jpg"))
 {
uploadLogoImg.sendKeys(filePath);
getInvalidUploadExtensionError();
getAllowedFileListMsg();

}
 }
*/
	public void uploadLogoImage(String filePath)//Modification done
	{
	
	 uploadLogoImg.sendKeys(filePath);
	}
	 
	
	public void uploadLogovalidations(String dataflag)//Modification done
	{
	 if(dataflag.contains("valid"))
	{
	 System.out.println("File uploaded succesfully");
	}
	 
	 else if(dataflag.contains("invalid"))
	{
	
	getEnterRequiredFieldErrorMsg();
	}
	 
	 else if(dataflag.contains("invalidfileextension"))
	 {
	
	getInvalidUploadExtensionError();
	getAllowedFileListMsg();

	}
	 }

public String getInvalidUploadExtensionError()
{
 return invalidextensionError.getText();
}



public String getAllowedFileListMsg()
{
return allowedextensionErrorTxt.getText();
}

/*
public void uploadBackgroundImage(String filePath)
	{
		uploadBackgroundImg.sendKeys(filePath);
	}
	*/

public void uploadBackgroundImage(String filePath, String dataflag, String extension)//Modification done
{
 if(dataflag.contains("valid") && extension.equals("jpg") &&  extension.equals("png"))
{
	 uploadBackgroundImg.sendKeys(filePath);
}
 
 else if(dataflag.contains("invalid") && extension.equals("jpg") &&  extension.equals("png"))
{
	 uploadBackgroundImg.sendKeys(filePath);
getEnterRequiredFieldErrorMsg();

}
 else if(dataflag.contains("invalid") && !extension.equals("png") && !extension.equals("jpg"))
 { 
	 uploadBackgroundImg.sendKeys(filePath);
	 
	 getInvalidUploadExtensionError();
getAllowedFileListMsg();

}
 }

public void uploadReportHeaderImage(String filePath, String dataflag, String extension)//Modification done
{
 if(dataflag.contains("valid") && extension.equals("jpg") &&  extension.equals("png"))
{
	 uploadReportHeaderImg.sendKeys(filePath);
}
 
 else if(dataflag.contains("invalid") && extension.equals("jpg") &&  extension.equals("png"))
{
	 uploadReportHeaderImg.sendKeys(filePath);
getEnterRequiredFieldErrorMsg();

}
 
 else if(dataflag.contains("invalid") && !extension.equals("png") && !extension.equals("jpg"))
 { 
	 uploadReportHeaderImg.sendKeys(filePath);
	 
	 getInvalidUploadExtensionError();
getAllowedFileListMsg();

}
 }


/*
	public void uploadReportHeaderImage(String filePath)
	{
		uploadReportHeaderImg.sendKeys(filePath);
	}
*/	
	public void selectHindiLanguage()
	{
		//changeLanguageTb.click();
		//variableUtilities.reusabletestUtilities.windowsscrollfordropdwown();
		windowsscrollfordropdwown();
		//changeLanguageTb.click();
		selectHindiTxt.click(); 
	
	}
	
	/*public void enterMailId(String mailId) {
		instituteEmailTb.clear();
		instituteEmailTb.sendKeys(mailId);
	}*/
	
	/*public void enterPhoneNumber(String phoneNum) {
		institutePhoneNumTb.clear();
		institutePhoneNumTb.sendKeys(phoneNum);
	}*/
	
	public void clickPreviousButton()
	{
		PreviousBtn.click();
		
	}
	public void configPreviousButton()
	{
		configPreviousBtn.click();
	}
	
	public String validateErrorMsg() {
		//Assert.assertTrue(patternError.getText().contains("Entered value doesn't match the pattern."));
 return patternError.getText();
	}
	
	public String validatePhoneNumError() {
		//Assert.assertTrue(phoneNumError.getText().contains("Minimum length should be 10"));
	return phoneNumError.getText();
	}
	
	
	public String getEnterRequiredFieldErrorMsg()
{
	return	enterRequiredFieldErrorMsg.getText();
	}

public String getInstitutename() {
	
	String nameoftheinstitution=instituteName.getAttribute("value");
	return nameoftheinstitution;
}


	
	public boolean validateExistingDataFromPreviousPage(String excelWebsite, String excelMailId, String excelphNum)
    {
        String website = instituteWebsiteTb.getAttribute("value");
        String emailId = instituteEmailTb.getAttribute("value");
        String phNum = institutePhoneNumTb.getAttribute("value");
System.out.println(website);
System.out.println(emailId);
System.out.println(phNum);
        
        ArrayList<String> arr1 =new ArrayList<String>();
        for(WebElement ele : allUploadElement)
        {
           System.out.println(arr1.add(ele.getText()));
        }
        ArrayList<String> arr2 =new ArrayList<String>();
        arr2.add("Image4.jpg");
        arr2.add("Image5.jpg");
        arr2.add("Image6.jpg");

        boolean flag=false;
       if(website.equals(excelWebsite) && emailId.equals(excelMailId) && phNum.equals(excelphNum) && arr1.equals(arr2))
       // if(website.equals(excelWebsite) && emailId.equals(excelMailId) && phNum.equals(excelphNum))
            
        {
            System.out.println("Existing data verified successfully");
            flag=true;

        }
        //Assert.assertTrue(flag);
        return(flag);
    }

}
	
	
	
	
	/*public String getinstituteWebsiteAttribute() {
		
		 String instituteWebsiteinapp=instituteWebsiteTb.getAttribute("value");   
		 return instituteWebsiteinapp;		 	
		
	}
	public String getinstituteemailAttribute() {
				
		String instituteemailinapp = instituteEmailTb.getAttribute("value");
		return instituteemailinapp; 	
		
	}
	
	public String getinstitutePhoneNumAttribute() {
		
	String institutePhoneNuminapp= institutePhoneNumTb.getAttribute("value");
	return institutePhoneNuminapp;
}*/

