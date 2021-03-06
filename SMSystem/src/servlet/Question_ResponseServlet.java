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
 * Servlet implementation class Question_ResponseServlet
 */
@WebServlet("/Question_ResponseServlet")
public class Question_ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// フォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question_response.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String question_id1 = request.getParameter("question_id");
		int question_id = Integer.parseInt(question_id1);
		//String question = request.getParameter("getQuestion");

		All_QuestionDao aqDao = new All_QuestionDao();
		String question = aqDao.select_question(new All_Question(0,"","","","","","",question_id,""));
		request.setAttribute("all_question", question);

		// フォワードする
		RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/question_response.jsp");
		dispacher.forward(request, response);
	}

}
