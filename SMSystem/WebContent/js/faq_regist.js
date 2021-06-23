/**
 *
 */
document.getElementById('form').onsubmit = function(event) {
	const f_genre = document.getElementById('form').genre.value;
	const f_question = document.getElementById('form').question.value;
	const f_answer = document.getElementById('form').answer.value;
	if (f_genre === "" && f_question === "" && f_answer === "") {
		event.preventDefault();
		document.getElementById('alert').textContent = '記入してください';
	} else if (f_genre === "" || f_question === "" || f_answer === "") {
		event.preventDefault();
		document.getElementById('alert').textContent = '全て記入してください';
	//}
	// else if (f_genre === "") {
	//	event.preventDefault();
	//	document.getElementById('alert').textContent = 'ジャンルを選択してください';
	//	console.log(f_genre);
	//} else if (f_question === '') {
	//	event.preventDefault();
	//	document.getElementById('alert').textContent = '質問を記入してください';
	//} else if (f_answer === "") {
	//	event.preventDefault();
	//	document.getElementById('alert').textContent = '回答を記入してください';
	}
}
document.getElementById('alert').style.color = 'red';