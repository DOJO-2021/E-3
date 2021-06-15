package test;
import java.util.List;

import dao.All_QuestionDao;
import model.All_Question;

public class All_QuestionDaoTest {
	public static void main(String[] args) {
		All_QuestionDao dao = new All_QuestionDao();

/*
	// 「FAQ画面（受講者）」select()のテスト
	//(id,"user_id","genre","question","answer","faq","emergent",question_id)
	System.out.println("---------- select()のテスト ----------");
	List<All_Question> all_questionFaq_selectList = dao.select_faq(new All_Question(0, "", "", "", "", "", "", 0));
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

	// 「FAQ画面（受講者）」件数カウント select()のテスト
	//(id,"user_id","genre","question","answer","faq","emergent",question_id)
	System.out.println("---------- select()のテスト ----------");
	List<All_Question> all_questionFaq_selectList = dao.select_faq(new All_Question(0, "", "", "", "", "", "", 0));
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

	// 「FAQ登録画面（講師）」insert()のテスト
	//(id,"user_id","genre","question","answer","faq","emergent",question_id)
	System.out.println("---------- insert()のテスト ----------");
	All_Question insertFaq = new All_Question(0, null, "T", "TEST", "TEST", "1", null,  0);
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

	// 「FAQ編集画面（講師）」update()のテスト
	//(id,"user_id","genre","question","answer","faq","emergent",question_id)
	System.out.println("---------- update()のテスト ----------");
	All_Question updateFaq = new All_Question(0, null, null, null, "TESTTEST", null, null, 0);
	if (dao.update_faq(updateFaq)) {
		System.out.println("更新成功！");
		List<All_Question> all_questionFaq_updateList = dao.select_faq(updateFaq);
		for (All_Question faq_update : all_questionFaq_updateList) {
			System.out.println("id：" + faq_update.getId());
			System.out.println("user_id：" + faq_update.getUser_id());
			System.out.println("genre：" + faq_update.getGenre());
			System.out.println("question：" + faq_update.getQuestion());
			System.out.println("answer：" + faq_update.getAnswer());
			System.out.println("faq：" + faq_update.getFaq());
			System.out.println("emergent：" + faq_update.getEmergent());
			System.out.println("question_id：" + faq_update.getQuestion_id());
			System.out.println();
		}
	}
	else {
		System.out.println("更新失敗！");
	}

/*
	// 「FAQ編集画面（講師）」delete()のテスト
	System.out.println("---------- delete()のテスト ----------");
	if (dao.delete_faq(0)) {
		System.out.println("削除成功！");
	}
	else {
		System.out.println("削除失敗！");
	}

*/


	// 「質問記入画面（受講者））」insert()のテスト
	//(id,"user_id","genre","question","answer","faq","emergent",question_id)
	System.out.println("---------- insert()のテスト ----------");
	All_Question insertQuestion = new All_Question(0, null, "T", "TEST", null, null, "T",  0);
	if (dao.insert_question(insertQuestion)) {
		System.out.println("登録成功！");
		List<All_Question> all_questionQuestion_insertList = dao.select_faq(insertQuestion);
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

	//挿入したコードのIDを取得する（この後で更新と削除をするため）
	//int questionId = dao.select_question(insertQuestion).get(0).getId();
/*

	//「質問回答記入画面（講師）」質問に対しての回答を更新→DB(update)
	//(id,"user_id","genre","question","answer","faq","emergent",question_id)
	System.out.println("---------- update()のテスト ----------");
	All_Question updateQuestion = new All_Question(0, null, null, null, "TEST", "TEST", null, 0);
	if (dao.update_question(updateQuestion)) {
		System.out.println("更新成功！");
		List<All_Question> all_questionQuestion_updateList = dao.select_faq(updateQuestion);
		for (All_Question faq_update : all_questionQuestion_updateList) {
			System.out.println("id：" + faq_update.getId());
			System.out.println("user_id：" + faq_update.getUser_id());
			System.out.println("genre：" + faq_update.getGenre());
			System.out.println("question：" + faq_update.getQuestion());
			System.out.println("answer：" + faq_update.getAnswer());
			System.out.println("faq：" + faq_update.getFaq());
			System.out.println("emergent：" + faq_update.getEmergent());
			System.out.println("question_id：" + faq_update.getQuestion_id());
			System.out.println();
		}
	}
	else {
		System.out.println("更新失敗！");
	}
*/



	}

}
