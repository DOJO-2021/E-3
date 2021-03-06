package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.All_Question;
import model.Table;

public class All_QuestionDao {


	//「FAQ画面（受講者）」質問と回答を表示→DB(select) OK
	public List<All_Question> select_faq(All_Question all_question, Table table) {
		Connection conn = null;
		List<All_Question> all_questionList = new ArrayList<All_Question>();

		//データベースへ接続
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SMSystem", "sa", "");

			// SELECT文を準備する
			String sql = "SELECT * FROM ALL_QUESTION WHERE GENRE = ? AND FAQ = '1' ORDER BY QUESTION_ID DESC LIMIT ?, 2";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			if (all_question.getGenre() != null && !all_question.getGenre().equals("")) {
				pStmt.setString(1, all_question.getGenre());
			}
			else {
				pStmt.setString(1, null);
			}

			pStmt.setInt(2, table.getRow());

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
				String answered = rs.getString("ANSWERED");
				All_Question All_Question = new All_Question(id, user_id, genre, question, answer, faq, emergent, question_id, answered);
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


	//「FAQ画面（受講者）」件数を表示→DB(select) OK
	public int select_count(All_Question all_question) {
		Connection conn = null;
		int count = 0;

		//データベースへ接続
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SMSystem", "sa", "");

			// SELECT文を準備する
			String sql = "SELECT COUNT(QUESTION_ID) FROM ALL_QUESTION WHERE GENRE = ? AND FAQ = '1'";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			if (all_question.getGenre() != null && !all_question.getGenre().equals("")) {
				pStmt.setString(1, all_question.getGenre());
			}
			else {
				pStmt.setString(1, null);
			}

			//SELECT文を実行
			ResultSet rs = pStmt.executeQuery();
			rs.next();
			count = rs.getInt("COUNT(QUESTION_ID)");

		}
		catch (SQLException e) {
			e.printStackTrace();
			count = (Integer) null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			count =(Integer) null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					count = (Integer) null;
				}
			}
		}

		return count;
	}


	//「FAQ編集画面（講師）」質問と回答を表示→DB(select)
		public List<All_Question> select_faqEdit(All_Question all_question, Table table) {
			Connection conn = null;
			List<All_Question> all_questionList = new ArrayList<All_Question>();

			//データベースへ接続
			try {
				Class.forName("org.h2.Driver");
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SMSystem", "sa", "");

				// SELECT文を準備する
				String sql = "SELECT * FROM ALL_QUESTION WHERE GENRE = ? AND FAQ = '1'  ORDER BY QUESTION_ID DESC LIMIT ?, 1";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				if (all_question.getGenre() != null && !all_question.getGenre().equals("")) {
					pStmt.setString(1, all_question.getGenre());
				}
				else {
					pStmt.setString(1, null);
				}

				pStmt.setInt(2, table.getRow());

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
					String answered = rs.getString("ANSWERED");
					All_Question All_Question = new All_Question(id, user_id, genre, question, answer, faq, emergent, question_id, answered);
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


	//「FAQ登録画面（講師）」講師がFAQを登録→DB（insert）OK
	public boolean insert_faq(All_Question all_question) {
		Connection conn = null;
		boolean result = false;

		//データベースへ接続
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SMSystem", "sa", "");
			//INSERT文を準備
			String sql = "INSERT INTO all_question VALUES (null,'',?,?,?,'1','',null,'1')";
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



	//「FAQ編集画面（講師）」FAQの内容を編集する→DB(update) OK
	public boolean update_faq(All_Question all_question) {
		Connection conn = null;
		boolean result = false;

		//データベースへ接続
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SMSystem", "sa", "");

			// UPDATE文を準備する
			String sql = "UPDATE ALL_QUESTION SET QUESTION =?, ANSWER = ? WHERE QUESTION_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			if (all_question.getQuestion() != null && !all_question.getQuestion().equals("")) {
				pStmt.setString(1, all_question.getQuestion());
			}
			else {
				pStmt.setString(1, null);
			}

			if (all_question.getAnswer() != null && !all_question.getAnswer().equals("")) {
				pStmt.setString(2, all_question.getAnswer());
			}
			else {
				pStmt.setString(2, null);
			}

			pStmt.setInt(3, all_question.getQuestion_id());


			/*
			String question_id = String.valueOf(all_question.getQuestion_id());
			if (question_id != null && !question_id.equals("")) {
				pStmt.setString(2, question_id);
			}
			else {
				pStmt.setString(2, null);
			}
			*/


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


	//「FAQ編集画面（講師）」削除→DB(delete) OK
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



	//「質問記入画面（受講者）」受講者が質問を記入→DB（insert） OK
	public boolean insert_question(All_Question all_question) {
		Connection conn = null;
		boolean result = false;

		//データベースへ接続
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SMSystem", "sa", "");
			//INSERT文を準備
			String sql = "INSERT INTO all_question VALUES (null,?,?,?,'','',?,null,'0')";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文

			if (all_question.getUser_id() != null && !all_question.getUser_id().equals("")) {
				pStmt.setString(1, all_question.getUser_id());
			}
			else {
				pStmt.setString(1, null);
			}

			if (all_question.getGenre() != null && !all_question.getGenre().equals("")) {
				pStmt.setString(2, all_question.getGenre());
			}
			else {
				pStmt.setString(2, null);
			}

			if (all_question.getQuestion() != null && !all_question.getQuestion().equals("")) {
				pStmt.setString(3, all_question.getQuestion());
			}
			else {
				pStmt.setString(3, null);
			}

			if (all_question.getEmergent() != null && !all_question.getEmergent().equals("")) {
				pStmt.setString(4, all_question.getEmergent());
			}
			else {
				pStmt.setString(4, null);
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

	//「質問回答記入画面（講師）」質問を表示→DB(select) OK
	public String select_question(All_Question all_question) {
		Connection conn = null;
		String s = "";

		//データベースへ接続
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SMSystem", "sa", "");

			// SELECT文を準備する
			String sql = "SELECT QUESTION FROM ALL_QUESTION WHERE QUESTION_ID = ? AND ANSWERED = '0'";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, all_question.getQuestion_id());


			//SELECT文を実行
			ResultSet rs = pStmt.executeQuery();

			//SELECT文の結果をArrayListに格納
			rs.next();
			String question = rs.getString("question");
			s = question;

		}
		catch (SQLException e) {
			e.printStackTrace();
			s = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			s = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					s = null;
				}
			}
		}

		return s;
	}



	//「質問回答記入画面（講師）」質問に対しての回答を更新→DB(update) OK
	public boolean update_question(All_Question all_question) {
		Connection conn = null;
		boolean result = false;

		//データベースへ接続
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SMSystem", "sa", "");

			// UPDATE文を準備する
			//String sql = "UPDATE ALL_QUESTION SET ANSWER = ?, FAQ = ?, ANSWERED = '1' WHERE QUESTION_ID = ? ";
			String sql = "UPDATE ALL_QUESTION SET ANSWER = ?, FAQ = ? , ANSWERED = '1' WHERE QUESTION = ? ";
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

			//pStmt.setInt(3, all_question.getQuestion_id());
			pStmt.setString(3, all_question.getQuestion());

			/*
			String question_id = String.valueOf(all_question.getQuestion_id());
			if (question_id != null && !question_id.equals("")) {
				pStmt.setString(2, question_id);
			}
			else {
				pStmt.setString(2, null);
			}
			*/


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




	//「質問回答(受講者)」表示→DB(select) OK
	public List<All_Question> select_questionUser_id(All_Question all_question, Table table) {
		Connection conn = null;
		List<All_Question> all_questionIdList = new ArrayList<All_Question>();

		//データベースへ接続
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SMSystem", "sa", "");

			// SELECT文を準備する
			String sql = "SELECT * FROM ALL_QUESTION WHERE USER_ID = ? ORDER BY QUESTION_ID DESC LIMIT ?, 1";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			if (all_question.getUser_id() != null && !all_question.getUser_id().equals("")) {
				pStmt.setString(1, all_question.getUser_id());
			}
			else {
				pStmt.setString(1, null);
			}

			pStmt.setInt(2, table.getRow());

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
				String answered = rs.getString("ANSWERED");
				All_Question All_Question = new All_Question(id, user_id, genre, question, answer, faq, emergent, question_id, answered);
				all_questionIdList.add(All_Question);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			all_questionIdList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			all_questionIdList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					all_questionIdList = null;
				}
			}
		}

		return all_questionIdList;
	}

	//「質問回答画面（受講者）」質問した回数を表示→DB(select) OK
		public int select_question_count(All_Question all_question) {
			Connection conn = null;
			int count = 0;

			//データベースへ接続
			try {
				Class.forName("org.h2.Driver");
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SMSystem", "sa", "");

				// SELECT文を準備する
				String sql = "SELECT COUNT(QUESTION_ID) FROM ALL_QUESTION WHERE USER_ID = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				if (all_question.getUser_id() != null && !all_question.getUser_id().equals("")) {
					pStmt.setString(1, all_question.getUser_id());
				}
				else {
					pStmt.setString(1, null);
				}

				//SELECT文を実行
				ResultSet rs = pStmt.executeQuery();
				rs.next();
				count = rs.getInt("COUNT(QUESTION_ID)");

			}
			catch (SQLException e) {
				e.printStackTrace();
				count = (Integer) null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				count =(Integer) null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						count = (Integer) null;
					}
				}
			}

			return count;
		}


}

