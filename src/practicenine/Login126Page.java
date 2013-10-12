package practicenine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login126Page {

	private WebDriver driver;
	private DBOp dbsession;
	
	public Login126Page(WebDriver driver,DBOp dbsession){
	    this.driver = driver;	
	    this.dbsession = dbsession;
	}
	
	
	public void setUserName(String username){
		driver.findElement(By.cssSelector(dbsession.getLocatorCSS("UserName"))).sendKeys(username);
	}
	
	
	
	public void setPassword(String passwd){
		driver.findElement(By.cssSelector(dbsession.getLocatorCSS("Password"))).sendKeys(passwd);
	}
	
	
	public void signIn(){
		driver.findElement(By.cssSelector(dbsession.getLocatorCSS("SignUp"))).click();
	}
	
	
	
}
