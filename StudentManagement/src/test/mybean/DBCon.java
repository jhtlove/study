package test.mybean;

import java.sql.*;

public class DBCon
{
	private static Connection con = null;
	
	public static Connection getCon()
	{
		try
		{
//			Class.forName("oracle.jdbc.OracleDriver");//oracle.jdbc.driver.OracleDriver
//			String user = "scott";
//			String pwd = "zwj";
//			String url = "jdbc:oracle:thin:@localhost:1521:ORCL";//jdbc:oracle:thin:@localhost:1521:ORCL
			Class.forName("com.mysql.jdbc.Driver");
			String user = "root";
			String pwd = "root";
			String url = "jdbc:mysql://localhost:3306/test";
			con = DriverManager.getConnection(url,user,pwd);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
