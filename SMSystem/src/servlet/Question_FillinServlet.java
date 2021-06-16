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
 * Servlet implementation class Question_FillinServlet
 */
@WebServlet("/Question_FillinServlet")
public class Question_FillinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//質問記入ページにフォワードする
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/question_fillin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");

		String genre = request.getParameter("select");
		String question = request.getParameter("question");
		String emergent = request.getParameter("emergent");

		//登録処理を行う
		All_QuestionDao qDao = new All_QuestionDao();
		if(qDao.insert_question(new All_Question(0, "", genre, question, "", "", emergent, 0))) {
			//質問投稿画面にリダイレクト
			response.sendRedirect("/SMSystem/Question_UpServlet");
}

		 else { //記入漏れした場合は失敗
			 //リクエストスコープにタイトル、メッセージ、戻り先を格納する
			 response.sendRedirect("/SMSystem/Menu_StudentServlet");
		 }
	}
}