package pkg47923_bmr.model;

import java.util.Observable;

/**
 * Represents a person able to get her/ his BMR and her/his amount of needed
 * calories calculated.
 *
 * @author g47923
 */
public class Person extends Observable {

    private double bmr;
    private double calories;
    private int age;
    private double weight;
    private double height;
    private boolean isFemale;
    private LifeStyle lifestyle;

    /**
     * Gets this person BMR.
     *
     * @return this person BMR.
     */
    public double getBmr() {
        return bmr;
    }

    /**
     * Gets this person amount of needed calories.
     *
     * @return this person amount of needed calories.
     */
    public double getCalories() {
        return calories;
    }

    /**
     * Gets this person age.
     *
     * @return this person age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets this person weight.
     *
     * @return this person weight.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Gets this person height.
     *
     * @return this person height.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Indicates if this person is female.
     *
     * @return true if this person is female.
     */
    public boolean isFemale() {
        return isFemale;
    }

    /**
     * Gets this person life style.
     *
     * @return this person life style.
     */
    public LifeStyle getLifeStyle() {
        return lifestyle;
    }

    /**
     * Calculates this person data.
     *
     * @param isWoman tell if this person is a woman.
     * @param weight the weight of this person.
     * @param height the size of this person.
     * @param age the age of this person.
     * @param lifeStyle the life style of this person.
     */
    public void setData(boolean isWoman, double weight, double height, int age,
            LifeStyle lifeStyle) {
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.lifestyle = lifeStyle;
        this.isFemale = isWoman;
        setBmr(isWoman, weight, height, age);
        setCalories(lifeStyle);
        notifyView();
    }

    /**
     * Calculates someone's basal metabolic rate.
     *
     * @param isWoman is true if the subject is a woman.
     * @param weight is the weight of the subject.
     * @param size is the size of the subject.
     * @param age is the age of the subject.
     */
    private void setBmr(boolean isWoman, double weight, double size, int age) {
        if (isWoman) {
            this.bmr = womanBMR(weight, size, age);
        } else {
            this.bmr = manBMR(weight, size, age);
        }
    }

    /**
     * Calculates the number of calories needed given a basal metabolic rate.
     *
     * @param lifeStyle is a given lifestyle.
     */
    private void setCalories(LifeStyle lifeStyle) {
        this.calories = lifeStyle.getFactor() * this.bmr;
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
     * Notifies the view.
     */
    private void notifyView() {
        setChanged();
        notifyObservers();
    }

}
