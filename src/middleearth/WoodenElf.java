package middleearth;

import java.util.Random;

public class WoodenElf extends Elf {
    private static final int minPower = 6;
    private static final int maxPower = 6;

    public WoodenElf(){
        setPower(PowerCalc(minPower,maxPower));
        setRace("Древесный эльф");
    }
}