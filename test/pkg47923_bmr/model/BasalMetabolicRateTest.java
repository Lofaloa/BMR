package pkg47923_bmr.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the basal metabolic rate calculation.
 * 
 * @author g47923
 */
public class BasalMetabolicRateTest {
    
    @Test
    public void testManBMR() {
        assertEquals(1858, BasalMetabolicRate.manBMR(80.0, 180.0, 30), 1);
    }
    
    @Test
    public void testWomanBMR() {
        assertEquals(1606, BasalMetabolicRate.womanBMR(80.0, 180.0, 30), 1);
    }
    
    @Test
    public void testnbCaloriesNeeded() {
        double bmr = BasalMetabolicRate.womanBMR(80.0, 180.0, 30);
        assertEquals(2489.3, BasalMetabolicRate.calories(bmr, LifeStyle.ACTIVE), 1);
    }
    
}
