<?php
	abstract class Livro extends Produto{

		private $isbn;

		public function setIsbn($isbn){
			$this->isbn = $isbn;
		}//setIsbn

		public function getIsbn(){
			return $this->isbn;
		}//getIsbn
		public function calculaImposto(){
			return $this->getPreco() * 0.065;
		}//calculaImposto
	}//class