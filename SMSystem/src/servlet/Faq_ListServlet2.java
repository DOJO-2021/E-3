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
 * Servlet implementation class Faq_ListServlet2
 */
@WebServlet("/Faq_ListServlet2")
public class Faq_ListServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher1 =request.getRequestDispatcher("/WEB-INF/jsp/faq_list_t.jsp");
		dispatcher1.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String genre = request.getParameter("genre");
	Table table = new Table (0);
	All_QuestionDao ADao = new All_QuestionDao();
	List<All_Question> faqList = ADao.select_faq(new All_Question(0,"",genre,"","","","",0,""), table);
	request.setAttribute("faqList",faqList);
	HttpSession session = request.getSession();
	session.setAttribute("genre", genre);
	RequestDispatcher dispatcher1 =request.getRequestDispatcher("/WEB-INF/jsp/faq_list_t2.jsp");
	dispatcher1.forward(request, response);

	}
}
