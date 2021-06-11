package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDao {

	//新規登録記入→DB(insert)
	public boolean insert(User user) {
		Connection conn = null;
		boolean result = false;

		//データベースへ接続
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SMSystem", "sa", "");
			//INSERT文を準備
			String sql = "INSERT INTO user VALUES (null,?,?,?,?,?,?,?,?)";
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

	//クラスを検索してプロフィールを表示→DB(select)
public List<User> select(User user) {
	Connection conn = null;
	List<User> studentList = new ArrayList<User>();

	//データベースへ接続
	try {
		Class.forName("org.h2.Driver");
		conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SMSystem", "sa", "");

		// SELECT文を準備する
		String sql = "SELECT * FROM USER  WHERE USER_CLASS = ? AND USER_ROLE = 0";
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
			String user_id = rs.getString("USER_ID");
			String user_pw = rs.getString("USER_PW");
			String user_name = rs.getString("USER_NAME");
			String user_name_kana = rs.getString("USER_NAME_KANA");
			String user_company = rs.getString("USER_COMPANY");
			String user_company_kana = rs.getString("USER_COMPANY_KANA");
			String user_class = rs.getString("USER_CLASS");
			String user_role = rs.getString("USER_ROLE");

			User student = new User(id, user_id, user_pw, user_name, user_name_kana, user_company, user_company_kana, user_class, user_role);
			studentList.add(student);
		}
	}
	catch (SQLException e) {
		e.printStackTrace();
		studentList = null;
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
		studentList = null;
	}
	finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				studentList = null;
			}
		}
	}

	return studentList;
}
}
