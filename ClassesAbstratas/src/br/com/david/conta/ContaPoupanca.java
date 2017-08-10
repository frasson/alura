package br.com.david.conta;

class ContaPoupanca extends Conta{

    public void deposita(double valor) {
        this.saldo += (valor - 0.1);
    }
    
    @Override
    public void atualiza(double taxa) {
        this.saldo += (this.saldo * (taxa * 3));
    }
}