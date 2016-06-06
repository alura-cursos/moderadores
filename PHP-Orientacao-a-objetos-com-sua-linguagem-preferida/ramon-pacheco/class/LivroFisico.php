<?php

	class LivroFisico extends Livro{

		private $taxaImpressao;

		public function setTaxaImpressao($taxaImpressao){
			$this->taxaImpressao = $taxaImpressao;
		}//setTaxaImpressao
		public function getTaxaImpressao(){
			return $this->taxaImpressao;
		}//getTaxaImpressao
		
		function atualizaBaseadoEm($params){
			$this->setIsbn($params["isbn"]);
        	$this->taxaImpressao = $params["taxaImpressao"];
        	$this->nome = $params["nome"];
        	$this->setPreco($params["preco"]);
		    $this->setDescricao($params["descricao"]);
		    $this->setTipoProduto($params["tipoProduto"]);
		}

	}//LivroFisico