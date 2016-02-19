package br.com.alura.teste;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class ConverorParaHtml {

	public static void main(String[] args) throws Exception {
		InputStream xsl = new FileInputStream("src/xmlParaHtml.xsl");
		StreamSource xslSource = new StreamSource(xsl);
		
		InputStream dados = new FileInputStream("src/vendas.xml"); 
		StreamSource xmlSource = new StreamSource(dados);
		
		Transformer transformer = TransformerFactory.newInstance().newTransformer(xslSource);
		
		StreamResult saida = new StreamResult("src/vendas.html");
		transformer.transform(xmlSource, saida);
	}
	
}
