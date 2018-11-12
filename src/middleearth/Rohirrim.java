package middleearth;


public class Rohirrim extends Human {

    public Rohirrim() {
        Horse horse = new Horse();
        setPower(PowerCalc(minPower,maxPower) + horse.hp);
        setRace("Рохиррим");
    }

    @Override
    public String toString() {
        String str;
        switch (age % 10){
            case 1:
                str = "год";
                break;
            case 2:
            case 3:
            case 4:
                str = "года";
                break;
            default:
                str = "лет";
                break;
        }
        return "Рохиррим, " + age + " " + str + " от роду, сила: " + getPower();
    }

    private class Horse {
        private static final int minPower = 4;
        private static final int maxPower = 5;

        private int hp;

        public Rohirrim getOwner()
        {
            return Rohirrim.this;
        }

        private Horse() {
            hp = PowerCalc(minPower, maxPower);
        }
    }
}