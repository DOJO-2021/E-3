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
		request.setCharacterEncoding("UTF-8");
		String ganre = request.getParameter("ganre");


		All_QuestionDao ADao = new All_QuestionDao();
		All_Question aQ = new All_Question(0,"",ganre,"","","","",0);
		List<All_Question> faqList = ADao.select_faq(aQ);
		int count = ADao.select_count(aQ);
		request.setAttribute("count", count);
		request.setAttribute("faqList", faqList);

		if(ganre.equals("0")) {
			ganre = "ドリル";
		}else if (ganre.equals("1")) {
			ganre = "HTML";
		}else if (ganre.equals("2")) {
			ganre = "CSS";
		}else if (ganre.equals("3")) {
			ganre = "JavaScript";
		}else if (ganre.equals("4")){
				ganre = "Java";
		}else if (ganre.equals("5")) {
			ganre = "データベース";
		}else if (ganre.equals("6")) {
			ganre = "サーブレット＆JSP";
		}else if (ganre.equals("7")) {
			ganre = "名刺管理アプリ";
		}else if (ganre.equals("8")) {
			ganre = "その他";
		}

		request.setAttribute("ganre", ganre);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/faq_delete_update.jsp");
		dispatcher.forward(request,response);
	}

}
