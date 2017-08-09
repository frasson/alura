package interfaces.exercicio02;

public abstract class Conta {
    protected double saldo;

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
}