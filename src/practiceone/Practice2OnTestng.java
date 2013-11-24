package practiceone;

import org.testng.annotations.*;

public class Practice2OnTestng {
    @BeforeClass
    public void beforeClass(){
    	System.out.println("beforeClass");
    }
    
    @BeforeMethod
    public void beforeMethod(){
    	System.out.println("beforeMethod");
    }
    
    @Test
    public void aFastTest(){
    	System.out.println("practice2:aFastTest");
    }
    
    @Test
    public void bSlowTest(){
    	System.out.println("practice2:bSlowTest");
    }
    

    
    @AfterMethod
    public void afterMethod(){
    	System.out.println("afterMethod");
    }
    
    @AfterClass
    public void afterClass(){
    	System.out.println("afterClass");
    }
    
}
