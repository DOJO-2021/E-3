package test;
import dao.LoginDao;


public class LoginDaoTest {
	public static void main(String[] args) {
		testIsLoginOK1();	// ユーザーが見つかる場合のテスト
		testIsLoginOK2();	// ユーザーが見つからない場合のテスト
	}

	//「ログイン画面」IDPW記入→DB(select) ユーザーが見つかるテスト
	//("user_id","user_pw","user_role")
	public static void testIsLoginOK1() {
		LoginDao dao = new LoginDao();
		if (dao.isLoginOK("YONEDA", "YONEDA","1")) {
			System.out.println("testIsLoginOK1：テストが成功しました");
		}
		else {
			System.out.println("testIsLoginOK1：テストが失敗しました");
		}
	}

	// 「ログイン画面」IDPW記入→DB(select) ユーザーが見つからないテスト
	//("user_id","user_pw","user_role")
	public static void testIsLoginOK2() {
		LoginDao dao = new LoginDao();
		if (!dao.isLoginOK("DOJO", "pass","1")) {
			System.out.println("testIsLoginOK2：テストが成功しました");
		}
		else {
			System.out.println("testIsLoginOK2：テストが失敗しました");
		}
	}
}

