package middleearth;

import java.util.Random;

public class Orc extends MiddleEarthCitizen {

    enum Country{
        MORDOR,
        IZENGARD
    }

    protected Country country;

    @Override
    public String toString() {
        String str = "";
        switch (country) {
            case MORDOR:
                str += "Мордора";
                break;
            case IZENGARD:
                str += "Изенгарда";
                break;
        }
        return "Орк из " + str + ", сила: " + getPower();
    }

    private static final int minPower = 8;
    private static final int maxPower = 10;

    public Orc() {
        Random r = new Random();
        Wolf wolf = new Wolf();
        setPower(PowerCalc(minPower,maxPower) + wolf.pow);
        setRace("Орк");
        switch (r.nextInt(2)) {
            case 0:
                country = Country.MORDOR;
                break;
            case 1:
                country = Country.IZENGARD;
                break;
        }
    }

    private class Wolf {
        private static final int minPower = 4;
        private static final int maxPower = 7;

        private int pow;

        private Wolf() {
            pow = PowerCalc(minPower, maxPower);
        }
    }
}
