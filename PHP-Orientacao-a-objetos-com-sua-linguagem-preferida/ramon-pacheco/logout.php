<?php
require_once("logica-usuario.php");

logout();
$_SESSION["success"] = "Deslogado com sucesso.";
header("Location: index.php");
die();