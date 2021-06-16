/**
 *
 */
document.getElementById('form').onsubmit = function(event) {
	const role = document.getElementById('form').user_role.value;
	const name = document.getElementById('form').user_name.value;
	const name_kana = document.getElementById('form').user_name_kana.value;
	const company = document.getElementById('form').user_company.value;
	const company_kana = document.getElementById('form').user_company_kana.value;
	const id = document.getElementById('form').user_id.value;
	const pw = document.getElementById('form').user_pw.value;
	const cla = document.getElementById('form').user_class.value;
	if (role === "") {
		event.preventDefault();
		document.getElementById('role_op').textContent = '受講者か講師のどちらかを選択してください';
	} else if(name === "" || name_kana === "" || company === "" || company_kana === "" || id === "" || pw === "" || cla === "") {
		event.preventDefault();
		document.getElementById('op').textContent = '全て記入してください'
	}
}
document.getElementById('role_op').style.color = 'red';
document.getElementById('op').style.color = 'red';