package middleearth;

public class UrukHai extends Orc {
    private static final int minPower = 10;
    private static final int maxPower = 12;

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
        return "Урук-хай из " + str + ", сила: " + getPower();
    }

    public UrukHai(){
        setPower(PowerCalc(minPower,maxPower));
        setRace("Урук-хай");
    }
}
