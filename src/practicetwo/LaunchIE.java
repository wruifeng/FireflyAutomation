package practicetwo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

public class LaunchIE {
	
	private static WebDriver iewb = null;
	private static DesiredCapabilities caps = null;
	private String projectpath = System.getProperty("user.dir");
	
	
	@BeforeClass
	public void startIE(){
		System.setProperty("webdriver.ie.driver", projectpath+"/tool/IEDriverServer32.exe"); 
		caps = DesiredCapabilities.internetExplorer();
		caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);   
		caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");		
        caps.setCapability("ignoreZoomSetting", true);
        iewb = new InternetExplorerDriver(caps);
        
	}
	

	
	@Test
	public void searchOnBaidu(){	
		iewb.get("http://www.baidu.com");
		//iewb.get("javascript:document.getElementById('overridelink').click();");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void releaseIEDriver(){
		iewb.quit();
	}
	
}
