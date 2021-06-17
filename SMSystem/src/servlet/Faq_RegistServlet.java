package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.All_QuestionDao;
import model.All_Question;

/**
 * Servlet implementation class Faq_RegistServlet
 */
@WebServlet("/Faq_RegistServlet")
public class Faq_RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/faq_regist.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String genre = request.getParameter("genre");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");

		All_QuestionDao aDao = new All_QuestionDao();
		if(aDao.insert_faq(new All_Question(0,"",genre,question,answer,"1","",0))) {
			response.sendRedirect("/SMSystem/Menu_TeacherServlet");
		}
	}

}
