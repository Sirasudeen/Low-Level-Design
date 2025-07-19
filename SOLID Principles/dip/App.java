package dip;

public class App {
    private Database db;

    public App(Database db)
    {
        this.db = db;
    }

    public void start()
    {
        db.connect();
    }
}
