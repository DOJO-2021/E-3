package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.UserProfile;

public class UserProfileDao {

	//クラスを検索して緊急の質問を表示→DB(select)
	public List<UserProfile> select_profile(UserProfile userProfile) {
		Connection conn = null;
		List<UserProfile> userProfileList = new ArrayList<UserProfile>();

		//データベースへ接続
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SMSystem", "sa", "");

			// SELECT文を準備する
			String sql = "SELECT * FROM PROFILE INNER JOIN USER ON PROFILE.USER_ID = USER.USER_ID WHERE  USER_ID = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);



			//SELECT文を実行
			ResultSet rs = pStmt.executeQuery();

			//SELECT文の結果をArrayListに格納
			while(rs.next()){
				int id = rs.getInt("ID");
				String user_id = rs.getString("USER_ID");
				String user_blood = rs.getString("USER_BLOOD");
				String user_career = rs.getString("USER_CAREER");
				String user_club = rs.getString("USER_CLUB");
				String user_hobby = rs.getString("USER_HOBBY");
				String user_intro = rs.getString("USER_INTRO");
				String user_name = rs.getString("USER_NAME");
				String user_name_kana = rs.getString("USER_NAME_KANA");
				String user_company = rs.getString("USER_COMPANY");
				String user_company_kana = rs.getString("USER_COMPANY_KANA");
				UserProfile UserProfile = new UserProfile(id, user_id, user_blood, user_career, user_club, user_hobby, user_intro, user_name, user_name_kana, user_company, user_company_kana);
				userProfileList.add(UserProfile);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			userProfileList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			userProfileList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					userProfileList = null;
				}
			}
		}

		return userProfileList;
	}


}
