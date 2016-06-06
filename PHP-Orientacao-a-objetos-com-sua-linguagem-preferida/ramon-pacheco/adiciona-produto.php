<?php
require_once("conecta.php"); 
#require_once("class/Produto.php");
#require_once("class/Categoria.php");
require_once("cabecalho.php");
#require_once("banco-produto.php");
require_once("logica-usuario.php");


			verificaUsuario();
			
			$tipoProduto = $_POST['tipoProduto'];
		
			$CriadorDeProdutos = new CriadorDeProdutos();
			
			$produto = $CriadorDeProdutos->criaPor($tipoProduto);
			$produto->atualizaBaseadoEm($_POST);
			
			
			// if(strcasecmp($_POST['tipoProduto'], "livro") == 0){
			// 	$produto = new Livro($_POST["nome"], $_POST["preco"]);
				
			// }else{
			// 	$produto = new Produto($_POST["nome"], $_POST["preco"]);
			// }

			
			$categoria = new Categoria;

			$categoria->setId($_POST["categoria_id"]);

			#$produto->nome = $_POST["nome"];
			#$produto->setPreco($_POST["preco"]);

			#$produto->descricao = $_POST["descricao"];
			$produto->categoria = $categoria;
			#$produto->setTipoProduto($_POST["tipoProduto"]);
		
			if(array_key_exists('usado', $_POST)){$usado="true";}else{$usado = "false";}	
			
			$produto->usado = $usado;

			$produtoDAO = new ProdutoDAO($conexao);

			if($produtoDAO->insereProduto($produto)){
		?>
				<p class="text-success">
				Produto <?= $produto->nome; ?>, <?= $produto->getPreco(); ?> adicionado com sucesso!
				</p>
			<?php
			}else{
				$msg = mysqli_error($conexao);
			?>
				<p class="text-danger">
				O produto <?= $produto->nome; ?> não foi adicionado: <?= $msg; ?>
				</p>
			<?php
			}
			?>
		
<?php include("rodape.php"); ?>
