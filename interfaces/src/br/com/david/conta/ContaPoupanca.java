package br.com.david.conta;

public class ContaPoupanca extends Conta implements Comparable<ContaPoupanca> {

    public void deposita(double valor) {
        this.saldo += (valor - 0.1);
    }
    
    @Override
    public void atualiza(double taxa) {
        this.saldo += (this.saldo * (taxa * 3));
    }

	@Override
	public int compareTo(ContaPoupanca outra) {    	
    	return this.getNomeDoCliente().compareTo(outra.getNomeDoCliente());
	}
}