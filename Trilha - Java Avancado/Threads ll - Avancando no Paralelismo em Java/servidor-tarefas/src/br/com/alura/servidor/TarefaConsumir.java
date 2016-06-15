package br.com.alura.servidor;

import java.util.concurrent.BlockingQueue;

public class TarefaConsumir implements Runnable {

	private BlockingQueue<String> filaComandos;
	
	public TarefaConsumir(BlockingQueue<String> fileComandos) {
		// TODO Auto-generated constructor stub
		filaComandos = fileComandos;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			String comando = null;
			while((comando = this.filaComandos.take()) != null) {
				System.out.println("Consumindo o comando " + comando + ", " + Thread.currentThread().getName());
				Thread.sleep(20000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}
