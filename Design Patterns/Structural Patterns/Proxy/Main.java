package Proxy;

public class Main {
    public static void main(String[] args) {
        VideoDownloader cacheDownloader = new CachedVideoDownloader();

        cacheDownloader.downloadVideo("https://video.com/Iam-Ive-MV");
        cacheDownloader.downloadVideo("https://video.com/Fifty-Fifty-SOS-MV");
        cacheDownloader.downloadVideo("https://video.com/Iam-Ive-MV");
    }
}
