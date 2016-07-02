package br.com.alura.conjunto;

public class TestaConjunto {

	public static void main(String[] args) {
		Conjunto conjunto = new Conjunto();
		conjunto.adiciona("Matheus");
		System.out.println(conjunto);
		
		conjunto.adiciona("Maria");
		System.out.println(conjunto);
		
		conjunto.adiciona("Maria");
		System.out.println(conjunto);
		
		conjunto.adiciona("Andreia");
		System.out.println(conjunto);
		
		conjunto.adiciona("Adriana");
		System.out.println(conjunto);
		
		conjunto.adiciona("Diego");
		System.out.println(conjunto);
		
		conjunto.remove("Matheus");
		conjunto.remove("Diego");
		System.out.println(conjunto);
	}
	
}
