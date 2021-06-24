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
		String PAGER = request.getParameter("page");
		HttpSession session = request.getSession();
		session.getAttribute("count_maxpager");
		int current_pager = (int) session.getAttribute("current_pager");
		int count_pager = (int) session.getAttribute("count_pager");
		String pagerSmall = "前へ";
		session.setAttribute("pagerSmall",pagerSmall);
		String pagerBig = "次へ";
		session.setAttribute("pagerBig",pagerBig);

		if(count_pager == 0) {
			int value = 0;

			Table table = new Table(value);

			String user_id = (String) session.getAttribute("user_id");
			All_QuestionDao aqDao = new All_QuestionDao();
			List<All_Question> AList = aqDao.select_questionUser_id(new All_Question(0,user_id,"","","","","",0,""),table);
			request.setAttribute("AList", AList);

			RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/question_answer.jsp");
			dispatcher.forward(request, response);

		}else if(count_pager == 1) {
			int pager1 = (int) session.getAttribute("pager1");
			int value = 0;

			if(PAGER.equals("1")) {
				value = 1*(pager1-1);
			}

			session.setAttribute("pager1", pager1);


			Table table = new Table(value);
			session.getAttribute("question_count");
			current_pager = value/1+1;
			session.setAttribute("current_pager", current_pager);

			String user_id = (String) session.getAttribute("user_id");
			All_QuestionDao aqDao = new All_QuestionDao();
			List<All_Question> AList = aqDao.select_questionUser_id(new All_Question(0,user_id,"","","","","",0,""),table);
			request.setAttribute("AList", AList);

			RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/question_answer.jsp");
			dispatcher.forward(request, response);

		}else if(count_pager == 2) {
			int pager1 = (int) session.getAttribute("pager1");
			int pager2 = (int) session.getAttribute("pager2");
			int value = (int) session.getAttribute("value");

			if(PAGER.equals("1")) {
				value = 1*(pager1-1);
			}else if(PAGER.equals("2")) {
				value = 1*(pager2-1);
			}

			session.setAttribute("pager1", pager1);
			session.setAttribute("pager2", pager2);
			Table table = new Table(value);

			session.setAttribute("value",value);

			session.getAttribute("question_count");
			current_pager = value/1+1;
			session.setAttribute("current_pager", current_pager);

			String user_id = (String) session.getAttribute("user_id");
			All_QuestionDao aqDao = new All_QuestionDao();
			List<All_Question> AList = aqDao.select_questionUser_id(new All_Question(0,user_id,"","","","","",0,""),table);
			request.setAttribute("AList", AList);

			RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/question_answer.jsp");
			dispatcher.forward(request, response);
		}else if(count_pager == 3) {
			int pager1 = (int) session.getAttribute("pager1");
			int pager2 = (int) session.getAttribute("pager2");
			int pager3 = (int) session.getAttribute("pager3");
			int value = (int) session.getAttribute("value");
			int max = (int) session.getAttribute("question_count");

			if(PAGER.equals("small")) {
				if(pager1>=2) {
					pager1-=1;
					pager2-=1;
					pager3-=1;
				}
			}else if(PAGER.equals("big")) {
				if(max/1+1>pager3 && max%1!=0) {
					pager1+=1;
					pager2+=1;
					pager3+=1;
				}else if(max/1>pager3 && max%1==0) {
					pager1+=1;
					pager2+=1;
					pager3+=1;
				}
			}else if(PAGER.equals("1")) {
				value = 1*(pager1-1);
			}else if(PAGER.equals("2")) {
				value = 1*(pager2-1);
			}else if(PAGER.equals("3")) {
				value = 1*(pager3-1);
			}



			session.setAttribute("pager1", pager1);
			session.setAttribute("pager2", pager2);
			session.setAttribute("pager3", pager3);
			session.setAttribute("value", value);

			Table table = new Table(value);
			session.getAttribute("question_count");
			current_pager = value/1+1;
			session.setAttribute("current_pager", current_pager);

			String user_id = (String) session.getAttribute("user_id");
			All_QuestionDao aqDao = new All_QuestionDao();
			List<All_Question> AList = aqDao.select_questionUser_id(new All_Question(0,user_id,"","","","","",0,""),table);
			request.setAttribute("AList", AList);

			int count_maxpager = (int) session.getAttribute("count_maxpager");
			if(pager3 == count_maxpager) {
				session.removeAttribute("pagerBig");
			}else if(pager1 == 1) {
				session.removeAttribute("pagerSmall");
			}

			RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/question_answer.jsp");
			dispatcher.forward(request, response);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
