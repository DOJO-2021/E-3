
package model;
import java.io.Serializable;

public class All_Question implements Serializable {

		//フィールド
		private int id;
		private String user_id;
		private String genre;
		private String question;
		private String answer;
		private String faq;
		private String emergent;
		private int question_id;

		//引数があるコンストラクタ
		public All_Question(int id, String user_id, String genre, String question, String answer, String faq, String emergent,	int question_id) {
			super();
			this.id = id;
			this.user_id = user_id;
			this.genre = genre;
			this.question = question;
			this.answer = answer;
			this.faq = faq;
			this.emergent = emergent;
			this.question_id = question_id;
		}

		//引数がないコンストラクタ（デフォルトコンストラクタ）
		public All_Question() {
			super();
			this.id = 0;
			this.user_id = "";
			this.genre = "";
			this.question = "";
			this.answer = "";
			this.faq = "";
			this.emergent = "";
			this.question_id = 0;
		}

		//getter/setter
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUser_id() {
			return user_id;
		}

		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}


		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public String getQuestion() {
			return question;
		}

		public void setQuestion(String question) {
			this.question = question;
		}

		public String getAnswer() {
			return answer;
		}

		public void setAnswer(String answer) {
			this.answer = answer;
		}

		public String getFaq() {
			return faq;
		}

		public void setFaq(String faq) {
			this.faq = faq;
		}

		public String getEmergent() {
			return emergent;
		}

		public void setEmergent(String emergent) {
			this.emergent = emergent;
		}

		public int getQuestion_id() {
			return question_id;
		}

		public void setQuestion_id(int question_id) {
			this.question_id = question_id;
		}


}
