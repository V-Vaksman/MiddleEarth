package middleearth;

import java.util.Random;

public class WoodenElf extends Elf {
    private static final int minPower = 6;
    private static final int maxPower = 6;

    @Override
    public String toString() {
        String str = "";
        switch (weapon) {
            case ARC:
                str += "лучник";
                break;
            case SWORD:
                str += "мечник";
                break;
        }
        return "Древесный эльф, " + str + ", сила: " + getPower();
    }

    public WoodenElf(){
        setPower(PowerCalc(minPower,maxPower));
        setRace("Древесный эльф");
    }
}