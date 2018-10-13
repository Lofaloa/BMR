package pkg47923_bmr.model;

/**
 * Contains useful for the basal metabolic rate calculation.
 *
 * @author g47923
 */
public class BasalMetabolicRate {
    
    /**
     * Calculates a basal metabolic rate for a woman.
     *
     * @param weight is the weight of the woman.
     * @param size is the size of the woman.
     * @param age is the age of the woman.
     * @return a basal metabolic rate for a woman.
     */
    static double womanBMR(double weight, double size, int age) {
        return 9.6 * weight + 1.8 * size - 4.7 * age + 655;
    }

    /**
     * Calculates a basal metabolic rate for a man.
     *
     * @param weight is the weight of the man.
     * @param size is the size of the man.
     * @param age is the age of the man.
     * @return a basal metabolic rate for a man.
     */
    static double manBMR(double weight, double size, int age) {
        return 13.7 * weight + 5 * size - 6.8 * age + 66;
    }
    
    /**
     * Calculates someone's basal metabolic rate.
     *
     * @param isWoman is true if the subject is a woman.
     * @param weight is the weight of the subject.
     * @param size is the size of the subject.
     * @param age is the age of the subject.
     * @return a basal metabolic rate for a subject.
     */
    public static double BMR(boolean isWoman, double weight, double size, int age) {
        if (isWoman) {
            return womanBMR(weight, size, age);
        } else {
            return manBMR(weight, size, age);
        }
    }

    /**
     * Calculates the number of calories needed given a basal metabolic rate.
     *
     * @param BMR is a given BMR.
     * @param lifeStyle is a given lifestyle.
     * @return the number of calories needed given a basal metabolic rate.
     */
    public static double calories(double BMR, LifeStyle lifeStyle) {
        return lifeStyle.getFactor() * BMR;
    }

}
