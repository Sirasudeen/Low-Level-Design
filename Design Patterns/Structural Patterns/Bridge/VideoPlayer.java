package Bridge;

public abstract class VideoPlayer {
    protected  VideoQuality quality;


    public VideoPlayer(VideoQuality quality) {
        this.quality = quality;
    }

    public abstract void play(String video);
}
