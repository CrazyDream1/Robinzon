package TextQuest;

public class Main {

    public static void main(String[] args) {
        //Game g = new Game();
        //g.run();
        Inventory i = new Inventory();
        i.AddResource(Resource.Iron, 10);
        i.AddResource(Resource.Meat, 5);
        i.Print();
    }
}
