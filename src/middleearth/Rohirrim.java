package middleearth;


public class Rohirrim extends Human {
    /*
    public Rohirrim(String name, int age){
        super("Рохан",age,name,170);
    }
    */

    public Rohirrim() {
        Horse horse = new Horse();
        setPower(PowerCalc(minPower,maxPower) + horse.hp);
        setRace("Рохиррим");
    }

    private class Horse {
        private static final int minPower = 4;
        private static final int maxPower = 5;

        private int hp;

        /*
        private String color;
        private String breed;

        public String getBreed() { return breed; }
        public String getColor() { return color; }

        public void setBreed(String breed) { this.breed = breed; }
        public void setColor(String color) { this.color = color; }

        public Horse(String color, String breed) {
            this.color = color;
            this.breed = breed;
        }

        public Rohirrim getOwner()
        {
            return Rohirrim.this;
        }
        */

        private Horse() {
            hp = PowerCalc(minPower, maxPower);
        }
    }
}