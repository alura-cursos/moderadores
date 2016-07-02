package br.com.alura.vetor;

public class Aluno {

	private String nome;
	
	public Aluno(String nome) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Aluno outro = (Aluno) obj;
		return outro.getNome().endsWith(this.nome);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nome;
	}
	
}
