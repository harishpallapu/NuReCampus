package com.NuReCampus.StepDefinitionFiles;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.VariableUtilities;

public class Hooks {
	VariableUtilities variableUtilities;

	public Hooks(VariableUtilities variableUtilities)
	{
		this.variableUtilities=variableUtilities;
	}
	


/*
@Before("@Registration_with_validdata,@Registration_with_invaliddata,@Registration_with_Duplicatedata")
public void pagerefresh() throws IOException
{
	variableUtilities.baseTestComponents.invokebrowser().navigate().refresh();
}
*/
/*
	@After()
	public void browserlaunch() throws IOException {
		
		if(variableUtilities.baseTestComponents.invokebrowser().getCurrentUrl().contains("https://erp.campuslabs.in/qa/"))
			
		{
			variableUtilities.baseTestComponents.invokebrowser();
		}
		else if(variableUtilities.baseTestComponents.invokebrowser().getCurrentUrl().contains("https://erp.campuslabs.in/qa/register"))
		{
			variableUtilities.baseTestComponents.invokebrowser().navigate().refresh();
			
		}
	
	}
*/
@AfterStep
public void getScreenshot(Scenario scenario) throws IOException
{
	WebDriver driver=variableUtilities.baseTestComponents.invokebrowser();

	if(scenario.isFailed())
	{
	File sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	byte[] filecontent=FileUtils.readFileToByteArray(sourcepath);
	scenario.attach(filecontent,"image/png","image");
	
	}
}

@After
public void teardown() throws IOException {
	
	
	variableUtilities.baseTestComponents.invokebrowser().close();
}

}
