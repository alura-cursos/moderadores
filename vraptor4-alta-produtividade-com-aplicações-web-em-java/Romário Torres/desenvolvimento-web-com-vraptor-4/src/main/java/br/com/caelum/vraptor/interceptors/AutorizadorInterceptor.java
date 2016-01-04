package br.com.caelum.vraptor.interceptors;

import javax.inject.Inject;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.annotations.Public;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.controller.LoginController;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.caelum.vraptor.model.UsuarioLogado;

@Intercepts
public class AutorizadorInterceptor {
	
	private final UsuarioLogado usuarioLogado;
	private final Result result;
	private final ControllerMethod controllerMethod;
	
	@Inject
	public AutorizadorInterceptor(UsuarioLogado usuarioLogado, Result result, ControllerMethod controllerMethod) {
		this.usuarioLogado = usuarioLogado;
		this.result = result;
		this.controllerMethod = controllerMethod;
	}

	
	@Deprecated
	public AutorizadorInterceptor() {
		this(null, null, null);
	}

	@Accepts
	public boolean accepts() {
	    return !controllerMethod.containsAnnotation(Public.class);
	}


	@AroundCall
	public void intercept(SimpleInterceptorStack stack){
		if(usuarioLogado.getUsuario() == null){
			result.redirectTo(LoginController.class).formulario();
			return;
		}
		stack.next();		
	}
}
