package test.servelet;
import java.util.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.mybean.DBCon;
import test.mybean.EditStudent;
import test.mybean.Student;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		//request.setContenType("");
		String name = request.getParameter("name");
		Student s = new Student();
		s.setName(name);
		System.out.println(s.getName());
		EditStudent.getInstance().saveStudent(s);
		RequestDispatcher dispatcher = request.getRequestDispatcher("show.jsp");
		dispatcher.forward(request, response);
//		ServletContext application = getSerletContext();
//		List<Student> list = (List<Student>)application.getAttribute("student");
//		if(list == null)
//		{
//			list = new ArrayList<Student()>;
//		}
//		list.add(stu)
	}

}
