package practicethree;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ViewInbox extends TestSuite{

	@Test
	public void viewRecMails(){
		ffwb.findElement(By.xpath("//span[@title='收件箱']")).click();		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
