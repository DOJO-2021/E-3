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
import model.LoginUser;
import model.Profile;
/**
 * Servlet implementation class Create_profileServlet
 */
@WebServlet("/Create_ProfileServlet")
public class Create_ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//プロフィール登録ページにフォワードする
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/create_profile.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("user_id");
		String user_blood = request.getParameter("user_blood");
		String user_career = request.getParameter("user_career");
		String user_club = request.getParameter("user_club");
		String user_hobby = request.getParameter("user_hobby");
		String user_intro= request.getParameter("user_intro");
		//登録処理を行う
		ProfileDao pDao= new ProfileDao();
		 if(pDao.insert(new Profile(0,user_id, user_blood,user_career, user_club, user_hobby, user_intro))) {
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
