public class Conta{
   int numero;
   double limite;
   double saldo;

   public Conta(int numero, double limite) {
      this(numero, limite, 0);
   }
   
   public Conta(int numero, double limite, double saldoInicial) {
      this.numero = numero;
      this.limite = limite;
      this.saldo = saldoInicial;
   }   
   
   public void deposita(double valor){
      this.saldo += valor;      
   }
   
   public void saca(double valor){
      this.saldo -= valor;
   }
   
   public void setLimite(double limite){
      this.limite = limite;
   }
   
   public double getSaldo(){
      return this.saldo;
   }
}