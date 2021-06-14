package test;

import java.util.List;

import model.All_Question;

public class UserAll_QuestionTest {

	// select()のテスト(nameに名前を含んだデータを検索する)
	SystemS.out.println("---------- select()のテスト ----------");
	List<All_Question> all_questionList2 = dao.select(new All_Question(0, "", "", "", "", "", insId, ""));
	for (All_Question all_question : all_questionList) {
		System.out.println("id：" + all_question.getId());
		System.out.println("genre：" + all_question.getGenre());
		System.out.println("question：" + all_question.getQuestion());
		System.out.println("answer：" + all_question.getAnswer());
		System.out.println("faq：" + all_question.getFaq());
		System.out.println("emergent：" + all_question.getEmergent());
		System.out.println("question_id：" + all_question.getQuestion_id());
		System.out.println("user_name：" + all_question.getUser_name());
		System.out.println();
	}

// select()のテスト(nameに名前を含んだデータを検索する)
		SystemS.out.println("---------- select()のテスト ----------");
		List<All_Question> all_questionList3 = dao.select(new All_Question(0,"", "", "", "", "", insId, ""));
		for (All_Question all_question : all_questionList) {
			System.out.println("id：" + all_question.getId());
			System.out.println("genre：" + all_question.getGenre());
			System.out.println("question：" + all_question.getQuestion());
			System.out.println("answer：" + all_question.getAnswer());
			System.out.println("faq：" + all_question.getFaq());
			System.out.println("emergent：" + all_question.getEmergent());
			System.out.println("question_id：" + all_question.getQuestion_id());
			System.out.println("user_name：" + all_question.getUser_name());
			System.out.println();
		}


}
