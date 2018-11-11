package middleearth;

public class Goblin extends MiddleEarthCitizen {
    private static final int minPower = 2;
    private static final int maxPower = 5;

    public Goblin(){
        setPower(PowerCalc(minPower,maxPower));
        setRace("Гоблин");
    }
}