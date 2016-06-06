<?php

#require_once("class/Produto.php");
#require_once("class/Categoria.php");
class ProdutoDAO{
	private $conexao;
	function __construct($conexao){
		$this->conexao = $conexao;
	}

	function listaProdutos(){
		$produtos = array();
		$resultado = mysqli_query($this->conexao, "SELECT p.*,c.nome as categoria_nome FROM produtos as p join categorias as c on c.id=p.categoria_id");

		while($produto_atual = mysqli_fetch_assoc($resultado)){

			// if(trim($produto_atual['isbn'] != "")){
			// 	$produto = new Livro($produto_atual['nome'], $produto_atual['preco']);
			// 	$produto->setIsbn($produto_atual['isbn']);
			// }else{
			// 	$produto = new Produto($produto_atual['nome'], $produto_atual['preco']);
			// }
			$produto = new $produto_atual['tipoProduto']($produto_atual['nome'], $produto_atual['preco']);
			$categoria = new Categoria;

			$categoria->setNome($produto_atual['categoria_nome']);
			$produto->id = $produto_atual['id'];
			$produto->setIsbn($produto_atual['isbn']);
			#$produto->nome = $produto_atual['nome'];
			#$produto->setPreco($produto_atual['preco']);
			$produto->descricao = $produto_atual['descricao'];
			$produto->categoria = $categoria;
			$produto->usado = $produto_atual['usado'];
			$produto->setTipoProduto($produto_atual['tipoProduto']);
			#$produto->setIsbn($produto_atual['isbn']);
			array_push($produtos, $produto);	
		}
		return $produtos;
	}

	#function alteraProduto($conexao, $id, $nome, $preco, $descricao, $categoria_id, $usado){
	function alteraProduto(Produto $produto){
		$query = "update produtos set nome='{$produto->nome}', preco='{$produto->getPreco()}', descricao='{$produto->descricao}', categoria_id='{$produto->categoria->getId()}', usado='{$produto->usado}' where id='{$produto->id}'";
		return mysqli_query($this->conexao, $query); 
	}

	#function insereProduto($conexao, $nome, $preco, $descricao, $categoria_id, $usado){
	function insereProduto(Produto $produto){
		$nome = mysqli_real_escape_string($this->conexao, $nome);
		
		$isbn = "";
	    if(method_exists($produto, "getIsbn")) {
	        $isbn = $produto->getIsbn();
	    }
	    $waterMark = "";
	    if(method_exists($produto, "getWaterMark")) {
	        $waterMark = $produto->getWaterMark();
	    }
	    $taxaImpressao = "";
	    if(method_exists($produto, "getTaxaImpressao")) {
	        $taxaImpressao = $produto->getTaxaImpressao();
	    }


		$query = "insert into produtos (nome, preco, descricao, categoria_id, usado, isbn, tipoProduto, waterMark, taxaImpressao) values ('{$produto->getNome()}', '{$produto->getPreco()}', '{$produto->getDescricao()}', '{$produto->categoria->getId()}', '{$produto->getUsado()}', '{$isbn}', '{$produto->getTipoProduto()}', '{$waterMark}', '{$taxaImpressao}')";
		$resultadoDaInsercao = mysqli_query($this->conexao, $query);
		return $resultadoDaInsercao;
	}

	#function buscaProduto($conexao, $id){
	function buscaProduto(Produto $produto){
		$query = "SELECT * FROM produtos WHERE id={$produto->id}";
		$resultado = mysqli_query($this->conexao, $query);

		return mysqli_fetch_assoc($resultado);
	}

	function removeProduto($id){
		$query = "DELETE FROM produtos WHERE id={$id}";
		mysqli_query($this->conexao, $query);
	}
}//class