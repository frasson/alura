package br.com.alura.alura_lib.factory;

import br.com.alura.alura_lib.dao.DAO;
import java.lang.reflect.ParameterizedType;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@SuppressWarnings("unchecked")
public class DAOFactory {

    @Inject
    private EntityManager manager;

    @Produces
    public <T> DAO<T> factory(InjectionPoint point) {
        ParameterizedType type = (ParameterizedType) point.getType();

        Class<T> classe = (Class<T>) type.getActualTypeArguments()[0];

        return new DAO<T>(classe, manager);
    }
}