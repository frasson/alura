package br.com.alura.financas.teste;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.util.JPAUtil;
import javax.persistence.EntityManager;

public class TesteMovimentacaoConta {
    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        Movimentacao movimentacao = em.find(Movimentacao.class, 3);
        Conta conta = movimentacao.getConta();
        
                
        System.out.println("Titular: " + conta.getTitular());
        System.out.println("Movimentacoes: " + conta.getMovimentacoes().size());
        em.close();
        JPAUtil.close();        
    }
    
}
