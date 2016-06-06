<?php require_once("cabecalho.php"); 
require_once("banco-categoria.php");
require_once("logica-usuario.php");

verificaUsuario();
$produto = array("nome" => "", "descricao" => "", "preco" => "", "categoria_id" => "1");
$usado = "";
$categorias = listaCategorias($conexao);

?>

<h1>Formulário de cadastro</h1>

	<form action="adiciona-produto.php" method="post">
		<table class="table">
			<?php include("produto-formulario-base.php");?>
			<tr>
				<td>Tipo de produto</td>
				<td>
					<select name="tipoProduto">
								
						<option value="Ebook">Ebook</option>
						<option value="LivroFisico">Livro Físico</option>
						
					</select>
				</td>
			</tr>
			<tr>
				<td>ISBN</td>
				<td><input name="isbn"></input>
			</tr>
			<tr>
				<td><input class="btn btn-primary" type="submit" value="Cadastrar" /></td>
			</tr>
		</table>
	</form>

<?php include("rodape.php"); ?>
