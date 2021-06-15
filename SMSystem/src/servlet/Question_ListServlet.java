package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserAll_QuestionDao;
import model.UserAll_Question;

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
		RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/question_list.jsp");
		dispacher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_class = request.getParameter("class");

		UserAll_QuestionDao aqDao = new UserAll_QuestionDao();
		List<UserAll_Question> userAll_questionList = aqDao.select_emergent(new UserAll_Question("0", "", user_class, "",  "", "", "", 0));
		List<UserAll_Question> userAll_questionList2 = aqDao.select_not_emergent(new UserAll_Question("0", "", user_class, "", "", "", "", 0));
		request.setAttribute("emergent", userAll_questionList);
		request.setAttribute("not_emergent", userAll_questionList2);

		RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/question_list2.jsp");
		dispacher.forward(request, response);
	}
}