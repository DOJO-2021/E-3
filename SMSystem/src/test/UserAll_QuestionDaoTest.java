package test;

import java.util.List;

import dao.UserAll_QuestionDao;
import model.UserAll_Question;

public class UserAll_QuestionDaoTest {
	public static void main(String[] args) {
		UserAll_QuestionDao dao = new UserAll_QuestionDao();

	//「質問一覧画面(講師)」クラスを検索して緊急の質問を表示→DB(select)
	//("user_id","user_name","user_class","genre","question","emergent")
	System.out.println("---------- select()のテスト ----------");
	List<UserAll_Question> userAll_questionEmergentList = dao.select_emergent(new UserAll_Question("", "", "E", "", "", "0", 0, ""));
	for (UserAll_Question userAll_question : userAll_questionEmergentList) {
		System.out.println("user_id：" + userAll_question.getUser_id());
		System.out.println("user_name：" + userAll_question.getUser_name());
		System.out.println("user_class：" + userAll_question.getUser_class());
		System.out.println("genre：" + userAll_question.getGenre());
		System.out.println("question：" + userAll_question.getQuestion());
		System.out.println("emergent：" + userAll_question.getEmergent());
		System.out.println("question_id：" + userAll_question.getQuestion_id());
		System.out.println("answered：" + userAll_question.getAnswered());
		System.out.println();
	}

	//「質問一覧画面（講師）」クラスを検索して緊急でない質問を表示→DB(select)
	//("user_id","user_name","user_class","genre","question","emergent")
	System.out.println("---------- select()のテスト ----------");
	List<UserAll_Question> userAll_questionNotEmergentList = dao.select_not_emergent(new UserAll_Question("", "", "E", "", "", "1", 0, ""));
	for (UserAll_Question userAll_question : userAll_questionNotEmergentList) {
		System.out.println("user_id：" + userAll_question.getUser_id());
		System.out.println("user_name：" + userAll_question.getUser_name());
		System.out.println("user_class：" + userAll_question.getUser_class());
		System.out.println("genre：" + userAll_question.getGenre());
		System.out.println("question：" + userAll_question.getQuestion());
		System.out.println("emergent：" + userAll_question.getEmergent());
		System.out.println("question_id：" + userAll_question.getQuestion_id());
		System.out.println("answered：" + userAll_question.getAnswered());
		System.out.println();
	}

}
}
