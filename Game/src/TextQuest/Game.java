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
                        //создание инструментов и оружия например:
                        //меч , топор , кирка , мотыга
                        //допустим с мечом будет увеличиватся сила
                        //с топором время добычи дерева уменьшатся
                        //с кикрой время добычи камня и металлов уменьшатя
                        //и с мотыгой можно будет выращивать растения
                        //после того как соберешь мотыгу можно будет построить ферму
                        //еще можно сделать для мотыги садоводство например:
                        //выращивание морковки - 3 дня , картошки - 2 дня , пшена - 5 дней
                        //из них можно будет что-то готовить и есть
                        //улучшение построек:
                        //шалаш : 1 ур. - шалаш , 2 ур. - палатка , 3 ур. - дом на дереве , 4 ур. - дом
                        //забор : 1 ур. - забор из дерева , 2 ур. - забор из камня , 3 ур. - забор из железа
                        //ров : 1 ур. - неглубокий ров , 2 ур. - средний ров , 3 ур. - глубокий ров
                        //ферма : 1 ур. - маленька ферма без ограждения , 2 ур. - мал. ферма с ограждением , 3 ур. - большая ферма с ограждением
                    }
                }
            }
            playBase();
        }
    }

    private void playForest(){System.out.println("Вы пришли в локацию лес");
        if (check() != 0) return;
    }

    private void playBase(){
        if (check() != 0) return;
    }
}
