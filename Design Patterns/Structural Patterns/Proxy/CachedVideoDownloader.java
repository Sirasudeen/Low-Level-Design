package Proxy;

import java.util.HashMap;

public class CachedVideoDownloader implements VideoDownloader {
    private RealVideoDownloader realVideoDownloader;
    private HashMap<String,String> cache;

    public CachedVideoDownloader()
    {
        this.realVideoDownloader = new RealVideoDownloader();
        this.cache = new HashMap<>();
    }
    public String downloadVideo(String url)
    {
        if(!cache.containsKey(url))
        {

        System.out.println("Cache miss. Downloading...");
            cache.put(url,realVideoDownloader.downloadVideo(url));
        }
        System.out.println("Returning cached video for: " + url);
        return cache.get(url);
    }
}
