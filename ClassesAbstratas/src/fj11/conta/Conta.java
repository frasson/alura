package fj11.conta;

public abstract class Conta {
    protected double saldo;

    public double getSaldo() {
        return this.saldo;
    }

    public void deposita(double valor) {
        this.saldo += valor;
    }

    public void saca(double valor) {
        this.saldo -= valor;
    }

    public abstract void atualiza(double taxa);
}