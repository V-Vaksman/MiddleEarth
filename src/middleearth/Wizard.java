package middleearth;

import java.util.Random;

public class Wizard extends MiddleEarthCitizen {
    private static final int minPower = 20;
    private static final int maxPower = 20;

    public Wizard(){
        Horse horse = new Horse();
        setPower(PowerCalc(minPower,maxPower) + horse.hp);
        setRace("Чародей");
    }

    private class Horse {
        private static final int minPower = 4;
        private static final int maxPower = 5;

        private int hp;

        public Wizard getOwner()
        {
            return Wizard.this;
        }

        private Horse() {
            Random r = new Random();
            hp = minPower + r.nextInt(maxPower - minPower + 1);
        }
    }
}
