package servlet;

import java.io.IOException;
import java.util.List;

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
		String question = request.getParameter("textquestion");

		All_QuestionDao aqDao = new All_QuestionDao();
		List<All_Question> all_question = aqDao.update_question(new All_Question(0, "", "", "", "", "", "", ));
		request.setAttribute("question", all_question);

		RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/question_response.jsp");
		dispacher.forward(request, response);
	}

}
