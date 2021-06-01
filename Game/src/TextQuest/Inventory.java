package TextQuest;

import java.util.ArrayList;

public class Inventory {
    int maxSize = 35;
    int currentSize = 0;
    ArrayList<Resource> cells;
    ArrayList<Integer> numberOfElements;
    Inventory() {
        cells = new ArrayList<>();
        numberOfElements = new ArrayList<>();
    }

    boolean UseResource(ArrayList<Resource> r, ArrayList<Integer> amount) {
        for (int i = 0; i < r.size(); i++) {
            int id = cells.indexOf(r.get(i));
            if (id == -1) {
                return false;
            }
            if (amount.get(i) > numberOfElements.get(id)) {
                return false;
            }
        }
        for (int i = 0; i < r.size(); i++) {
            int id = cells.indexOf(r.get(i));
            currentSize -= amount.get(i);
            numberOfElements.set(id, numberOfElements.get(id) - amount.get(i));
        }
        return true;
    }

    void AddResource(Resource a, int amount){
        if (currentSize + amount > maxSize) {
            return;
        }
        if (cells.contains(a)){
            int x = cells.indexOf(a);
            numberOfElements.set(x, numberOfElements.get(x) + amount);
        } else {
            cells.add(a);
            numberOfElements.add(amount);
        }
        currentSize += amount;
    }

    void Print(){
        for (int i = 0; i < cells.size(); i++) {
            System.out.println(cells.get(i) + " " + numberOfElements.get(i) + "\n");
        }
    }
}
/*
 * 0 - Камень
 * 1 - Дерево
 * 2 - Ягоды
 * 3 - мясо
 *
 * 
 * */
 enum Resource{
    Rock,//камень
    Wood,//дерево
    Berries,//ягоды
    Meat,//мясо
    Iron,//железо
    Gold,//золото
    Leaves,//листья
    Ground,//земля
    Fish,//рыба
 }
 enum Tools{
     Sword,//меч
     Axe,//топор
     Pick,//кирка
     Hoe,//мотыга
     FishingRod,//удочка
 }