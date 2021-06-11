
package model;
import java.io.Serializable;

public class All_Question implements Serializable {

		//フィールド
		private int id;
		private String genre;
		private String question;
		private String answer;
		private String faq;
		private String emergent;
		private int question_id;
		private String user_name;

		//引数があるコンストラクタ
		public All_Question(int id, String genre, String question, String answer, String faq, String emergent,	int question_id, String user_name) {
			super();
			this.id = id;
			this.genre = genre;
			this.question = question;
			this.answer = answer;
			this.faq = faq;
			this.emergent = emergent;
			this.question_id = question_id;
			this.user_name = user_name;
		}

		//引数がないコンストラクタ（デフォルトコンストラクタ）
		public All_Question() {
			super();
			this.id = 0;
			this.genre = "";
			this.question = "";
			this.answer = "";
			this.faq = "";
			this.emergent = "";
			this.question_id = 0;
			this.user_name = "";
		}

		//getter/setter
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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

		public String getUser_name() {
			return user_name;
		}

		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}


}
