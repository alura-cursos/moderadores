
public class TestaGerador {

	public static void main(String[] args) throws Exception {
		GeradorXML gerador = new GeradorXML();
		Usuario usuario = new Usuario();
		usuario.setAtivo(true);
		usuario.setEmail("teste@teste.com.br");
		usuario.setLogin("teste");
		usuario.setPapel("administrador");
		usuario.setSenha("123456");
		System.out.println(gerador.getXML(usuario));
	}
	
}
