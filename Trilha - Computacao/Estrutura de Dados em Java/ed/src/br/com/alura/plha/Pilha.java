package br.com.alura.plha;

import java.util.LinkedList;

public class Pilha {

	private LinkedList<String> lista = new LinkedList<String>();
	
	public void push(String elemento) {
		lista.add(elemento);
	}
	
	public String pop() {
		return lista.remove(lista.size() - 1);
	}
	
	public boolean vazia() {
		return lista.isEmpty();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return lista.toString();
	}
	
}
