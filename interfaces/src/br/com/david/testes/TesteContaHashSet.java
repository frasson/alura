package br.com.david.testes;

import java.util.HashSet;
import java.util.Set;

import br.com.david.conta.Conta;
import br.com.david.conta.ContaPoupanca;

public class TesteContaHashSet {
	public static void main(String args[]) {
		Set<Conta> contas = new HashSet<>();
		
		ContaPoupanca a = new ContaPoupanca();
		a.setNomeDoCliente("a");
		a.setNumero(1);
		contas.add(a);
		
		ContaPoupanca b = new ContaPoupanca();
		b.setNomeDoCliente("b");
		b.setNumero(1);
		contas.add(b);
		
		for (Conta con : contas) {
			System.out.println(con);
		}
	}
}
