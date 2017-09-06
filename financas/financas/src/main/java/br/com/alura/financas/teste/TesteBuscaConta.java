package br.com.alura.financas.teste;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

import javax.persistence.EntityManager;

public class TesteBuscaConta {

    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = em.find(Conta.class, 1);

        em.getTransaction().commit();
        em.close();
    }

}