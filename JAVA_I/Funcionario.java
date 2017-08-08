public class Funcionario {
	private String nome;
	private String departamento;
	private double salario;
	private Data dataEntradaBanco;
	private String rg;
	private int identificador;
	private static int numeroIncremental = 0;


	public Funcionario() {
		this("");		
	}

	public Funcionario(String nome) {
		this.nome = nome;
		this.identificador = numeroIncremental;
		numeroIncremental++;
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
   
	public Data getDataEntradaBanco() {
		return this.dataEntradaBanco;
	}
   
	public void setDataEntradaBanco(Data dataEntradaBanco) {
		this.dataEntradaBanco = dataEntradaBanco;
	}
   
	public String getRg() {
		return this.rg;
	}
   
	public void setRg(String rg) {
		this.rg = rg;
	}

	public void bonifica(double valor) {
		this.salario += valor;
	}

	public double getGanhoAnual() {
		return this.salario * 12;
	}

	public int getIdentificador(){
		return this.identificador;
	}

	public void mostra() {
		System.out.println("Nome: " + getNome());
		System.out.println("Departamento: " + getDepartamento());
		System.out.println("Salario: " + getSalario());
		System.out.println("Data de entrada no banco: " + getDataEntradaBanco().toString());
		System.out.println("Rg: " + getRg());
		System.out.println("Identificador: " + getIdentificador());
	}
}