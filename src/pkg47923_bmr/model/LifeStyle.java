package pkg47923_bmr.model;

/**
 * Represents a life style.
 *
 * @author g47923
 */
public enum LifeStyle {

    /**
     * Represents an extremely active life style.
     */
    EXTREMELY_ACTIVE(1.9) {
        @Override
        public String toString() {
            return "Extrêmement actif·ve";
        }
    },

    /**
     * Represents a very active life style.
     */
    VERY_ACTIVE(1.725) {
        @Override
        public String toString() {
            return "Très actif·ve";
        }
    },

    /**
     * Represents an active life style.
     */
    ACTIVE(1.55) {
        @Override
        public String toString() {
            return "Actif·ve";
        }
    },

    /**
     * Represents a not so much active life style.
     */
    NOT_MUCH_ACTIVE(1.375) {
        @Override
        public String toString() {
            return "Pas très actif·ve";
        }
    },

    /**
     * Represents a sedentary life style.
     */
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

    /**
     * Gets a life style factor.
     *
     * @return a life style factor.
     */
    public double getFactor() {
        return this.factor;
    }

}
