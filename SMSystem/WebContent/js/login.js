/**
 *
 */


/* submitボタンが押されたら「クリックされました」というメッセージを表示 */

document.getElementById('form').onsubmit = function(event) {

 /* もしも、IDかパスワードが未入力なら、デフォルトの動作を行わず、
警告ダイアログに「IDとパスワードを入力してください」と表示する
空であることの比較の例
*/
  const id = document.getElementById('form').user_id.value;
  const pw = document.getElementById('form').user_pw.value;
  if (id === "" && pw === "" ) {
  event.preventDefault();
  document.getElementById('output').textContent = 'IDとPWを入力してください';
  //window.alert('IDとPWを入力してください');
} else if(id === "" ) {
  event.preventDefault();
 document.getElementById('output').textContent = 'IDを入力してください';
  //window.alert('IDを入力してください');
} else if(pw === "" ) {
  event.preventDefault();
  document.getElementById('output').textContent = 'PWを入力してください';
  //window.alert('PWを入力してください');
}
};
  document.getElementById('output').style.color = 'red';
