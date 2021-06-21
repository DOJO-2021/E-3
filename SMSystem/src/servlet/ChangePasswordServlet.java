package servlet;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.getAttribute("userInfo");
		session.getAttribute("id");
		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/changepassword.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String new_password = request.getParameter("new_pw");
		String user_id = request.getParameter("user_id");
		String confirm_pw = request.getParameter("confirm_pw");
		Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]{8,16}$");
		if(pattern.matcher(new_password).matches()) {
			if(new_password.equals(confirm_pw)) {
				UserDao UDao = new UserDao();
				if(UDao.update_user(new User(0,user_id,new_password,"","","","","",""))) {
					HttpSession session = request.getSession();
					session.getAttribute("userInfo");
					session.removeAttribute("userInfo");
					List<User> user_info = UDao.select_user(new User(0,user_id,"","","","","","",""));
					session.setAttribute("userInfo",user_info);
					response.sendRedirect("/SMSystem/PasswordOkServlet");
				}else {
					response.sendRedirect("/SMSystem/PasswordNoServlet");
				}
			}else {
				response.sendRedirect("/SMSystem/PasswordNoServlet");
			}
		}else {
			response.sendRedirect("/SMSystem/PasswordNoServlet");
		}


	}

}
