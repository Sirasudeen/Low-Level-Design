package dip;

public class Main {
    public static void main(String[] args) {
        
        Database db = new Postgres();
        App app = new App(db);
        app.start();

    }
}
