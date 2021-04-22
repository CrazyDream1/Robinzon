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
        } else{ if (ans.equals("нет")) {
                System.out.println("хотите ли вы что-то построить");
                if (ans.equals("да")){
                    System.out.println("что вы хотите построить ?\n1 - забор\n2 - шалаш\n3 - ров");
                    if (ans.equals("1")){
                        System.out.println("для постройки забора тебе нужно\n3 дерева");
                    }
                    if (ans.equals("2")){
                        System.out.println("для постройки шалаша тебе нужно\n1 палка\n3 листа");
                    }
                    if (ans.equals("3")){
                        System.out.println("для постройки рва тебе нужно\n2 камня");
                    }
                }
            }
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
