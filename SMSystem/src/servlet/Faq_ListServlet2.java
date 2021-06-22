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

		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/faq_list_t.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	String genre = request.getParameter("genre");
	HttpSession session = request.getSession();
	session.setAttribute("faqGenre",genre);
	Table table = new Table (0);
	All_QuestionDao ADao = new All_QuestionDao();
	All_Question aQ = new All_Question(0,"",genre,"","","","",0,"");
	List<All_Question> faqList = ADao.select_faq(aQ, table);
	request.setAttribute("faqList",faqList);

	if(genre.equals("0")) {
		genre = "ドリル";
	}else if (genre.equals("1")){
		genre = "HTML";
	}else if (genre.equals("2")){
		genre = "CSS";
	}else if (genre.equals("3")){
		genre = "JavaScript";
	}else if (genre.equals("4")) {
		genre = "Java";
	}else if (genre.equals("5")) {
		genre = "データベース";
	}else if (genre.equals("6")) {
		genre = "サーブレット＆JSP";
	}else if (genre.equals("7")){
		genre = "名刺管理アプリ";
	}else if (genre.equals("8")) {
		genre = "その他";
	}

	session.setAttribute("genre", genre);
	int count = 0;
	count = ADao.select_count(aQ);
	session.setAttribute("count", count);
	RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/faq_list_t2.jsp");
	dispatcher.forward(request, response);

	}
}
