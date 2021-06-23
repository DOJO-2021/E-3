/**
 *
 */
document.getElementById('form').onsubmit = function(event) {
	const blood = document.getElementById('form').user_blood.value;
	const career = document.getElementById('form').user_career.value;
	const club = document.getElementById('form').user_club.value;
	const hobby = document.getElementById('form').user_hobby.value;
	const intro = document.getElementById('form').user_intro.value;
	if (blood === "" || career === "" || club === "" || hobby === "" || intro === "") {
		event.preventDefault();
		document.getElementById('alert').textContent = '全て記入してください';
	}
}
document.getElementById('alert').style.color = 'red';