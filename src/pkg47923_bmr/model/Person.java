package pkg47923_bmr.model;

import java.util.Observable;

/**
 * Contains useful methods for the basal metabolic rate calculation.
 *
 * @author g47923
 */
public class Person extends Observable {

    private double bmr;
    private double calories;
    private double weight;
    private boolean isWoman;

    /**
     * Initializes this model bmr and calories to 0.
     */
    public Person() {
        this.bmr = 0;
        this.calories = 0;
    }

    /**
     * Get
     *
     * @return
     */
    public double getBmr() {
        return bmr;
    }

    public double getCalories() {
        return calories;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public boolean isWoman() {
        return isWoman;
    }

    /**
     * Calculates a basal metabolic rate for a woman.
     *
     * @param weight is the weight of the woman.
     * @param size is the size of the woman.
     * @param age is the age of the woman.
     * @return a basal metabolic rate for a woman.
     */
    double womanBMR(double weight, double size, int age) {
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
    double manBMR(double weight, double size, int age) {
        return 13.7 * weight + 5 * size - 6.8 * age + 66;
    }

    /**
     * Calculates someone's basal metabolic rate.
     *
     * @param isWoman is true if the subject is a woman.
     * @param weight is the weight of the subject.
     * @param size is the size of the subject.
     * @param age is the age of the subject.
     */
    public void setBmr(boolean isWoman, double weight, double size, int age) {
        this.weight = weight;
        this.isWoman = isWoman;
        if (isWoman) {
            this.bmr = womanBMR(weight, size, age);
        } else {
            this.bmr = manBMR(weight, size, age);
        }
        notifyView();
    }

    /**
     * Calculates the number of calories needed given a basal metabolic rate.
     *
     * @param lifeStyle is a given lifestyle.
     */
    public void setCalories(LifeStyle lifeStyle) {
        if (this.bmr == 0) {
            throw new IllegalStateException("BMR has not been calculated.");
        }
        System.out.println(bmr);
        this.calories = lifeStyle.getFactor() * this.bmr;
        notifyView();
    }

    /**
     * Notifies the view.
     */
    public void notifyView() {
        setChanged();
        notifyObservers();
    }

}
