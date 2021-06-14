package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	String user_role = request.getParameter("user_role");
	String user_name = request.getParameter("user_name");
	String user_name_kana = request.getParameter("user_name_kana");
	String user_company = request.getParameter("user_company");
	String user_company_kana = request.getParameter("user_company_kana");
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
	String user_class = request.getParameter("user_class");

	// 登録を行う
	  UserDao uDao = new UserDao();
	  if(uDao.insert(new User(0,user_id,user_pw, user_name, user_name_kana, user_company, user_company_kana, user_class,user_role))) {


			  if(user_role.equals("0")) {
				  HttpSession session = request.getSession();
				  session.setAttribute("id",new LoginUser(user_id));
				  response.sendRedirect("/SMSystem/Menu_TeacherServlet");
			  }else if (user_role.equals("1")) {
				  request.setAttribute("userName", user_name);
				  request.setAttribute("userNameKana", user_name_kana);
				  request.setAttribute("userID",user_id);

				  RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/create_profile.jsp");
				dispatcher.forward(request, response);
			  }
		  } else {
			  response.sendRedirect("/SMSystem/LoginServlet");
		  }
	}
}




