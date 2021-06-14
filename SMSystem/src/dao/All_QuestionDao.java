package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.All_Question;

public class All_QuestionDao {

	//受講者が質問を記入→DB（insert）
	public boolean insert(All_Question all_question) {
		Connection conn = null;
		boolean result = false;

		//データベースへ接続
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SMSystem", "sa", "");
			//INSERT文を準備
			String sql = "INSERT INTO all_question VALUES (null,?,?,?,null)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文

			if (all_question.getGenre() != null && !all_question.getGenre().equals("")) {
				pStmt.setString(1, all_question.getGenre());
			}
			else {
				pStmt.setString(1, null);
			}

			if (all_question.getQuestion() != null && !all_question.getQuestion().equals("")) {
				pStmt.setString(2, all_question.getQuestion());
			}
			else {
				pStmt.setString(2, null);
			}

			if (all_question.getEmergent() != null && !all_question.getEmergent().equals("")) {
				pStmt.setString(3, all_question.getEmergent());
			}
			else {
				pStmt.setString(3, null);
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



	//質問に対しての回答を更新→DB(update)
	public boolean update(All_Question all_question) {
		Connection conn = null;
		boolean result = false;

		//データベースへ接続
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SMSystem", "sa", "");

			// UPDATE文を準備する
			String sql = "UPDATE ALL_QUESTION SET ANSWER = ?, FAQ = ? WHERE QUESTION_ID = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			if (all_question.getAnswer() != null && !all_question.getAnswer().equals("")) {
				pStmt.setString(1, all_question.getAnswer());
			}
			else {
				pStmt.setString(1, null);
			}
			if (all_question.getFaq() != null && !all_question.getFaq().equals("")) {
				pStmt.setString(2, all_question.getFaq());
			}
			else {
				pStmt.setString(2, null);
			}


			//UPDATE文を実行
			if (pStmt.executeUpdate() == 1) {
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


	//FAQ編集画面での削除→DB(update)
	public boolean delete(int question_id) {
		Connection conn = null;
		boolean result = false;

		//データベースへ接続
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SMSystem", "sa", "");

			// SQL文を準備する
			String sql = "DELETE FROM all_question WHERE QUESTION_ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, question_id);

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
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

		// 結果を返す
		return result;
	}
}

