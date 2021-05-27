package TextQuest;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player player;
    private double currentDay = 0;
    private double currentTime = 0;
    private double maxTime = 16;
    private double maxDay = 10;

    Game() {
        player = new Player();
    }

    public void run() {
        while (currentDay != maxDay) {
            playDay();

        }
    }

    private int check() {
        if (currentTime >= maxTime) {
            System.out.println("День закончен");
            return 1;
        }
        // Учитывать голод
        return 0;
    }

    private void playDay() {
        if (check() != 0) return;
        System.out.println("Пойдете ли вы в лес (0.5 час)?");
        Scanner in = new Scanner(System.in);
        String ans = in.next();
        if (ans.equals("да")) {
            currentTime += 0.5;
            playForest();
        } else {
            playBase();
        }
    }

    private void playForest() {
        System.out.println("Вы пришли в локацию лес");
        if (check() != 0) return;
        /*
        добыча с приспособлениями камня , дерева , ягод
        охота
        сбор веток , камней , листьев , ягод
        выкапывать грядки и садить их
        пойти в горы или в на озеро
         */
        if (check() != 0) return;
        System.out.println("Пойдете ли вы вы еще куда - нибудь (0.5 час)?");
        Scanner in = new Scanner(System.in);
        String ans = in.next();
        if (ans.equals("да")) {
            if (check() != 0) return;
            System.out.println("куда вы пойедте ? \n1 - горы  \n2 - озеро \n(0.5 час)");
            ans = in.next();
            if (ans.equals("1")) {
                currentTime += 0.5;
                playMountains();
            }
            if (ans.equals("2")) {
                currentTime += 0.5;
                playLake();
            }
        } else {
            System.out.println("что будете делать\n1 - искать ресурсы \n2 - добывать ресурсы \n3 - охотится ");
            ans = in.next();
            if (ans.equals("1")){
                currentTime += 0.25;
                Random r = new Random ();
                int random = r.nextInt(3);
                if (random == 0) {
                    System.out.println("вы нашли: 1 камень");
                    player.inventory.AddResource(Resource.Rock, 1);
                }
                if (random == 1) {
                    System.out.println("вы нашли: 1 дерево");
                    player.inventory.AddResource(Resource.Wood, 1);
                }
                if (random == 2) {
                    System.out.println("вы нашли: 1 ягоду");
                    player.inventory.AddResource(Resource.Berries, 1);
                }
            }
            if (ans.equals("2")){
                // TODO добыча ресурсов в лесу
            }
            if (ans.equals("3")){
                // TODO охота в лесу
            }
        }
    }

    private void playMountains(){

    }

    private void playLake(){

    }

    private void playBase() {
        if (check() != 0) return;
        Scanner in = new Scanner(System.in);
        String ans;
        System.out.println("что вы хотите делать ?\n1 - строить\n2 - крафтить\n3 - ждать");
        ans = in.next();
        if (ans.equals("1")) {
            System.out.println("что вы хотите построить ?\n1 - забор\n2 - шалаш\n3 - ров");
            ans = in.next();
            if (ans.equals("1")) {
                System.out.println("для постройки забора тебе нужно\n3 дерева");
            }
            if (ans.equals("2")) {
                System.out.println("для постройки шалаша тебе нужно\n1 палка\n3 листа");
            }
            if (ans.equals("3")) {
                System.out.println("для постройки рва тебе нужно\n2 камня");
            }
            if (ans.equals("4")) {
                System.out.println("для постройки фермы нужно\n4 дерева\n2 камня\n3 земли");
            }
            //создание инструментов и оружия например:
            //меч , топор , кирка , мотыга
            //допустим с мечом будет увеличиватся сила
            //с топором время добычи дерева уменьшатся
            //с кикрой время добычи камня и металлов уменьшится
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
        } else {
            if (ans.equals("2")) {
                System.out.println("что вы будете крафтить ?\n1 - меч\n2 - кирка\n3 - топор\n4 - мотыга");
                ans = in.next();
                if (ans.equals("1")) {
                    System.out.println("для создания меча нужно\n2 железа\n1 дерево");
                    player.inventory.Print();
                    System.out.println("вы уверены что хотите это создать?\n1 - да\n2 - нет");
                    ans = in.next();
                    if (ans.equals("1")) {
                        ArrayList<Resource> res = new ArrayList<>();
                        ArrayList<Integer> amount = new ArrayList<>();
                        res.add(Resource.Iron);
                        amount.add(2);
                        res.add(Resource.Wood);
                        amount.add(1);
                        if (player.inventory.UseResource(res, amount)) {
                            System.out.println("Крафт успешен");
                        } else {
                            System.out.println("Нехватка ресурсов");
                        }
                    }
                }
                if (ans.equals("2")) {
                    System.out.println("для создания кирки нужно\n3 камня\n2 дерево");
                    player.inventory.Print();
                    System.out.println("вы уверены что хотите это создать?\n1 - да\n2 - нет");
                    ans = in.next();
                    if (ans.equals("1")) {
                        ArrayList<Resource> res = new ArrayList<>();
                        ArrayList<Integer> amount = new ArrayList<>();
                        res.add(Resource.Rock);
                        amount.add(4);
                        res.add(Resource.Wood);
                        amount.add(3);
                        if (player.inventory.UseResource(res, amount)) {
                            System.out.println("Крафт успешен");
                        } else {
                            System.out.println("Нехватка ресурсов");
                        }
                    }
                }
                if (ans.equals("3")) {
                    System.out.println("для создания топора нужно\n3 камня\n2 дерево");
                    player.inventory.Print();
                    System.out.println("вы уверены что хотите это создать?\n1 - да\n2 - нет");
                    ans = in.next();
                    if (ans.equals("1")) {
                        ArrayList<Resource> res = new ArrayList<>();
                        ArrayList<Integer> amount = new ArrayList<>();
                        res.add(Resource.Rock);
                        amount.add(3);
                        res.add(Resource.Wood);
                        amount.add(2);
                        if (player.inventory.UseResource(res, amount)) {
                            System.out.println("Крафт успешен");
                        } else {
                            System.out.println("Нехватка ресурсов");
                        }
                    }
                }
                if (ans.equals("4")) {
                    System.out.println("для создания мотыги нужно\n2 железа\n2 дерево");
                    player.inventory.Print();
                    System.out.println("вы уверены что хотите это создать?\n1 - да\n2 - нет");
                    ans = in.next();
                    if (ans.equals("1")) {
                        ArrayList<Resource> res = new ArrayList<>();
                        ArrayList<Integer> amount = new ArrayList<>();
                        res.add(Resource.Iron);
                        amount.add(2);
                        res.add(Resource.Wood);
                        amount.add(2);
                        if (player.inventory.UseResource(res, amount)) {
                            System.out.println("Крафт успешен");
                        } else {
                            System.out.println("Нехватка ресурсов");
                        }

                    }
                }
            }
        }
    }
}
