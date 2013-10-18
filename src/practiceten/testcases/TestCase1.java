package practiceten.testcases;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import practicefour.Wait;
import practiceten.BrowsersType;
import practiceten.MutipleTasks;

public class TestCase1 extends MutipleTasks{

	private WebDriver driver;
	private FirefoxProfile firefoxprofile = null;
	private String projectpath = System.getProperty("user.dir");
	private Wait wait = null;
	

	@BeforeClass
	public void beforeClass(){
		String node = map.get("node1");
		BrowsersType browser = new BrowsersType();
		//driver = browser.setFirefox(node);
		//driver = browser.setChrome(node);
		driver = browser.setIE(node);
		
		wait =  new Wait(driver);
	}

	
	
	@Test
	public void selectItemFromDropDownList(){	
		
		//登录jd官方网站
		driver.get("http://www.jd.com");
		wait.waitForElementPresent("//a[text()='[登录]']");
		driver.findElement(By.xpath("//a[text()='[登录]']")).click();		
		//登录用户信息
		wait.waitForElementPresent("//input[@id='loginname']");
		driver.findElement(By.xpath("//input[@id='loginname']")).sendKeys("test201301@mailinator.com");
		driver.findElement(By.xpath("//input[@id='nloginpwd']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='loginsubmit']")).click();
		//登录个人信息
		driver.findElement(By.xpath("//a[text()='我的订单']")).click();
		driver.findElement(By.xpath("//a[text()='账户信息']")).click();	
		//选择上海作为它的province
		Select province = new Select(driver.findElement(By.xpath("//select[@id='province']")));
		province.selectByVisibleText("上海");
		wait.waitFor(3000);
		//打印上海下的所有区域
		Select city = new Select(driver.findElement(By.xpath("//select[@id='city']")));
		List<WebElement> allcitys = city.getOptions();
		for(WebElement eachcity:allcitys)
			System.out.println(eachcity.getText());
		
	}
	
	

	
	

	
	
	
	
	
	
	
	
	@AfterClass
	public void releaseFFDriver(){
		driver.quit();
	}
}
