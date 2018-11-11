package middleearth;

import java.util.ArrayList;

public class Army {
    public ArrayList<MiddleEarthCitizen> infantry;
    public ArrayList<MiddleEarthCitizen> cavalry;

    public Army(){
        infantry = new ArrayList<MiddleEarthCitizen>();
        cavalry = new ArrayList<MiddleEarthCitizen>();
    }

    public void Print(){

        System.out.println("Кавалерия:");
        for (MiddleEarthCitizen warrior : cavalry) {
            System.out.println(warrior.toString());
        }
        System.out.println("\nПехота:");
        for (MiddleEarthCitizen warrior : infantry) {
            System.out.println(warrior.toString());
        }
    }
}
