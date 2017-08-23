package br.com.david.conta;

public abstract class Conta {
    protected double saldo;
    protected int numero;

    public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSaldo() {
        return this.saldo;
    }

    public void deposita(double valor) {
        this.saldo += valor;
    }

    /**
     * 
     * @param valor
     */
    public void saca(double valor) {
        this.saldo -= valor;
    }

    public abstract void atualiza(double taxa);
}