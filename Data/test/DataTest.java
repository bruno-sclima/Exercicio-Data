package test;

import business.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataTest {

	Data data;
	
	@BeforeEach
	void setUp() throws ExcecaoDataInvalida {
		
		data = new Data(2021, 3,1);
	}
	
	@Test
	void testAdicionaDiasNoMes() {
		data.adicionaDias(1);
		assertEquals(2, data.getDia());
	}

	@Test
	public void testAdicionaDiasMudaMes() {
		data.adicionaDias(data.diasNoMes()+365);
		assertEquals(1, data.getDia(), "Erro no dia");
		assertEquals(4, data.getMes(), "Erro no mes");
		assertEquals(2022, data.getAno(), "Erro no ano");
	}
	
	@Test
	public void testDataRecente() {
		assertTrue(data.dataRecente(7, 4,2018));
	}
	
	@Test
	public void testAnoInvalido() {
		
		assertThrows(ExcecaoDataInvalida.class, () -> { data.setAno(-1); });
	}
	@Test
	public void testMesInvalido() {
	assertThrows(ExcecaoDataInvalida.class, () -> { data.setMes(13); } );
	
	}
	@Test
	public void testDiaInvalido() {
		
		assertThrows(ExcecaoDataInvalida.class, () -> { data.setDia(32 ); }, "Erro ao lancar ExcecaoDataInvalida no atributo dia" );
	}
}
