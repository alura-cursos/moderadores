<?php include("cabecalho.php");
require_once("conecta.php");
#require_once("banco-produto.php");
require_once("logica-usuario.php");

$id = $_POST['id'];
$produtoDAO = new ProdutoDAO($conexao);
$produtoDAO->removeProduto($id);
$_SESSION["success"] = "Produto removido com sucesso";
header("Location: produto-lista.php");
die();

include("rodape.php");
?>
