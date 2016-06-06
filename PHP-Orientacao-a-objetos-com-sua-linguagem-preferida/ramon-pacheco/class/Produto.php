<?php
abstract class Produto{
	public $id;
	public $nome;
	private $preco;
	public $descricao;
	public $categoria;
	public $usado;
	#public $isbn;
	public $tipoProduto;

	function __construct($nome, $preco){
		$this->setNome($nome);
		$this->setPreco($preco);
	}
	function __toString(){
		echo "nome: ".$this->getNome()." preço: ".$this->getPreco()." descricao: ".$this->getDescricao()."<br/>";
	}
	#function __destruct(){
	#	echo "O objeto: ".$this->getNome()." está sendo destruido";
	#}
	public function setId($id){
		$this->id = $id;
	}//setId
	public function getId(){
		return $this->id;
	}//getId
	public function setNome($nome){
		$this->nome = $nome;
	}//setNome
	public function getNome(){
		return $this->nome;
	}//getNome
	public function setPreco($preco){
		if($preco > 0){
			$this->preco = $preco;
		}//if
	}//setPreco
	public function getPreco(){
		return $this->preco;
	}//getPreco
	public function setDescricao($descricao){
		$this->descricao = $descricao;
	}//setDescricao
	public function getDescricao(){
		return $this->descricao;
	}//getDescricao
	public function setUsado($usado){
		$this->usado = $usado;
	}//setUsado
	public function getUsado(){
		return $this->usado;
	}//getDescricao
	// public function setIsbn($isbn){
	// 	$this->isbn = $isbn;
	// }//setIsbn
	// public function getIsbn(){
	// 	return $this->isbn;
	// }//getIsbn
	 public function setTipoProduto($tipoProduto){
	 	$this->tipoProduto = $tipoProduto;
	 }//setTipoProduto
	 public function getTipoProduto(){
	 	return $this->tipoProduto;
	 }//getTipoProduto
	// public function isLivro(){
	// 	return strcasecmp($this->tipoProduto, "livro") == 0;
	// }//isLivro
	public function temIsbn(){
		return $this instanceof Livro;
	}
	public function desconto($valor = 0.1){
		if($valor > 0 && $valor < 1){
			$this->preco -= $this->preco * $valor;
			return $this->preco;
		}//if
	}//desconto

	public function calculaImposto(){
		return $this->getPreco() * 0.195;
	}//calculaImposto

	abstract function atualizaBaseadoEm($params);
}//Produto
?>