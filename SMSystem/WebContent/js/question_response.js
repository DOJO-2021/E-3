/**
 *
 */
document.getElementById('form').onsubmit = function(event) {
	const t_answer = document.getElementById('form').answer.value;
	const t_faq = document.getElementById('form').faq.value;
	if (t_answer === "" && t_faq === "") {
		event.preventDefault();
		document.getElementById('th_alert').textContent = '回答とチェックボックスが未記入です';
	} else if (t_answer === "") {
		event.preventDefault();
		document.getElementById('th_alert').textContent = '回答が未記入です';
	} else if (t_faq === "") {
		event.preventDefault();
		document.getElementById('th_alert').textContent = 'どちらかのチェックボックスを選択してください';
	}
}
document.getElementById('th_alert').style.color = 'red';