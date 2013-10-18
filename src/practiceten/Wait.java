package practiceten;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public class Wait {
	private WebDriver driver;	

	
	public Wait(WebDriver driver){
		this.driver = driver;	
        PageFactory .initElements(driver, this);		
	}
	
	public void waitForElementPresent(String locator){
		(new WebDriverWait(driver, 10000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}
	
	

	
	
	public void waitForElementIsEnable(String locator){
		(new WebDriverWait(driver, 10000)).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}
	
	public void waitFor(long timeout){
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
