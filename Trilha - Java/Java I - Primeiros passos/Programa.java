import java.util.List;
import java.util.ArrayList;

public class Programa {
	public static void main(String[] args) {
		Funcionario funcionario1 = new Funcionario();
		funcionario1.setNome("Matheus");
		funcionario1.setDepartamento("Desenvolvimento");
		funcionario1.setSalario(2000.0);
		funcionario1.setDataEntradaBanco("01/01/2015");
		funcionario1.setRg("00.000.000-0");

		List<Funcionario> funcionarios = new ArrayList<Funcionario>();		

		Empresa empresa1 = new Empresa();
		empresa1.setRazaoSocial("Atena Informatica");
		empresa1.setCnpj("00.000.000/0000-00");
		empresa1.setFuncionarios(funcionarios);
		empresa1.adicionaFuncionario(funcionario1);

		empresa1.mostraTodasInformacoes();
	}
}