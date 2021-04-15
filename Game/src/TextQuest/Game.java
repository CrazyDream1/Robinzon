package TextQuest;

import java.util.Scanner;

public class Game {
    private Player player;
    private double currentDay = 0;
    private double currentTime = 0;
    private double maxTime = 16;
    private double maxDay = 10;

    public void run(){
        while (currentDay != maxDay){
            playDay();

        }
    }

    private int check(){
        if (currentTime >= maxTime){
            System.out.println("День закончен");
            return 1;
        }
        // Учитывать голод
        return 0;
    }

    private void playDay(){
        if (check() != 0) return;
        System.out.println("Пойдете ли вы в лес (0.5 час)?");
        Scanner in = new Scanner(System.in);
        String ans = in.next();
        if (ans.equals("да")){
            currentTime += 0.5;
            playForest();
        } else{
            playBase();
        }
    }

    private void playForest(){
        if (check() != 0) return;
    }

    private void playBase(){
        if (check() != 0) return;
    }
}
