package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Avaliador;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class AvaliadorTest {
	
	@Test
	public void deveEntenderLancesRandomicos() {
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Randomicos");

		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(joao, 450.0));
		leilao.propoe(new Lance(jose, 120.0));
		leilao.propoe(new Lance(maria, 700.0));
		leilao.propoe(new Lance(joao, 630.0));
		leilao.propoe(new Lance(jose, 230.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		double maiorEsperado = 700;
		double menorEsperado = 120;

		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
	}	

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Playstation 3 Novo");

		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		double maiorEsperado = 400;
		double menorEsperado = 250;

		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
	}
	
	@Test
	public void deveEntenderLancesEmOrdemDecrescente() {
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Playstation 3 Novo");

		leilao.propoe(new Lance(jose, 400.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(maria, 250.0));		

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		double maiorEsperado = 400;
		double menorEsperado = 250;

		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
	}	

	@Test
	public void devePegarOValorMedioDosLances() {
		Usuario david = new Usuario("David");
		Usuario paty = new Usuario("Paty");

		Leilao leilao = new Leilao("Teste média");

		leilao.propoe(new Lance(david, 50));
		leilao.propoe(new Lance(paty, 50));

		Avaliador avalia = new Avaliador();
		avalia.avalia(leilao);

		double mediaEsperada = 50;

		assertEquals(mediaEsperada, avalia.getMedia(), 0.0001);
	}
	
	@Test
	public void deveEntenderLeilaoComApenasUmLance() {
		Usuario david = new Usuario("david");
		
		Leilao leilao = new Leilao("Teste apenas um lance");
		
		leilao.propoe(new Lance(david, 500));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		assertEquals(500, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(500, leiloeiro.getMenorLance(), 0.0001);
	}	
	
	@Test
    public void deveEncontrarOsTresMaioresLances() {
        Usuario joao = new Usuario("João");
        Usuario maria = new Usuario("Maria");
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(maria, 200.0));
        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(maria, 400.0));
        leilao.propoe(new Lance(maria, 422.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        assertEquals(3, maiores.size());
        assertEquals(422, maiores.get(0).getValor(), 0.00001);
        assertEquals(400, maiores.get(1).getValor(), 0.00001);
        assertEquals(300, maiores.get(2).getValor(), 0.00001);        
    }
	
	@Test
    public void deveEncontrarApenasDoisLances() {
        Usuario joao = new Usuario("João");
        Usuario maria = new Usuario("Maria");
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(maria, 200.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        assertEquals(2, maiores.size());
        assertEquals(200, maiores.get(0).getValor(), 0.00001);
        assertEquals(100, maiores.get(1).getValor(), 0.00001);       
    }	
	
	@Test
    public void naoDeveEncontrarLances() {
        Usuario joao = new Usuario("João");
        Leilao leilao = new Leilao("Playstation 3 Novo");

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        assertEquals(0, maiores.size());
    }	
}