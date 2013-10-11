package practiceeight;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.log4testng.Logger;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionType;
import br.eti.kinoshita.testlinkjavaapi.model.ReportTCResultResponse;
import br.eti.kinoshita.testlinkjavaapi.model.TestCase;
import br.eti.kinoshita.testlinkjavaapi.model.TestPlan;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;

public class APIObject {
	private static Logger logger = Logger.getLogger(APIObject.class);
    private static TestLinkAPI api = null;
    private String planName;
    private String projectName;
    private String url ;
    private String devKey;
    private TestCase[] tcs;
    private TestPlan tl;
    private String buildName;
    private String platformName;
    
    
   public  APIObject(String url,String devKey,String projectName,String planName,String buildName,String platformName){
	   this.url = url;
	   this.devKey = devKey;
	   this.projectName = projectName;
	   this.planName = planName;
	   this.buildName = buildName;
	   this.platformName = platformName;
   }

    public TestLinkAPI getAPI() {
        if (null == api) {
            try {
                api = new TestLinkAPI(new URL(url), devKey);
            } catch (TestLinkAPIException te) {
                logger.error(te.getMessage(), te);
            } catch (MalformedURLException mue) {
                logger.error(mue.getMessage(), mue);
            }
        }
        return api;
    }
    
    
    public void getTestCases(){      
    	this.planName = planName;
    	this.projectName = projectName;
        tl = api.getTestPlanByName(planName,projectName);
        tcs=api.getTestCasesForTestPlan(tl.getId(), null, null,null,null,null,null,null,ExecutionType.MANUAL,null,null);
        /*for(TestCase tc:tcs){
            System.out.println(tc.toString());
        }*/
        
    }

    
    
    public void executeTestCase(String testcasename,int status){ 
        Integer planID = tl.getId();       
        Integer tcID = 0;
        for(TestCase tc:tcs){
        	String casename = tc.getName();
        	if(casename.equals(testcasename)){
        		tcID = tc.getId();
        		break;
        	}       	
        }
 
        switch(status){
             case 1:        
            	 api.reportTCResult(tcID, null,planID, ExecutionStatus.PASSED, null, buildName," 自动化上传结果的备注 ", null, null, null, platformName, null, null); 
                 break;
             case 2:  
            	 api.reportTCResult(tcID, null,planID, ExecutionStatus.FAILED, null, buildName," 自动化上传结果的备注 ", null, null, null, platformName, null, null);
            	 break;
             case 3:       
            	 api.reportTCResult(tcID, null,planID, ExecutionStatus.BLOCKED, null, buildName," 自动化上传结果的备注 ", null, null, null, platformName, null, null);
            	 break;
             default:
            	 System.out.println("please check your status");
        }

    }
    
    
    public static void main(String args[]){
    	String url = "http://172.28.50.123:88/testlink/lib/api/xmlrpc.php";
    	String devKey = "2f782c29529e69dfa47e399c4af70944";
    	String projectName = "Demo";
    	String tl = "testplan1";
    	String buildName = "build001";
    	String platform = "winxp";
    	
    	
    	APIObject testlinkapi = new APIObject(url,devKey,projectName,tl,buildName,platform);
    	testlinkapi.getAPI();
    	testlinkapi.getTestCases();
    	testlinkapi.executeTestCase("test case3 for Demo",1);
    }
}
