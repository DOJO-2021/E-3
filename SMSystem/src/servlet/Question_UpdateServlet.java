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
 * Servlet implementation class Question_UpdateServlet
 */
@WebServlet("/Question_UpdateServlet")
public class Question_UpdateServlet extends HttpServlet {
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
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		String faq = request.getParameter("faq");
		String submit = request.getParameter("submit_response");

		// 更新処理を行う
		All_QuestionDao aqDao = new All_QuestionDao();
		if (submit.equals("登録")) {
			if (aqDao.update_question(new All_Question(0, "", "", question, answer, faq, "", 0, ""))) {
					// 質問一覧画面にリダイレクト
					response.sendRedirect("/SMSystem/Question_ListServlet");
			}
		}


	}

}
