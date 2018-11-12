package middleearth;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.Random;

public class Goblin extends MiddleEarthCitizen {

    enum Origin{
        MORIA,
        GUNDABAD
    }

    private Origin origin;

    private static final int minPower = 2;
    private static final int maxPower = 5;

    @Override
    public String toString() {
        String str = "";
        switch (origin) {
            case MORIA:
                str += "из Мории";
                break;
            case GUNDABAD:
                str += "из Гундабада";
                break;
        }
        return "Гоблин " + str + ", сила: " + getPower();
    }

    public Goblin(){
        Random r = new Random();
        setPower(PowerCalc(minPower,maxPower));
        setRace("Гоблин");
        switch (r.nextInt(2)) {
            case 0:
                origin = Origin.MORIA;
                break;
            case 1:
                origin = Origin.GUNDABAD;
                break;
        }
    }
}