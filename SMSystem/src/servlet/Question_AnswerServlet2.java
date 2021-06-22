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
 * Servlet implementation class Question_AnswerServlet2
 */
@WebServlet("/Question_AnswerServlet2")
public class Question_AnswerServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Question_AnswerServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String PAGER = request.getParameter("pager");

		int pager = Integer.parseInt(PAGER);


		if(pager == 1) {
			pager = 0;
		}else if(pager == 2) {
			pager = 1;
		}else {
			pager = 2;
		}


		Table table = new Table(pager);
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");
		All_QuestionDao aqDao = new All_QuestionDao();
		List<All_Question> AList = aqDao.select_questionUser_id(new All_Question(0,user_id,"","","","","",0,""),table);
		request.setAttribute("AList", AList);
		session.getAttribute("question_count");

		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/question_answer.jsp");
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
