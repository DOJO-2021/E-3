package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;
import dao.ProfileDao;
import model.LoginUser;
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
		/*HttpSession session =request.getSession();
		if (session.getAttribute("id") == null) {
				response.sendRedirect("/SMSystem/LoginServlet");
				return;
		}*/
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
		/*HttpSession session = request.getSession();
		if (session.getAttribute("id") == null){
			response.sendRedirect("/SMSystem/LoginServret");
			return;
		}*/
		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_name = request.getParameter("user_name");
		String user_name_kana = request.getParameter("user_name_kana");
		String user_blood = request.getParameter("user_blood");
		String user_career = request.getParameter("user_career");
		String user_club = request.getParameter("user_club");
		String user_hobby = request.getParameter("user_hobby");
		String user_intro= request.getParameter("user_intro");
		User user = new User();
		String user_id = user.getUser_id();
		String user_pw = user.getUser_pw();
		String user_company = user.getUser_company();
		String user_company_kana = user.getUser_company_kana();
		//登録処理を行う
		ProfileDao pDao= new ProfileDao();
		 pDao.insert(new Profile(0, user_name, user_name_kana, user_blood, user_company, user_company_kana, user_career, user_club, user_hobby, user_intro));
		//ログイン処理を行う
		 LoginDao LDao = new LoginDao();
		 if (LDao.isLoginOK(user_id, user_pw)) { //ログイン成功
			 //セッションスコープにIDを格納する
			 HttpSession session = request.getSession();
			 session.setAttribute("id", new LoginUser(user_id));
			 		//メニュー受講生サーブレットにリダイレクトする
					 response.sendRedirect("/SMSystem/Menu_StudentServlet");
		 }
		 else { //記入漏れした場合は失敗
			 //リクエストスコープにタイトル、メッセージ、戻り先を格納する
			 response.sendRedirect("/SMSystem/LoginServlet");
		 }

	}
}