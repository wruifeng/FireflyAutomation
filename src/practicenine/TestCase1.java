package practicenine;

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
import practicefour.Wait;
import practiceeight.HomePage;
import practiceeight.LoginPage;

public class TestCase1 {
	
	    protected  static WebDriver ffwb;
		private FirefoxProfile firefoxprofile;
		private String projectpath = System.getProperty("user.dir");		
		private ParseProperties data = new ParseProperties(System.getProperty("user.dir")+"\\tool\\test.properties"); 
		private Wait wa;
		
		@BeforeClass
		public void startFirefox(){

			File firebug = new File(projectpath+"/tool/firebug-1.12.1-fx.xpi");
			File firepath = new File(projectpath+"/tool/firepath-0.9.7-fx.xpi");
			File sqlitemgr = new File(projectpath+"/tool/sqlite_manager-0.8.1-fx+tb+sm.xpi");
			firefoxprofile =  new FirefoxProfile();
			try {
				firefoxprofile.addExtension(firebug);
				firefoxprofile.addExtension(firepath);
				firefoxprofile.addExtension(sqlitemgr);
				firefoxprofile.setPreference("webdriver.accept.untrusted.certs", "true"); 
				firefoxprofile.setPreference("extensions.firebug.currentVersion", "1.12.1");
				
				ffwb = new FirefoxDriver(firefoxprofile);
				ffwb.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				wa = new Wait(ffwb);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		
		
		@Test
		public void loginBaidu(){
			ffwb.get("http://www.baidu.com");
			ffwb.findElement(By.xpath("//a[@name='tj_mp3']")).click();
			ffwb.findElement(By.xpath("//a[contains(text(),'æ≠µ‰¿œ∏Ë')]")).click();
			ffwb.findElement(By.xpath("//span[child::a[text()='«ß«ß„⁄∏Ë'] ]/following-sibling::span/descendant::a[@title='œ¬‘ÿ']")).click();
			Switch sw = new Switch(ffwb);
			sw.toSpecificWindow("œ¬‘ÿ_∞Ÿ∂»“Ù¿÷");
			ffwb.findElement(By.xpath("//a[contains(@href,'link=http:')]/span/span")).click();
			try {
				Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\tool\\download.exe");
				Thread.sleep(5000);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		@Test
		public void login126DotCom(){				
			Login126Page loginpage = new Login126Page(ffwb);	
			
			ffwb.get("http://www.126.com");			
			loginpage.setUserName("FireflyAutomation");
			loginpage.setPassword("Firefly");
			loginpage.signIn();
			wa.waitFor(5000);
			
		}
		

		@AfterClass
		public void end(){
			ffwb.quit();
		}
		
		
}
