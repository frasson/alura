package br.com.david.funcionario;

public class Gerente extends Funcionario {

	@Override
	public double getBonus() {		
		return this.salario * 0.3;
	}
	
	public void cobraEntrega() {
		System.out.println("Está pronto!");
	}
}
