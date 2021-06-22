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
 * Servlet implementation class FaqListServlet3
 */
@WebServlet("/Faq_ListServlet3")
public class Faq_ListServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String PAGER = request.getParameter("pager");
	HttpSession session = request.getSession();
	String genre = (String) session.getAttribute("genre");
	int pager = Integer.parseInt(PAGER);
	if(pager == 1) {
		pager = 0;
	}else if (pager == 2) {
		pager = 2;
	}else {
		pager = 4;
	}
	Table table = new Table(pager);
	All_QuestionDao ADao = new All_QuestionDao();
	List<All_Question> faqList = ADao.select_faq(new All_Question(0,"",genre,"","","","",0,""),table);
	request.setAttribute("faqList", faqList);
	RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/faq_list_t2.jsp");
	dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
