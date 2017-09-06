package br.com.alura.financas.teste;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class TestaJpqlAvancada {

    public static void main(String[] args) {

        EntityManager manager = new JPAUtil().getEntityManager();

        Conta conta = new Conta();
        conta.setId(3);

        String jpql = "select sum(m.valor) from Movimentacao m where m.conta=:pConta "
                + "and m.tipoMovimentacao=:pTipo";

        Query query = manager.createQuery(jpql);

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        BigDecimal resultado = (BigDecimal) query.getSingleResult();

        System.out.println("Total movimentado ..: R$ " + resultado);
    }
}
