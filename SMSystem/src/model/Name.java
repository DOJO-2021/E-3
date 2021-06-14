package model;
import java.io.Serializable;

public class Name implements Serializable{

	//フィールド
	private String user_name;
	private String user_name_kana;

	//引数があるコンストラクタ
	public Name( String user_name, String user_name_kana) {
		super();
		this.user_name = user_name;
		this.user_name_kana = user_name_kana;
	}

	//引数がないコンストラクタ（デフォルトコンストラクタ）
	public Name() {
		super();
		this.user_name = "";
		this.user_name_kana = "";
	}

	//getter/setter
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

}
