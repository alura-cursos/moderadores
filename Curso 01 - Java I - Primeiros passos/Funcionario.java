public class Funcionario {
	private String nome;
	private String departamento;
	private double salario;
	private String dataEntradaBanco;
	private String rg;

	public Funcionario() {
		
	}

	public Funcionario(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDepartamento() {
		return this.departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public double getSalario() {
		return this.salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getDataEntradaBanco() {
		return this.dataEntradaBanco;
	}
	public void setDataEntradaBanco(String dataEntradaBanco) {
		this.dataEntradaBanco = dataEntradaBanco;
	}
	public String getRg() {
		return this.rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}

	public void recebeAumento(double valor) {
		this.salario += valor;
	}

	public double calculaGanhoAnual() {
		return this.salario * 12;
	}

	public void mostra() {
		System.out.println("Nome: " + getNome());
		System.out.println("Departamento: " + getDepartamento());
		System.out.println("Salario: " + getSalario());
		System.out.println("Data de entrada no banco: " + getDataEntradaBanco());
		System.out.println("Rg: " + getRg());
	}
}