package br.com.alura.teste;

import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import br.com.alura.handler.ProdutoHandler;

public class LerXmlComSax {

	public static void main(String[] args) throws Exception {
		XMLReader leitor = XMLReaderFactory.createXMLReader();
		InputStream is = new FileInputStream("src/vendas.xml");
		ProdutoHandler logica = new ProdutoHandler();
		leitor.setContentHandler(logica);
		leitor.parse(new InputSource(is));
		System.out.println(logica.getProdutos());
	}
	
}
