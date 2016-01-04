package br.com.caelum.vraptor.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.annotations.Log;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.simplemail.Mailer;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;

@Controller
public class ProdutoController {
	
	private final ProdutoDao dao;
	private final Result result;
	private final Validator validator;
	private final Mailer mailer;

	@Inject
	public ProdutoController(ProdutoDao dao, Result result, Validator validator, Mailer mailer) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
		this.mailer = mailer;
	}
	
	@Deprecated
	public ProdutoController() {
		this(null, null, null, null);
	}
	
	@Get("/")
	public void inicio(){
		
	}
	
	@Get
	public void lista(){
		result.include("produtoList", dao.lista());
	}
	
	@Get
	public void listaXML(){
		result.use(Results.xml()).from(dao.lista()).serialize();;
	}
	
	@Get @Log
	public void formulario(){
		
	}
	
	@Post
	public void adiciona(@Valid Produto produto){
		validator.onErrorUsePageOf(this).formulario();
		dao.adiciona(produto);
		result.include("mensagem", "Produto adicionado com sucesso!");
		result.redirectTo(this).lista();
	}
	
	@Get
	public void enviaPedidoDeNovosItens(Produto produto) throws EmailException{
		Email email = new SimpleEmail();
		email.setSubject("Precisamos de mais estoque");
		email.setMsg("O produto" + produto.getNome() + "está em falta no estoque");
		
//		Configure aqui o email pra qual deseja enviar
		email.addTo("curso.alura.vraptor4@gmail.com");
		mailer.send(email);
		result.redirectTo(this).lista();
	}
	
	
	
}
