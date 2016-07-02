package br.com.alura.listaligada;

public class TestaListaLigada {

	public static void main(String[] args) {
		ListaLigada lista = new ListaLigada();
		
		lista.adicionaNoComeco("Matheus");
		lista.adicionaNoComeco("João");
		lista.adicionaNoComeco("José");
		System.out.println(lista);
	}
	
}
