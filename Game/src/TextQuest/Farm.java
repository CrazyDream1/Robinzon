package TextQuest;

import java.util.ArrayList;

public class Farm {
    ArrayList<Bed> beds;

    Farm(){
        beds = new ArrayList<>();
    }

    // Сажаем еду
    public void Plant(Food f){
        // TODO
    }
    
    public void AddGardenBed(){
        beds.add(null);
    }

    // Проверка, что есть свободная грядка
    public boolean IsFreeSpace(){
        // TODO
        return false;
    }

    // Сбор еды с определенной грядки
    public void Harvest(int id){
        // TODO
    }

    // Вернем информацию о грядках
    public String Info(int currentDay){
        // TODO
        return null;
    }

    public class Bed{
        public Food food;
        public int time;

        Bed(Food food, int plantingTime){
            this.food = food;
            this.time = plantingTime;
        }
    }
}

enum Food{
    Carrot, // Морковь
    Potato // Картофель
}