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