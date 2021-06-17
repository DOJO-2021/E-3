package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.UserAll_Question;

public class UserAll_QuestionDao {

	//「質問一覧画面(講師)」クラスを検索して緊急の質問を表示→DB(select)
	public List<UserAll_Question> select_emergent(UserAll_Question userAll_question) {
		Connection conn = null;
		List<UserAll_Question> userAll_questionEmergentList = new ArrayList<UserAll_Question>();

		//データベースへ接続
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SMSystem", "sa", "");

			// SELECT文を準備する
			String sql = "SELECT * FROM USER INNER JOIN ALL_QUESTION ON USER.USER_ID = ALL_QUESTION.USER_ID WHERE USER_CLASS = ? AND EMERGENT = '0' AND ANSWERED = '0' ORDER BY ALL_QUESTION.QUESTION_ID DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			if (userAll_question.getUser_class() != null && !userAll_question.getUser_class().equals("")) {
				pStmt.setString(1, userAll_question.getUser_class());
			}
			else {
				pStmt.setString(1, null);
			}

			//SELECT文を実行
			ResultSet rs = pStmt.executeQuery();

			//SELECT文の結果をArrayListに格納
			while(rs.next()){
				String user_id = rs.getString("USER_ID");
				String user_name = rs.getString("USER_NAME");
				String user_class = rs.getString("USER_CLASS");
				String genre = rs.getString("GENRE");
				String question = rs.getString("QUESTION");
				String emergent = rs.getString("EMERGENT");
				int question_id = rs.getInt("QUESTION_ID");
				String answered = rs.getString("ANSWERED");

				if(genre.equals("0")) {
					genre = "ドリル";
				}else if (genre.equals("1")) {
					genre = "HTML";
				}else if (genre.equals("2")) {
					genre = "CSS";
				}else if (genre.equals("3")) {
					genre = "JavaScript";
				}else if (genre.equals("4")){
						genre = "Java";
				}else if (genre.equals("5")) {
					genre = "データベース";
				}else if (genre.equals("6")) {
					genre = "サーブレット＆JSP";
				}else if (genre.equals("7")) {
					genre = "名刺管理アプリ";
				}else if (genre.equals("8")) {
					genre = "その他";
				}

				UserAll_Question UserAll_Question = new UserAll_Question(user_id, user_name, user_class, genre, question, emergent, question_id, answered);
				userAll_questionEmergentList.add(UserAll_Question);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			userAll_questionEmergentList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			userAll_questionEmergentList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					userAll_questionEmergentList = null;
				}
			}
		}

		return userAll_questionEmergentList;
	}

	//「質問一覧画面（講師）」クラスを検索して緊急でない質問を表示→DB(select)
		public List<UserAll_Question> select_not_emergent(UserAll_Question userAll_question) {
			Connection conn = null;
			List<UserAll_Question> userAll_questionNotEmergentList = new ArrayList<UserAll_Question>();

			//データベースへ接続
			try {
				Class.forName("org.h2.Driver");
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/SMSystem", "sa", "");

				// SELECT文を準備する
				String sql = "SELECT * FROM USER INNER JOIN ALL_QUESTION ON USER.USER_ID = ALL_QUESTION.USER_ID WHERE USER_CLASS = ? AND EMERGENT = '1' AND ANSWERED = '0' ORDER BY ALL_QUESTION.QUESTION_ID DESC";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				if (userAll_question.getUser_class() != null && !userAll_question.getUser_class().equals("")) {
					pStmt.setString(1, userAll_question.getUser_class());
				}
				else {
					pStmt.setString(1, null);
				}

				//SELECT文を実行
				ResultSet rs = pStmt.executeQuery();

				//SELECT文の結果をArrayListに格納
				while(rs.next()){
					String user_id = rs.getString("USER_ID");
					String user_name = rs.getString("USER_NAME");
					String user_class = rs.getString("USER_CLASS");
					String genre = rs.getString("GENRE");
					String question = rs.getString("QUESTION");
					String emergent = rs.getString("EMERGENT");
					int question_id = rs.getInt("QUESTION_ID");
					String answered = rs.getString("ANSWERED");

					if(genre.equals("0")) {
						genre = "ドリル";
					}else if (genre.equals("1")) {
						genre = "HTML";
					}else if (genre.equals("2")) {
						genre = "CSS";
					}else if (genre.equals("3")) {
						genre = "JavaScript";
					}else if (genre.equals("4")){
							genre = "Java";
					}else if (genre.equals("5")) {
						genre = "データベース";
					}else if (genre.equals("6")) {
						genre = "サーブレット＆JSP";
					}else if (genre.equals("7")) {
						genre = "名刺管理アプリ";
					}else if (genre.equals("8")) {
						genre = "その他";
					}

					UserAll_Question UserAll_Question = new UserAll_Question(user_id, user_name, user_class, genre, question, emergent, question_id, answered);
					userAll_questionNotEmergentList.add(UserAll_Question);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				userAll_questionNotEmergentList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				userAll_questionNotEmergentList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						userAll_questionNotEmergentList = null;
					}
				}
			}

			return userAll_questionNotEmergentList;
		}




}
