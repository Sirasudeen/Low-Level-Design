package AbstractFactory;

public class Main {
    public static void main(String[] args) {
        UIFactory Lightfactory = new LightUIFactory();
        UIFactory DFactory = new DarkUIFactory();

        App Lightapp = new App(Lightfactory); 
        App DarkApp = new App(DFactory);
        Lightapp.render();
        
        DarkApp.render();
    }
}
