package model;
import java.io.Serializable;

public class Profile implements Serializable {

	//フィールド
	private int id;
	private int user_id;
	private String user_blood;
	private String user_career;
	private String user_club;
	private String user_hobby;
	private String user_intro;

	//引数があるコンストラクタ
	public Profile(int id, int user_id, String user_blood, String user_career, String user_club, String user_hobby, String user_intro) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.user_blood = user_blood;
		this.user_career = user_career;
		this.user_club = user_club;
		this.user_hobby = user_hobby;
		this.user_intro = user_intro;
	}

	//引数がないコンストラクタ（デフォルトコンストラクタ）
	public Profile() {
		super();
		this.id = 0;
		this.user_id = 0;
		this.user_blood = "";
		this.user_career = "";
		this.user_club = "";
		this.user_hobby = "";
		this.user_intro = "";
	}

	//getter/setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_blood() {
		return user_blood;
	}

	public void setUser_blood(String user_blood) {
		this.user_blood = user_blood;
	}

	public String getUser_career() {
		return user_career;
	}

	public void setUser_career(String user_career) {
		this.user_career = user_career;
	}

	public String getUser_club() {
		return user_club;
	}

	public void setUser_club(String user_club) {
		this.user_club = user_club;
	}

	public String getUser_hobby() {
		return user_hobby;
	}

	public void setUser_hobby(String user_hobby) {
		this.user_hobby = user_hobby;
	}

	public String getUser_intro() {
		return user_intro;
	}

	public void setUser_intro(String user_intro) {
		this.user_intro = user_intro;
	}


}
