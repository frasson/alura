package br.com.caelum.leilao.matematica;

import org.junit.Assert;
import org.junit.Test;

public class MatematicaMalucaTest {

	@Test
	public void testaNumeroMaiorQueDez() {
		int numero = 11;
		MatematicaMaluca matematica = new MatematicaMaluca();
		Assert.assertEquals(numero * 3, matematica.contaMaluca(numero), 0);
	}
	
	@Test
	public void testaNumeroMaiorQueTrinta() {
		int numero = 31;
		MatematicaMaluca matematica = new MatematicaMaluca();
		Assert.assertEquals(numero * 4, matematica.contaMaluca(numero), 0);
	}
	
	@Test
	public void testaNumeroMenorOuIgualDez() {
		int numero = 10;
		MatematicaMaluca matematica = new MatematicaMaluca();
		Assert.assertEquals(numero * 2, matematica.contaMaluca(numero), 0);
	}	
}
