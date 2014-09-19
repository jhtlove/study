package test.mybean;
import java.sql.*;
import java.util.*;
public class testMain
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Student s = new Student();
		s.setName("luck");
		EditStudent.getInstance().saveStudent(s);
		Connection con = DBCon.getCon();
		System.out.println(con);
		ArrayList<Student> list = EditStudent.getInstance().selectStudent();
		Student temp = null;
		System.out.println("ok");
		if(list.iterator().hasNext()==true)
		{
			temp = list.iterator().next();
			System.out.println(temp.getName() + " :there");
		}
		System.out.print(list.iterator().next().getName());
		//list.iterator().next()
		//System.out.print(temp.getName() + " :name");
		
	}

}
