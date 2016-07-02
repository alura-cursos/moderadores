package br.com.alura.fila;

public class TestaFila {

	public static void main(String[] args) {
		Fila fila = new Fila();
		
		fila.adiciona("Matheus");
		fila.adiciona("Ricardo");
		System.out.println(fila);
		
		fila.remove();
		System.out.println(fila);
	}
	
}
