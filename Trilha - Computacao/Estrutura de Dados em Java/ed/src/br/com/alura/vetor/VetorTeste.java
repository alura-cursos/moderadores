package br.com.alura.vetor;

public class VetorTeste {

	public static void main(String[] args) {
		Aluno a1 = new Aluno("Matheus");
		Aluno a2 = new Aluno("João");
		Vetor lista = new Vetor();
		
		lista.adiciona(a1);
		lista.adiciona(a2);
		System.out.println(lista);
		
		Aluno a3 = lista.pega(0);
		System.out.println(a3);
		
		Aluno a4 = new Aluno("Maria");
		System.out.println(lista.contem(a4));
		
		System.out.println(lista.tamanho());
		
		lista.adiciona(a4, 1);
		System.out.println(lista);
		
		lista.remove(1);
		System.out.println(lista);
	}
	
}
