
public class TestaValidador {

	public static void main(String[] args) throws Exception {
		Usuario usuario = new Usuario();
		usuario.setEmail("semarroba.com");
		usuario.setSenha("123456789");

		Validador validador = new Validador();
		boolean valido = validador.validarObjeto(usuario);
		if (valido)
			System.out.println("Objeto é valido");
		else
			System.out.println("Objeto é invalido");
	}
	
}
