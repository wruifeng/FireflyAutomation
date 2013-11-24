package practiceseven.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import practicefour.ParseProperties;
import practiceseven.pages.HomePage;

public class TestCase2 {
	   protected  static WebDriver ffwb;
		private FirefoxProfile firefoxprofile;
		private String projectpath = System.getProperty("user.dir");
		
		private ParseProperties data = new ParseProperties(System.getProperty("user.dir")+"\\src\\practiceseven\\data\\test.properties"); 
		
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
				ffwb.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				ffwb.manage().window().maximize();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		

		@Test
		public void test2(){
			HomePage homepage = new HomePage(ffwb);
			homepage.navigateToJD("http://www.jd.com/");
		}
}
