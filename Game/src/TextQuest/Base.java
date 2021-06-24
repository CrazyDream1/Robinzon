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
        if (Building.GardenBed == building) {
            farm.AddGardenBed();
        }
        buildings.add(building);
    }

    // Положить ресурсы в инвентарь базы
    public boolean PutResources(Inventory inventory1 , Resource resource, int amount){
        ArrayList<Resource> r = new ArrayList<>();
        r.add(resource);
        ArrayList<Integer> a = new ArrayList<>();
        a.add(amount);
        boolean b =  inventory1.UseResource(r,a);
        if (b){
            inventory.AddResource(resource,amount);
            System.out.println("успешно");
            return true;
        }else{
            System.out.println("незватка ресурсов");
        }
        return false;
    }
    // Взять ресурсы из инвентаря базы
    public boolean GetResources(Inventory inventory1 ,Resource resource, int amount){
        ArrayList<Resource> r = new ArrayList<>();
        r.add(resource);
        ArrayList<Integer> a = new ArrayList<>();
        a.add(amount);
        boolean b =  inventory.UseResource(r,a);
        if (b){
            inventory1.AddResource(resource,amount);
            System.out.println("успешно");
            return true;
        }else{
            System.out.println("незватка ресурсов");
        }
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