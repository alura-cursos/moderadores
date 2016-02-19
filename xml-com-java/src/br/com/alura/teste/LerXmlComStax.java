package br.com.alura.teste;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import br.com.alura.model.Produto;

public class LerXmlComStax {

	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("src/vendas.xml");
		XMLEventReader eventos = XMLInputFactory.newInstance().createXMLEventReader(is);
		List<Produto> produtos = new ArrayList<Produto>();
		
		while(eventos.hasNext()) {
			XMLEvent evento = eventos.nextEvent();
			if(evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("produto")) {
				Produto produto = criaUmProduto(eventos);
				produtos.add(produto);
			}
		}
		
		System.out.println(produtos);
	}

	private static Produto criaUmProduto(XMLEventReader eventos) throws Exception {
		// TODO Auto-generated method stub
		Produto produto = new Produto();
		while(eventos.hasNext()) {
			XMLEvent evento = eventos.nextEvent();
			if(evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("nome")) {
				evento = eventos.nextEvent();
				produto.setNome(evento.asCharacters().getData());
			} else if (evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("preco")) {
				evento = eventos.nextEvent();
				produto.setPreco(Double.parseDouble(evento.asCharacters().getData()));
			} else if (evento.isEndElement() && evento.asEndElement().getName().getLocalPart().equals("produto")) {
				break;
			}
		}
		return produto;
	}
	
}
