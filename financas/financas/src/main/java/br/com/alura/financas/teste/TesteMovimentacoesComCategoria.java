package br.com.alura.financas.teste;

import br.com.alura.financas.modelo.Categoria;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import javax.persistence.EntityManager;

public class TesteMovimentacoesComCategoria {
    public static void main(String[] args) {
        Categoria viagem = new Categoria("Viagem");
        Categoria negocios = new Categoria("Negócios");
        
        Conta conta = new Conta();
        conta.setId(2);
        
        Movimentacao movimentacao1 = new Movimentacao();
        movimentacao1.setData(Calendar.getInstance());
        movimentacao1.setDescricao("Viagem à SP");
        movimentacao1.setTipo(TipoMovimentacao.SAIDA);
        movimentacao1.setValor(new BigDecimal("100.0"));
        movimentacao1.setCategorias(Arrays.asList(viagem, negocios));
        movimentacao1.setConta(conta);
        
        Movimentacao movimentacao2 = new Movimentacao();
        movimentacao2.setData(Calendar.getInstance());
        movimentacao2.setDescricao("Viagem à RJ");
        movimentacao2.setTipo(TipoMovimentacao.SAIDA);
        movimentacao2.setValor(new BigDecimal("300.0"));
        movimentacao2.setCategorias(Arrays.asList(viagem, negocios));
        movimentacao2.setConta(conta);
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        
        em.persist(viagem);
        em.persist(negocios);
        em.persist(movimentacao1);
        em.persist(movimentacao2);
        
        em.getTransaction().commit();
        em.close();        
        JPAUtil.close();        
        
    }
}
