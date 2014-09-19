package test.my.jdbc;

import java.sql.*;

public class TestDML
{

	public static void main(String[] args)
	{
		if(args.length != 3)
		{
			System.out.println("������������Ӧ����3������");
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
			System.out.print("��һ������ӦΪ����");
			System.exit(-1);
		}
		String dname = args[1];
		String loc = args[2];
		// ����������
        String driver = "com.mysql.jdbc.Driver";
        // URLָ��Ҫ���ʵ����ݿ���scutcs
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        // MySQL����ʱ���û���
        String user = "root"; 
        // MySQL����ʱ������
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
//System.out.println(sql);//ִ��ǰ�Ȱ�sql����ӡ������Ȼ��Ѵ�ӡ������sql���Ƶ�sqlplus��ִ��һ�飬��ϸ��������������ˡ�
//        	stmt.executeUpdate(sql);
        	
        	rs = pstmt.executeQuery("select * from dept");
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
