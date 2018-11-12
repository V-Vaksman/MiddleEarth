package middleearth;

import java.io.Serializable;
import java.util.ArrayList;

public class Army implements Serializable {
    public ArrayList<MiddleEarthCitizen> infantry;
    public ArrayList<MiddleEarthCitizen> cavalry;

    public Army(){
        infantry = new ArrayList<MiddleEarthCitizen>();
        cavalry = new ArrayList<MiddleEarthCitizen>();
    }

    public void Print(){
        if (cavalry.size() > 0) {
            System.out.println("Кавалерия:");
            for (MiddleEarthCitizen warrior : cavalry) {
                System.out.println(warrior.toString());
            }
            System.out.println();
        }
        if (infantry.size() > 0) {
            System.out.println("Пехота:");
            for (MiddleEarthCitizen warrior : infantry) {
                System.out.println(warrior.toString());
            }
        }
    }
}
