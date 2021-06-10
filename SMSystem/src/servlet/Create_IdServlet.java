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
import dao.UserDao;
import model.LoginUser;
import model.User;
/**
 * Servlet implementation class Create_IdServlet
 */
@WebServlet("/Create_IdServlet")
public class Create_IdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログインしていなければ、ログインサーブレットにリダイレクトする


		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/create_id.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doGet(request, response);
		// ログインしていなければ、ログインサーブレットにリダイレクトする



	// リクエストパラメータを取得する
	request.setCharacterEncoding("UTF-8");
	String user_role = request.getParameter("first");
	String user_name = request.getParameter("regist_name");
	String user_name_kana = request.getParameter("regist_name_kana");
	String user_company = request.getParameter("regist_company");
	String user_company_kana = request.getParameter("regist_company_kana");
	String user_id = request.getParameter("regist_id");
	String user_pw = request.getParameter("regist_pw");
	String user_class = request.getParameter("regist_class");

	// 登録を行う
	  UserDao uDao = new UserDao();
	  uDao.insert(new User(0, user_role, user_name, user_name_kana, user_company, user_company_kana, user_id, user_pw, user_class));
		  LoginDao iDao = new LoginDao();
		  if (iDao.isLoginOK(user_id,user_pw)) {
			  // セッションスコープにIDを格納する
			  HttpSession session = request.getSession();
			  session.setAttribute("id",new LoginUser(user_id));
			  if(user_role == "0") {
				  response.sendRedirect("/SMSystem/Menu_TeacherServlet");
			  }else if (user_role == "1") {
				  response.sendRedirect("/SMSystem/Create_ProfileServlet");
			  }
		  } else {
			  response.sendRedirect("/SMSystem/LoginServlet");
		  }
	}
}




