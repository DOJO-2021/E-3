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

import dao.LoginDao;
import dao.UserDao;
import model.User;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		String user_role = request.getParameter("user_role");

		// ログイン処理を行う
		LoginDao iDao = new LoginDao();
		if (iDao.isLoginOK(id, pw, user_role)) {
			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.setAttribute("id",id);

			UserDao UDao = new UserDao();
			List<User> userInfo= UDao.select_user(new User(0,id,"","","","","","",""));
			session.setAttribute("userInfo", userInfo);

			if(user_role.equals("0")) {
				response.sendRedirect("/SMSystem/Menu_TeacherServlet");
			}else if(user_role.equals("1")) {
				response.sendRedirect("/SMSystem/Menu_StudentServlet");
			}


		} else {
			response.sendRedirect("/SMSystem/LoginServlet");

		}
	}

}
