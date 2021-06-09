package model;
import java.io.Serializable;

public class User implements Serializable{

	//フィールド
	private int id;
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_name_kana;
	private String user_company;
	private String user_company_kana;
	private String user_class;
	private String user_role;

	//引数があるコンストラクタ
	public User(int id, String user_id,String user_pw, String user_name, String user_name_kana,  String user_company,	String user_company_kana, String user_class, String user_role) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_name_kana = user_name_kana;
		this.user_company = user_company;
		this.user_company_kana = user_company_kana;
		this.user_class = user_class;
		this.user_role = user_role;
	}

	//引数がないコンストラクタ（デフォルトコンストラクタ）
	public User() {
		super();
		this.id = 0;
		this.user_id = "";
		this.user_pw = "";
		this.user_name = "";
		this.user_name_kana = "";
		this.user_company = "";
		this.user_company_kana = "";
		this.user_class = "";
		this.user_role = "";
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

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
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

	public String getUser_class() {
		return user_class;
	}

	public void setUser_class(String user_class) {
		this.user_class = user_class;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}



}
