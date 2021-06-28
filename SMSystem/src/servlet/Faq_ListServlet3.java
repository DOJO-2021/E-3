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
		request.setCharacterEncoding("UTF-8");
		String PAGER = request.getParameter("page");
		HttpSession session = request.getSession();
		String genre = (String)session.getAttribute("faqGenre");
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

			All_QuestionDao ADao = new All_QuestionDao();
			List<All_Question> faqList = ADao.select_faq(new All_Question(0,"",genre,"","","","",0,""),table);
			request.setAttribute("faqList", faqList);

			RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/faq_list_t2.jsp");
			dispatcher.forward(request, response);

		}else if(count_pager == 1) {
			int pager1 = (int) session.getAttribute("pager1");
			int value = 0;

			if(PAGER.equals("1")) {
				value = 2*(pager1-1);
			}

			session.setAttribute("pager1", pager1);

			Table table = new Table(value);



			All_QuestionDao ADao = new All_QuestionDao();
			List<All_Question> faqList = ADao.select_faq(new All_Question(0,"",genre,"","","","",0,""),table);
			request.setAttribute("faqList", faqList);

			session.getAttribute("count");
			current_pager = value/2+1;
			session.setAttribute("current_pager", current_pager);
			session.removeAttribute("pagerSmall");
			session.removeAttribute("pagerBig");


			RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/faq_list_t2.jsp");
			dispatcher.forward(request, response);

		}else if(count_pager == 2) {
			int pager1 = (int) session.getAttribute("pager1");
			int pager2 = (int) session.getAttribute("pager2");
			int value = (int) session.getAttribute("value");
			int max = (int) session.getAttribute("count");

			if(PAGER.equals("1")) {
				value = 2*(pager1-1);
			}else if(PAGER.equals("2")) {
				value = 2*(pager2-1);
			}

			session.setAttribute("pager1", pager1);
			session.setAttribute("pager2", pager2);
			Table table = new Table(value);

			session.setAttribute("value",value);

			All_QuestionDao ADao = new All_QuestionDao();
			List<All_Question> faqList = ADao.select_faq(new All_Question(0,"",genre,"","","","",0,""),table);
			request.setAttribute("faqList", faqList);

			session.getAttribute("count");
			current_pager = value/2+1;
			session.setAttribute("current_pager", current_pager);
			session.removeAttribute("pagerSmall");
			session.removeAttribute("pagerBig");


			RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/faq_list_t2.jsp");
			dispatcher.forward(request, response);

		}else if(count_pager == 3) {
			int pager1 = (int) session.getAttribute("pager1");
			int pager2 = (int) session.getAttribute("pager2");
			int pager3 = (int) session.getAttribute("pager3");
			int value = (int) session.getAttribute("value");
			int max = (int) session.getAttribute("count");

			if(PAGER.equals("small")) {
				if(pager1>=2) {
					pager1-=1;
					pager2-=1;
					pager3-=1;
				}
			}else if(PAGER.equals("big")) {
				if(max/2+1>pager3 && max%2!=0) {
					pager1+=1;
					pager2+=1;
					pager3+=1;
				}else if(max/2>pager3 && max%2==0) {
					pager1+=1;
					pager2+=1;
					pager3+=1;
				}
			}else if(PAGER.equals("1")) {
				value = 2*(pager1-1);
			}else if(PAGER.equals("2")) {
				value = 2*(pager2-1);
			}else if(PAGER.equals("3")) {
				value = 2*(pager3-1);
			}



			session.setAttribute("pager1", pager1);
			session.setAttribute("pager2", pager2);
			session.setAttribute("pager3", pager3);
			session.setAttribute("value", value);
			Table table = new Table(value);

			All_QuestionDao ADao = new All_QuestionDao();
			List<All_Question> faqList = ADao.select_faq(new All_Question(0,"",genre,"","","","",0,""),table);
			request.setAttribute("faqList", faqList);

			session.getAttribute("count");
			current_pager = value/2+1;
			session.setAttribute("current_pager", current_pager);

			int count_maxpager = (int) session.getAttribute("count_maxpager");
			if(count_maxpager == 3) {
				session.removeAttribute("pagerBig");
				session.removeAttribute("pagerSmall");
			}else if(pager3 == count_maxpager) {
				session.removeAttribute("pagerBig");
			}else if(pager1 == 1) {
				session.removeAttribute("pagerSmall");
			}

			RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/faq_list_t2.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}