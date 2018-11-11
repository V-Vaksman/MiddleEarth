package middleearth;

import java.util.Random;

public class Wizard extends MiddleEarthCitizen {
    private static final int minPower = 20;
    private static final int maxPower = 20;

    public Wizard(){
        Horse horse = new Horse();
        Random r = new Random();
        int randPower = minPower + r.nextInt(maxPower - minPower + 1);
        setPower(randPower + horse.hp);
        setRace("Чародей");
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

        public Rohhirim getOwner()
        {
            return Rohhirim.this;
        }
        */

        private Horse() {
            Random r = new Random();
            hp = minPower + r.nextInt(maxPower - minPower + 1);
        }
    }
}
