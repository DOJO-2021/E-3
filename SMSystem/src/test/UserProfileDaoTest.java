package test;

import java.util.List;

import dao.UserProfileDao;
import model.UserProfile;

public class UserProfileDaoTest {
	public static void main(String[] args) {
		UserProfileDao dao = new UserProfileDao();

	// //「プロフィール画面」user_idに該当するプロフィールを表示→DB(select)
	//("user_id","user_blood","user_career","user_club","user_hobby","user_intro","user_name","user_name_kana","user_company","user_company_kana")
	System.out.println("---------- select()のテスト ----------");
	List<UserProfile> userProfileList = dao.select_profile(new UserProfile("TEST", "", "", "", "", "", "", "", "", ""));
	for (UserProfile userProfile : userProfileList) {
		System.out.println("user_id：" + userProfile.getUser_id());
		System.out.println("user_blood：" + userProfile.getUser_blood());
		System.out.println("user_career：" + userProfile.getUser_career());
		System.out.println("user_club：" + userProfile.getUser_club());
		System.out.println("user_hobby：" + userProfile.getUser_hobby());
		System.out.println("user_intro：" + userProfile.getUser_intro());
		System.out.println("user_name：" + userProfile.getUser_name());
		System.out.println("user_name_kana：" + userProfile.getUser_name_kana());
		System.out.println("user_company：" + userProfile.getUser_company());
		System.out.println("user_company_kana：" + userProfile.getUser_company_kana());
		System.out.println();
	}
}}
