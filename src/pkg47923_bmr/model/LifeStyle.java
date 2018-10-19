package pkg47923_bmr.model;

/**
 * Represents different level of life style.
 *
 * @author g47923
 */
public enum LifeStyle {

    EXTREMELY_ACTIVE(1.9) {
        @Override
        public String toString() {
            return "Extrêmement actif·ve";
        }
    },
    VERY_ACTIVE(1.725) {
        @Override
        public String toString() {
            return "Très actif·ve";
        }
    },
    ACTIVE(1.55) {
        @Override
        public String toString() {
            return "Actif·ve";
        }
    },
    NOT_MUCH_ACTIVE(1.375) {
        @Override
        public String toString() {
            return "Pas très actif·ve";
        }
    },
    SEDENTARY(1.2) {
        @Override
        public String toString() {
            return "Sédentaire";
        }
    };

    private final double factor;

    LifeStyle(double factor) {
        this.factor = factor;
    }
    
    public double getFactor() {
        return this.factor;
    }

}
