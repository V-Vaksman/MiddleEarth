package middleearth;

import java.io.Serializable;
import java.util.Random;

public abstract class MiddleEarthCitizen implements Serializable {
    private int power;
    public int getPower() { return power; }
    public void setPower(int power) { this.power = power; }

    private String race;
    public String getRace() { return race; }
    public void setRace(String race) { this.race = race; }

    /*
    private String name;
    private double height;
    static private String origin = "Средиземье";

    public String getName() { return name; }
    public void setName(String val) { name = val; }
    public double getHeight() { return height; }
    public void setHeight(double val) { height = val; }
    static public String getCountryOrigin() { return origin; }

    public double heightToMeters() {
        return height/100;
    }

    public MiddleEarthCitizen(String name, double height) {
        this.name = name;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Житель средиземья. Имя: "+ getName() + ", рост: " + getHeight() + " см";
    }
    */

    public MiddleEarthCitizen(int power){
        this.power = power;
    }

    public MiddleEarthCitizen() {}

    public int PowerCalc(int min, int max){
        Random r = new Random();
        int randPower = min + r.nextInt(max - min + 1);
        return randPower;
    }

    @Override
    public String toString() {
        return getRace() + ", сила: " + getPower();
    }
}