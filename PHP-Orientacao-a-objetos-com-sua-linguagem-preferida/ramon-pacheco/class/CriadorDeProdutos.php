<?php
	class CriadorDeProdutos {
		private $classes = array("Ebook", "LivroFisico");

		function criaPor($tipoProduto){
	        if (in_array($tipoProduto, $this->classes)) {
	            return new $tipoProduto("", "");
	        }
        return new LivroFisico("", "");
   		}//criaPor

	}//class