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
 * Servlet implementation class Question_AnswerServlet
 */
@WebServlet("/Question_AnswerServlet")
public class Question_AnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String question = request.getParameter("QUESTION");
		String answer = request.getParameter("ANSWER");

		All_QuestionDao ADao=new All_Question();
		List<All_Question> Alist = ADao.

		//質問回答をリクエストスコープに格納する
		request.setAttribute(question, answer);

		// フォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question_answer.jsp");
				dispatcher.forward(request, response);


			}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



	}

}
