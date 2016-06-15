package br.com.alura.servidor;

import java.io.PrintStream;

public class ComandoC1 implements Runnable {

	private PrintStream response;

	public ComandoC1(PrintStream response) {
		// TODO Auto-generated constructor stub
		this.response = response;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Executando comando c1");
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.response.println("Confirmação do comando c1");
	}

}
