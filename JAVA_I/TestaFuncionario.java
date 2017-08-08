class TestaFuncionario {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario("David");
        f1.setDepartamento("Casa");
        f1.setSalario(100);
        f1.bonifica(50);
        f1.setDataEntradaBanco(new Data(1, 7, 2009));
        f1.setRg("999");

        f1.mostra();

        Funcionario f2 = new Funcionario("Pedro");
        f2.setDepartamento("RH");
        f2.setSalario(50);
        f2.bonifica(10);
        f2.setDataEntradaBanco(new Data(1, 7, 2005));
        f2.setRg("888");

        f2.mostra();
    }
}