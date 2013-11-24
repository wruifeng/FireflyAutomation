package practiceone;

import org.testng.annotations.*;


public class PracticeBase {
    @BeforeTest
    public void beforeTest(){
    	System.out.println("beforeTest");
    }
    
    @AfterTest
    public void afterTest(){
    	System.out.println("afterTest");
    }
    
    @BeforeSuite
    public void beforeSuite(){
    	System.out.println("beforeSuite");
    }
    
    @AfterSuite
    public void afterSuite(){
    	System.out.println("afterSuite");
    }
    
    
    @Test
    public void runAll(){
    	System.out.println("Run all test cases");
    }
    
}
