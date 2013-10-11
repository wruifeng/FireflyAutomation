package practiceseven.pages;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.thoughtworks.selenium.Wait;
import practiceseven.libs.*;

public class RegisterOnJD {

	private WebDriver driver;
	
	@FindBy(xpath = "//input[@id='regName']")
	private WebElement accountname;
	
	@FindBys(@FindBy(xpath = "//input[@id='pwd']|//input[@id='pwdRepeat']"))
	private List<WebElement> passwds;
	
	@FindBy(xpath="//input[@id='registsubmit']")
	private WebElement submit;
	
	//这里就不需要@FindBy或者@FindBys
    protected WebElement regfinished;
	
	public RegisterOnJD(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setAccountName(String accountname){
		this.accountname.sendKeys(accountname);
		setWebElement(accountname);
	}
	
	public void setPassword(String password){
        for(WebElement passwd:passwds){
        	passwd.sendKeys(password);
        }
			
	}
	
	
	public void submit(){
		submit.click();
	}
	
	
	//动态设置webpage上的元素xpath
	public void setWebElement(String value){
		String locator = "//div[text()=' 恭喜，%var[0]% 已注册成功！']";
		locator = locator.replace("%var%", value);
		regfinished = driver.findElement(By.xpath(locator));
	}
	
	public WebElement getWebElement(){		
		return regfinished;
	}
	
}
