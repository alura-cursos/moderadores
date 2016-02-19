package br.com.alura.handler;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import br.com.alura.model.Produto;

public class ProdutoHandler extends DefaultHandler {

	private List<Produto> produtos = new ArrayList<Produto>();
	private Produto produto;
	private StringBuilder conteudo;
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		if (qName.equals("produto")) {
			produto = new Produto();
		}
		
		conteudo = new StringBuilder();
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		conteudo.append(new String(ch, start, length));
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		if (qName.equals("produto"))
			produtos.add(produto);
		else if (qName.equals("nome"))
			produto.setNome(conteudo.toString());
		else if (qName.equals("preco"))
			produto.setPreco(Double.parseDouble(conteudo.toString()));
	}

}
