<?php 
require_once("cabecalho.php"); 
require_once("banco-categoria.php");
#require_once("banco-produto.php");
#$id = $_GET['id'];
$produtoParametro = new $_GET['tipoProduto']("", "");
$produtoParametro->id = $_GET['id'];
$produtoDAO = new ProdutoDAO($conexao);
#$produto = buscaProduto($conexao, $id);
$produto = $produtoDAO->buscaProduto($produtoParametro);
$categorias = listaCategorias($conexao);
$usado = $produto['usado'] ? "checked='checked'" : "";
?>

<h1>Alterando produto</h1>
	<form action="altera-produto.php" method="post">
		<input type="hidden" name="id" value="<?=$produto['id']?>">
		<input type="hidden" name="tipoProduto" value="<?=$produto['tipoProduto']?>">
		<table class="table">
			<?php include("produto-formulario-base.php");?>
			<tr>
				<td><input class="btn btn-primary" type="submit" value="Alterar" /></td>
			</tr>
		</table>
	</form>

<?php include("rodape.php"); ?>
