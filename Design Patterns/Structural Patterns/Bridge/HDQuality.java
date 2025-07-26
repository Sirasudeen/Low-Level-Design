package Bridge;

public class HDQuality implements VideoQuality {
        public void load(String title) {
        System.out.println("Streaming " + title + " in HD Quality");
    }
}
