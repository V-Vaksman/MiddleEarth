package middleearth;

import java.util.Random;

public class Human extends MiddleEarthCitizen {

    protected int age;

    @Override
    public String toString() {
        String str;
        switch (age % 10){
            case 1:
                str = "год";
                break;
            case 2:
            case 3:
            case 4:
                str = "года";
                break;
            default:
                str = "лет";
                break;
        }
        return "Человек, " + age + " " + str + " от роду, сила: " + getPower();
    }

    protected static final int minPower = 7;
    protected static final int maxPower = 8;

    public Human(){
        Random r = new Random();
        setPower(PowerCalc(minPower,maxPower));
        setRace("Человек");
        age = 18 + r.nextInt(33);
    }
}