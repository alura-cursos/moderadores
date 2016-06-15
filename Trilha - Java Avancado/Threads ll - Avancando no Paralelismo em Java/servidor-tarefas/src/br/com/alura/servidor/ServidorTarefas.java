package br.com.alura.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServidorTarefas {

	private ExecutorService threadsPool;
	private ServerSocket servidor;
	private AtomicBoolean estaRodando;
	private BlockingQueue<String> filaComandos;

	public ServidorTarefas() throws IOException {
		// TODO Auto-generated constructor stub
		System.out.println("Servidor iniciado...");
		this.servidor = new ServerSocket(12345);
		this.threadsPool = Executors.newCachedThreadPool(new FabricaDeThread());
		this.estaRodando = new AtomicBoolean(true);
		this.filaComandos = new ArrayBlockingQueue<>(2);
		iniciarConsumidores();
	}
	
	private void iniciarConsumidores() {
		// TODO Auto-generated method stub
		int quantidadeConsumidores = 2;
		for (int i = 0; i < quantidadeConsumidores; i++) {
			TarefaConsumir tarefa = new TarefaConsumir(this.filaComandos);
			this.threadsPool.execute(tarefa);
		}
	}

	public void rodar() throws IOException {
		while (this.estaRodando.get()) {
			try {
				Socket socket = servidor.accept();
				System.out.println("Um novo cliente conectou-se no servidor na porta " + socket.getPort());
				DistribuirTarefas tarefa = new DistribuirTarefas(threadsPool, socket, this, this.filaComandos);
				threadsPool.execute(tarefa);
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				System.out.println("SocketException, esta rodando? " + this.estaRodando.get());
			}
		}
	}
	
	public void parar() throws IOException {
		this.estaRodando.set(false);
		servidor.close();
		threadsPool.shutdown();
	}
	
	public static void main(String[] args) throws Exception {
		ServidorTarefas servidor = new ServidorTarefas();
		servidor.rodar();
	}
	
}
