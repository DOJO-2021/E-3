package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Profile;

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








}