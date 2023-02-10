package CucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
 

@CucumberOptions(features={"src\\test\\java\\com\\NuReCampus\\Features"},
glue ="com\\NuReCampus\\StepDefinitionFiles",//tags=" @OnboardingConfiguration_with_filesizes_UploadLogo_UploadReportHeader",//tags="@Registration_with_validdata",//tags="@OnboardingConfiguration_Page_Content or @OnboardingConfiguration_with_Validdata_autosave or @OnboardingConfiguration_with_InValiddata",//tags=" @Registration_with_Duplicatedata or @Registration_with_invaliddata",
		 //tags="@Registration_with_Duplicatedata",//tags=" @tag1 or @tag2 or @tag3 or @tag4",//tags="@Registration_with_invaliddata",

//tags="@OnboardingConfiguration_with_Validdata_AutoSave or  @OnboardingConfiguration_with_InValiddata",//tags="@Registration_with_Duplicatedata",//tags="@tag1 or @tag2 or @tag3 or @tag4 or @tag5", 
monochrome =true,stepNotifications=true,
plugin = {"html:target/cucumber.html","json:target/cucumber.json","junit:target/cukes.xml"
		,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

//monochrome=true,

// tags= ("@FirstTest or @SecondTest"),
// tags="@FirstTest",
// tags = ("not @ThridTest and not @FourthTest"),

public class NurecampusrunnerTest {

}
