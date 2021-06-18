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
 * Servlet implementation class Faq_ListServlet
 */
@WebServlet("/Faq_ListServlet")
public class Faq_ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	// フォワード
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/faq_list.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String genre = request.getParameter("genre");
		int row = 0;
		Table table = new Table(row);


		// 検索処理を行う
		All_QuestionDao aqDao = new All_QuestionDao();
		List<All_Question> faqList = aqDao.select_faq(new All_Question(0, "", genre, "", "", "", "", 0,""),table);
		HttpSession session = request.getSession();
		session.setAttribute("faqGenre",genre);
		session.setAttribute("faqList", faqList);


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/faq_list2.jsp");
		dispatcher.forward(request, response);


	}

}
