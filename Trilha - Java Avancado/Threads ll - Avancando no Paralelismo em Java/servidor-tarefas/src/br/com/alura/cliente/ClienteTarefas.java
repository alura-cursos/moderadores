package br.com.alura.cliente;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTarefas {

	public static void main(String[] args) throws Exception {
		final Socket socket = new Socket("localhost", 12345);
		System.out.println("Conexão estabelecida com sucesso");
		Thread threadRequisicao = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					System.out.println("Aguardando os comandos...");
					PrintStream requisicaoServidor = new PrintStream(socket.getOutputStream());
					Scanner scanner = new Scanner(System.in);
					while (scanner.hasNextLine()) {
						String linha = scanner.nextLine();
						if (linha.trim().equals(""))
							break;
						requisicaoServidor.println(linha);
					}
					scanner.close();
					requisicaoServidor.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					throw new RuntimeException(e);
				}
			}
		});
		
		Thread threadResposta = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Scanner respostaServidor = new Scanner(socket.getInputStream());
					while (respostaServidor.hasNextLine()) {
						System.out.println(respostaServidor.nextLine());
					}
					respostaServidor.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					throw new RuntimeException(e);
				}
			}
		});
		
		
		threadResposta.start();
		threadRequisicao.start();
		threadRequisicao.join();
		
		System.out.println("Finalizado as requisições");
		
		socket.close();
	}
	
}
