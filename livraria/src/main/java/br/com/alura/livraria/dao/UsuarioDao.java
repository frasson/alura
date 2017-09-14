package br.com.alura.livraria.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.alura.livraria.modelo.Usuario;
import javax.inject.Inject;

public class UsuarioDao {

    @Inject
    private EntityManager em;

    public boolean existe(Usuario usuario) {

        TypedQuery<Usuario> query = em.createQuery(
                " select u from Usuario u "
                + " where u.email = :pEmail and u.senha = :pSenha", Usuario.class);

        query.setParameter("pEmail", usuario.getEmail());
        query.setParameter("pSenha", usuario.getSenha());
        try {
            query.getSingleResult();
        } catch (NoResultException ex) {
            return false;
        }

        em.close();

        return true;
    }

}
