package test;
import java.util.List;

import dao.All_QuestionDao;
import model.All_Question;

public class All_QuestionDaoTest {
	public static void main(String[] args) {
		All_QuestionDao dao = new All_QuestionDao();


	// 「FAQ画面（受講者）」select()のテスト OK
	//(id,"user_id","genre","question","answer","faq","emergent",question_id)
	System.out.println("---「FAQ画面（受講者）」select()のテスト---");
	List<All_Question> all_questionFaq_selectList = dao.select_faq(new All_Question(0, "", "3", "", "", "1", "", 0));
	for (All_Question faq_select : all_questionFaq_selectList) {
		System.out.println("id：" + faq_select.getId());
		System.out.println("user_id: " + faq_select.getUser_id());
		System.out.println("genre：" + faq_select.getGenre());
		System.out.println("question：" + faq_select.getQuestion());
		System.out.println("answer：" + faq_select.getAnswer());
		System.out.println("faq：" + faq_select.getFaq());
		System.out.println("emergent：" + faq_select.getEmergent());
		System.out.println("question_id：" +faq_select.getQuestion_id());
		System.out.println();
	}

	// 「FAQ画面（受講者）」件数カウント select()のテスト OK
	//(id,"user_id","genre","question","answer","faq","emergent",question_id)
		System.out.println("---「FAQ画面（受講者）」件数カウント select()のテスト---");
		int count = dao.select_count(new All_Question(0, "", "3", "", "", "1", "", 0));
		System.out.println(count);


	// 「FAQ登録画面（講師）」insert()のテスト OK
	//(id,"user_id","genre","question","answer","faq","emergent",question_id)
	System.out.println("---「FAQ登録画面（講師）」insert()のテスト---");
	All_Question insertFaq = new All_Question(0, "", "", "", "ANSWERANSWER", "", "",  0);
	if (dao.insert_faq(insertFaq)) {
		System.out.println("登録成功！");

		List<All_Question> all_questionFaq_insertList = dao.select_faq(insertFaq);
		for (All_Question faq_insert : all_questionFaq_insertList) {
			System.out.println("question：" + faq_insert.getQuestion());
			System.out.println("answer：" + faq_insert.getAnswer());
			System.out.println();
		}

	}
	else {
		System.out.println("登録失敗！");
	}


	// 「FAQ編集画面（講師）」update()のテスト OK
	//(id,"user_id","genre","question","answer","faq","emergent",question_id)
	System.out.println("---「FAQ編集画面（講師）」update()のテスト---");
	All_Question updateFaq = new All_Question(3, "", "", "", "ANSWERANSWERANSWER", "", "", 3);
	if (dao.update_faq(updateFaq)) {
		System.out.println("更新成功！");
	}
	else {
		System.out.println("更新失敗！");
	}


	// 「FAQ編集画面（講師）」delete()のテスト OK
	System.out.println("---「FAQ編集画面（講師）」delete()のテスト---");
	if (dao.delete_faq(3)) {
		System.out.println("削除成功！");
	}
	else {
		System.out.println("削除失敗！");
	}


	// 「質問記入画面（受講者））」insert()のテスト OK
	//(id,"user_id","genre","question","answer","faq","emergent",question_id)
	System.out.println("---「質問記入画面（受講者））」insert()のテスト---");
	All_Question insertQuestion = new All_Question(0, "", "3", "QUESTION", "", "", "0",  0);
	if (dao.insert_question(insertQuestion)) {
		System.out.println("登録成功！");
		List<All_Question> all_questionQuestion_insertList = dao.select_question(insertQuestion);
		for (All_Question question_insert : all_questionQuestion_insertList) {
			System.out.println("id：" + question_insert.getId());
			System.out.println("user_id：" + question_insert.getUser_id());
			System.out.println("genre：" + question_insert.getGenre());
			System.out.println("question：" + question_insert.getQuestion());
			System.out.println("answer：" + question_insert.getAnswer());
			System.out.println("faq：" + question_insert.getFaq());
			System.out.println("emergent：" + question_insert.getEmergent());
			System.out.println("question_id：" + question_insert.getQuestion_id());
			System.out.println();
		}
	}
	else {
		System.out.println("登録失敗！");
	}


	//「質問回答記入画面（講師）」select()のテスト OK
	System.out.println("---「質問回答記入画面（講師）」select()のテスト---");
	List<All_Question> all_questionQuestion_selectList = dao.select_question(new All_Question(0, "", "", "", "", "", "", 0));
	for (All_Question question_select : all_questionQuestion_selectList) {
		System.out.println("id：" + question_select.getId());
		System.out.println("user_id: " + question_select.getUser_id());
		System.out.println("genre：" + question_select.getGenre());
		System.out.println("question：" + question_select.getQuestion());
		System.out.println("answer：" + question_select.getAnswer());
		System.out.println("faq：" + question_select.getFaq());
		System.out.println("emergent：" + question_select.getEmergent());
		System.out.println("question_id：" + question_select.getQuestion_id());
		System.out.println();
	}


	//「質問回答記入画面（講師）」update()のテスト OK
	//(id,"user_id","genre","question","answer","faq","emergent",question_id)
	System.out.println("---「質問回答記入画面（講師）」update()のテスト---");
	All_Question updateQuestion = new All_Question(0, "", "", "", "ANSWER", "1", "", 0);
	if (dao.update_question(updateQuestion)) {
		System.out.println("更新成功！");
	}
	else {
		System.out.println("更新失敗！");
	}


	// 「」select()のテスト OK
	//(id,"user_id","genre","question","answer","faq","emergent",question_id)
	System.out.println("---「」select()のテスト---");
	List<All_Question> all_questionIdList = dao.select_questionUser_id(new All_Question(0, "a", "", "", "", "", "", 0));
	for (All_Question questionId_select : all_questionIdList) {
		System.out.println("id：" + questionId_select.getId());
		System.out.println("user_id: " + questionId_select.getUser_id());
		System.out.println("genre：" + questionId_select.getGenre());
		System.out.println("question：" + questionId_select.getQuestion());
		System.out.println("answer：" + questionId_select.getAnswer());
		System.out.println("faq：" + questionId_select.getFaq());
		System.out.println("emergent：" +questionId_select.getEmergent());
		System.out.println("question_id：" +questionId_select.getQuestion_id());
		System.out.println();
	}

	}

}
