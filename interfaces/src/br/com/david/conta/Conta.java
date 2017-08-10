package br.com.david.conta;

public abstract class Conta {
    protected double saldo;
    private int numero;
    private String nomeDoCliente;
    
    public String getNomeDoCliente() {
		return nomeDoCliente;
	}

	public void setNomeDoCliente(String nomeDoCliente) {
		this.nomeDoCliente = nomeDoCliente;
	}

	public void setNumero(int numero) {
    	this.numero = numero;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void deposita(double valor) throws ValorInvalidoException {
    	if (valor < 0) {
    		throw new ValorInvalidoException("O valor passado " + valor + " é inválido!");
    	} else {
    		this.saldo += valor;	
    	}
    }

    public void saca(double valor) {
        this.saldo -= valor;
    }

    public abstract void atualiza(double taxa);
    
    @Override
    public String toString() {
    	return "esse objeto é uma conta com saldo R$" + this.saldo;
    }
    
    @Override
    public boolean equals(Object obj) {
    	Conta outraConta = (Conta) obj;
    	return (this.numero == outraConta.numero && 
    			this.nomeDoCliente.equals(outraConta.nomeDoCliente)) ;
    }
}