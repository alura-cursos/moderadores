<?php
	class Ebook extends Livro{

		private $waterMark;

		public function setWaterMark($waterMark){
			$this->waterMark = $waterMark;
		}//setWaterMark
		public function getWaterMark(){
			return $this->waterMark;
		}//getWaterMark
		
		function atualizaBaseadoEm($params){
			$this->isbn = $params["isbn"];
        	$this->waterMark = $params["waterMark"];
        	$this->taxaImpressao = $params["taxaImpressao"];
        	$this->setNome($params["nome"]);
    		$this->setPreco($params["preco"]);
    		$this->setDescricao($params["descricao"]);
    		$this->setTipoProduto($params["tipoProduto"]);
		}

	}//class