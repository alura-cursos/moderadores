import java.util.List;

public class Empresa {
	private String razaosocial;
	private String cnpj;
	private List<Funcionario> funcionarios;

	public String getRazaoSocial() {
		return this.razaosocial;
	}
	public void setRazaoSocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}
	public String getCnpj() {
		return this.cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public List<Funcionario> getFuncionarios() {
		return this.funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public void adicionaFuncionario(Funcionario funcionario) {
		this.funcionarios.add(funcionario);
	}

	public void imprimiSalarios() {
		for(Funcionario funcionario: this.funcionarios) {
			System.out.println("Salario: " + funcionario.getSalario());
		}
	}

	public void mostraTodasInformacoes() {
		for(Funcionario funcionario : this.funcionarios) {
			funcionario.mostra();
			System.out.println("Razao Social: " + this.getRazaoSocial());
			System.out.println("Cnpj: " + this.getCnpj());
		}
	}
}