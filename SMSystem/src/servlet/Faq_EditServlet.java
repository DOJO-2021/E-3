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
 * Servlet implementation class Faq_EditServlet
 */
@WebServlet("/Faq_EditServlet")
public class Faq_EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/faq_edit.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String genre = request.getParameter("genre");
		int row = 0;
		Table table = new Table(row);


		All_QuestionDao ADao = new All_QuestionDao();
		All_Question aQ = new All_Question(0,"",genre,"","","","",0,"");
		List<All_Question> faqList = ADao.select_faqEdit(aQ, table);
		HttpSession session = request.getSession();
		session.setAttribute("faqGenre",genre);
		session.setAttribute("faqList", faqList);

		int count = ADao.select_count(aQ);
		session.setAttribute("count", count);

		if(genre.equals("0")) {
			genre = "ドリル";
		}else if (genre.equals("1")) {
			genre = "HTML";
		}else if (genre.equals("2")) {
			genre = "CSS";
		}else if (genre.equals("3")) {
			genre = "JavaScript";
		}else if (genre.equals("4")){
				genre = "Java";
		}else if (genre.equals("5")) {
			genre = "データベース";
		}else if (genre.equals("6")) {
			genre = "サーブレット＆JSP";
		}else if (genre.equals("7")) {
			genre = "名刺管理アプリ";
		}else if (genre.equals("8")) {
			genre = "その他";
		}

		session.setAttribute("genre", genre);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/faq_delete_update.jsp");
		dispatcher.forward(request,response);
	}

}
