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
 * Servlet implementation class Question_AnswerServlet
 */
@WebServlet("/Question_AnswerServlet")
public class Question_AnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.removeAttribute("pager1");
		session.removeAttribute("pager2");
		session.removeAttribute("pager3");
		session.removeAttribute("count_pager");
		session.removeAttribute("value");
		session.removeAttribute("count_maxpager");
		session.removeAttribute("current_pager");
		session.removeAttribute("pagerSmall");
		session.removeAttribute("pagerBig");

		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		Object O = session.getAttribute("id");
		String user_id = O.toString();
		int row = 0;
		Table table = new Table(row);

		All_QuestionDao ADao=new All_QuestionDao();
		All_Question aQ = new All_Question(0,user_id,"","","","","",0,"");
		List<All_Question> AList = ADao.select_questionUser_id(aQ,table);
		request.setAttribute("user_id",user_id);
		request.setAttribute("AList",AList);
		session.setAttribute("user_id", user_id);

		int question_count = 0;
		question_count = ADao.select_question_count(aQ);
		session.setAttribute("question_count", question_count);

		int value = 0;
		session.setAttribute("value", value);
		int current_pager = value/1+1;
		session.setAttribute("current_pager", current_pager);

		String pagerSmall = "前へ";
		String pagerBig = "次へ";
		session.setAttribute("pagerSmall", pagerSmall);
		session.setAttribute("pagerBig", pagerBig);

		int count_pager = 0;
		int count_maxpager = 0;
		int max = (int) session.getAttribute("question_count");
		if(max/1+1==1 && max%1!=0) {
			int pager1 = 1;
			session.setAttribute("pager1", pager1);
			count_pager = 1;
			session.setAttribute("count_pager", count_pager);
			count_maxpager = max/1+1;
			session.removeAttribute("pagerSmall");
			session.removeAttribute("pagerBig");
		}else if(max/1==1 && max%1==0) {
			int pager1 = 1;
			session.setAttribute("pager1", pager1);
			count_pager = 1;
			session.setAttribute("count_pager", count_pager);
			count_maxpager = max/1;
			session.removeAttribute("pagerSmall");
			session.removeAttribute("pagerBig");
		}else if(max/1+1==2 && max%1!=0) {
			int pager1 = 1;
			session.setAttribute("pager1", pager1);
			int pager2 = 2;
			session.setAttribute("pager2", pager2);
			count_pager = 2;
			session.setAttribute("count_pager", count_pager);
			count_maxpager = max/1+1;
			session.removeAttribute("pagerSmall");
			session.removeAttribute("pagerBig");
		}else if(max/1==2 && max%1==0) {
			int pager1 = 1;
			session.setAttribute("pager1", pager1);
			int pager2 = 2;
			session.setAttribute("pager2", pager2);
			count_pager = 2;
			session.setAttribute("count_pager", count_pager);
			count_maxpager = max/1;
			session.removeAttribute("pagerSmall");
			session.removeAttribute("pagerBig");
		}else if(max/1+1==3 && max%1!=0) {
			int pager1 = 1;
			session.setAttribute("pager1", pager1);
			int pager2 = 2;
			session.setAttribute("pager2", pager2);
			int pager3 = 3;
			session.setAttribute("pager3", pager3);
			count_pager = 3;
			session.setAttribute("count_pager", count_pager);
			count_maxpager = max/1+1;
			session.removeAttribute("pagerSmall");
			session.removeAttribute("pagerBig");
		}else if(max/1==3 && max%1==0) {
			int pager1 = 1;
			session.setAttribute("pager1", pager1);
			int pager2 = 2;
			session.setAttribute("pager2", pager2);
			int pager3 = 3;
			session.setAttribute("pager3", pager3);
			count_pager = 3;
			session.setAttribute("count_pager", count_pager);
			count_maxpager = max/1;
			session.removeAttribute("pagerSmall");
			session.removeAttribute("pagerBig");
		}else if(max/1+1>3 && max%1!=0){
			int pager1 = 1;
			session.setAttribute("pager1", pager1);
			int pager2 = 2;
			session.setAttribute("pager2", pager2);
			int pager3 = 3;
			session.setAttribute("pager3", pager3);
			count_pager = 3;
			session.setAttribute("count_pager", count_pager);
			count_maxpager = max/1+1;
			session.removeAttribute("pagerSmall");
		}else if(max/1>3 && max%1==0) {
			int pager1 = 1;
			session.setAttribute("pager1", pager1);
			int pager2 = 2;
			session.setAttribute("pager2", pager2);
			int pager3 = 3;
			session.setAttribute("pager3", pager3);
			count_pager = 3;
			session.setAttribute("count_pager", count_pager);
			count_maxpager = max/1;
			session.removeAttribute("pagerSmall");
		}else if(max == 0) {
			current_pager -= 1;
			session.setAttribute("current_pager", current_pager);
			session.setAttribute("count_pager", count_pager);
			session.removeAttribute("pagerSmall");
			session.removeAttribute("pagerBig");
		}
		session.setAttribute("count_maxpager",count_maxpager);




		// フォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question_answer.jsp");
				dispatcher.forward(request, response);


			}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



	}

}
