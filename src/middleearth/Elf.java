package middleearth;

import java.util.Random;

public class Elf extends MiddleEarthCitizen {
    private static final int minPower = 4;
    private static final int maxPower = 7;

    public Elf(){
        setPower(PowerCalc(minPower,maxPower));
        setRace("Эльф");
    }
}