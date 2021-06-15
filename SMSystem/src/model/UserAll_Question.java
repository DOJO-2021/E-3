package model;
import java.io.Serializable;

public class UserAll_Question implements Serializable{

	//フィールド
	private String user_id;
	private String user_name;
	private String user_class;
	private String genre;
	private String question;
	private String emergent;
	private int question_id;

	//引数があるコンストラクタ
	public UserAll_Question(String user_id, String user_name, String user_class, String genre, String question, String emergent, int question_id) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_class = user_class;
		this.genre = genre;
		this.question = question;
		this.emergent = emergent;
		this.question_id = question_id;
	}

	//引数がないコンストラクタ（デフォルトコンストラクタ）
	public UserAll_Question() {
		super();
		this.user_id = "";
		this.user_name = "";
		this.user_class = "";
		this.genre = "";
		this.question = "";
		this.emergent = "";
		this.question_id = 0;
	}

	//getter/setter
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_class() {
		return user_class;
	}

	public void setUser_class(String user_class) {
		this.user_class = user_class;
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
