package practicefour;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class Practice2OnTestNG {
	
    protected  static WebDriver ffwb = null;
	private FirefoxProfile firefoxprofile = null;
	private String projectpath = System.getProperty("user.dir");
	
	private ParseProperties data = new ParseProperties(System.getProperty("user.dir")+"\\tool\\test.properties"); 
	private ParseProperties locator = new ParseProperties(System.getProperty("user.dir")+"\\tool\\locators.properties"); 
	
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
		Wait wait = new Wait(ffwb);
		ffwb.get(data.getValue("url"));
		ffwb.findElement(By.xpath(locator.getValue("SearchBox"))).sendKeys(data.getValue("merchandise"));
		ffwb.findElement(By.xpath(locator.getValue("SearchBtn"))).click();		
		WebElement we = ffwb.findElement(By.xpath(locator.getValue("Item")));
		wait.waitForElementPresent(locator.getValue("Item"));
		Assert.assertEquals(we.isDisplayed(), false);
	}
	
	
	@Test
	public void testPTC(){
		ffwb.get("http://www.ptc.com/");

		WebElement element1 = ffwb.findElement(By.xpath("//a[contains(text(),'Products') and @class='nav_products_all']"));
	
		(new Actions(ffwb)).moveToElement(element1).build().perform();
		WebElement element2 = ffwb.findElement(By.xpath("//a[text()='PTC Creo']"));
		(new Actions(ffwb)).moveToElement(element2).build().perform();
		WebElement element3 = ffwb.findElement(By.xpath("//a[text()='Draw']"));

		element3.click();

		

		ffwb.quit();


	}
	
}
