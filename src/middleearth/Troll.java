package middleearth;

import java.util.Random;

public class Troll extends MiddleEarthCitizen {

    enum Type{
        STONE,
        CAVE,
        HILL,
        SNOW;
    }

    private Type type;

    private static final int minPower = 11;
    private static final int maxPower = 15;

    @Override
    public String toString() {
        String str = "";
        switch (type) {
            case STONE:
                str += "Каменный";
                break;
            case CAVE:
                str += "Пещерный";
                break;
            case HILL:
                str += "Холмовой";
                break;
            case SNOW:
                str += "Снежный";
                break;
        }
        return str + " тролль" + ", сила: " + getPower();
    }

    public Troll() {
        Random r = new Random();
        setPower(PowerCalc(minPower, maxPower));
        setRace("Тролль");
        switch (r.nextInt(4)) {
            case 0:
                type = Type.STONE;
                break;
            case 1:
                type = Type.CAVE;
                break;
            case 2:
                type = Type.HILL;
                break;
            case 3:
                type = Type.SNOW;
                break;
        }
    }
}
