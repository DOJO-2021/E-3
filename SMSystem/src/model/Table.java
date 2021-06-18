package model;

public class Table {
	private int row;

	//引数があるコンストラクタ
		public Table(int row) {
			super();
			this.row = row;
		}

		//引数がないコンストラクタ（デフォルトコンストラクタ）
		public Table() {
			super();
			this.row = 0;
		}

		public int getRow() {
			return row;
		}

		public void setRow(int row) {
			this.row = row;
		}


}
