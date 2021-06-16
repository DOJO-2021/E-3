package test;
import java.util.List;

import dao.UserDao;
import model.User;

public class UserDaoTest {
	public static void main(String[] args) {
		UserDao dao = new UserDao();
		//「新規登録画面」新規登録記入→DB(insert)
		//(id,"user_id","user_pw","user_name","user_name_kana","user_company","user_company_kana","user_class","user_role")
		System.out.println("---------- insert()のテスト ----------");
		User insRec = new User(0,"TESTTEST", "TESTTEST", "TEST", "TEST", "TEST", "TEST", "E", "1");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			List<User> user_insertList = dao.select(insRec);
			for (User user : user_insertList) {
				System.out.println("id：" + user.getId());
				System.out.println("user_id：" + user.getUser_id());
				System.out.println("user_pw：" + user.getUser_pw());
				System.out.println("user_name：" + user.getUser_name());
				System.out.println("user_name_kana：" + user.getUser_name_kana());
				System.out.println("user_company：" + user.getUser_company());
				System.out.println("user_company_kana：" + user.getUser_company_kana());
				System.out.println("user_class：" + user.getUser_class());
				System.out.println("user_role：" + user.getUser_role());
				System.out.println();
			}
		}
		else {
			System.out.println("登録失敗！");
		}

		//「メニュー画面（受講者）（講師）」クラスを検索してプロフィールを表示→DB(select)
		//(id,"user_id","user_pw","user_name","user_name_kana","user_company","user_company_kana","user_class","user_role")
		System.out.println("---------- select()のテスト ----------");
		List<User> user_selectList = dao.select(new User(0,"", "", "", "", "", "", "E", "1"));
		for (User user : user_selectList) {
			System.out.println("id：" + user.getId());
			System.out.println("user_id：" + user.getUser_id());
			System.out.println("user_pw：" + user.getUser_pw());
			System.out.println("user_name：" + user.getUser_name());
			System.out.println("user_name_kana：" + user.getUser_name_kana());
			System.out.println("user_company：" + user.getUser_company());
			System.out.println("user_company_kana：" + user.getUser_company_kana());
			System.out.println("user_class：" + user.getUser_class());
			System.out.println("user_role：" + user.getUser_role());
			System.out.println();
		}

		// 「メニュー画面（受講者）（講師）」件数カウント select()のテスト
		//(id,"user_id","genre","question","answer","faq","emergent",question_id)
		System.out.println("---------- select()のテスト ----------");
		int count = dao.select_count(new User(0, "", "", "", "", "", "", "E", "1"));
		System.out.println(count);


}}
