package br.com.alura.servidor;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class DistribuirTarefas implements Runnable {

	private Socket socket;
	private ServidorTarefas servidor;
	private ExecutorService threadsPool;
	private BlockingQueue<String> filaComandos;

	public DistribuirTarefas(ExecutorService threadsPool, Socket socket, ServidorTarefas servidor, BlockingQueue<String> filaComandos) {
		// TODO Auto-generated constructor stub
		this.threadsPool = threadsPool;
		this.socket = socket;
		this.servidor = servidor;
		this.filaComandos = filaComandos;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Distribuindo mensagem para o cliente " + this.socket);
			Scanner request = new Scanner(this.socket.getInputStream());
			PrintStream response = new PrintStream(this.socket.getOutputStream());
			while (request.hasNextLine()) {
				String requisicao = request.nextLine();
				System.out.println("Comando " + requisicao + " recebido");
				switch (requisicao) {
					case "c1" : {
						ComandoC1 c1 = new ComandoC1(response);
						this.threadsPool.execute(c1);
						break;
					}
					case "c2" : {
						ComandoC2ChamaWS c2WS = new ComandoC2ChamaWS(response);
						ComandoC2AcessaBanco c2Banco = new ComandoC2AcessaBanco(response);
						Future<String> futureWS = this.threadsPool.submit(c2WS);
						Future<String> futureBanco = this.threadsPool.submit(c2Banco);
						this.threadsPool.submit(new JuntaResultadosFutureWSFutureBanco(futureWS, futureBanco, response));
						break;
					}
					case "c3" : {
						this.filaComandos.put(requisicao);
						response.println("Comando c3 adicionado na fila");
						break;
					}
					case "fim" : {
						response.println(("Finalizando o servidor"));
						this.servidor.parar();
						break;
					}
					default : {
						response.println("Comando não identificado");
						break;
					}
				}
			}
			request.close();
			response.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
}
