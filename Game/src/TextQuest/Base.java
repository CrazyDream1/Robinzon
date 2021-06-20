package TextQuest;

import java.util.ArrayList;

public class Base {
    ArrayList<Building> buildings;
    Inventory inventory;
    Farm farm;

    Base(){
        buildings = new ArrayList<>();
        farm = new Farm();
        inventory = new Inventory();
        inventory.maxSize = 100;
    }

    // Строим здание
    public void Build(Building building){
        // TODO
    }

    // Положить ресурсы в инвентарь базы
    public boolean PutResources(Inventory inventory1, int amount){
        // TODO
        return false;
    }

    // Взять ресурсы из инвентаря базы
    public boolean GetResources(Inventory inventory1, int amount){
        // TODO
        return false;
    }
}

enum Building{
    Hut, // Шалаш
    GardenBed, // Грядка
    Fence // Забор
}
/*
* queue - очередь
* 1 2 3 5 4 8 1
*
* PriorityQueue
* 8 5 4 3 2 1 1
* */