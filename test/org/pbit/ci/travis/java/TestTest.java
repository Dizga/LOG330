package org.pbit.ci.travis.java;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TestTest {
	
	double tab[] = {2d,1d,3d,4d};
	Calcul calcul = new Calcul;
	
    @Test
    public void testTest() {
	assertTrue(1 == 1);
	assertTrue(calcul.Variance(tab) == 1.25d)
    }
}

