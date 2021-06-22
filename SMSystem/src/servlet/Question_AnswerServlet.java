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

import dao.All_QuestionDao;
import model.All_Question;
import model.Table;
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
		HttpSession session = request.getSession();
		Object O = session.getAttribute("id");
		String user_id = O.toString();
		int row = 0;
		Table table = new Table(row);

		All_QuestionDao ADao=new All_QuestionDao();
		List<All_Question> AList = ADao.select_questionUser_id(new All_Question(0,user_id,"","","","","",0,""),table);
		request.setAttribute("user_id",user_id);
		request.setAttribute("AList",AList);
		session.setAttribute("user_id", user_id);
		//セッションIDを取得する



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
