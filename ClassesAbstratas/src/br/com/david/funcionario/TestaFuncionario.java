package br.com.david.funcionario;

public class TestaFuncionario {

	public static void main(String[] args) {
		Gerente joaquim = new Gerente();
		joaquim.setSalario(2000.0);
		joaquim.cobraEntrega();
		
		System.out.println(joaquim.getBonus());
		
		TotalizadorDeBonus totalizadorDeBonus = new TotalizadorDeBonus();
		totalizadorDeBonus.adiciona(joaquim);
		
		System.out.println(totalizadorDeBonus.getTotal());
	}

}
