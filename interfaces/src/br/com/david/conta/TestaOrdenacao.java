package br.com.david.conta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TestaOrdenacao {
	public static void main(String args[]) {
		List<ContaPoupanca> contas = new ArrayList<>();

		Random ranNum = new Random(100);
		Random ranDeposito = new Random(9999999);
		
		
		
		for (int i = 0; i < 100; i++) {
			ContaPoupanca a = new ContaPoupanca();
			a.setNomeDoCliente("maria");
			a.setNumero(ranNum.nextInt());
			a.deposita(ranDeposito.nextDouble());
			contas.add(a);
		}
		
		contas.clear();
		ContaPoupanca b = new ContaPoupanca();
		b.setNomeDoCliente("B");
		b.setNumero(ranNum.nextInt());
		b.deposita(ranDeposito.nextDouble());
		contas.add(b);

		ContaPoupanca c = new ContaPoupanca();
		c.setNomeDoCliente("A");
		c.setNumero(ranNum.nextInt());
		c.deposita(ranDeposito.nextDouble());
		contas.add(c);
		
		Collections.sort(contas);		
		
		for (ContaPoupanca contaPoupanca : contas) {
			System.out.println(contaPoupanca);	
		}
	}
}
