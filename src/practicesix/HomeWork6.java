package practicesix;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import practicefour.ParseProperties;
import practicefour.Wait;

public class HomeWork6 {

    protected  static WebDriver ffwb;
	private FirefoxProfile firefoxprofile;
	private String projectpath = System.getProperty("user.dir");
	
	private ParseProperties data = new ParseProperties(System.getProperty("user.dir")+"\\tool\\test.properties"); 
	
	@BeforeClass
	public void startFirefox(){
		File firebug = new File(projectpath+"/tool/firebug-1.12.1-fx.xpi");
		File firepath = new File(projectpath+"/tool/firepath-0.9.7-fx.xpi");
		firefoxprofile =  new FirefoxProfile();
		try {
			firefoxprofile.addExtension(firebug);
			firefoxprofile.addExtension(firepath);
			firefoxprofile.setPreference("webdriver.accept.untrusted.certs", "true"); 
			firefoxprofile.setPreference("extensions.firebug.currentVersion", "1.12.1");
			ffwb = new FirefoxDriver(firefoxprofile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	@Test
	public void searchMerchandise(){
		//Wait wait = new Wait(ffwb);
        LoginPage loginpage = new LoginPage(ffwb);
        HomePage homepage = new HomePage(ffwb);
        
        
        loginpage.navigate(data.getValue("url"));
		loginpage.setUserName(data.getValue("username"));
		loginpage.setPassWord(data.getValue("password"));
		loginpage.login();
		
		Assert.assertEquals(homepage.hometab.isDisplayed(), true);
	}
}
