package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.All_QuestionDao;
import model.All_Question;
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
		String ganre = request.getParameter("ganre");

		All_QuestionDao ADao = new All_QuestionDao();
		List<All_Question> faqList = ADao.select_faq(new All_Question(0,"",ganre,"","","","",0));
		request.setAttribute("faqList", faqList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/faq_delete_update.jsp");
		dispatcher.forward(request,response);
	}

}
