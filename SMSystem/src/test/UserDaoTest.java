package test;
import java.util.List;

import dao.UserDao;
import model.User;

public class UserDaoTest {
	public static void main(String[] args) {
		UserDao dao = new UserDao();
		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		User insRec = new User(0,"TEST", "TEST", "TEST", "TEST", "TEST", "TEST", "E", "0");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			List<User> UserList2 = dao.select(insRec);
			for (User user : UserList2) {
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

		// select()のテスト(nameに名前を含んだデータを検索する)
		System.out.println("---------- select()のテスト ----------");
		List<User> cardList2 = dao.select(new User(0,"", "", "", "", "", "", "E", "0"));
		for (User user : cardList2) {
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





}}
