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
		request.setCharacterEncoding("UTF-8");
		String PAGER = request.getParameter("pager");

		int pager = Integer.parseInt(PAGER);
		if(pager == 1) {
			pager = 0;
		}else if(pager == 2) {
			pager = 2;
		}else {
			pager = 4;
		}

		Table table = new Table(pager);
		HttpSession session = request.getSession();
		String genre = (String) session.getAttribute("faqGenre");
		All_QuestionDao aDao = new All_QuestionDao();
		List<All_Question> faqList = aDao.select_faq(new All_Question(0, "", genre, "", "", "", "", 0, ""),table);
		request.setAttribute("faqList", faqList);

		RequestDispatcher dispatcher1 =request.getRequestDispatcher("/WEB-INF/jsp/faq_list2.jsp");
		dispatcher1.forward(request, response);

	}


}
