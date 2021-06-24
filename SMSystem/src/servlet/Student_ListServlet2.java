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

import dao.UserDao;
import dao.UserProfileDao;
import model.Table;
import model.User;
import model.UserProfile;

/**
 * Servlet implementation class Student_ListServlet
 */
@WebServlet("/Student_ListServlet2")
public class Student_ListServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("user_id");

		UserProfileDao upDao = new UserProfileDao();
		List<UserProfile> userProfileList = upDao.select_profile(new UserProfile(user_id,"","","","","","","","",""));
		request.setAttribute("userProfileList", userProfileList);


		//プロフィール一覧ページにフォワードする
		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/profile2.jsp");
		dispatcher.forward(request, response);
	}

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

			String user_class = (String) session.getAttribute("studentClass");
			UserDao uDao = new UserDao();
			List<User> studentList = uDao.select(new User(0,"","","","","","",user_class,""),table);
			request.setAttribute("studentList", studentList);

			session.getAttribute("count");

			RequestDispatcher dispatcher1 =request.getRequestDispatcher("/WEB-INF/jsp/student_list2.jsp");
			dispatcher1.forward(request, response);

		}else if(count_pager == 1) {
			int pager1 = (int) session.getAttribute("pager1");
			int value = 0;

			if(PAGER.equals("1")) {
				value = 10*(pager1-1);
			}

			session.setAttribute("pager1", pager1);

			Table table = new Table(value);

			String user_class = (String) session.getAttribute("studentClass");
			UserDao uDao = new UserDao();
			List<User> studentList = uDao.select(new User(0,"","","","","","",user_class,""),table);
			request.setAttribute("studentList", studentList);

			session.getAttribute("count");

			RequestDispatcher dispatcher1 =request.getRequestDispatcher("/WEB-INF/jsp/student_list2.jsp");
			dispatcher1.forward(request, response);

		}else if(count_pager == 2) {
			int pager1 = (int) session.getAttribute("pager1");
			int pager2 = (int) session.getAttribute("pager2");
			int value = 0;

			if(PAGER.equals("1")) {
				value = 10*(pager1-1);
			}else if(PAGER.equals("2")) {
				value = 10*(pager2-1);
			}

			session.setAttribute("pager1", pager1);
			session.setAttribute("pager2", pager2);
			Table table = new Table(value);

			String user_class = (String) session.getAttribute("studentClass");
			UserDao uDao = new UserDao();
			List<User> studentList = uDao.select(new User(0,"","","","","","",user_class,""),table);
			request.setAttribute("studentList", studentList);

			session.getAttribute("count");
			current_pager = value/10+1;
			session.setAttribute("current_pager", current_pager);

			RequestDispatcher dispatcher1 =request.getRequestDispatcher("/WEB-INF/jsp/student_list2.jsp");
			dispatcher1.forward(request, response);
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
				if(max/10+1>pager3 && max%10!=0) {
					pager1+=1;
					pager2+=1;
					pager3+=1;
				}else if(max/10>pager3 && max%10==0) {
					pager1+=1;
					pager2+=1;
					pager3+=1;
				}
			}else if(PAGER.equals("1")) {
				value = 10*(pager1-1);
			}else if(PAGER.equals("2")) {
				value = 10*(pager2-1);
			}else if(PAGER.equals("3")) {
				value = 10*(pager3-1);
			}



			session.setAttribute("pager1", pager1);
			session.setAttribute("pager2", pager2);
			session.setAttribute("pager3", pager3);
			session.setAttribute("value", value);
			Table table = new Table(value);

			String user_class = (String) session.getAttribute("studentClass");
			UserDao uDao = new UserDao();
			List<User> studentList = uDao.select(new User(0,"","","","","","",user_class,""),table);
			request.setAttribute("studentList", studentList);

			session.getAttribute("count");
			current_pager = value/10+1;
			session.setAttribute("current_pager", current_pager);

			int count_maxpager = (int) session.getAttribute("count_maxpager");
			if(pager3 == count_maxpager) {
				session.removeAttribute("pagerBig");
			}else if(pager1 == 1) {
				session.removeAttribute("pagerSmall");
			}


			RequestDispatcher dispatcher1 =request.getRequestDispatcher("/WEB-INF/jsp/student_list2.jsp");
			dispatcher1.forward(request, response);
		}
		}
}
