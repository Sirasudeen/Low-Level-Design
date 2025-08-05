package Iterator;

public class Main {
    public static void main(String[] args) {
        
        YoutubePlaylist playlist = new YoutubePlaylist();
        playlist.addVideo(new Video("I AM MV"));
        playlist.addVideo(new Video("Cupid MV"));

        PlaylistIterator it = new YoutubePlaylistIterator(playlist.getVideos());

        while(it.hasNext())
        {
            System.out.println(it.next().getTitle());
        }
    }
}
