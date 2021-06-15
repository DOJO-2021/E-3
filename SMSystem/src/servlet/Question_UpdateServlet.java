package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.All_QuestionDao;
import model.All_Question;

/**
 * Servlet implementation class Question_UpdateServlet
 */
@WebServlet("/Question_UpdateServlet")
public class Question_UpdateServlet extends HttpServlet {
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
		String question_id1 = request.getParameter("question_id");
		int question_id = Integer.parseInt(question_id1);

		All_QuestionDao aqDao = new All_QuestionDao();
		if (aqDao.update_question(new All_Question(0, "", "", "", "", "", "", question_id))) {
			response.sendRedirect("/SMSystem/Question_ListServlet");
		}

	}

}
