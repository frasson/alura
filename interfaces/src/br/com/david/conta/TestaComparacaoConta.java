package br.com.david.conta;

public class TestaComparacaoConta {

	public static void main(String[] args) {
		Conta c1 = new ContaCorrente();
		c1.setNumero(1);
		c1.setNomeDoCliente("David");
		Conta c2 = new ContaCorrente();
		c2.setNumero(1);
		c2.setNomeDoCliente("Frasson");

		if (c1 == c2) {
			System.out.println("São iguais!");
		} else {
			System.out.println("São diferentes!");
		}
		
		
		if (c1.equals(c2)) {
			System.out.println("São iguais!");
		} else {
			System.out.println("São diferentes!");
		}		
	}
}
