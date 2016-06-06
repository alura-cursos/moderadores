<?php
session_start();
function mostraAlerta($tipo){
	if(isset($_SESSION[$tipo])){
?>
<p class="alert-<?=$tipo?>"><?=$_SESSION[$tipo]?>
<?php
	unset($_SESSION[$tipo]);
	}

}
