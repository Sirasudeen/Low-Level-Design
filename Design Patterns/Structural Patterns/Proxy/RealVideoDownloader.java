package Proxy;

public class RealVideoDownloader implements VideoDownloader {

    @Override
    public String downloadVideo(String url) {
        return "Downloading video from " + url;
    }
}
