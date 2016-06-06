<?php
	class Categoria{
		private $id;
		private $nome;

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
	}
?>