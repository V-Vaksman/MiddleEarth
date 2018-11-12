import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import middleearth.*;
//import static middleearth.MiddleEarthCitizen.getCountryOrigin;

public class Main {

    public static String filename = "winners.out";

    public static int RandBetween(int min, int max) // Генерация случайного целого числа от min до max
    {
        Random r = new Random();
        return min + r.nextInt(max - min + 1);
    }

    public static void WriteToFile(Army army, String filename)
    {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(army);
            oos.flush();
            oos.close();
            fos.close();
            System.out.println("\nПредания о победившей армии сохранены в файл " + filename);
        }
        catch (Exception e)
        {
            System.out.println("\nОшибка: " + e.getMessage());
        }
    }

    public static void ReadFromFile(String filename){

        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream oin = new ObjectInputStream(fis);
            Army army = (Army) oin.readObject();
            System.out.println("Сохранились сведения о Предпоследней битве Средиземья!\nВот имена героев:");
            army.Print();
        }
        catch (Exception e) {}
    }

    public static void main(String[] args) {

        ReadFromFile(filename);
        // Размеры армий генерируются в этих пределах
        final int maxCount = 12;
        final int minCount = 8;

        Random r = new Random();

        Army Light = new Army();
        Army Dark = new Army();

        int lightCount = RandBetween(minCount,maxCount);
        int darkCount = RandBetween(minCount,maxCount);

        System.out.println("И началась Последняя битва Средиземья!");

        // Случайное добавление чародея
        if (r.nextBoolean()) {
            Light.cavalry.add(new Wizard());
            System.out.println("\nСветлая армия заручилась поддержкой чародея!");
            lightCount--;
        }

        // Случайное заполнение армий
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

        System.out.println("*** СВЕТЛАЯ АРМИЯ ("+(Light.cavalry.size()+Light.infantry.size())+") ***");
        Light.Print();
        System.out.println("\n*** ТЕМНАЯ АРМИЯ ("+(Dark.cavalry.size()+Dark.infantry.size())+") ***");
        Dark.Print();

        System.out.println("\n*** Раунд 1 - всадники ***");
        if (Light.cavalry.size()>0 && Dark.cavalry.size()>0)
            Round(Light.cavalry, Dark.cavalry, false); // Всадники сражаются со всадниками
        else System.out.println("\nРаунд не состоялся");

        System.out.println("\n*** Раунд 2 - пехота ***");
        if (Light.infantry.size()>0 && Dark.infantry.size()>0)
            Round(Light.infantry, Dark.infantry, false); // Пехотинцы сражаются с пехотинцами
        else System.out.println("\nРаунд не состоялся");

        if (Light.cavalry.size()>0 && Light.infantry.size()>0)
            System.out.println("\nПобедила светлая армия! "+(Light.cavalry.size()+Light.infantry.size())+" выживших");
        else if (Dark.cavalry.size()>0 && Dark.infantry.size()>0)
            System.out.println("\nПобедила темная армия! "+(Dark.cavalry.size()+Dark.infantry.size())+" выживших");
        else {
            System.out.println("\n*** Раунд 3 - решающий бой ***");
            if (Light.cavalry.size()>0)
                Round(Light.cavalry, Dark.infantry, true); // Выжившие всадники сражаются с выжившими пехотинцами
            else
                Round(Dark.cavalry, Light.infantry,true);
            if (Light.infantry.size()>0 || Light.cavalry.size()>0)
                System.out.println("\nСветлая армия в решающей схватке одержала верх! Выживших: "+(Light.cavalry.size()+Light.infantry.size()));
            else System.out.println("\nТемная армия в решающей схватке одержала верх! Выживших: "+(Dark.cavalry.size()+Dark.infantry.size()));
        }

        // Вывод победителя в файл
        if (Light.infantry.size() > 0 || Light.cavalry.size() > 0)
            WriteToFile(Light, filename);
        else
            WriteToFile(Dark, filename);

        //java -jar C:\Users\user\jar_name.jar
    }

    // в Round, Duel и Punch - "первый" и "второй" не связаны, это локальные обозначения

    public static void Round(ArrayList<MiddleEarthCitizen> first, ArrayList<MiddleEarthCitizen> second, boolean firstPrior) // Раунд битвы
    {
        Random r = new Random();
        do {
            // выбор случайного воина
            int firstNum = RandBetween(0,first.size()-1);
            int secondNum = RandBetween(0,second.size()-1);

            if (firstPrior || r.nextBoolean()) { // Если приоритет у первой армии или рандом
                Duel(first, second, firstNum, secondNum); // первый воин бьет первым
            }
            else {
                Duel(second, first, secondNum, firstNum); // второй воин бьет первым
            }
        } while (first.size() > 0 && second.size() > 0); // пока есть кому сражаться в каждой армии
    }

    public static void Duel(ArrayList<MiddleEarthCitizen> first, ArrayList<MiddleEarthCitizen> second, int firstNum, int secondNum) // циклический обмен ударами между первым и вторым воином
    {
        boolean enough = false;
        int firstPow = first.get(firstNum).getPower();
        int secondPow = second.get(secondNum).getPower();
        String firstName = first.get(firstNum).getRace();
        String secondName = second.get(secondNum).getRace();
        System.out.println("\n" + firstName + "(" + firstPow + ") vs " + secondName + "(" + secondPow + ")");
        while (!enough) // пока живы оба - начинает первый
        {
            firstPow = first.get(firstNum).getPower();
            enough = Punch(firstPow, secondNum, secondPow, firstName, secondName, second); // Бьет первый
            if (!enough) // если живы оба - отвечает второй
            {
                secondPow = second.get(secondNum).getPower();
                enough = Punch(secondPow, firstNum, firstPow, secondName, firstName, first); // Бьет второй
            }
        }
    }

    public static boolean Punch(int attackerPow, int defenderNum, int defenderPow, String attackerName, String defenderName, ArrayList<MiddleEarthCitizen> defenders) // Удар первого по второму
    {
        boolean exit = false;
        if (defenderPow-attackerPow <= 0) // если обороняющийся не перенес удар
        {
            System.out.println(attackerName + "(" + attackerPow + "): " + defenderName + " в нокауте!");
            defenders.remove(defenderNum);
            exit = true;
        }
        else {
            defenderPow -= attackerPow;
            defenders.get(defenderNum).setPower(defenderPow);
            System.out.println(attackerName + "(" + attackerPow + "): " + defenderName+" -"+attackerPow+" HP");
        }
        return exit;
    }
}
