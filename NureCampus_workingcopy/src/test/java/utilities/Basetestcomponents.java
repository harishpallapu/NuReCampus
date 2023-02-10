package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetestcomponents {

	public WebDriver driver;
	public String QAloginenv;
	public String QAlandingenv;
	public String QAModuleenv;
	public String QAConfigenv;
	public String QACampushierarchyenv;
	public String QAUsersandRolesenv;
	 
	public Basetestcomponents() {
		
		this.driver=driver;
		
	}
	
	
public WebDriver invokebrowser() throws IOException {
	
	
	FileInputStream fileInput=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
	
	Properties prop=new Properties();
	prop.load(fileInput);
	//String QAenvironment=prop.getProperty("QALoginURL");//login URL
	//String QAenvironmentlandinURL=prop.getProperty("QALoginURL");//landing URL
		

	
  if(driver==null) {
	  
		
  String browserInstance = System.getProperty("browser")!= null ? System.getProperty("browser")
				: prop.getProperty("browser");
  String QAenvironment=System.getProperty("QAURL")!=null?System.getProperty("QAURL"):prop.getProperty("QAURL");
  String QAregistraionenv=prop.getProperty("QARegistrationURL");
  //QAModulepageloginURL=https://erp.campuslabs.in/qa/login
  //QAURL=https://erp.campuslabs.in/qa/dashboard-login
  QAloginenv=prop.getProperty("QAURL");
  //QAlandingURL=https://erp.campuslabs.in/qa/landing
  QAlandingenv=prop.getProperty("QAlandingURL");
  //QAModulepageURL=https://erp.campuslabs.in/qa/onboarding/module
  QAModuleenv=prop.getProperty("QAModulepageURL");
  //QAConfigpageURL=https://erp.campuslabs.in/qa/onboarding/configuration
  QAConfigenv=prop.getProperty("QAConfigpageURL");
  //QACampusHierarchyURL=https://erp.campuslabs.in/qa/onboarding/campus-hierarchy
  QACampushierarchyenv=prop.getProperty("QACampusHierarchyURL");
  
  
  //QAusersandrolespageURL=https://erp.campuslabs.in/qa/onboarding/user-roles
  QAUsersandRolesenv=prop.getProperty("QAusersandrolespageURL");
  
  
  

if (browserInstance.equalsIgnoreCase("chrome")) {
 
	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
//	driver.get("chrome://settings/clearBrowserData");

} else if (browserInstance.equalsIgnoreCase("firefox")) {

	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();

} else if (browserInstance.equalsIgnoreCase("edge")) {

	WebDriverManager.edgedriver().setup();
	driver = new EdgeDriver();

} else {

	System.out.println("You have chosen incorrect browser....");

}
	driver.manage().deleteAllCookies();
	driver.get(QAenvironment);
	//driver.get(QAenvLogin);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(15));
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	assert driver!= null;
	return driver;
}

}
