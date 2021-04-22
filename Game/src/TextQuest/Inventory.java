package TextQuest;

import java.util.ArrayList;

public class Inventory {
    int maxSize = 100;
    int currentSize = 0;
    ArrayList<Resource> cells;
    ArrayList<Integer> numberOfElements;
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
    Rock,
    Wood,
    Berries,
    Meat
 }