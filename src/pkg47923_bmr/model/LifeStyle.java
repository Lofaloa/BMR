package pkg47923_bmr.model;

/**
 * Represents different level of life style.
 *
 * @author g47923
 */
public enum LifeStyle {

    EXTREMELY_ACTIVE(1.9),
    VERY_ACTIVE(1.725),
    ACTIVE(1.55),
    NOT_MUCH_ACTIVE(1.375),
    SEDENTARY(1.2);

    private final double factor;

    LifeStyle(double factor) {
        this.factor = factor;
    }
    
    public double getFactor() {
        return this.factor;
    }

}
