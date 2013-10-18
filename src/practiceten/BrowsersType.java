package practiceten;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;

import practicefour.Wait;

public class BrowsersType {
	private WebDriver driver = null;
	private Wait wait =  null;
	private String projectpath = System.getProperty("user.dir");
	private DesiredCapabilities caps;
	

	
	
	public WebDriver setFirefox(String nodeurl){		
		caps = DesiredCapabilities.firefox();		
		File firebug = new File(projectpath+"/tool/firebug-1.12.1-fx.xpi");
	    File firepath = new File(projectpath+"/tool/firepath-0.9.7-fx.xpi");
	    FirefoxProfile firefoxprofile =  new FirefoxProfile();
		try {
			firefoxprofile.addExtension(firebug);
			firefoxprofile.addExtension(firepath);
			firefoxprofile.setPreference("webdriver.accept.untrusted.certs", "true"); 
			firefoxprofile.setPreference("extensions.firebug.currentVersion", "1.12.1");
			caps.setCapability(FirefoxDriver.PROFILE, firefoxprofile);
			driver = new RemoteWebDriver(new URL(nodeurl), caps);	
			wait = new Wait(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return driver;
	}
	
	
	
	public WebDriver setChrome(String nodeurl){
		//System.setProperty("webdriver.chrome.driver", projectpath+"/tool/chromedriver.exe"); 
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("chrome.switches",Arrays.asList("--start-maximized"));
		try {
			driver = new RemoteWebDriver(new URL(nodeurl), caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return driver;
	}
	
	
	public WebDriver setIE(String nodeurl){
		/*if(System.getProperty("os.arch").equals("x86"))
		    System.setProperty("webdriver.ie.driver", projectpath+"/tool/IEDriverServer32.exe"); 
		else
			 System.setProperty("webdriver.ie.driver", projectpath+"/tool/IEDriverServer64.exe"); */
		
		caps = DesiredCapabilities.internetExplorer();
		caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);   
		caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");		
        caps.setCapability("ignoreZoomSetting", true);
        try {
			driver = new RemoteWebDriver(new URL(nodeurl), caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return driver;
	}
	
	
	
	
	
	
}
