package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;

public class UserDao {

	//新規登録記入→DB(insert)
	public boolean insert(User user) {
		Connection conn = null;
		boolean result = false;

		//データベースへ接続
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");
			//INSERT文を準備
			String sql = "INSERT INTO user ( ID, USER_ID, USER_PW, USER_NAME, USER_NAME_KANA, USER_COMPANY, USER_COMPANY_KANA, USER_CLASS, USER_ROLE) VALUE (null,?,?,?,?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文
			if (user.getUser_id() != null && !user.getUser_id().equals("")) {
				pStmt.setString(1, user.getUser_id());
			}
			else {
				pStmt.setString(1, null);
			}

			if (user.getUser_pw() != null && !user.getUser_pw().equals("")) {
				pStmt.setString(2, user.getUser_pw());
			}
			else {
				pStmt.setString(2, null);
			}

			if (user.getUser_name() != null && !user.getUser_name().equals("")) {
				pStmt.setString(3, user.getUser_name());
			}
			else {
				pStmt.setString(3, null);
			}

			if (user.getUser_name_kana() != null && !user.getUser_name_kana().equals("")) {
				pStmt.setString(4, user.getUser_name_kana());
			}
			else {
				pStmt.setString(4, null);
			}

			if (user.getUser_company() != null && !user.getUser_company().equals("")) {
				pStmt.setString(5, user.getUser_company());
			}
			else {
				pStmt.setString(5, null);
			}

			if (user.getUser_company_kana() != null && !user.getUser_company_kana().equals("")) {
				pStmt.setString(6, user.getUser_company_kana());
			}
			else {
				pStmt.setString(6, null);
			}

			if (user.getUser_class() != null && !user.getUser_class().equals("")) {
				pStmt.setString(7, user.getUser_class());
			}
			else {
				pStmt.setString(7, null);
			}

			if (user.getUser_role() != null && !user.getUser_role().equals("")) {
				pStmt.setString(8, user.getUser_role());
			}
			else {
				pStmt.setString(8, null);
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
