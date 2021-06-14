package test;

import java.util.List;

import model.UserProfile;
import dao.UserProfileDao;

public class UserProfileDaoTest {

	// select()のテスト(nameに名前を含んだデータを検索する)
	System.out.println("---------- select()のテスト ----------");
	List<UserProfile> userProfileList2 = dao.select_profile(new UserProfile("", "", "", "", "", "", "", "", "", ""));
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
