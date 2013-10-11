package practiceeight;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import practicefour.ParseProperties;
import practiceeight.HomePage;
import practiceeight.LoginPage;

public class TestCase1 {
	
	
	    //testlink parameters
	    private String url;
	    private String devKey;
	    private String projectName;
	    private String tl;
	    private String buildName;
	    private String platform;
	    private APIObject testlinkapi;
	    
	    private String caseName;
	    
	    
	    protected  static WebDriver ffwb;
		private FirefoxProfile firefoxprofile;
		private String projectpath = System.getProperty("user.dir");
		
		private ParseProperties data = new ParseProperties(System.getProperty("user.dir")+"\\tool\\test.properties"); 
		
		@Parameters({"url","devkey","project","plan","build","platform"})
		@BeforeClass
		public void startFirefox(@Optional("aaa") String url,String devkey,String project,String plan,String build,String platform){
			this.url = url;
	    	this.devKey = devkey;
	    	this.projectName = project;
	    	this.tl = plan;
	    	this.buildName = build;
	    	this.platform = platform;
	    	
	    	testlinkapi = new APIObject(url,devKey,projectName,tl,buildName,platform);
			File firebug = new File(projectpath+"/tool/firebug-1.12.1-fx.xpi");
			File firepath = new File(projectpath+"/tool/firepath-0.9.7-fx.xpi");
			firefoxprofile =  new FirefoxProfile();
			try {
				firefoxprofile.addExtension(firebug);
				firefoxprofile.addExtension(firepath);
				firefoxprofile.setPreference("webdriver.accept.untrusted.certs", "true"); 
				firefoxprofile.setPreference("extensions.firebug.currentVersion", "1.12.1");
				ffwb = new FirefoxDriver(firefoxprofile);
				ffwb.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		
		
		@Test
		public void login126DotCom(){
			caseName = "TestCase1";
	        LoginPage loginpage = new LoginPage(ffwb);
	        HomePage homepage = new HomePage(ffwb);        
	        loginpage.navigate(data.getValue("url"));
			loginpage.setUserName(data.getValue("username"));
			loginpage.setPassWord(data.getValue("password"));
			loginpage.login();			
			Assert.assertEquals(homepage.hometab.isDisplayed(), false);
		}
		
		
		
		@Test
		public void loginislibDotCom(){
			caseName = "TestCase2";
	        LoginPage loginpage = new LoginPage(ffwb);
	        HomePage homepage = new HomePage(ffwb);        
	        loginpage.navigate(data.getValue("url"));
			loginpage.setUserName(data.getValue("username"));
			loginpage.setPassWord(data.getValue("password"));
			loginpage.login();			
			Assert.assertEquals(homepage.hometab.isDisplayed(), false);
		}
		
		

		
		@AfterMethod
		public void import2TestLink(ITestResult result) throws Exception {  	
	    	testlinkapi.getAPI();
	    	testlinkapi.getTestCases();
	    	testlinkapi.executeTestCase(caseName,result.getStatus());
		}
		
		@AfterClass
		public void end(){
			ffwb.quit();
		}
		
		
}
