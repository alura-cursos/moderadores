package br.com.alura.vetor;

import java.util.Arrays;

public class Vetor {

	private Aluno[] alunos = new Aluno[100];
	private int totalAlunos = 0;
	
	public void adiciona(Aluno aluno) {
		this.alunos[totalAlunos] = aluno;
		this.totalAlunos++;
	}
	
	public void adiciona(Aluno aluno, int posicao) {
		for (int i = this.totalAlunos - 1; i >= posicao; i--) {
			this.alunos[i + 1] = this.alunos[i];
		}
		this.alunos[posicao] = aluno;
		this.totalAlunos++;
	}
	
	public Aluno pega(int posicao) {
		return this.alunos[posicao];
	}
	
	public void remove(int posicao) {
		for(int i = posicao; i < this.totalAlunos; i++) {
			this.alunos[i] = this.alunos[i + 1];
		}
		this.totalAlunos--;
	}
	
	public boolean contem(Aluno aluno) {
		for (int i = 0; i < this.totalAlunos; i++) {
			if (this.alunos[i] == aluno) {
				return true;
			}
		}
		return false;
	}
	
	public int tamanho() {
		return this.totalAlunos;
	}
	
	public String toString() {
		return Arrays.toString(alunos);
	}
	
}
