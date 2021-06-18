package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.Table;
import model.User;

/**
 * Servlet implementation class Menu_TeacherServlet
 */
@WebServlet("/Menu_TeacherServlet")
public class Menu_TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/menu_teacher.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String user_class = request.getParameter("user_class");
		int row = 0;
		Table table = new Table(row);

		UserDao uDao = new UserDao();
		User u = new User(0,"","","","","","",user_class,"");
		List<User> studentList = uDao.select(u, table);
		request.setAttribute("studentClass", user_class);
		request.setAttribute("studentList", studentList);
		HttpSession session = request.getSession();
		session.setAttribute("studentClass", user_class);

		int count = uDao.select_count(u);
		request.setAttribute("count", count);
		session.setAttribute("count", count);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/student_list2.jsp");
		dispatcher.forward(request,response);
	}

}
