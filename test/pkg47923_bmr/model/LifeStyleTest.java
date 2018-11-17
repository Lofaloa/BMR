package pkg47923_bmr.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests a LifeStyle
 *
 * @author g47923
 */
public class LifeStyleTest {

    @Test
    public void valuesShouldHaveExpectedFactor() {
        assertEquals(1.9, LifeStyle.values()[0].getFactor(), 0);
        assertEquals(1.725, LifeStyle.values()[1].getFactor(), 0);
        assertEquals(1.55, LifeStyle.values()[2].getFactor(), 0);
        assertEquals(1.375, LifeStyle.values()[3].getFactor(), 0);
        assertEquals(1.2, LifeStyle.values()[4].getFactor(), 0);
    }

    @Test
    public void valuesOf() {
        assertEquals(LifeStyle.EXTREMELY_ACTIVE, LifeStyle.valueOf("EXTREMELY_ACTIVE"));
        assertEquals(LifeStyle.VERY_ACTIVE, LifeStyle.valueOf("VERY_ACTIVE"));
        assertEquals(LifeStyle.ACTIVE, LifeStyle.valueOf("ACTIVE"));
        assertEquals(LifeStyle.NOT_MUCH_ACTIVE, LifeStyle.valueOf("NOT_MUCH_ACTIVE"));
        assertEquals(LifeStyle.SEDENTARY, LifeStyle.valueOf("SEDENTARY"));
    }

}
