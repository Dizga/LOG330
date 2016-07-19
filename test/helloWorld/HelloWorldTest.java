package helloWorld;

import static org.junit.Assert.*;

import org.junit.Test;

import uk.co.placona.helloWorld.HelloWorld;
import uk.co.placona.helloWorld.Calcul;

public class HelloWorldTest {

	Calcul calcul = new Calcul();
	
	@Test
	public void testHellowWorld(){
		HelloWorld hello = new HelloWorld();
		assertEquals("A test for Hello World String", "Hello World", hello.sayHello());
	}

	@Test
	public void testVarianceMax() {
		double[] tab = {Math.sqrt(Double.MAX_VALUE/2),-Math.sqrt(Double.MAX_VALUE/2)};
		assertEquals(Double.MAX_VALUE/2,calcul.Variance(tab),Double.MAX_VALUE/2);
	}
	@Test
	public void testVarianceMin() {
		double[] tab = {Math.sqrt(Double.MIN_VALUE*2),-Math.sqrt(Double.MIN_VALUE*2)};
		assertEquals(Double.MIN_VALUE,calcul.Variance(tab),1d);
	}
	@Test
	public void testVarianceInv() {
		double[] tab = {};
		assertTrue(Double.isNaN(calcul.Variance(tab)));
	}
	
	
	@Test
	public void testCorrelationMin() {
		double[][] tab = new double[3][3];
		tab[0][0] = Math.sqrt(Double.MIN_VALUE*2)*2;
		tab[0][1] = Math.sqrt(Double.MIN_VALUE*2);
		tab[0][2] = 0d;
		tab[1][0] = 0d;
		tab[1][1] = 9d;
		tab[1][2] = 18d;
		assertEquals(-1d,(calcul.Correlation(tab)),0.001d);
	}
	@Test
	public void testCorrelationMax() {
		double[][] tab = new double[3][3];
		tab[0][0] = 0d;
		tab[0][1] = Math.sqrt(Double.MIN_VALUE*2);
		tab[0][2] = Math.sqrt(Double.MIN_VALUE*2)*2;
		tab[1][0] = 0d;
		tab[1][1] = 9d;
		tab[1][2] = 18d;
		assertEquals(1d,(calcul.Correlation(tab)),0.001d);
	}
	@Test
	public void testCorrelationInv() {
		double[][] tab = new double[2][2];
		tab[0][0] = 0d;
		tab[0][1] = 0d;
		tab[1][0] = 0d;
		tab[1][1] = 0d;
		assertTrue(Double.isNaN(calcul.Correlation(tab)));
	}
	
	@Test
	public void testRegLinMax() {
		assertEquals(Double.MAX_VALUE,(calcul.RegLinB1(Double.MAX_VALUE,1d,0,0d,0d)),1d);
	}
	@Test
	public void testRegLinMin() {
		assertEquals(-Double.MAX_VALUE,(calcul.RegLinB1(-Double.MAX_VALUE,1d,0,0d,0d)),1d);
	}
	@Test
	public void testRegLinInv() {
		assertTrue(Double.isNaN(calcul.RegLinB1(0d,0d,0,0d,0d)));
	}
	
}
