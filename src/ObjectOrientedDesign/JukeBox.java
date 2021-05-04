package ObjectOrientedDesign;
import java.util.Queue;
import java.util.Set;

/**
 * Design a musical jukebox using object oriented design


// represents the body of the problem
public class JukeBox {
    private CDPlayer cdPlayer;
    private User user;
    private Set<CD> cdCollection;
    private SongSelector ts;
    public JukeBox(CDPlayer cdPlayer, User user, Set<CD> cdCollection, SongSelector ts){...}

    public Song getCurrentSong(){ts.getCurretSong();}
    public void setUser(User u){this.user = u;}
}
// supports storing just one CD at a time.
class CDPlayer{
    private Playlist p;
    private CD c;

    public CDPlayer(CD c, Playlist p){...}
    public CDPlayer(Playlist p){this.p = p;}
    public CDPlayer(CD c){this.c = c;}

    //play song
    public void playSong(Song s){...}

    //getters and setters
    public Playlist getPlaylist(){return this.p;}
    public void setPlayList(Playlist p){this.p = p;}

    public CD getCD(){return this.c;}
    public void setCD(CD c){this.c = c;}

}
// manages the current and next songs to play.
class Playlist{
    private Song song;
    private Queue<Song> queue;
    public Playlist(Song song, Queue<Song> queue){...}

    public Song getNextSToPlay(){
        return queue.peek();
    }
    public void queueUpSong(Song s){queue.add(s);}
}
class User{
    private String name;
    public String getName(){return name;}
    public void setName(String n){this.name =n;}

    private long ID;
    public long getID(){return ID;}
    public void setID(long id){this.ID = id;}

    public User(String name, long ID){...}
    public User getUser(){return this;}
    public static User addUser(String name, long id){...}

}
class SongSelector{
    Song song;
    SongSelector(Song song){this.song = song;}
}
class CD{
    // data for id, artist, songs etc.
}
class Song{
    // data for id, CD, title, length
}

Core Objects:
- JukeBox
- CD
- Song
- Artist
- Playlist
- Display (displays detail sn screen)

Actions:
- playlist creation (add, delete and shuffle)
- cd selector
- song selector
- queuing up a song
- get next song from playlist
User can be introduced
- adding
- deleting
- credit information
 */