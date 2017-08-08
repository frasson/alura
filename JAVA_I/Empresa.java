public class Empresa {
	private String nome;
	private String cnpj;
	private Funcionario[] empregados;
	private int posicao = 0;

	public Empresa(int quantidadeEmpregados){
		empregados = new Funcionario[quantidadeEmpregados];
	}

	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return this.cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

 	public Funcionario getFuncionario (int posicao) {
        return this.empregados[posicao];
	}
	
 	public void addFuncionario (Funcionario funcionario) {
        this.empregados[posicao++] = funcionario;
	}
	
	public void mostraFuncionarios(){
		for (Funcionario fun : empregados){
			if (fun != null){
				fun.mostra();
			}
		}
	}
}