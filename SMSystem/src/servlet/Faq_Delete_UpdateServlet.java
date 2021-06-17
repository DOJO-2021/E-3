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
 * Servlet implementation class Faq_Delete_UpdateServlete
 */
@WebServlet("/Faq_Delete_UpdateServlet")
public class Faq_Delete_UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/faq_delete_update.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String QUESTION_ID= request.getParameter("question_id");
		int question_id = Integer.parseInt(QUESTION_ID);

		String answer = request.getParameter("answer");
		String submit = request.getParameter("SUBMIT");

		All_QuestionDao ADao = new All_QuestionDao();
		if(submit.equals("登録"))  {
			if(ADao.update_faq(new All_Question(0,"","","",answer,"","",question_id))) {
				response.sendRedirect("/SMSystem/Menu_TeacherServlet");
			}

		}else {
			if(ADao.delete_faq(question_id)){
				response.sendRedirect("/SMSystem/Menu_TeacherServlet");
			}
		}
	}

}
