package br.com.alura.plha;


public class TestaPilha {

	public static void main(String[] args) {
		Pilha pilha = new Pilha();
		
		pilha.push("Matheus");
		pilha.push("João");
		pilha.push("Maria");
		System.out.println(pilha);
		
		pilha.pop();
		System.out.println(pilha);
		
		pilha.pop();
		System.out.println(pilha.vazia());
		System.out.println(pilha);
		
		pilha.pop();
		System.out.println(pilha.vazia());
		System.out.println(pilha);
		
		System.out.println(pilha.vazia());
	}
	
}
