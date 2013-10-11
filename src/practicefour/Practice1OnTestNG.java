package practicefour;

import org.testng.Assert;
import org.testng.annotations.*;

public class Practice1OnTestNG {

	@Parameters({"TestData"})
	@Test
	public void test(@Optional("aaa") String testdata){
		ParseProperties pp = new ParseProperties(System.getProperty("user.dir")+testdata);
		System.out.println(pp.getValue("url"));
		System.out.println(pp.getValue("username"));
		System.out.println(pp.getValue("password"));
	    Assert.assertEquals("q".equals("q"), true);
	}
	
	
	
	
	
	
	
	
}
