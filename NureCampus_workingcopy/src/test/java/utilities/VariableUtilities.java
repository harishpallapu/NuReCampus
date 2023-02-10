package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.NuReCampus_PageObjects.AllPageObjects;





public class VariableUtilities {

		public  WebDriver driver;
		public AllPageObjects allpageObjects;
		public Basetestcomponents baseTestComponents;
		public ReusableTestUtilities reusabletestUtilities;
		public ConfigReader configReader;
		public String CurrentURl;
		public String fullname;
		public String emailid;
		
		public String phonenum;
		public String InstituteName;
		public String instituteurl;
		public String dataFlag;
		public ExcelReader excelReader;
		public String username;
		public String password;
		public String instituewebsite;
		public String logoimage;
		public String backgroundimage;
		public String reportheaderimage;
		public String emailaddressid;
		public String extension;
		public String dataFlag2;
		public String phonenumber;
		public String groupName;
		public String msg;
		public String childgroupName;
		public String childdecriptionmsg;
		public String secondchild;
		public String secondchildmsg;
		public String QAloginenv;
		public String QAlandingenv;
		public String QAModuleenv;
		public String QAConfigenv;
		public String QACampushierarchyenv;
		public String QAUsersandRolesenv;
		public String emailidretrieved;

		
		
		
	public VariableUtilities() throws IOException

	{
		 baseTestComponents=new Basetestcomponents();
		 allpageObjects=new AllPageObjects(baseTestComponents.invokebrowser());
		 reusabletestUtilities=new ReusableTestUtilities(baseTestComponents.invokebrowser());
		 configReader=new ConfigReader(baseTestComponents.invokebrowser());
		 excelReader=new ExcelReader();
	}
	}

