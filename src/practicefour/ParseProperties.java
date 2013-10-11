package practicefour;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ParseProperties {
	
	private  Properties pro = new Properties();
	
	public  ParseProperties(String propertiespath){		
		this.loadProperties(propertiespath);
	}
	
	
	private void loadProperties(String propertiespath){			
		
		try {
			InputStream in = new FileInputStream(propertiespath);
			InputStreamReader inr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inr);
			pro.load(br);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//to get value of specific keyname
	public String getValue(String keyname){
		return pro.getProperty(keyname).trim();
	}
	
	
	
	
}
