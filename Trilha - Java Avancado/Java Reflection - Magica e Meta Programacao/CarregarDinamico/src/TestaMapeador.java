import java.util.List;
import java.util.Map;


public class TestaMapeador {

	public static void main(String[] args) throws Exception {
		Mapeador mapeador = new Mapeador();
		mapeador.load("classes.prop");
		System.out.println("Pegando a implementação");
		System.out.println(mapeador.getImplementacao(List.class));
		System.out.println(mapeador.getImplementacao(Map.class));
		System.out.println();
		
		System.out.println("Pegando a instância");
		List list = mapeador.getInstancia(List.class);
		System.out.println(list.getClass());
		System.out.println();
		
		System.out.println("Pegando uma instancia com parâmetros");
		InterfaceExemplo interfaceExemplo = mapeador.getInstancia(InterfaceExemplo.class, "Teste");
		System.out.println(interfaceExemplo.getClass());
	}
	
}
