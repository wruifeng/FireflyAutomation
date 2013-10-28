package practiceten;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;


import org.testng.annotations.*;



public class MutipleTasks{

	private Wait waiter;
	protected static HashMap<String,String> map = new  HashMap<String, String>();
	private String seleniumserverstandalone  = null;
	private String node1json                 = null;
	private String node2json                 = null;
	private String hubjson                   = null;
	private String projectpath               = null;
	private String startnode1                = null;
	private String startnode2                = null;
	private String starthub                  = null;
	private String chromedriver              = null;

	
	
	@Parameters({"node1","node2"})
	@BeforeSuite()
	public void beforesuite(@Optional("http://localhost:5555/wd/hub")String node1,@Optional("http://localhost:6666/wd/hub")String node2){
		
		projectpath = System.getProperty("user.dir");		
		seleniumserverstandalone = projectpath+"\\tool\\selenium-server-standalone.jar";
		//node1json = projectpath+"\\src\\practiceten\\config\\node1.json";
		//node2json = projectpath+"\\src\\practiceten\\config\\node2.json";
		hubjson   =  projectpath+"\\src\\practiceten\\config\\hub.json";
		
		//startnode1 = projectpath+"\\tool\\startnode1.bat";
		//startnode2 = projectpath+"\\tool\\startnode2.bat";
		starthub   = projectpath+"\\tool\\starthub.bat";
		//chromedriver = projectpath+"\\tool\\chromedriver32.exe";
		
		try {
			Runtime.getRuntime().exec("cmd /c  start "+starthub+" "+seleniumserverstandalone+" "+hubjson);
			Thread.sleep(15000);
			//Runtime.getRuntime().exec("cmd /c  start "+startnode1+" "+seleniumserverstandalone+" "+node1json+" "+chromedriver);
			//Runtime.getRuntime().exec("cmd /c  start "+startnode2+" "+seleniumserverstandalone+" "+node2json+" "+chromedriver);
			//Thread.sleep(10000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		map.put("node1", node1);
		map.put("node2", node2);
	}
	
	

	
}
