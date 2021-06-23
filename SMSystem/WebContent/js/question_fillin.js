/**
 *
 */
document.getElementById('form').onsubmit = function(event) {
	const t_select = document.getElementById('form').select.value;
	const t_question = document.getElementById('form').question.value;
	const t_emergent = document.getElementById('form').emergent.value;
	if (t_select === "" && t_question === "" && t_emergent === "") {
		event.preventDefault();
		document.getElementById('alert').textContent = '記入してください';
	} else if (t_select === "" || t_question === "" || t_emergent === "") {
		event.preventDefault()
		document.getElementById('alert').textContent = '全て記入してください';
	//} else if (t_select === "") {
		//event.preventDefault();
		//document.getElementById('alert').textContent = 'ジャンルを選択してください';
	//} else if (t_question === "") {
		//event.preventDefault();
		//document.getElementById('alert').textContent = '質問を記入してください';
	//} else if (t_emergent === "") {
		//event.preventDefault();
		//document.getElementById('alert').textContent = 'どちらかのチェックボックスを選択してください';
	}
}
document.getElementById('alert').style.color = 'red';