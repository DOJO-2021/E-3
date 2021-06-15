package test;
import dao.ProfileDao;
import model.Profile;

public class ProfileDaoTest {
	public static void main(String[] args) {
		ProfileDao dao = new ProfileDao();
		//「初回プロフィール入力画面」profile記入→DB（insert）
		//("user_id","user_blood","user_career","user_club","user_hobby","user_intro")
				System.out.println("---------- insert()のテスト ----------");
				Profile insRec = new Profile("TEST", "TEST", "TEST", "TEST", "TEST", "TEST");
				if (dao.insert(insRec)) {
					System.out.println("登録成功！");
				}
				else {
					System.out.println("登録失敗！");
				}
	}
}
