class ContaCorrente extends Conta{

    public void atualiza(double taxa) {
        super.atualiza(taxa * 2);
    }

    @Override
    public double getSaldo() {
        return this.saldo;
    }
}