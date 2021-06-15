package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserProfileDao;
import model.UserProfile;

/**
 * Servlet implementation class Student_ListServlet2
 */
@WebServlet("/Student_ListServlet2")
public class Student_ListServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("user_id");

		UserProfileDao upDao = new UserProfileDao();
		List<UserProfile> userProfileList = upDao.select_profile(new UserProfile(user_id,"","","","","","","","",""));
		request.setAttribute("userProfileList", userProfileList);
		//プロフィール一覧ページにフォワードする
		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/profile2.jsp");
		dispatcher.forward(request, response);
	}

}
