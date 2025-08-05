package Iterator;

import java.util.ArrayList;
import java.util.List;
public class YoutubePlaylist {
    
    private List<Video> videos = new ArrayList<>();

    public void addVideo(Video video)
    {
        videos.add(video);
    }
    
    public List<Video> getVideos()
    {
        return videos;
    }
}
