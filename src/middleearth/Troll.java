package middleearth;

public class Troll extends MiddleEarthCitizen {
    /*
    enum Type{
        STONE,
        CAVE,
        HILL,
        SNOW;
    }

    private Type type;

    public Type getType() { return type; }
    public void setType(Type type) { this.type = type; }

    public Troll() {}

    public Troll(String name, double height, Type type) {
        super(name, height); this.type = type;
    }*/

    private static final int minPower = 11;
    private static final int maxPower = 15;

    public Troll(){
        setPower(PowerCalc(minPower,maxPower));
        setRace("Тролль");
    }
}
