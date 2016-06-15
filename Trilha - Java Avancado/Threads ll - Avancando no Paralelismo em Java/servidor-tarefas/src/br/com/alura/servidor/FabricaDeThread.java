package br.com.alura.servidor;

import java.util.concurrent.ThreadFactory;

public class FabricaDeThread implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		// TODO Auto-generated method stub
		Thread t = new Thread(r);
		t.setUncaughtExceptionHandler(new TratadorDeExcecao());
		return t;
	}

}
