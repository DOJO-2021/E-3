package model;
import java.io.Serializable;

public class UserAll_Question implements Serializable{

	//フィールド
	private int user_id;
	private String user_name;
	private String user_class;
	private String genre;
	private String question;
	private String emergent;

	//引数があるコンストラクタ
	public UserAll_Question(int user_id, String user_name, String user_class, String genre, String question, String emergent) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_class = user_class;
		this.genre = genre;
		this.question = question;
		this.emergent = emergent;
	}

	//引数がないコンストラクタ（デフォルトコンストラクタ）
	public UserAll_Question() {
		super();
		this.user_id = 0;
		this.user_name = "";
		this.user_class = "";
		this.genre = "";
		this.question = "";
		this.emergent = "";
	}

	//getter/setter
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
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



}
