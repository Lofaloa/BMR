package pkg47923_bmr.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests a person.
 *
 * @author g47923
 */
public class PersonTest {

    @Test
    public void femaleWithSetDataShouldHaveExtpectedState() {
        Person p = new Person();
        p.setData(true, 80.0, 175.0, 20, LifeStyle.ACTIVE);
        assertTrue(p.isFemale());
        assertEquals(80.0, p.getWeight(), 0);
        assertEquals(175.0, p.getHeight(), 0);
        assertEquals(20, p.getAge());
        assertEquals(LifeStyle.ACTIVE, p.getLifeStyle());
        assertEquals(p.womanBMR(80.0, 175.0, 20), p.getBmr(), 0);
        assertEquals(LifeStyle.ACTIVE.getFactor() * p.getBmr(), p.getCalories(), 0);
    }

    @Test
    public void maleWithSetDataShouldHaveExtpectedState() {
        Person p = new Person();
        p.setData(false, 80.0, 175.0, 20, LifeStyle.ACTIVE);
        assertFalse(p.isFemale());
        assertEquals(80.0, p.getWeight(), 0);
        assertEquals(175.0, p.getHeight(), 0);
        assertEquals(20, p.getAge());
        assertEquals(LifeStyle.ACTIVE, p.getLifeStyle());
        assertEquals(p.manBMR(80.0, 175.0, 20), p.getBmr(), 0);
        assertEquals(LifeStyle.ACTIVE.getFactor() * p.getBmr(), p.getCalories(), 0);
    }

}
