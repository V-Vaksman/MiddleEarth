package middleearth;

public class UrukHai extends Orc {
    private static final int minPower = 10;
    private static final int maxPower = 12;

    public UrukHai(){
        setPower(PowerCalc(minPower,maxPower));
        setRace("Урук-хай");
    }
}
