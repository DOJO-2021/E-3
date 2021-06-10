package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProfileDao;
import dao.UserDao;
import model.Profile;
import model.User;
/**
 * Servlet implementation class Create_profileServlet
 */
@WebServlet("/Create_profileServlet")
public class Create_profileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session =request.getSession();
		if (session.getAttribute("id") == null) {
				response.sendRedirect("/SMSystem/loginServret");
				return;
		}
		//登録ページにフォワードする
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/create_profile.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//doGet(request, response);
		//もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null){
			response.sendRedirect("/SMSystem/LoginServret");
			return;
		}
		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_name = request.getParameter("USER_NAME");
		String user_name_kana = request.getParameter("USER_NAME_KANA");
		String user_blood = request.getParameter("USER_BLOOD");
		String user_career = request.getParameter("USER_CAREER");
		String user_club = request.getParameter("USER_CLUB");
		String user_hobby = request.getParameter("USER_HOBBY");
		String user_intro= request.getParameter("USER_INTRO");

		//登録処理を行う
		ProfileDao pDao= new ProfileDao();
		if (pDao.insert(new Profile))
	}


}
