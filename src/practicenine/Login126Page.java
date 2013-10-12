package practicenine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login126Page {

	private WebDriver driver;
	private DBOp dbsession = new DBOp("LoginPage");
	
	public Login126Page(WebDriver driver){
	    this.driver = driver;	
	    dbsession.conn();
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
	//
	
	
}
