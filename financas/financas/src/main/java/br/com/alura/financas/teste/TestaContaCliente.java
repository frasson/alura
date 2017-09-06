package br.com.alura.financas.teste;

import br.com.alura.financas.modelo.Cliente;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;
import javax.persistence.EntityManager;

public class TestaContaCliente {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente();
        cliente1.setNome("David");
        cliente1.setEndereco("Rua Fulano, 123");
        cliente1.setProfissao("Professor");
        
        Conta conta = new Conta();
        conta.setId(1);
        
        cliente1.setConta(conta);
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        em.persist(cliente1);
        
        em.getTransaction().commit();
        em.close();     
        JPAUtil.close();
    }
}
