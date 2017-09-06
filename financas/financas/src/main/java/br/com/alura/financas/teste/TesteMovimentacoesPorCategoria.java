package br.com.alura.financas.teste;

import br.com.alura.financas.modelo.Categoria;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class TesteMovimentacoesPorCategoria {

    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Categoria categoria = new Categoria();
        categoria.setId(1);
        Query query = em.createQuery("select m from Movimentacao m join m.categoria c where c = :pCategoria");
        query.setParameter("pCategoria", categoria);

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
