package br.com.alura.financas.teste;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;
import java.math.BigDecimal;
import java.util.Calendar;
import javax.persistence.EntityManager;

public class TesteJPARelacionamento {
    public static void main(String[] args) {

        Conta conta = new Conta();
        conta.setAgencia("0102");
        conta.setBanco("Itau");
        conta.setNumero("1010");
        conta.setTitular("David");
        
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(Calendar.getInstance());
        movimentacao.setDescricao("Churrascaria");
        movimentacao.setTipo(TipoMovimentacao.SAIDA);
        movimentacao.setValor(new BigDecimal("200.0"));
        movimentacao.setConta(conta);        

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        
        //Primeiro tem que persistir a conta para que ela exista no banco
        em.persist(conta);
        
        //Depois pode ser persistida a movimentação, pois já existe a conta para fazer o relacionamento
        em.persist(movimentacao);
        
        em.getTransaction().commit();
        em.close();        
        JPAUtil.close();
    }    
}
