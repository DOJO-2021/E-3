package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.All_Question;
import model.User;

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
			String sql = "INSERT INTO profile (ID, GENRE, QUESTION, ANSWER, FAQ, EMERGENT, DATE, USER_NAME) VALUE (null,?,?,?,?,?,?,?)";
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

			if (all_question.getAnswer() != null && !all_question.getAnswer().equals("")) {
				pStmt.setString(3, all_question.getAnswer());
			}
			else {
				pStmt.setString(3, null);
			}

			if (all_question.getFaq() != null && !all_question.getFaq().equals("")) {
				pStmt.setString(4, all_question.getFaq());
			}
			else {
				pStmt.setString(4, null);
			}

			if (all_question.getEmergent() != null && !all_question.getEmergent().equals("")) {
				pStmt.setString(5, all_question.getEmergent());
			}
			else {
				pStmt.setString(5, null);
			}

			if (all_question.getDate() != null && !all_question.getDate().equals("")) {
				pStmt.setString(6, all_question.getDate());
			}
			else {
				pStmt.setString(6, null);
			}

			if (all_question.getUser_name() != null && !all_question.getUser_name().equals("")) {
				pStmt.setString(7, all_question.getUser_name());
			}
			else {
				pStmt.setString(7, null);
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


	//クラスを検索して緊急の質問を表示→DB(select)
	public List<All_Question> select_emergent(User user, All_Question all_question) {
		Connection conn = null;
		List<All_Question> all_questionList = new ArrayList<All_Question>();

		//データベースへ接続
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SMSystem", "sa", "");

			// SELECT文を準備する
			String sql = "SELECT GENRE, USER_NAME FROM ALL_QUESTION INNER JOIN USER ON ALL_QUESTION.ID=USER.ID WHERE USER_CLASS = ? AND emergent =0";
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
				String genre = rs.getString("GENRE");
				String question = rs.getString("QUESTION");
				String answer = rs.getString("ANSWER");
				String faq = rs.getString("FAQ");
				String emergent = rs.getString("EMERGENT");
				String date = rs.getString("DATE");
				String user_name = rs.getString("USER_NAME");
				All_Question all_Question = new All_Question(id, genre, question, answer, faq, emergent, date, user_name);
				all_questionList.add(all_Question);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			all_questionList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			all_questionList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					all_questionList = null;
				}
			}
		}

		return all_questionList;
	}


	//クラスを検索して緊急ではないの質問を表示→DB(select)
	public List<All_Question> select_not_emergent(User user, All_Question all_question) {
		Connection conn = null;
		List<All_Question> all_questionList = new ArrayList<All_Question>();

		//データベースへ接続
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SMSystem", "sa", "");

			// SELECT文を準備する
			String sql = "SELECT GENRE, USER_NAME FROM ALL_QUESTION INNER JOIN USER ON ALL_QUESTION.ID=USER.ID WHERE USER_CLASS = ? AND emergent =1";
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
				String genre = rs.getString("GENRE");
				String question = rs.getString("QUESTION");
				String answer = rs.getString("ANSWER");
				String faq = rs.getString("FAQ");
				String emergent = rs.getString("EMERGENT");
				String date = rs.getString("DATE");
				String user_name = rs.getString("USER_NAME");
				All_Question all_Question = new All_Question(id, genre, question, answer, faq, emergent, date, user_name);
				all_questionList.add(all_Question);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			all_questionList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			all_questionList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					all_questionList = null;
				}
			}
		}

		return all_questionList;
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
			String sql = "INSERT INTO ALL_QUESTION value (null, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

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
			if (all_question.getAnswer() != null && !all_question.getAnswer().equals("")) {
				pStmt.setString(3, all_question.getAnswer());
			}
			else {
				pStmt.setString(3, null);
			}
			if (all_question.getFaq() != null && !all_question.getFaq().equals("")) {
				pStmt.setString(4, all_question.getFaq());
			}
			else {
				pStmt.setString(4, null);
			}
			if (all_question.getEmergent() != null && !all_question.getEmergent().equals("")) {
				pStmt.setString(5, all_question.getEmergent());
			}
			else {
				pStmt.setString(5, null);
			}
			if (all_question.getDate() != null && !all_question.getDate().equals("")) {
				pStmt.setString(6, all_question.getDate());
			}
			else {
				pStmt.setString(6, null);
			}
			if (all_question.getUser_name() != null && !all_question.getUser_name().equals("")) {
				pStmt.setString(7, all_question.getUser_name());
			}
			else {
				pStmt.setString(7, null);
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
	public boolean delete(int id) {
		Connection conn = null;
		boolean result = false;

		//データベースへ接続
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SMSystem", "sa", "");

			// SQL文を準備する
			String sql = "delete from All_question where id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, id);

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

