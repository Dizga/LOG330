package helloWorld;

import static org.junit.Assert.*;

import org.junit.Test;

import uk.co.placona.helloWorld.HelloWorld;
import uk.co.placona.helloWorld.Calcul;

public class HelloWorldTest {

	double tab[] = {2d,1d,3d,4d};
	Calcul calcul = new Calcul();
	
	@Test
	public void testHellowWorld(){
		HelloWorld hello = new HelloWorld();
		assertEquals("A test for Hello World String", "Hello World", hello.sayHello());
	}

	@Test
	public void testTest() {
		assertEquals(1.25d,calcul.Variance(tab),0.01d);
	}
}
