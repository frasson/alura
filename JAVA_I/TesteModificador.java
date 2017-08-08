class TesteModificador {
    public static void main(String args[]) {

        Conta joao = new Conta(123, 100);
        joao.deposita(500.0);

        double valorASerSacado = 600;
        joao.saca(valorASerSacado);

        System.out.println(joao.getSaldo());
    }
}