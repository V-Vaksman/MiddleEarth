package middleearth;

import java.util.Random;

public class Elf extends MiddleEarthCitizen {

    enum Weapon{
        ARC,
        SWORD
    }

    protected Weapon weapon;

    private static final int minPower = 4;
    private static final int maxPower = 7;

    @Override
    public String toString() {
        String str = "";
        switch (weapon) {
            case ARC:
                str += "-лучник";
                break;
            case SWORD:
                str += "-мечник";
                break;
        }
        return "Эльф" + str + ", сила: " + getPower();
    }

    public Elf(){
        Random r = new Random();
        setPower(PowerCalc(minPower,maxPower));
        setRace("Эльф");
        switch (r.nextInt(3)) {
            case 0:
                weapon = Weapon.SWORD;
                break;
            default:
                weapon = Weapon.ARC;
                break;
        }
    }
}