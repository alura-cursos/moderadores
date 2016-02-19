package br.com.alura.teste;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import br.com.alura.model.Produto;

public class Sistema {

	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		fabrica.setValidating(true);
		fabrica.setNamespaceAware(true);
		fabrica.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		DocumentBuilder builder = fabrica.newDocumentBuilder();
		Document document = builder.parse("src/vendas.xml");
		
		String formaDePagamento = document.getElementsByTagName("formaDePagamento").item(0).getTextContent();
		System.out.println(formaDePagamento);
		
		String moeda = document.getDocumentElement().getAttribute("moeda");
		System.out.println(moeda);
		
		String exp = "/venda/produtos/produto[2]";
		XPath path = XPathFactory.newInstance().newXPath();
		XPathExpression expression = path.compile(exp);
		
		NodeList produtos = (NodeList) expression.evaluate(document, XPathConstants.NODESET);
		for(int i = 0; i < produtos.getLength(); i++) {
			Element produtoElement = (Element) produtos.item(i);
			String nome = produtoElement.getElementsByTagName("nome").item(0).getTextContent();
			double preco = Double.parseDouble(produtoElement.getElementsByTagName("preco").item(0).getTextContent());
			Produto produto = new Produto(nome, preco);
			System.out.println(produto);
		}
	}
	
}
