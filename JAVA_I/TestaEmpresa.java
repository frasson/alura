public class TestaEmpresa{
   public static void main(String args[]){
      Empresa empresa = new Empresa();
		empresa.setNome("Atena Informatica");
		empresa.setCnpj("00.000.000/0000-00");
      
        Funcionario f1 = new Funcionario("David");
        f1.setDepartamento("Casa");
        f1.setSalario(100);
        f1.bonifica(50);
        f1.setDataEntradaBanco(new Data(1, 7, 2009));
        f1.setRg("999");        
        empresa.addFuncionario(f1);
        
        empresa.mostraFuncionarios();
   }   
}