package test.my.jdbc;

import java.sql.*;

public class TestJDBC
{

	public static void main(String[] args)
	{
		// ����������
        String driver = "com.mysql.jdbc.Driver";
        // URLָ��Ҫ���ʵ����ݿ���scutcs
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        // MySQL����ʱ���û���
        String user = "root"; 
        // MySQL����ʱ������
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
        	System.out.println("���ź���  " + "��������   " + "��ַ");
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
