import java.util.Calendar;
import java.util.List;


public class TestaValidadorNulo {

	public static void main(String[] args) throws Exception {
		ValidadorNulo validador = new ValidadorNulo();
		NotaFiscal nf = new NotaFiscal();
		nf.cnpj = "00.000.000/0000-00";
		nf.talao = 1;
		nf.data = Calendar.getInstance().getTime();
		List<String> camposNf = validador.getAtributosNulos(nf);
		for (String string : camposNf) {
			System.out.println(string);
		}
	}
	
}
