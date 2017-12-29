package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Student;
import Dao.JDBCUtils;

public class checkUser extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public checkUser() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		// out.print("    This is ");
		// out.print(this.getClass());
		// out.println(", using the POST method");
		//
		String stuNum = request.getParameter("stunum");
		String password = request.getParameter("password").toUpperCase();
		if (stuNum == null)
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
		// out.println(password);
		Student stu = null;
		try {
			stu = JDBCUtils.queryStudent(stuNum);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (stu == null) {
			out.println("<font color='red'>µÇÂ¼Ê§°Ü</font>");
			request.setAttribute("msg", "ÓÃ»§Ãû´íÎó");
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
		} else {
			if (stu.getPassword().equals(password)) {
				out.println("<font color='red'>µÇÂ¼³É¹¦</font>");
				HttpSession session = request.getSession();
				session.setAttribute("stuName", stu.getName());
				session.setAttribute("stuNum", stu.getStuNum());
				request.getRequestDispatcher("FileUpload.jsp").forward(request,
						response);
			} else {
				out.println("<font color='red'>µÇÂ¼Ê§°Ü</font>");
				request.setAttribute("msg", "ÃÜÂë´íÎó");
				request.getRequestDispatcher("index.jsp").forward(request,
						response);
			}
		}

		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
