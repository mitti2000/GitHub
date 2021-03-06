package ch.mitti.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BankkontoTest {
	private Bankkonto b;
	
	@Before
	public void setUp() throws Exception {
		b = new Bankkonto("Max Muster", 1000.00);
	}

	@Ignore
	public void test() {
		//Bankkonto b = new Bankkonto();
		assertNotNull("Objekt konnte nicht instantiiert werden.");
	}
	
	@Ignore
	public void bankkontoMitArgumentenInstantiieren(){
	}
	
	@Test
	public void gibBesitzerVonKonto(){
		assertTrue(b.gibBesitzer().equals("Max Muster"));
	}
	
	@Test
	public void gibKontostand(){
		assertEquals(1000.00, b.gibKontostand(), 0.0);
	}

}
