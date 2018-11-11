package middleearth;

public class Orc extends MiddleEarthCitizen {
    private static final int minPower = 8;
    private static final int maxPower = 10;

    public Orc() {
        Wolf wolf = new Wolf();
        setPower(PowerCalc(minPower,maxPower) + wolf.pow);
        setRace("Орк");
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
