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
		double[] tab = {Math.sqrt(Double.MAX_VALUE/2),-Math.sqrt(Double.MIN_VALUE/2)};
		assertEquals(Double.MAX_VALUE,calcul.Variance(tab),1d);
	}
	@Test
	public void testVarianceMin() {
		double[] tab = {Math.sqrt(Double.MIN_VALUE*2),-Math.sqrt(Double.MIN_VALUE*2)};
		assertEquals(Double.MIN_VALUE,calcul.Variance(tab),Double.MIN_VALUE);
	}
}
