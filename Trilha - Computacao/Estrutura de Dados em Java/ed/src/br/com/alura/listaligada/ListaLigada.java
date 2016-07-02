package br.com.alura.listaligada;

public class ListaLigada {
	
	private Celula primeira = null;
	private Celula ultima = null;
	private int totalElementos = 0;

	public void adicionaNoComeco(Object elemento) {
		if (totalElementos == 0) {
			Celula nova = new Celula(elemento);
			this.primeira = nova;
			this.ultima = nova;
		} else {
			Celula nova = new Celula(elemento, primeira);
			primeira.setAnterior(nova);
			this.primeira = nova;
		}
		totalElementos++;
	}
	
	public void adicionaNoFim(Object elemento) {
		if (totalElementos == 0) {
			adicionaNoComeco(elemento);
		} else {
			Celula nova = new Celula(elemento);
			nova.setAnterior(ultima);
			ultima.setProxima(nova);
			ultima = nova;
			totalElementos++;
		}
	}
	
	public void adiciona(Object elemento) {
		if (totalElementos == 0) {
			adicionaNoComeco(elemento);
		} else {
			Celula nova = new Celula(elemento, null);
			ultima.setProxima(nova);
			ultima = nova;
			totalElementos++;
		}
	}
	
	public void adiciona(Object elemento, int posicao) {
		if (posicao == 0 ) {
			adicionaNoComeco(elemento);
		} else if (posicao == this.totalElementos) {
			adicionaNoFim(elemento);
		} else {
			Celula anteriorPosicao = pegaCelula(posicao - 1);
			Celula proxima = anteriorPosicao.getProxima();
			Celula nova = new Celula(elemento, proxima);
			anteriorPosicao.setProxima(nova);
			nova.setAnterior(anteriorPosicao);
			nova.setProxima(proxima);
			proxima.setAnterior(nova);
			totalElementos++;
		}
	}
	
	public boolean contem(Object elemento) {
		Celula atual = primeira;
		while (atual.getProxima() != null) {
			if (atual.getElemento().equals(elemento))
				return true;
			atual = atual.getProxima();
		}
		return false;
	}
	
	public Object pega(int posicao) {
		return pegaCelula(posicao).getElemento();
	}
	
	public void remove(int posicao) {
		if (posicao == 0) {
			removeDoComeco();
		} else if (posicao == totalElementos) {
			removeDoFim();
		} else {
			Celula atual = pegaCelula(posicao);
			Celula anterior = atual.getAnterior();
			Celula proxima = atual.getProxima();
			anterior.setProxima(proxima);
			proxima.setAnterior(anterior);
			totalElementos--;
		}
	}
	
	public void removeDoComeco() {
		if (totalElementos == 0)
			throw new IllegalAccessError("Lista vázia");
		primeira = primeira.getProxima();
		totalElementos--;
		if (totalElementos == 0)
			ultima = null;
	}
	
	public void removeDoFim() {
		Celula anterior = ultima.getAnterior();
		anterior.setProxima(null);
		ultima = anterior;
		totalElementos--;
	}
	
	public int tamanho() {
		return totalElementos;
	}
	
	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < totalElementos;
	}
	
	private Celula pegaCelula(int posicao) {
		if (!posicaoOcupada(posicao)) {
			throw new IllegalAccessError("Posição inválida");
		}
		Celula atual = primeira;
		for (int i = 0; i < posicao; i++) {
			atual = atual.getProxima();
		}
		return atual;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if (totalElementos == 0)
			return "[]";
		StringBuilder builder = new StringBuilder("[");
		Celula atual = primeira;
		for (int i = 0; i < totalElementos; i++) {
			builder.append(atual.getElemento());
			builder.append(",");
			atual = atual.getProxima();
		}
		builder.append("]");
		return builder.toString();
	}
	
}
