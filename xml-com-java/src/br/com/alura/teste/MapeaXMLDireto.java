package br.com.alura.teste;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import br.com.alura.model.Produto;
import br.com.alura.model.Venda;

public class MapeaXMLDireto {
	public static void main(String[] args) throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(Venda.class);
		
		//xmlParaObjeto(jaxbContext);
		
		ObjetoParaXml(jaxbContext);
	}

	private static void ObjetoParaXml(JAXBContext jaxbContext) throws Exception {
		// TODO Auto-generated method stub
		Venda venda = new Venda();
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(new Produto("Livro de java", 59.90));
		produtos.add(new Produto("Livro de xml", 59.90));
		produtos.add(new Produto("Livro de O.O", 59.90));
		venda.setFormaDePagamento("Crediario");
		venda.setProdutos(produtos);
		Marshaller marshaller = jaxbContext.createMarshaller();
		StringWriter writer = new StringWriter();
		marshaller.marshal(venda, writer);
		System.out.println(writer.toString());
	}

	private static void xmlParaObjeto(JAXBContext jaxbContext) throws Exception {
		// TODO Auto-generated method stub
		Venda venda = (Venda) jaxbContext.createUnmarshaller().unmarshal(new File("src/vendas.xml"));
		System.out.println(venda);		
	}
}
