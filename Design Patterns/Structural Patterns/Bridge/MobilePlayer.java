package Bridge;

public class MobilePlayer extends VideoPlayer{
        public MobilePlayer(VideoQuality quality) {
        super(quality);
           }

    public void play(String title) {
        System.out.println("Mobile Platform:");
        quality.load(title);
    }
}
