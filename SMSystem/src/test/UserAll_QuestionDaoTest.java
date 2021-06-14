package test;

import java.util.List;

import model.UserAll_Question;
import dao.UserAll_QuestionDao;

public class UserAll_QuestionDaoTest {

	// 「FAQ画面（受講者）」select()のテスト
	System.out.println("---------- select()のテスト ----------");
	List<UserAll_Question> userAll_questionList = dao.select_faq(new UserAll_Question("", "", "", "TEST", "", ""));
	for (UserAll_Question userAll_question : all_questionList) {
		System.out.println("user_id：" + userAll_question.getUser_id());
		System.out.println("user_name：" + userAll_question.getUser_name());
		System.out.println("user_class：" + userAll_question.getUser_class());
		System.out.println("genre：" + userAll_question.getGenre());
		System.out.println("question：" + userAll_question.getQuestion());
		System.out.println("emergent：" + userAll_question.getEmergent());
		System.out.println();
	}


}
