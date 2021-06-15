package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.All_Question;

public class All_QuestionDao {


	//「FAQ画面（受講者）」質問と回答を表示→DB(select)
	public List<All_Question> select_faq(All_Question all_question) {
		Connection conn = null;
		List<All_Question> all_questionList = new ArrayList<All_Question>();

		//データベースへ接続
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SMSystem", "sa", "");

			// SELECT文を準備する
			String sql = "SELECT * FROM ALL_QUESTION WHERE GENRE = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			if (all_question.getGenre() != null && !all_question.getGenre().equals("")) {
				pStmt.setString(1, all_question.getEmergent());
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
				String genre = rs.getString("GENRE");
				String question = rs.getString("QUESTION");
				String answer = rs.getString("ANSWER");
				String faq = rs.getString("FAQ");
				String emergent = rs.getString("EMERGENT");
				int question_id = rs.getInt("QUESTION_ID");
				All_Question All_Question = new All_Question(id, user_id, genre, question, answer, faq, emergent, question_id);
				all_questionList.add(All_Question);
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



	//「FAQ画面（受講者）」件数を表示→DB(select)
	public List<All_Question> select_count(All_Question all_question) {
		Connection conn = null;
		List<All_Question> all_questionList = new ArrayList<All_Question>();

		//データベースへ接続
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SMSystem", "sa", "");

			// SELECT文を準備する
			String sql = "SELECT COUNT(QUESTION_ID) FROM ALL_QUESTION WHERE GENRE = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			if (all_question.getGenre() != null && !all_question.getGenre().equals("")) {
				pStmt.setString(1, all_question.getEmergent());
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
				String genre = rs.getString("GENRE");
				String question = rs.getString("QUESTION");
				String answer = rs.getString("ANSWER");
				String faq = rs.getString("FAQ");
				String emergent = rs.getString("EMERGENT");
				int question_id = rs.getInt("QUESTION_ID");
				All_Question All_Question = new All_Question(id, user_id, genre, question, answer, faq, emergent, question_id);
				all_questionList.add(All_Question);
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

	//「FAQ登録画面（講師）」講師がFAQを登録→DB（insert）
	public boolean insert_faq(All_Question all_question) {
		Connection conn = null;
		boolean result = false;

		//データベースへ接続
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SMSystem", "sa", "");
			//INSERT文を準備
			String sql = "INSERT INTO all_question VALUES (0,'',?,?,?,'1','',0)";
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



	//「FAQ編集画面（講師）」FAQの内容を編集する→DB(update)
	public boolean update_faq(All_Question all_question) {
		Connection conn = null;
		boolean result = false;

		//データベースへ接続
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SMSystem", "sa", "");

			// UPDATE文を準備する
			String sql = "UPDATE ALL_QUESTION SET ANSWER = ? WHERE QUESTION_ID = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			if (all_question.getAnswer() != null && !all_question.getAnswer().equals("")) {
				pStmt.setString(1, all_question.getAnswer());
			}
			else {
				pStmt.setString(1, null);
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


	//「FAQ編集画面（講師）」削除→DB(delete)
	public boolean delete_faq(int question_id) {
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



	//「質問記入画面（受講者）」受講者が質問を記入→DB（insert）
	public boolean insert_question(All_Question all_question) {
		Connection conn = null;
		boolean result = false;

		//データベースへ接続
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SMSystem", "sa", "");
			//INSERT文を準備
			String sql = "INSERT INTO all_question VALUES (0,'',?,?,'','',?,0)";
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



	//「質問回答記入画面（講師）」質問に対しての回答を更新→DB(update)
	public boolean update_question(All_Question all_question) {
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



}

