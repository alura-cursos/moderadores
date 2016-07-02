package br.com.alura.fila;

import java.util.LinkedList;

public class Fila {

	private LinkedList<String> alunos = new LinkedList<String>();
	
	public void adiciona(String aluno) {
		alunos.add(aluno);
	}
	
	public String remove() {
		return alunos.remove(0);
	}
	
	public boolean vazia() {
		return alunos.isEmpty();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return alunos.toString();
	}
	
}
