package test;
import java.util.List;

import dao.All_QuestionDao;
import model.All_Question;

public class All_QuestionDaoTest {
	All_QuestionDao dao = new All_QuestionDao();

	// 「FAQ画面（受講者）」select()のテスト
	System.out.println("---------- select()のテスト ----------");
	List<All_Question> all_questionList2 = dao.select_faq(new All_Question(0, "", "", "", "", "", "", 0));
	for (All_Question faqselect : faq_selectList) {
		System.out.println("id：" + faqselect.getId());
		System.out.println("user_id: " + faqselect.getUser_id());
		System.out.println("genre：" + faqselect.getGenre());
		System.out.println("question：" + faqselect.getQuestion());
		System.out.println("answer：" + faqselect.getAnswer());
		System.out.println("faq：" + faqselect.getFaq());
		System.out.println("emergent：" + faqselect.getEmergent());
		System.out.println("question_id：" +faqselect.getQuestion_id());
		System.out.println();
	}

	// 「FAQ登録画面（講師）」insert()のテスト
	System.out.println("---------- insert()のテスト ----------");
	All_Question faq = new All_Question(0, null, "TEST", "TEST", null, null, "TEST",  0);
	if (dao.insert(insRec)) {
		System.out.println("登録成功！");

		List<All_Question> faq_insertList1 = dao.select_faq(faq);
		for (All_Question faq_insert : faq_insertList1) {
			System.out.println("question：" + faq_insert.getQuestion());
			System.out.println("answer：" + faq_insert.getAnswer());
			System.out.println();
		}

	}
	else {
		System.out.println("登録失敗！");
	}


	//挿入したコードのIDを取得する（この後で更新と削除をするため）
	int faqId = dao.select_faq(faq).get(0).getId();


	// 「FAQ編集画面（講師）」update()のテスト
	System.out.println("---------- update()のテスト ----------");
	All_Question upFaq = new All_Question(0, null, null, null, "TEST", null, null, faqId);
	if (dao.update_faq(upRec)) {
		System.out.println("更新成功！");
		List<All_Question> faq_updateList4 = dao.select_faq(upFaq);
		for (All_Question faq_update : faq_updateList4) {
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


	// 「FAQ編集画面（講師）」delete()のテスト
	System.out.println("---------- delete()のテスト ----------");
	if (dao.delete_faq(faqId)) {
		System.out.println("削除成功！");
	}
	else {
		System.out.println("削除失敗！");
	}






	// 「質問記入画面（受講者））」insert()のテスト
	System.out.println("---------- insert()のテスト ----------");
	All_Question question = new All_Question(0, null, "TEST", "TEST", null, null, "TEST",  0);
	if (dao.insert_question(insRec)) {
		System.out.println("登録成功！");
		List<All_Question> question_insertList1 = dao.select_faq(question);
		for (All_Question question_insert : question_insertList1) {
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
	int questionId = dao.select_faq(question).get(0).getId();

	// 「FAQ編集画面（講師）」update()のテスト
	System.out.println("---------- update()のテスト ----------");
	All_Question upQuestion = new All_Question(0, null, null, null, "TEST", "TEST", null, questionId);
	if (dao.update_faq(upRec)) {
		System.out.println("更新成功！");
		List<All_Question> faq_updateList4 = dao.select_faq(upQuestion);
		for (All_Question faq_update : faq_updateList4) {
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

	}

}
