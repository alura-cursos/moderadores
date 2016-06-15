package br.com.alura.servidor;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Callable;

public class ComandoC2ChamaWS implements Callable<String> {

	private PrintStream response;

	public ComandoC2ChamaWS(PrintStream response) {
		// TODO Auto-generated constructor stub
		this.response = response;
	}

	@Override
	public String call() throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Servidor recebeu o comando c2 - WS");
		this.response.println("Processando o comando c2 - WS");
		Thread.sleep(15000);
		int numero = new Random().nextInt(100) + 1;
		this.response.println("Servidor Finalizou o comando c2 - WS");
		return Integer.toString(numero);
	}

}
