package practicethree;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class TestSuite {
    protected  static WebDriver ffwb = null;
	private FirefoxProfile firefoxprofile = null;
	private String projectpath = System.getProperty("user.dir");
	
	
	@BeforeSuite
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
	
	@BeforeTest
	public void login(){
		ffwb.get("http://www.126.com/");		
		ffwb.findElement(By.xpath("//input[@id='idInput']")).clear();
		ffwb.findElement(By.xpath("//input[@id='idInput']")).sendKeys("FireflyAutomation");
		ffwb.findElement(By.xpath("//input[@id='pwdInput']")).sendKeys("Firefly");
		ffwb.findElement(By.xpath("//button[@id='loginBtn']")).click();			
		
		WebElement myDynamicElement = (new WebDriverWait(ffwb, 15)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'ͨѶ¼')]")));
	}
	
	
	
	@AfterTest
	public void logoutSauceLabs(){
		ffwb.findElement(By.xpath("//a[contains(text(),'�˳�')]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterSuite
	public void endFirefox(){
		ffwb.quit();
	}
	
}
