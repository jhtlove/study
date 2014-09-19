package test.my.jdbc;

import java.sql.*;

public class TestDML
{

	public static void main(String[] args)
	{
		if(args.length != 3)
		{
			System.out.println("参数输入有误，应输入3个参数");
			System.exit(-1);
		}
		int deptno = 0;
		try
		{
			deptno = Integer.parseInt(args[0]);
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
			System.out.print("第一个参数应为数字");
			System.exit(-1);
		}
		String dname = args[1];
		String loc = args[2];
		// 驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        // URL指向要访问的数据库名scutcs
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        // MySQL配置时的用户名
        String user = "root"; 
        // MySQL配置时的密码
        String password = "root";
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        
        try
        {
        	Class.forName(driver);
        	conn = DriverManager.getConnection(url, user, password);
        	 if(!conn.isClosed()) 
        	 {
                 System.out.println("Succeeded connecting to the Database!");
        	 }
        	pstmt = conn.prepareStatement("insert into dept values(?,?,?)");
        	pstmt.setInt(1, deptno);
        	pstmt.setString(2, dname);
        	pstmt.setString(3, loc);
        	pstmt.executeUpdate();
        	
//        	String sql = "insert into dept values(40,'dsDAa','sfzgds')";
//System.out.println(sql);//执行前先把sql语句打印出来，然后把打印出来的sql复制到sqlplus中执行一遍，仔细看到底哪里出错了。
//        	stmt.executeUpdate(sql);
        	
        	rs = pstmt.executeQuery("select * from dept");
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
			if(pstmt != null)
			{
				try
				{
					pstmt.close();
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
