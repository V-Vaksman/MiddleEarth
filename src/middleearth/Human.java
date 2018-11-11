package middleearth;

public class Human extends MiddleEarthCitizen {
    /*
    private String homeTown;
    private int age;

    public Human() {}

    public String getHomeTown() { return homeTown; }
    public void setHomeTown(String val) { homeTown = val; }
    public int getAge() { return age; }
    public void setAge(int val) { age = val; }

    public Human(String homeTown, int age, String name, double height) {
        super(name, height);
        this.homeTown = homeTown;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Человек. Имя: "+ getName() +", рост: " + getHeight() + " см, город: " + getHomeTown() + ", возраст: " + getAge();
    }
    */

    protected static final int minPower = 7;
    protected static final int maxPower = 8;

    public Human(){
        setPower(PowerCalc(minPower,maxPower));
        setRace("Человек");
    }
}