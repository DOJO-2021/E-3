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
import model.Table;
import model.User;

/**
 * Servlet implementation class Menu_StudentServlet
 */
@WebServlet("/Menu_StudentServlet")
public class Menu_StudentServlet extends HttpServlet {
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

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/menu_student.jsp");
		dispatcher.forward(request,response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_class = request.getParameter("user_class");
		int row = 0;
		Table table = new Table(row);

		UserDao uDao = new UserDao();
		User u = new User(0,"","","","","","",user_class,"");
		List<User> studentList = uDao.select(u, table);
		request.setAttribute("studentClass", user_class);
		request.setAttribute("studentList", studentList);
		HttpSession session = request.getSession();
		session.setAttribute("studentClass", user_class);

		int count = uDao.select_count(u);
		request.setAttribute("count", count);
		session.setAttribute("count", count);
		int value = 0;
		session.setAttribute("value", value);
		int current_pager = value/10+1;
		session.setAttribute("current_pager", current_pager);

		String pagerSmall = "前へ";
		String pagerBig = "次へ";
		session.setAttribute("pagerSmall", pagerSmall);
		session.setAttribute("pagerBig", pagerBig);

		int count_pager = 0;
		int count_maxpager = 0;
		int max = (int) session.getAttribute("count");
		if(max/10+1==1 && max%10!=0) {
			int pager1 = 1;
			session.setAttribute("pager1", pager1);
			count_pager = 1;
			session.setAttribute("count_pager", count_pager);
			count_maxpager = max/10+1;
			session.removeAttribute("pagerSmall");
			session.removeAttribute("pagerBig");
		}else if(max/10==1 && max%10==0) {
			int pager1 = 1;
			session.setAttribute("pager1", pager1);
			count_pager = 1;
			session.setAttribute("count_pager", count_pager);
			count_maxpager = max/10;
			session.removeAttribute("pagerSmall");
			session.removeAttribute("pagerBig");
		}else if(max/10+1==2 && max%10!=0) {
			int pager1 = 1;
			session.setAttribute("pager1", pager1);
			int pager2 = 2;
			session.setAttribute("pager2", pager2);
			count_pager = 2;
			session.setAttribute("count_pager", count_pager);
			count_maxpager = max/10+1;
			session.removeAttribute("pagerSmall");
			session.removeAttribute("pagerBig");
		}else if(max/10==2 && max%10==0) {
			int pager1 = 1;
			session.setAttribute("pager1", pager1);
			int pager2 = 2;
			session.setAttribute("pager2", pager2);
			count_pager = 2;
			session.setAttribute("count_pager", count_pager);
			count_maxpager = max/10;
			session.removeAttribute("pagerSmall");
			session.removeAttribute("pagerBig");
		}else if(max/10+1==3 && max%10!=0) {
			int pager1 = 1;
			session.setAttribute("pager1", pager1);
			int pager2 = 2;
			session.setAttribute("pager2", pager2);
			int pager3 = 3;
			session.setAttribute("pager3", pager3);
			count_pager = 3;
			session.setAttribute("count_pager", count_pager);
			count_maxpager = max/10+1;
			session.removeAttribute("pagerSmall");
			session.removeAttribute("pagerBig");
		}else if(max/10==3 && max%10==0) {
			int pager1 = 1;
			session.setAttribute("pager1", pager1);
			int pager2 = 2;
			session.setAttribute("pager2", pager2);
			int pager3 = 3;
			session.setAttribute("pager3", pager3);
			count_pager = 3;
			session.setAttribute("count_pager", count_pager);
			count_maxpager = max/10;
			session.removeAttribute("pagerSmall");
			session.removeAttribute("pagerBig");
		}else if(max/10+1>3 && max%10!=0){
			int pager1 = 1;
			session.setAttribute("pager1", pager1);
			int pager2 = 2;
			session.setAttribute("pager2", pager2);
			int pager3 = 3;
			session.setAttribute("pager3", pager3);
			count_pager = 3;
			session.setAttribute("count_pager", count_pager);
			count_maxpager = max/10+1;
			session.removeAttribute("pagerSmall");
		}else if(max/10>3 && max%10==0) {
			int pager1 = 1;
			session.setAttribute("pager1", pager1);
			int pager2 = 2;
			session.setAttribute("pager2", pager2);
			int pager3 = 3;
			session.setAttribute("pager3", pager3);
			count_pager = 3;
			session.setAttribute("count_pager", count_pager);
			count_maxpager = max/10;
			session.removeAttribute("pagerSmall");
		}else if(max == 0) {
			current_pager -= 1;
			session.setAttribute("current_pager", current_pager);
			session.setAttribute("count_pager", count_pager);
			session.removeAttribute("pagerSmall");
			session.removeAttribute("pagerBig");
		}
		session.setAttribute("count_maxpager",count_maxpager);




		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/student_list1.jsp");
		dispatcher.forward(request,response);



	}

}
