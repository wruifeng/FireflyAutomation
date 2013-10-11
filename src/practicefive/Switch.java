package practicefive;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class Switch {
   private WebDriver driver;
   private String currentwindow;
   
	public Switch(WebDriver driver){
		this.driver = driver;	
		currentwindow = driver.getWindowHandle();
		//PageFactory .initElements(driver, this);		
	}
	
	/**
	 * 
	 * Description :switch to specific window.
	 * @author £ºTerry
	 * @see : 
	 * @param :partial Title Name of a window.
	 * @return : void
	 * @create £º2013-8-1
	 * @exception :
	 * @version £º1.0
	 */
	public void toSpecificWindow(String partialTitleName){
		Set<String> handles = driver.getWindowHandles();
		String titlename;
		for(String handle:handles){
			titlename = driver.switchTo().window(handle).getTitle();
			if(titlename.contains(partialTitleName))
				break;				
		}
	}
	
	/**
	 * 
	 * Description : back to parent window but dont close the source window.
	 * @author £ºTerry
	 * @see : 
	 * @param :
	 * @return : void
	 * @create £º2013-8-1
	 * @exception :
	 * @version £º1.0
	 */
	public void backToCurrentWindow(){
		driver.switchTo().window(currentwindow);
	}
	
	
	
	
}
