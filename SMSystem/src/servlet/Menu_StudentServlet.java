package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class Menu_StudentServlet
 */
@WebServlet("/Menu_StudentServlet")
public class Menu_StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/menu_student.jsp");
		dispatcher.forward(request,response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_class = request.getParameter("user_class");

		UserDao uDao = new UserDao();
		List<User> studentList = uDao.select(new User(0,"","","","","","",user_class,""));
		request.setAttribute("studentClass", user_class);
		request.setAttribute("studentList", studentList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/student_list1.jsp");
		dispatcher.forward(request,response);



	}

}
