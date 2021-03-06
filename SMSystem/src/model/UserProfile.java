package model;
import java.io.Serializable;

public class UserProfile implements Serializable{

	//フィールド
	private String user_id;
	private String user_blood;
	private String user_career;
	private String user_club;
	private String user_hobby;
	private String user_intro;
	private String user_name;
	private String user_name_kana;
	private String user_company;
	private String user_company_kana;

	//引数があるコンストラクタ
	public UserProfile(String user_id, String user_blood, String user_career, String user_club, String user_hobby, String user_intro, String user_name, String user_name_kana, String user_company, String user_company_kana) {
		super();
		this.user_id = user_id;
		this.user_blood = user_blood;
		this.user_career = user_career;
		this.user_club = user_club;
		this.user_hobby = user_hobby;
		this.user_intro = user_intro;
		this.user_name = user_name;
		this.user_name_kana = user_name_kana;
		this.user_company = user_company;
		this.user_company_kana = user_company_kana;
	}

	//引数がないコンストラクタ（デフォルトコンストラクタ）
	public UserProfile() {
		super();
		this.user_id = "";
		this.user_blood = "";
		this.user_career = "";
		this.user_club = "";
		this.user_hobby = "";
		this.user_intro = "";
		this.user_name = "";
		this.user_name_kana = "";
		this.user_company = "";
		this.user_company_kana = "";
	}

	//getter/setter
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
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

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_name_kana() {
		return user_name_kana;
	}

	public void setUser_name_kana(String user_name_kana) {
		this.user_name_kana = user_name_kana;
	}

	public String getUser_company() {
		return user_company;
	}

	public void setUser_company(String user_company) {
		this.user_company = user_company;
	}

	public String getUser_company_kana() {
		return user_company_kana;
	}

	public void setUser_company_kana(String user_company_kana) {
		this.user_company_kana = user_company_kana;
	}



}
