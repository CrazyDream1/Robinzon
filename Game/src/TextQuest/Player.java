package TextQuest;

import java.util.ArrayList;

public class Player {
    int health = 100;
    int hungry = 100;
    int thirst = 100;
    int happiness = 50;

    Inventory inventory;

    Player(){
        inventory = new Inventory();
    }
}
