package test.my.jdbc;

import java.sql.*;

public class TestJDBC
{

	public static void main(String[] args)
	{
		// 驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        // URL指向要访问的数据库名scutcs
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        // MySQL配置时的用户名
        String user = "root"; 
        // MySQL配置时的密码
        String password = "root";
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        		
        try
        {
        	Class.forName(driver);
        	conn = DriverManager.getConnection(url, user, password);
        	 if(!conn.isClosed()) 
        	 {
                 System.out.println("Succeeded connecting to the Database!");
        	 }
        	stmt = conn.createStatement();
        	
        	
        	String sql = "insert into dept values(40,'dsDAa','sfzgds')";
        	stmt.executeUpdate(sql);
        	
        	rs = stmt.executeQuery("select * from dept");
        	System.out.println("部门号码  " + "部门名称   " + "地址");
        	while(rs.next())
        	{
        		System.out.println(rs.getString("deptno") + " " + rs.getString("dname") + " " + rs.getString("loc") );
        	}
        	
        	
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
		finally
		{
			if(rs != null)
			{
				try
				{
					rs.close();
				}
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt != null)
			{
				try
				{
					stmt.close();
				}
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null)
			{
				try
				{
					conn.close();
				}
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
