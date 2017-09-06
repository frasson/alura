package br.com.alura.financas.teste;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class TesteJPQL {

    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = new Conta();
        conta.setId(2);
        Query query = em
                .createQuery("select m from Movimentacao m where m.conta = :pConta"
                        + " and m.tipo = :pTipo"
                        + " order by m.valor desc");

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        List<Movimentacao> resultados = query.getResultList();

        for (Movimentacao resultado : resultados) {
            System.out.println("Descricao: " + resultado.getDescricao());
            System.out.println("Conta: " + resultado.getConta().getId());
        }

        em.getTransaction().commit();
        em.close();
        JPAUtil.close();
    }
}
