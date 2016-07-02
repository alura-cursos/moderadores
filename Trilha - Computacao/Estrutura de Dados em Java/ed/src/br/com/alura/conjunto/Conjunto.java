package br.com.alura.conjunto;

import java.util.ArrayList;
import java.util.LinkedList;

public class Conjunto {

	private ArrayList<LinkedList<String>> tabela = new ArrayList<LinkedList<String>>();
	
	public Conjunto() {
		// TODO Auto-generated constructor stub
		for (int i = 0; i < 26; i++) {
			tabela.add(new LinkedList<String>());
		}
	}
	
	public void adiciona(String palavra) {
		if (!contem(palavra)) {
			int indice = calculaIndiceDaTabela(palavra);
			tabela.get(indice).add(palavra);
		}
	}
	
	public boolean contem(String palavra) {
		int indice = calculaIndiceDaTabela(palavra);
		return tabela.get(indice).contains(palavra);
	}
	
	public void remove(String palavra) {
		if (contem(palavra)) {
			int indice = calculaIndiceDaTabela(palavra);
			tabela.get(indice).remove(palavra);
		}
	}
	
	private int calculaIndiceDaTabela(String palavra) {
		return palavra.toLowerCase().charAt(0) % 26;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return tabela.toString();
	}
	
}
