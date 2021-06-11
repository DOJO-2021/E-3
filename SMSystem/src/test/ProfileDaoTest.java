package test;
import java.util.List;

import dao.ProfileDao;
import model.Profile;

public class ProfileDaoTest {
	public static void main(String[] args) {
		ProfileDao dao = new ProfileDao();
		// insert()のテスト
				System.out.println("---------- insert()のテスト ----------");
				Profile insRec = new Profile(0,"TEST", "TEST", "TEST", "TEST", "TEST", "TEST", "TEST");
				if (dao.insert(insRec)) {
					System.out.println("登録成功！");
					List<Profile> UserList2 = dao.select(insRec);
					for (Profile profile : UserList2) {
						System.out.println("id：" + profile.getId());
						System.out.println("user_name：" + profile.getUser_name());
						System.out.println("user_name_kana：" + profile.getUser_name_kana());
						System.out.println("user_blood：" + profile.getUser_blood());
						System.out.println("user_career：" + profile.getUser_career());
						System.out.println("user_club：" + profile.getUser_club());
						System.out.println("user_hobby：" + profile.getUser_hobby());
						System.out.println("user_intro：" + profile.getUser_intro());
						System.out.println();
					}
				}
				else {
					System.out.println("登録失敗！");
				}

	}
}
