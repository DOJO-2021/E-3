package test;
import java.util.List;

import dao.All_QuestionDao;
import model.All_Question;

public class All_QuestionDaoTest {
	All_QuestionDao dao = new All_QuestionDao();

	// insert()のテスト
	System.out.println("---------- insert()のテスト ----------");
	All_Question insRec = new All_Question(0,"TEST", "TEST", "TEST", "TEST", null, 0, null);
	if (dao.insert(insRec)) {
		System.out.println("登録成功！");

		List<All_Question> all_questionList1 = dao.select(insRec);
		for (All_Question all_question : all_questionList1) {
			System.out.println("id：" + all_question.getId());
			System.out.println("user_name：" + all_question.getUser_name());
			System.out.println("genre：" + all_question.getGenre());
			System.out.println("question：" + all_question.getQuestion());
			System.out.println("emergent：" + all_question.getEmergent());
			System.out.println("question_id：" + all_question.getQuestion_id());
			System.out.println();
		}

	}
	else {
		System.out.println("登録失敗！");
	}


	//挿入したコードのIDを取得する（この後で更新と削除をするため）
	int insId = dao.select(insRec).get(5).getQuestion_id();


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



	// update()のテスト
			System.out.println("---------- update()のテスト ----------");
				All_Question upRec = new All_Question("TEST", "TEST",null, null, null, insId, null);
				if (dao.update(upRec)) {
					System.out.println("更新成功！");
					List<All_Question> all_questionList4 = dao.select(upRec);
					for (All_Question all_question : all_questionList4) {
						System.out.println("answer：" + all_question.getAnswer());
						System.out.println("faq：" + all_question.getFaq());
						System.out.println("question_id：" + all_question.getQuestion_id());
						System.out.println();
					}
				}
				else {
					System.out.println("更新失敗！");
				}


	// delete()のテスト
				System.out.println("---------- delete()のテスト ----------");
				if (dao.delete(insId)) {
					System.out.println("削除成功！");
				}
				else {
					System.out.println("削除失敗！");
				}
	}

}
