import java.util.ArrayList;
import java.util.Random;
import middleearth.*;
//import static middleearth.MiddleEarthCitizen.getCountryOrigin;

public class Main {

    public static int RandBetween(int min, int max){
        Random r = new Random();
        return min + r.nextInt(max - min + 1);
    }

    public static void main(String[] args) {
        final int maxCount = 12;
        final int minCount = 8;

        Random r = new Random();

        Army Light = new Army();
        Army Dark = new Army();

        int lightCount = RandBetween(minCount,maxCount);
        int darkCount = RandBetween(minCount,maxCount);

        if (r.nextBoolean()) {
            Light.cavalry.add(new Wizard());
            System.out.println("Светлая армия заручилась поддержкой чародея!");
            lightCount--;
        }

        for(int i = 0; i < lightCount; i++){
            int elem = r.nextInt(4);
            switch (elem) {
                case 0:
                    Light.infantry.add(new Human());
                    break;
                case 1:
                    Light.cavalry.add(new Rohirrim());
                    break;
                case 2:
                    Light.infantry.add(new Elf());
                    break;
                case 3:
                    Light.infantry.add(new WoodenElf());
                    break;
            }
        }

        for(int i = 0; i < darkCount; i++){
            int elem = r.nextInt(4);
            switch (elem) {
                case 0:
                    Dark.cavalry.add(new Orc());
                    break;
                case 1:
                    Dark.infantry.add(new UrukHai());
                    break;
                case 2:
                    Dark.infantry.add(new Goblin());
                    break;
                case 3:
                    Dark.infantry.add(new Troll());
                    break;
            }
        }

        System.out.println("СВЕТЛАЯ АРМИЯ ("+(Light.cavalry.size()+Light.infantry.size())+"):");
        Light.Print();
        System.out.println("\nТЕМНАЯ АРМИЯ ("+(Dark.cavalry.size()+Dark.infantry.size())+"):");
        Dark.Print();

        System.out.println("\nРаунд 1 - всадники");
        if (Light.cavalry.size()>0 && Dark.cavalry.size()>0)
            Round(Light.cavalry, Dark.cavalry,0);

        System.out.println("\nРаунд 2 - пехота");
        if (Light.infantry.size()>0 && Dark.infantry.size()>0)
            Round(Light.infantry, Dark.infantry,0);

        if (Light.cavalry.size()>0 && Light.infantry.size()>0)
            System.out.println("\nПобедила светлая армия! "+(Light.cavalry.size()+Light.infantry.size())+" выживших");
        else if (Dark.cavalry.size()>0 && Dark.infantry.size()>0)
            System.out.println("\nПобедила темная армия! "+(Dark.cavalry.size()+Dark.infantry.size())+" выживших");
        else {
            System.out.println("\nРаунд 3 - недобитки");
            if (Light.cavalry.size()>0)
                Round(Light.cavalry,Dark.infantry,1);
            else
                Round(Light.infantry,Dark.cavalry,2);
            if (Light.infantry.size()>0 || Light.cavalry.size()>0) System.out.println("\nСветлая армия в решающей схватке одержала верх! "+(Light.cavalry.size()+Light.infantry.size())+" выживших");
            else System.out.println("\nТемная армия в решающей схватке одержала верх! "+(Dark.cavalry.size()+Dark.infantry.size())+" выживших");
        }
    }

    public static void Round(ArrayList<MiddleEarthCitizen> Light, ArrayList<MiddleEarthCitizen> Dark, int PriorNum){
        Random r = new Random();
        do {
            int goodGuy = RandBetween(0,Light.size()-1);
            int goodPow = Light.get(goodGuy).getPower();
            String goodName = Light.get(goodGuy).getRace();
            int badGuy = RandBetween(0,Dark.size()-1);
            int badPow = Dark.get(badGuy).getPower();
            String badName = Dark.get(badGuy).getRace();
            boolean enough = false;
            System.out.println("\n"+goodName+" ("+goodPow+") vs "+badName+" ("+badPow+")");

            if (PriorNum == 1 || (r.nextBoolean() && PriorNum != 2)) { // Если приоритет у светлого или рандом и нет приоритета у темного
                enough = Punch(goodPow, badGuy, badPow, badName, Dark); // Бьет светлый
            }
            while (!enough) {
                badPow = Dark.get(badGuy).getPower();
                enough = Punch(badPow, goodGuy, goodPow, goodName, Light); // Бьет темный
                if (!enough) {
                    goodPow = Light.get(goodGuy).getPower();
                    enough = Punch(goodPow, badGuy, badPow, badName, Dark); // Бьет светлый
                }
            }
        } while (Light.size() > 0 && Dark.size() > 0);
    }

    public static boolean Punch(int attackerPow, int defenderNum, int defenderPow, String defenderName, ArrayList<MiddleEarthCitizen> defenders){
        boolean exit = false;
        if (defenderPow-attackerPow <= 0) {
            System.out.println(defenderName+" в нокауте!");
            defenders.remove(defenderNum);
            exit = true;
        }
        else {
            defenderPow -= attackerPow;
            defenders.get(defenderNum).setPower(defenderPow);
            System.out.println(defenderName+" -"+attackerPow+" HP");
        }
        return exit;
    }
}
