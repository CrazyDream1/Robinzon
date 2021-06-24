package TextQuest;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //Game g = new Game();
        //g.run();
        /*Inventory i = new Inventory();
        i.AddResource(Resource.Iron, 10);
        i.AddResource(Resource.Meat, 5);
        i.Print();*/
        ArrayList <Integer> d = new ArrayList<>();
        d.add(5);
        d.add(6);
        d.add(7);
        d.add(8);
        d.add(9);
        d.add(10);
        for (int i = 0;i < d.size();i ++){
            System.out.println(d.get(i));
        }
    }
}
