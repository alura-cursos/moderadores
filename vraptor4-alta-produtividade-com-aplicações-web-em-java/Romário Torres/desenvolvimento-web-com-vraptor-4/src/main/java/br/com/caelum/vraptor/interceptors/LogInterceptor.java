package br.com.caelum.vraptor.interceptors;

import javax.inject.Inject;

import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.annotations.Log;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;

@Intercepts(after = AutorizadorInterceptor.class) @AcceptsWithAnnotations(Log.class)
public class LogInterceptor {
	private final ControllerMethod controllerMethod;

	@Inject
	public LogInterceptor(ControllerMethod controllerMethod) {
		this.controllerMethod = controllerMethod;
	}

	@Deprecated
	public LogInterceptor() {
		this(null);
	}
	
	@BeforeCall
	public void before(){
		System.out.println("Executando o método: " + controllerMethod.getMethod().getName());
	}
	
}
