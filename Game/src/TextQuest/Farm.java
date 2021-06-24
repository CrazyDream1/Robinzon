package TextQuest;

import java.util.ArrayList;

public class Farm {
    ArrayList<Bed> beds;

    Farm(){
        beds = new ArrayList<>();
    }

    // Сажаем еду
    public void Plant(Food f,int ti){
        for(int i = 0;i < beds.size();i ++) {
            if (beds.get(i).food == null) {
                beds.get(i).food = f;
                beds.get(i).time = ti;
               return;
            }
        }
    }
    
    public void AddGardenBed(){
        beds.add(new Bed());
    }

    // Проверка, что есть свободная грядка
    public boolean IsFreeSpace(){
        for(int i = 0;i < beds.size();i ++) {
            if (beds.get(i).food == null) {
             return true;
            }
            }
        return false;
    }

    // Сбор еды с определенной грядки
    public Food Harvest(int id,int ti){
        if (beds.get(id).food == null && ti - beds.get(id).time < 2){
            return null;
        }
        Food f = beds.get(id).food;
        beds.get(id).food = null;
        return f;
    }

    // Вернем информацию о грядках
    public String Info(int currentDay){
        for(int i = 0;i < beds.size();i ++) {
            if (beds.get(i).food != null){
                System.out.println(beds.get(i).food + " время посаддки: " + beds.get(i).time);
            }
        }
        System.out.println();
        return null;
    }

    public class Bed{
        public Food food;
        public int time;

        Bed(Food food, int plantingTime){
            this.food = food;
            this.time = plantingTime;
        }
        Bed(){

        }
    }
}

enum Food{
    Carrot, // Морковь
    Potato // Картофель
}