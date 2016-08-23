package br.com.alura.jogodaforca;

import java.util.HashSet;
import java.util.Set;

public class ForcaController {

    private String palavraParaAdivinhar;
    private Set<Character> letrasJogadas;
    private int qtdErros = -1;

    public ForcaController(String palavraParaAdivinhar) {
        this.palavraParaAdivinhar = palavraParaAdivinhar;
        this.letrasJogadas = new HashSet<Character>();
    }

    public int getQtdErros() {
        return qtdErros;
    }

    public void joga(Character letra) {
        if (this.letrasJogadas.contains(letra))
            return;
        letrasJogadas.add(letra);
        if (this.palavraParaAdivinhar.contains(letra.toString()))
            return;
        this.qtdErros++;
    }

    public String getPalavraAteAgora() {
        String visualizacao = "";
        for(char c : this.palavraParaAdivinhar.toCharArray()) {
            if (this.letrasJogadas.contains(c))
                visualizacao += c;
            else
                visualizacao += " ";
        }
        return visualizacao;
    }

    public boolean isMorreu() {
        return this.qtdErros == 5;
    }

    public boolean ganhou() {
        return !getPalavraAteAgora().contains(" ");
    }

    public boolean isTerminou() {
        return isMorreu() || ganhou();
    }

}
