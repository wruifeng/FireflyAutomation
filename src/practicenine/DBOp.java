package practicenine;


import java.sql.*;

import org.sqlite.JDBC;


public class DBOp {
	
	private Statement stat = null;
	private ResultSet rsq   = null;
	private String tablename = null;
	
	public DBOp(String tablename){
		this.tablename = tablename;
	}
    
	public void conn(){
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:"+System.getProperty("user.dir")+"\\tool\\mylocator.sqlite");
			stat = conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String  getLocatorXpath(String locatorname){
		String xpath = null;
		try {
			rsq =stat.executeQuery("select * from "+tablename+" where WebElementName = '"+locatorname+"';");
			while (rsq.next()) { 

				xpath = rsq.getString("Xpath");
				

				}
				rsq.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xpath;
	}
	
	
	public String getLocatorCSS(String locatorname){
		String css = null;
		try {
			rsq =stat.executeQuery("select * from "+tablename+" where WebElementName = '"+locatorname+"';");
			while (rsq.next()) { 

				
				css=rsq.getString("CSS");

				}
				rsq.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return css;
	}
	
	
	
	public static void main(String[] args) {
		DBOp test = new DBOp("LoginPage");
		test.conn();
		System.out.println(test.getLocatorXpath( "UserName"));
		//System.out.print(test.getLocatorCSS( "Password"));
		
	}
	
	
	
}
