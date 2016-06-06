<?php 
#require_once("class/Produto.php");
#require_once("class/Categoria.php");
require_once("conecta.php");
require_once("cabecalho.php");

			
			$produto = new $_POST['tipoProduto']($_POST["nome"], $_POST["preco"]);
			$categoria = new Categoria;
			$produtoDAO = new ProdutoDAO($conexao);

			$categoria->setId($_POST["categoria_id"]);

			$produto->id = $_POST['id'];
			$produto->descricao = $_POST["descricao"];
			$produto->categoria = $categoria;
			
			if(array_key_exists('usado', $_POST)){$usado="true";}else{$usado = "false";}	
			$produto->setUsado($usado);

			if($produtoDAO->alteraProduto($produto)){
		?>
				<p class="text-success">
				Produto <?= $nome; ?>, <?= $preco; ?> Alterado com sucesso!
				</p>
			<?php
			}else{
				$msg = mysqli_error($conexao);
			?>
				<p class="text-danger">
				O produto <?= $nome; ?> não foi alterado: <?= $msg; ?>
				</p>
			<?php
			}
			?>
		
<?php include("rodape.php"); ?>
