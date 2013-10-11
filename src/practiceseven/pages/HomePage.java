package practiceseven.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;
	
	@FindBy(xpath = "//a[contains(text(),'Ãâ·Ñ×¢²á')]")
	private WebElement reg;
	
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void register(){
		reg.click();
	}
	
	
	
}
