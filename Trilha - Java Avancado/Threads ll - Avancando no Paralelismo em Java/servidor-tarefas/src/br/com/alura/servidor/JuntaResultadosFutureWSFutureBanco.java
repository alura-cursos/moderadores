package br.com.alura.servidor;

import java.io.PrintStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class JuntaResultadosFutureWSFutureBanco implements Callable<Void> {

	private Future<String> futureWS;
	private Future<String> futureBanco;
	private PrintStream response;

	public JuntaResultadosFutureWSFutureBanco(Future<String> futureWS, Future<String> futureBanco, PrintStream response) {
		// TODO Auto-generated constructor stub
		this.futureWS = futureWS;
		this.futureBanco = futureBanco;
		this.response = response;
	}

	@Override
	public Void call() {
		// TODO Auto-generated method stub
		System.out.println("Aguardando resultado do future WS e future Banco");
		String numeroMagicoWs;
		try {
			numeroMagicoWs = this.futureWS.get(20, TimeUnit.SECONDS);
			String numeroMagicoBanco = this.futureBanco.get(20, TimeUnit.SECONDS);
			this.response.println("Resultado do comando c2: " + numeroMagicoWs + ", " + numeroMagicoBanco);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			// TODO Auto-generated catch block
			System.out.println("Timeout: Cancelando a execução do comando c2");
			this.futureWS.cancel(true);
			this.futureBanco.cancel(true);
			this.response.println("Timeout na execução do comando c2");
		}
		System.out.println("Finalizou a execução do JuntaResultadosFutureWSFutureBanco");
		return null;
	}

}
