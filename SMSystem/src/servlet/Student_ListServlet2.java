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
import dao.UserProfileDao;
import model.Table;
import model.User;
import model.UserProfile;

/**
 * Servlet implementation class Student_ListServlet2
 */
@WebServlet("/Student_ListServlet2")
public class Student_ListServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("user_id");

		UserProfileDao upDao = new UserProfileDao();
		List<UserProfile> userProfileList = upDao.select_profile(new UserProfile(user_id,"","","","","","","","",""));
		request.setAttribute("userProfileList", userProfileList);
		//プロフィール一覧ページにフォワードする
		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/profile2.jsp");
		dispatcher.forward(request, response);
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String PAGER = request.getParameter("pager");

		int pager = Integer.parseInt(PAGER);
		if(pager == 1) {
			pager = 0;
		}else if(pager == 2) {
			pager = 10;
		}else {
			pager = 20;
		}
		Table table = new Table(pager);
		HttpSession session = request.getSession();
		String user_class = (String) session.getAttribute("studentClass");
		UserDao uDao = new UserDao();
		List<User> studentList = uDao.select(new User(0,"","","","","","",user_class,""),table);
		request.setAttribute("studentList", studentList);

		session.getAttribute("count");

		RequestDispatcher dispatcher1 =request.getRequestDispatcher("/WEB-INF/jsp/student_list2.jsp");
		dispatcher1.forward(request, response);
	}
}


