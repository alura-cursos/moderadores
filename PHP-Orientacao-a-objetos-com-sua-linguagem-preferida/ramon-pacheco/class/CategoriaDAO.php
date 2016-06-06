<?php
require_once("conecta.php");
require_once("class/Categoria.php");

class CategoriaDAO{

	private $conexao;

	function __construct($conexao){
		$this->conexao = $conexao;
	}

	function listaCategorias() {
	    $categorias = array();
	    $query = "select * from categorias";
	    $resultado = mysqli_query($this->conexao, $query);
	    while($categoria_atual = mysqli_fetch_assoc($resultado)) {
	    	$categoria = new Categoria;
	    	
	    	$categoria->setId($categoria_atual['id']);
	    	$categoria->setNome($categoria_atual['nome']);

	        array_push($categorias, $categoria);
	    }
	    return $categorias;
	}

}//class