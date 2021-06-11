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
 * Servlet implementation class Question_ListServlet
 */
@WebServlet("/Question_ListServlet")
public class Question_ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 検索処理を行う（質問）
		All_QuestionDao qDao = new All_QuestionDao();
		List<All_Question> questionList = qDao.select_emergent(new All_Question());

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("quesrionList", questionList);

		// 質問一覧画面にフォワードする
		RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/question_list.jsp");
		dispacher.forward(request, response);

	}
}