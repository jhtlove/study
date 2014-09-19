package test.mybean;

import java.sql.*;
import java.util.*;
public class EditStudent
{
	private static EditStudent es= null;
	
	public static EditStudent getInstance()
	{
		if(es == null )
		{
			es = new EditStudent();
		}
		return es;
	}
	
	public boolean saveStudent(Student s)
	{
		Connection con = null;
		try
		{
			con = DBCon.getCon();
			String sql = "insert into tb_student  values(?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,s.getName());
			int i = ps.executeUpdate();
			if(i == 1) return true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
//			try
//			{
//				con.close();
//			}
//			catch(SQLException e)
//			{
//				e.printStackTrace();
//			}
		}
		return false;
		
	}
	
	public ArrayList<Student> selectStudent()
	{
		ArrayList<Student> sList = new ArrayList<Student>();
		Connection con = null;
		try
		{
			con = DBCon.getCon();
			String sql = "select * from tb_student";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Student s = new Student();
				s.setName(rs.getString("name"));
				//System.out.println(rs.getString("name") + ": here");
				sList.add(s);
			}
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{

			try
			{	
				if(con != null)
				{
					con.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return sList;
	}
}
