document.getElementById('form-busca').onsubmit = function() {
  if (document.getElementById('q').value === '') {
  	  document.getElementById('form-busca').style.background = 'red';
  	  return false;
  }	
};

var banners = ["img/destaque-home-2.png", "img/destaque-home.png"];
function trocaBanner() {
	document.querySelector('.destaque img').src = banners[0];
	banners.reverse();
}
setInterval(trocaBanner, 8000);

$('.painel').addClass('painel-compacto');

$('.painel button').click(function() {
	$(this).parent().removeClass('painel-compacto');
});