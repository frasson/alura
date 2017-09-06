package br.com.alura.financas.dao;

import javax.persistence.EntityManager;

public class MovimentacaoDAO {
    
    private EntityManager entityManager;

    public MovimentacaoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
