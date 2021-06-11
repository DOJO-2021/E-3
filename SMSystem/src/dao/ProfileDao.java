package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Profile;
import model.User;

public class ProfileDao {

	//profile記入→DB（insert）
	public boolean insert(Profile profile) {
		Connection conn = null;
		boolean result = false;

		//データベースへ接続
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SMSystem", "sa", "");
			//INSERT文を準備
			String sql = "INSERT INTO profile VALUES (null,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文
			if (profile.getUser_name() != null && !profile.getUser_name().equals("")) {
				pStmt.setString(1, profile.getUser_name());
			}
			else {
				pStmt.setString(1, null);
			}

			if (profile.getUser_name_kana() != null && !profile.getUser_name_kana().equals("")) {
				pStmt.setString(2, profile.getUser_name_kana());
			}
			else {
				pStmt.setString(2, null);
			}

			if (profile.getUser_blood() != null && !profile.getUser_blood().equals("")) {
				pStmt.setString(3, profile.getUser_blood());
			}
			else {
				pStmt.setString(3, null);
			}

			if (profile.getUser_company() != null && !profile.getUser_company().equals("")) {
				pStmt.setString(4, profile.getUser_company());
			}
			else {
				pStmt.setString(4, null);
			}

			if (profile.getUser_company_kana() != null && !profile.getUser_company_kana().equals("")) {
				pStmt.setString(5, profile.getUser_company_kana());
			}
			else {
				pStmt.setString(5, null);
			}

			if (profile.getUser_career() != null && !profile.getUser_career().equals("")) {
				pStmt.setString(6, profile.getUser_career());
			}
			else {
				pStmt.setString(6, null);
			}

			if (profile.getUser_club() != null && !profile.getUser_club().equals("")) {
				pStmt.setString(7, profile.getUser_club());
			}
			else {
				pStmt.setString(7, null);
			}

			if (profile.getUser_hobby() != null && !profile.getUser_hobby().equals("")) {
				pStmt.setString(8, profile.getUser_hobby());
			}
			else {
				pStmt.setString(8, null);
			}

			if (profile.getUser_intro() != null && !profile.getUser_intro().equals("")) {
				pStmt.setString(9, profile.getUser_intro());
			}
			else {
				pStmt.setString(9, null);
			}


			//INSERT文を実行（resultには追加された行数が代入される）
			if(pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}



	//クラスを検索してプロフィールを表示→DB(select)
		public List<Profile> select(User user) {
			Connection conn = null;
			List<Profile> profileList = new ArrayList<Profile>();

			//データベースへ接続
			try {
				Class.forName("org.h2.Driver");
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SMSystem", "sa", "");

				// SELECT文を準備する
				String sql = "SELECT USER_NAME, USER_NAME_KANA, USER_COMPANY FROM PROFILE INNER JOIN USER ON PROFILE.ID=USER.ID WHERE USER_CLASS = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				if (user.getUser_class() != null && !user.getUser_class().equals("")) {
					pStmt.setString(1, user.getUser_class());
				}
				else {
					pStmt.setString(1, null);
				}

				//SELECT文を実行
				ResultSet rs = pStmt.executeQuery();

				//SELECT文の結果をArrayListに格納
				while(rs.next()){
					int id = rs.getInt("ID");
					String user_name = rs.getString("USER_NAME");
					String user_name_kana = rs.getString("USER_NAMA_KANA");
					String user_blood = rs.getString("USER_BLOOD");
					String user_company = rs.getString("USER_COMPANY");
					String user_company_kana = rs.getString("USER_COMPANY_KANA");
					String user_career = rs.getString("USER_CAREER");
					String user_club = rs.getString("USER_CLUB");
					String user_hobby = rs.getString("USER_HOBBY");
					String user_intro = rs.getString("USER_INTRO");
					Profile profile = new Profile(id, user_name, user_name_kana, user_blood, user_company, user_company_kana, user_career, user_club, user_hobby, user_intro);
					profileList.add(profile);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				profileList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				profileList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						profileList = null;
					}
				}
			}

			return profileList;
		}



}